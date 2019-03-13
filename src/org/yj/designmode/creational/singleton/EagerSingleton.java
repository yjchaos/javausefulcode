package org.yj.designmode.creational.singleton;

/**
 * 单例设计模式，饿汉式
 * 
 * @author yaojun
 * @date 2019/3/13 13:45
 */
public class EagerSingleton {
    /**
     * jvm加载类时创建实例，线程安全
     */
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * 私有化构造器，不让外部创建
     */
    private EagerSingleton() {}

    /**
     * 提供全局访问点
     * 
     * @return EagerSingleton对象
     */
    public EagerSingleton getInstance() {
        return instance;
    }
}
