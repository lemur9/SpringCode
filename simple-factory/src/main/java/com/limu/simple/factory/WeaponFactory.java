package com.limu.simple.factory;

/**
 * 工厂类角色
 */
public class WeaponFactory {

    /**
     * 静态方法。根据入参类型，返回不同类型，传Tank获取坦克，传Dagger获取匕首
     * 简单工厂模式中有一个静态方法，所有被称为：静态工厂方法模式。
     *
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType) {
        if ("Tank".equals(weaponType)) {
            return new Tank();
        } else if ("Dagger".equals(weaponType)) {
            return new Dagger();
        } else if ("Fighter".equals(weaponType)) {
            return new Fighter();
        } else {
            throw new RuntimeException("不支持该武器！");
        }
    }
}
