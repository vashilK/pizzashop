package ch.elca.enums;

public enum  Toppings {
    OLIVE(10),
    JALAPENOS(10),
    PEPPERONI(10),
    ANANAS(10),
    PEPPER(10),
    ONION(10);

    private int value;

    private Toppings(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
