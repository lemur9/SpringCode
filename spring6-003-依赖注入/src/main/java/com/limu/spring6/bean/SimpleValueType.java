package com.limu.spring6.bean;

import java.util.Date;

public class SimpleValueType {
    /*
    * Spring的BeanUtils类中的isSimpleValueType方法，用来判断是否为简单类型。
    public static boolean isSimpleValueType(Class<?> type) {
		return (Void.class != type && void.class != type &&
				(ClassUtils.isPrimitiveOrWrapper(type) ||
				Enum.class.isAssignableFrom(type) ||
				CharSequence.class.isAssignableFrom(type) ||
				Number.class.isAssignableFrom(type) ||
				Date.class.isAssignableFrom(type) ||        java.util.Date 是简单类型
				Temporal.class.isAssignableFrom(type) ||    Temporal是Java8提供的时间和时区类型
				URI.class == type ||
				URL.class == type ||
				Locale.class == type ||                     Locale是语言类，也是简单类型
				Class.class == type));
	}
     */

    private int age;
    private Integer age2;

    //生日
    private Date birth;

    private boolean flag;
    private Boolean flag2;

    private char c;
    private Character c2;

    private Season season;

    private String userName;

    private Class Clazz;

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public void setC(char c) {
        this.c = c;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setClazz(Class clazz) {
        Clazz = clazz;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "SimpleValueType{" +
                "age=" + age +
                ", age2=" + age2 +
                ", birth=" + birth +
                ", flag=" + flag +
                ", flag2=" + flag2 +
                ", c=" + c +
                ", c2=" + c2 +
                ", season=" + season +
                ", userName='" + userName + '\'' +
                ", Clazz=" + Clazz +
                '}';
    }

}
