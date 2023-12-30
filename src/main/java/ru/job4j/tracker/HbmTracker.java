package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.function.Function;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        return this.tx(
                session -> {
                    session.save(item);
                    return item;
                }
        );
    }

    @Override
    public boolean replace(int id, Item item) {
        return this.tx(
                session -> {
                    item.setId(id);
                    session.update(item);
                    return true;
                }
        );
    }

    @Override
    public boolean delete(int id) {
        return this.tx(
                session -> {
                    Item item = new Item(null);
                    item.setId(id);
                    session.delete(item);
                    return true;
                }
        );
    }

    @Override
    public List<Item> findAll() {
        return this.tx(
                session -> session.createQuery("from Item").list()
        );
    }

    @Override
    public List<Item> findByName(String key) {
        return this.tx(
                session -> session.createQuery("from Item where name = :iname")
                        .setParameter("iname", key).list()
        );
    }

    @Override
    public Item findById(int id) {
        return this.tx(
                session -> session.get(Item.class, id)
        );
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    public static void main(String[] args) {
        HbmTracker tracker = new HbmTracker();

        //check methods
        tracker.add(new Item("One", "description one"));
        tracker.replace(5, new Item("replaced"));
        System.out.println(tracker.findById(2));
        System.out.println(tracker.findByName("replaced"));
        tracker.findAll().forEach(System.out::println);
        tracker.delete(9);
    }

    private <T> T tx(Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T result = command.apply(session);
            tx.commit();
            return result;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}