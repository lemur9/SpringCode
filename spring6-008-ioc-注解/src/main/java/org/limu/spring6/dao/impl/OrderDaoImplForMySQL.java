package org.limu.spring6.dao.impl;

import org.limu.spring6.dao.OrderDao;
import org.springframework.stereotype.Repository;

//@Repository("orderDaoImplForMySQL")
public class OrderDaoImplForMySQL implements OrderDao {

    @Override
    public void insert() {
        System.out.println("MySQL数据库正在保存订单信息...");
    }
}
