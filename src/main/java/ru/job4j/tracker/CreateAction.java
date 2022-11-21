package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;
    private int id = 1;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, SqlTracker tracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(id, name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        id++;
        return true;
    }
}
