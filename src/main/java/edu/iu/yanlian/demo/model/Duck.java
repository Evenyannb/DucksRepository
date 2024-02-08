package edu.iu.yanlian.demo.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MallardDuck.class, name = "MALLARD"),
        @JsonSubTypes.Type(value = RedheadDuck.class, name = "REDHEAD"),
        @JsonSubTypes.Type(value = RubberDuck.class, name = "RUBBER"),
        @JsonSubTypes.Type(value = DecoyDuck.class, name = "DECOY")
})

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    int id;
    DuckType type;

    public Duck(int id, DuckType type) {
        this.id = id;
        this.type = type;
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for type
    public void setType(DuckType type) {
        this.type = type;
    }

    // Getter for type
    public DuckType getType() {
        return type;
    }

    public enum DuckType {
        MALLARD,
        REDHEAD,
        RUBBER,
        DECOY;

        public String toSting(){
            switch (this){
                case MALLARD: return "Mallard";
                case REDHEAD: return "Redhead";
                case RUBBER: return "Rubber";
                case DECOY: return "Decoy";
                default: return "Non-type";
            }
        }

    }
}


