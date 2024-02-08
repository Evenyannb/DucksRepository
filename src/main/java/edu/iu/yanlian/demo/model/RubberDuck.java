package edu.iu.yanlian.demo.model;

public class RubberDuck extends Duck {
    public RubberDuck(int id) {
        super(id, DuckType.RUBBER);
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I'm a rubber duckie");
    }
}
