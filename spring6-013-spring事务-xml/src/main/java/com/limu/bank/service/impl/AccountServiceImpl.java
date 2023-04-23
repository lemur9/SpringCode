package com.limu.bank.service.impl;

import com.limu.bank.dao.AccountDao;
import com.limu.bank.pojo.Account;
import com.limu.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
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

        count += accountDao.update(toAct);

        if (count != 2) {
            throw new RuntimeException("转账失败，请联系银行处理！");
        }

        //第三步：如果执行业务流程中没有异常，提交事务。
        //第四步：如果执行业务流程中出现异常，回滚事务。
    }

}
