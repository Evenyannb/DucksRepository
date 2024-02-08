package edu.iu.yanlian.demo.model;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        super();
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();

    }



    public void display() {
        System.out.println("I'm a duck Decoy");
    }
}