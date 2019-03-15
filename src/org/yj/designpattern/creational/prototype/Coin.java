package org.yj.designpattern.creational.prototype;

/**
 * 抽象原型类(Prototype)，硬币类
 * 
 * @author yaojun
 * @date 2019/3/15 15:16
 */
public abstract class Coin implements Cloneable {
    protected String symbol;
    protected String cost;

    public Coin(String symbol, String cost) {
        this.symbol = symbol;
        this.cost = cost;
    }

    @Override
    protected Coin clone() throws CloneNotSupportedException {
        return (Coin) super.clone();
    }
}
