package be.vdab.voertuigen.div;

import java.io.Serializable;
import java.util.Objects;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String PLAAT;

    public Nummerplaat(String plaat) {
        this.PLAAT = plaat;
    }

    public String getPlaat() {
        return PLAAT;
    }

    @Override
    public String toString() {
        return "Nummerplaat=" + PLAAT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nummerplaat that = (Nummerplaat) o;
        return Objects.equals(PLAAT, that.PLAAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PLAAT);
    }

    @Override
    public int compareTo(Nummerplaat o) {
        return PLAAT.compareTo(o.PLAAT);
    }
}
