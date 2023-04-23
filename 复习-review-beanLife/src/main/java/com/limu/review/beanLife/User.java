package com.limu.review.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;


public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;

    public User() {
        System.out.println("第一步：实例化Bean");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：给属性赋值");
    }

    public void initUser() {
        System.out.println("第六步：Bean的初始化");
    }

    public void destroyUser() {
        System.out.println("第十步：Bean的销毁");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("第三步：实现Aware相关接口(包含BeanNameAware、BeanClassLoadAware、BeanFactoryAware)");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第五步：实现InitializingBean接口");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第九步：实现Destroyable接口");
    }

    @Override
    public String toString() {
        System.out.println("第八步：使用bean");
        return null;
    }
}
