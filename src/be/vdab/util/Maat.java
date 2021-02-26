package be.vdab.util;

public enum Maat {
    CENTIMETER(1), DECIMETER(1000), METER(1000000);
    private final int volumemeting;

    Maat(int volumemeting) {
        this.volumemeting = volumemeting;
    }

    public int getVolumemeting() {
        return volumemeting;
    }
}
