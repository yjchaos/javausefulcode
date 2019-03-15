package org.yj.designpattern.creational.builder;

/**
 * 建造者模式中的Product（产品角色），套餐类
 * 
 * @author yaojun
 * @date 2019/3/15 11:48
 */
public class Meal {
    private String food;
    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Meal{" + "food='" + food + '\'' + ", drink='" + drink + '\'' + '}';
    }
}
