package org.yj.designpattern.creational.prototype;

/**
 * 具体原型类(ConcretePrototype)，具体硬币类，可以通过原型克隆硬币
 * 
 * @author yaojun
 * @date 2019/3/15 15:18
 */
public class ConcreteCoin extends Coin {

    public ConcreteCoin(String symbol, String cost) {
        super(symbol, cost);
    }

    @Override
    protected ConcreteCoin clone() throws CloneNotSupportedException {
        return (ConcreteCoin) super.clone();
    }

    @Override
    public String toString() {
        return "ConcreteCoin{" + "symbol='" + symbol + '\'' + ", cost='" + cost + '\'' + '}';
    }
}
