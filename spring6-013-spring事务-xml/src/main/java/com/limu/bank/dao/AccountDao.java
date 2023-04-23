package com.limu.bank.dao;


import com.limu.bank.pojo.Account;

public interface AccountDao {

    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account SelectByActno(String actno);

    /**
     * 更新账户信息
     * @param act
     * @return
     */
    int update(Account act);
}
