package ca.csf.pobj.tp2;

public enum RomanLetters {
    M(1000, "M"), D(500, "D"), C(100, "C"), L(50, "L"), X(10, "X"), V(5, "V"), I(1, "I");

    private final int value;
    private final String text;

    RomanLetters(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
