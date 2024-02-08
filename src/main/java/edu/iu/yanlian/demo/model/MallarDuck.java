package edu.iu.yanlian.demo.model;

class MallardDuck extends Duck {
    public MallardDuck(int id) {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        super(id, DuckType.MALLARD);
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
