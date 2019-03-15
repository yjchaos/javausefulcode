package org.yj.designpattern.creational.builder;

/**
 * 建造者模式中的Builder（抽象建造者），套餐建造者
 *
 * @author yaojun
 * @date 2019/3/15 11:50
 */
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
