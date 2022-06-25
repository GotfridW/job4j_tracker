package ru.job4j.bank;

import java.util.*;

/** Класс описывает работу банковской системы, обрабатывающей базу данных
 * клинтов и переводы денежных средств между их счетами
 * @author Gotfrid
 * @version 1.0
  */
public class BankService {
    /**
     * users - база данных клиентов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет наличие искомого клиента в базе данных и в
     * случае отстствия добавляет его
     * @param user клиент
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет из базы данных искомого клиента
     * @param user клиент
     */
    public void removeUser(User user) {
        users.remove(user);
    }

    /**
     * Метод проверяет у клиента наличие искомого счёта
     * и в случае отсутствия добавляет этот счет
     * @param passport номер паспорта клиента
     * @param account банковский счёт клиента
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск клиента в базе данных по переданным
     * паспортным данным
     * @param passport номер паспорта клиента
     * @return клиент
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод проверяет наличие счёта у клиента
     * @param passport номер паспора клиента
     * @param requisite номер банковского счета
     * @return банковский счёт клиента
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(acc -> requisite.equals(acc.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод проверяет возможность перевода денежных средств со счёта
     * на счёт и осуществляет его
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер счёта отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер счёта получателя
     * @param amount сумма перевода
     * @return true или false - статус перевода
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
