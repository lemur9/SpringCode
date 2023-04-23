package com.limu.spring6.proxy.client;

import com.limu.spring6.proxy.service.OrderService;
import com.limu.spring6.proxy.service.OrderServiceImpl;
import com.limu.spring6.proxy.service.TimerInvocationHandler;
import com.limu.spring6.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

public class Client {
    //客户端程序
    public static void main(String[] args) {
        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理类对象
        /*
          1.newProxyInstance 翻译为：新建代理对象
            也就是说，通过调用这个方法可以创建代理对象。
            本质上，这个Proxy.newProxyInstance()方法的执行，做了两件事：
                第一件事：在内存中动态生成了一个代理类的字节码class文件
                第二件事：new对象了。通过内存中生成的代理类这个代码，实例了代理对象。
          2.关于newProxyInstance()方法的三个重要的参数，每一个什么含义，有什么用？
                第一个参数：ClassLoad loader
                    类加载器。这个类加载器有什么用？
                        在内存当中生成的字节码也是class文件，要执行也得先加载到内存当中。加载类就需要类加载器。所以这里需要指定类加载器。
                         并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个。
                第二个参数：Class<?>[] interfaces
                    代理类和目标类要实现同一个接口或同一些接口。
                    在内存中生成代理类的时候，这个代理类是需要你告诉他实现哪些接口的。
                第三个参数：InvocationHandler h
                    InvocationHandler 被翻译为：调用处理器。是一个接口。
                    在调用处理器接口中编写的是：增强代码
                    因为具体要增强什么代码，JDK动态代理是不知道的。

                注意：代理对象和目标对象实现的接口一样，所以可以向下转型
         */
        /*OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                                    target.getClass().getInterfaces(),
                                                                    new TimerInvocationHandler(target));*/
        //上面代码通过一个工具类的封装就简洁了
        OrderService proxy = ProxyUtil.newProxyInstance(target);

        //调用代理对象的代理方法
        //注意：调用代理对象的代理方法的时候，如果你要做增强的话，目标对象的目标方法需要保证执行。
        proxy.generate();
        proxy.modify();
        proxy.detail();
        String name = proxy.getName();
        System.out.println(name);
    }
}
