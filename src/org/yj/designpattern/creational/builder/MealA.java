package org.yj.designpattern.creational.builder;

/**
 * 建造者模式中的ConcreteBuilder（具体建造者），套餐A
 * 
 * @author yaojun
 * @date 2019/3/15 11:59
 */
public class MealA extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("汉堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("可乐");
    }
}
