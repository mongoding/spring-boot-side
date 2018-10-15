package org.spring.springboot.base.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;


public class CglibProxy implements MethodInterceptor {  //主要的方法拦截类，它是Callback接口的子接口，需要用户实现
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        System.out.println(method.getName());
        Object o1 = methodProxy.invokeSuper(o, args);
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        return o1;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();  //主要的增强类
        enhancer.setSuperclass(UserServiceImpl.class);  //设置父类，被增强的类
        enhancer.setCallback(cglibProxy);  //回调对象

        UserService o = (UserService)enhancer.create();//用cglibProxy来增强UserServiceImpl
        o.getName(1);
        o.getAge(1);
    }
}
