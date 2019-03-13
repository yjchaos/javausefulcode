package org.yj.designmode.creational.singleton;

/**
 * 单例设计模式，懒汉式，线程不安全</br>
 * 线程不安全： </br>
 * 1.instance不是volatile的<br/>
 * 2.getInstance()不是synchronized的<br/>
 * 
 * @author yaojun
 * @date 2019/3/13 13:52
 */
public class LazySingleton {
    /**
     * 全局唯一实例，第一次使用时初始化
     */
    private static LazySingleton instance;

    /**
     * 私有化构造器，不让外部创建
     */
    private LazySingleton() {}

    /**
     * 提供全局访问点
     *
     * @return LazySingleton对象
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
