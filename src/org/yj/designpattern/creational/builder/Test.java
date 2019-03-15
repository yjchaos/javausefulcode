package org.yj.designpattern.creational.builder;

/**
 * 建造者模式测试类
 *
 * @author yaojun
 * @date 2019/3/15 12:03
 */
public class Test {
    public static void main(String[] args) {
        Waiter waiter = new Waiter(new MealA());
        Meal meal1 = waiter.construct();
        System.out.println(meal1);
        waiter = new Waiter(new MealB());
        Meal meal2 = waiter.construct();
        System.out.println(meal2);
    }
}
