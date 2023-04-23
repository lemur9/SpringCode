package com.limu.simple.factory;

/**
 * 客户端程序
 */
public class Test {

    public static void main(String[] args) {
        //简单工厂模式起到了职责分离的作用，客户端不需要关心产品的生产细节
        //客户端只负责消费，工厂类负责生产。生产者和消费者分离了，这就是工厂模式的作用
        //需要坦克
        Weapon tank = WeaponFactory.get("Tank");
        tank.attack();
        //需要战斗机
        Weapon fighter = WeaponFactory.get("Fighter");
        fighter.attack();
        //需要匕首
        Weapon dagger = WeaponFactory.get("Dagger");
        dagger.attack();
    }
}
