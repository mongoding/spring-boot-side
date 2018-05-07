package org.spring.springboot.dao;

import org.spring.springboot.entity.Account;

import java.util.List;

/**
 * Created by mongoding on 2017/4/20.
 */
public interface IAccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
