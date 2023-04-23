package org.myspringframework.core;

/**
 * MySpring框架应用上下文接口
 */
public interface ApplicationContext {

    /**
     * 根据bean的名称获取bean的对象
     * @param beanName myspring配置中bean标签的id
     * @return 对应的单例bean对象
     */
    Object getBean(String beanName);
}
