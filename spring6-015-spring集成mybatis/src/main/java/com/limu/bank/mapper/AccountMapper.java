package com.limu.bank.mapper;

import com.limu.bank.pojo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {

    /**
     * 新增账户
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 通过actno删除账户
     * @param ActNo
     * @return
     */
    int deleteByActNo(String ActNo);

    /**
     * 更新账户
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 通过actno查询账户
     * @param ActNo
     * @return
     */
    Account selectByActNo(String ActNo);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> selectAll();
}
