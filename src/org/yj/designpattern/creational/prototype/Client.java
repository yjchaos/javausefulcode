package org.yj.designpattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型模式，客户类，提供接口用来获取原型的克隆
 * 
 * @author yaojun
 * @date 2019/3/15 15:09
 */
public class Client {
    private Map<String, Coin> hashMap = new HashMap<>();

    public Client() {
        // 初始化原型
        Coin rmb = new ConcreteCoin("￥", "1");
        Coin dollar = new ConcreteCoin("$", "1");
        hashMap.put("￥1", rmb);
        hashMap.put("$1", dollar);
    }

    public void add(String name, Coin coin) {
        hashMap.put(name, coin);
    }

    public Coin get(String name) throws CloneNotSupportedException {
        Coin prototype = hashMap.get(name);
        return prototype.clone();
    }
}
