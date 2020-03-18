package ch.elca.enums;

public enum PizzaType {
    VEG(250),
    CHICKEN(270),
    CHEESE(200);

    private int value;

    private PizzaType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
