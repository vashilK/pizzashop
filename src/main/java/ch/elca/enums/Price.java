package ch.elca.enums;

public enum Price {
    VEG(250),
    CHICKEN(270),
    CHEESE(200),
    OLIVE(10),
    JALAPENOS(10),
    PEPPERONI(10),
    ANANAS(10),
    PEPPER(10),
    ONION(10),
    THIN(30),
    THICK(50);

    private int value;

    private Price(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
