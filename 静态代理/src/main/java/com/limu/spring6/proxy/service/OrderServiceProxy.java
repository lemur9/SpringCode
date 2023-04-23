package com.limu.spring6.proxy.service;

//代理对象（代理对象和目标对象要具有相同的行为，就要实现同一个或同一些接口。）
//客户端在使用代理对象的时候就像在使用目标对象一样。
public class OrderServiceProxy implements OrderService {

    //将目标对象作为代理对象的一个属性，这种关系叫做关联关系。比继承关系的耦合度底。
    //代理对象中含有目标对象的引用。关联关系。has a
    //注意：这里要写一个公共接口类型。因为公共接口耦合度低。
    private OrderService target;

    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }
}
