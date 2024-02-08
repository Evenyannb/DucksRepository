package edu.iu.yanlian.demo.model;

public class RedheadDuck extends Duck {
    public RedheadDuck(int id) {
        super(id, DuckType.REDHEAD);
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I'm a real Redhead duck");
    }
}
