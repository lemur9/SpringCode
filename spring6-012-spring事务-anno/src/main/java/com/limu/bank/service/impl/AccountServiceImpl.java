package com.limu.bank.service.impl;

import com.limu.bank.dao.AccountDao;
import com.limu.bank.pojo.Account;
import com.limu.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void transfer(String fromActno, String toActno, double money) {

        //第一步：开启事务

        //第二步：执行核心业务逻辑
        //查询转出账户余额是否充足
        Account fromAct = accountDao.SelectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足！");
        }
        //余额充足
        Account toAct = accountDao.SelectByActno(toActno);

        // 将内存中两个对象的余额先修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        //数据库更新
        int count = accountDao.update(fromAct);

        //模拟异常
        /*String s = null;
        s.toString();*/

        count += accountDao.update(toAct);

        if (count != 2) {
            throw new RuntimeException("转账失败，请联系银行处理！");
        }

        //第三步：如果执行业务流程中没有异常，提交事务。
        //第四步：如果执行业务流程中出现异常，回滚事务。
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void withdraw() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {



        accountDao.insert(account);

        //创建账户对象
        Account act2 = new Account("act-004",30000.0);
        try {
            accountService.save(act2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
