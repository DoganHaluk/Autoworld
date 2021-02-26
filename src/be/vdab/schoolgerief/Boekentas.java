package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {
    private static final long serialVersionUID = 1L;
    private String kleur;
    private Volume laadvolume;

    public Boekentas(String kleur, Volume laadvolume) {
        setKleur(kleur);
        setLaadvolume(laadvolume);
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if (kleur != null && !kleur.isEmpty()) {
            this.kleur = kleur;
        } else {
            throw new IllegalArgumentException("Laadvolume moet ingevuld worden!");
        }
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume volume) {
        if (volume != null) {
            this.laadvolume = volume;
        } else {
            throw new IllegalArgumentException("Laadvolume moet ingevuld worden!");
        }
    }

    @Override
    public String toString() {
        return "kleur=" + kleur + ", laadvolume=" + laadvolume.getVolume() + "cm³";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boekentas boekentas = (Boekentas) o;
        return Objects.equals(kleur, boekentas.kleur) && Objects.equals(laadvolume, boekentas.laadvolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kleur, laadvolume);
    }
}
