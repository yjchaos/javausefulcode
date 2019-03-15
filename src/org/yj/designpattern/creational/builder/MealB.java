package org.yj.designpattern.creational.builder;

/**
 * 建造者模式中的ConcreteBuilder（具体建造者），套餐B
 * 
 * @author yaojun
 * @date 2019/3/15 12:01
 */
public class MealB extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("鸡肉卷");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("奶茶");
    }
}
