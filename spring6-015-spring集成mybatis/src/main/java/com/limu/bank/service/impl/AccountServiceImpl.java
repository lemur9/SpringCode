package com.limu.bank.service.impl;

import com.limu.bank.mapper.AccountMapper;
import com.limu.bank.pojo.Account;
import com.limu.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int deleteByActNo(String actno) {
        return accountMapper.deleteByActNo(actno);
    }

    @Override
    public int modify(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Account getByActNo(String actno) {
        return accountMapper.selectByActNo(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountMapper.selectByActNo(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }
        Account toAct = accountMapper.selectByActNo(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count1 = accountMapper.update(fromAct);
        int count2 = accountMapper.update(toAct);
        if (count1 + count2 != 2) {
            throw new RuntimeException("转账失败");
        }

    }
}
