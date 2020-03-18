package ch.elca.enums;

public enum  Base {
    THICK(50),
    THIN(30);

    private int value;

    private Base(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
