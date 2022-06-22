package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель банковской системы
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет.
 * У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author LYUBOV NIKIFOROVA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей системы с привязанными к ним счетами
     * осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя
     * и, если такого пользователя ещё нет,
     * добавляет его в банковский сервис (в коллекцию users).
     *
     * @param user пользователь, который добавляется в сервис
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     *
     * @param passport паспорт пользователя
     * @param account  добавляемый счёт
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            throw new NullPointerException("User is not found");
        }
        if (!users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        } else {
            throw new IllegalArgumentException("Account doesn't exist");
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     *
     * @param passport номер паспорта
     * @return возвращает найденного по паспорту пользователя
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     *
     * @param passport  номер паспорта
     * @param requisite реквизит счёта
     * @return возвращает найденный по реквизитам счёт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> result = Optional.empty();
        if (user.isPresent()) {
            return user.map(value -> users.get(value)
                    .stream()
                    .filter(ac -> ac.getRequisite().equals(requisite))
                    .findFirst()).orElse(result);
        }
        return result;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     *
     * @param srcPassport   номер паспорта исходного счёта
     * @param srcRequisite  реквизиты исходного счёта
     * @param destPassport  номер паспорта назначения
     * @param destRequisite реквизиты счёта назначения
     * @param amount        перечисляемая сумма
     * @return возвращает true/false
     * транзакция осуществлена/не осуществлена
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Optional<Account> source = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (source.isPresent() && dest.isPresent() && source.get().getBalance() >= amount) {
            result = true;
            source.get().setBalance(source.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
        }
        return result;
    }
}
