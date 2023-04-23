package com.limu.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

    private List<String> names;

    private Set<String> addrs;

    private Map<Integer, String> phones;

    // 注入属性类对象
    // Properties本质上也是一个map集合
    // Properties的父类Hashtable实现了Map接口
    // 虽然properties也是一个map，但是和map注入的方式有点不同
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }
}
