package com.limu.review.domain;


import com.limu.review.annotation.Component;

@Component
public class People {

    private String realName;

    private Integer age;

    private Address address;

    @Override
    public String toString() {
        return "People{" +
                "realName='" + realName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
