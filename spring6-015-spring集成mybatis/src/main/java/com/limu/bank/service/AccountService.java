package com.limu.bank.service;

import com.limu.bank.pojo.Account;

import java.util.List;

public interface AccountService {

    /**
     * 开户
     * @param account
     * @return
     */
    int save(Account account);

    /**
     *
     * @param actno
     * @return
     */
    int deleteByActNo(String actno);

    /**
     * 修改账户
     * @param account
     * @return
     */
    int modify(Account account);

    /**
     * 查询账户
     * @param actno
     * @return
     */
    Account getByActNo(String actno);

    /**
     * 获取所有账户
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno, String toActno, double money);
}
