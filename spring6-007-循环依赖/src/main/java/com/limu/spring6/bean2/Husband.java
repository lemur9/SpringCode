package com.limu.spring6.bean2;


public class Husband {
    private String name;

    private Wife wife;

    public String getName() {
        return name;
    }

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
