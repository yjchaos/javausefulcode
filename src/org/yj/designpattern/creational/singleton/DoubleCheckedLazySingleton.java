package org.yj.designpattern.creational.singleton;

/**
 * 单例设计模式，懒汉式(双重检查加锁版本)，线程安全
 * 
 * @author yaojun
 * @date 2019/3/13 14:16
 */
public class DoubleCheckedLazySingleton {
    /**
     * 全局唯一实例，第一次使用时初始化，volatile保证对其他线程的可见性
     */
    private volatile static DoubleCheckedLazySingleton instance;

    /**
     * 私有化构造器，不让外部创建
     */
    private DoubleCheckedLazySingleton() {}

    /**
     * 提供全局访问点,双重检查加锁<br/>
     * 第一次判空是为了不用每次调用getInstance方法都去获取锁，第二个判空是防止多线程创建多个对象
     *
     * @return DoubleCheckedLazySingleton对象
     */
    public static DoubleCheckedLazySingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLazySingleton();
                }
            }
        }
        return instance;
    }
}
