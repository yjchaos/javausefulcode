package org.yj.designpattern.creational.builder;

/**
 * 建造者模式中的Director（指挥者），服务员
 *
 * @author yaojun
 * @date 2019/3/15 12:02
 */
public class Waiter {
    private MealBuilder mealBuilder;

    public Waiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        return mealBuilder.getMeal();
    }
}
