package com.limu.bank.service.impl;

import com.limu.bank.dao.AccountDao;
import com.limu.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //负责插入
    @Transactional(timeout = 10)
    public void insert(Account account) {
        accountDao.insert(account);
        // 睡眠一会
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.SelectByActno("act-001");
    }
    
}
