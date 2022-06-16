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
        User user = findByPassport(passport);
        if (user == null) {
            throw new NullPointerException("User is not found");
        }
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
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
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     *
     * @param passport  номер паспорта
     * @param requisite реквизит счёта
     * @return возвращает найденный по реквизитам счёт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(ac -> ac.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (source != null && dest != null && source.getBalance() >= amount) {
            result = true;
            source.setBalance(source.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
        }
        return result;
    }
}
