package org.yj.designpattern.creational.prototype;

/**
 * 测试类
 * 
 * @author yaojun
 * @date 2019/3/15 16:26
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Client client = new Client();
        Coin coin1 = client.get("$1");
        Coin coin2 = client.get("$1");
        System.out.println(coin1);
        System.out.println(coin2);
    }
}
