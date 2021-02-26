package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

public class Volume implements Comparable<Volume>, Serializable {
    private static final long serialVersionUID = 1L;

    private final int breedte;
    private final int hoogte;
    private final int diepte;
    private final Maat maat;

    public Volume(int breedte, int hoogte, int diepte, Maat maat) throws VolumeException {
        if (breedte > 0 && hoogte > 0 && diepte > 0) {
            this.breedte = breedte;
            this.hoogte = hoogte;
            this.diepte = diepte;
            this.maat = maat;
        } else {
            throw new VolumeException("Breedte, hoogte en diepte mag niet negatief zijn!");
        }
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getDiepte() {
        return diepte;
    }

    public long getVolume() {
        return (long) breedte * hoogte * diepte * maat.getVolumemeting();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return getVolume()==((Volume) o).getVolume();
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedte, hoogte, diepte, maat);
    }

    @Override
    public int compareTo(Volume o) {
        if (this.equals(o)) {
            return 0;
        } else {
            if (this.getVolume() == o.getVolume())
                return 1;
            else if (this.getVolume() > 0)
                return 1;
            else
                return -1;
        }
    }
}
