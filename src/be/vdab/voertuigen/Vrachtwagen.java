package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

public class Vrachtwagen extends Voertuig implements Laadbaar {
    private Volume laadvolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;


    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen) {
        super(merk, aankoopprijs);
        setLaadvolume(laadvolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume volume) {
        if (volume!=null) {
            this.laadvolume = volume;
        }else {
            throw new IllegalArgumentException("Laadvolume moet ingevuld worden!");
        }
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if (maximaalToegelatenMassa > 0) {
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        } else {
            throw new IllegalArgumentException("Maximaal toegelaten massa moet groter dan 0 zijn!");
        }
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if (aantalAssen > 0) {
            this.aantalAssen = aantalAssen;
        } else {
            throw new IllegalArgumentException("Aantal assen moet groter dan 0 zijn!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Maximaal toegelaten massa=" + maximaalToegelatenMassa + "ton, Aantal assen=" + aantalAssen + ", Laadvolume=" + laadvolume.getVolume() + "cm³";
    }
}
