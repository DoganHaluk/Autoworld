package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

public class Pickup extends Personenwagen implements Laadbaar {
    private Volume laadvolume;

    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume laadvolume) {
        super(merk, aankoopprijs, zitplaatsen);
        setLaadvolume(laadvolume);
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume volume) {
        this.laadvolume=volume;
    }

    @Override
    public String toString() {
        return super.toString() + ", Laadvolume=" + laadvolume.getVolume()+"cm³";
    }
}
