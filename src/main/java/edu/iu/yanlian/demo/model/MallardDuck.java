package edu.iu.yanlian.demo.model;

public class MallardDuck extends Duck {
    public MallardDuck(int id) {
        super(id, DuckType.MALLARD);
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
