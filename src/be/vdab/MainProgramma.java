package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;


public class MainProgramma {
    public static void main(String[] args) throws IOException {

        Personenwagen personenwagen1 = null;
        Personenwagen personenwagen2 = null;
        Pickup pickup1 = null;
        Pickup pickup2 = null;
        Vrachtwagen vrachtwagen1 = null;
        Vrachtwagen vrachtwagen2 = null;
        Boekentas boekentas1 = null;
        Boekentas boekentas2 = null;

        try {
            personenwagen1 = new Personenwagen("Porsche", 99000, 4);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
        try {
            personenwagen2 = new Personenwagen("Ferrari", 189000, 2);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
        try {
            pickup1 = new Pickup("GMC", 39000, 4, new Volume(178, 56, 200, Maat.CENTIMETER));
        } catch (IllegalArgumentException | VolumeException ve) {
            System.err.println(ve.getMessage());
        }
        try {
            pickup2 = new Pickup("RAM", 29000, 5, new Volume(16, 5, 19, Maat.DECIMETER));
        } catch (IllegalArgumentException | VolumeException ve) {
            System.err.println(ve.getMessage());
        }
        try {
            vrachtwagen1 = new Vrachtwagen("Scania", 67000, new Volume(3, 2, 16, Maat.METER), 44, 5);
        } catch (IllegalArgumentException | VolumeException ve) {
            System.err.println(ve.getMessage());
        }
        try {
            vrachtwagen2 = new Vrachtwagen("DAF", 79000, new Volume(3, 2, 22, Maat.METER), 50, 8);
        } catch (IllegalArgumentException | VolumeException ve) {
            System.err.println(ve.getMessage());
        }
        try {
            boekentas1 = new Boekentas("zwart", new Volume(32, 53, 25, Maat.CENTIMETER));
        } catch (IllegalArgumentException | VolumeException ve) {
            System.err.println(ve.getMessage());
        }
        try {
            boekentas2 = new Boekentas("blauw", new Volume(35, 48, 28, Maat.CENTIMETER));
        } catch (IllegalArgumentException | VolumeException ve) {
            System.err.println(ve.getMessage());
        }

        var autos = new TreeSet<Voertuig>();
        autos.add(personenwagen1);
        autos.add(personenwagen2);
        autos.add(pickup1);
        autos.add(pickup2);
        autos.add(vrachtwagen1);
        autos.add(vrachtwagen2);
        System.out.println("//Voertuigen in een sortedset");
        autos.forEach(System.out::println);

        System.out.println("\n//Voertuigen in een bestand");
        try (var stream = new ObjectOutputStream(Files.newOutputStream(Path.of("/data/wagenpark.dat")))) {
            stream.writeObject(autos);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        var herlezendeAutos = new TreeSet<>();
        try (var stream = new ObjectInputStream(Files.newInputStream(Path.of("/data/wagenpark.dat")))) {
            herlezendeAutos = (TreeSet<Object>) stream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        herlezendeAutos.forEach(System.out::println);

        var boekentassen = new LinkedHashSet<Boekentas>();
        boekentassen.add(boekentas1);
        boekentassen.add(boekentas2);
        System.out.println("\n//Boekentassen in een hashset");
        boekentassen.forEach(System.out::println);

        var laadbaarArray = new Laadbaar[6];
        laadbaarArray[0] = pickup1;
        laadbaarArray[1] = pickup2;
        laadbaarArray[2] = vrachtwagen1;
        laadbaarArray[3] = vrachtwagen2;
        laadbaarArray[4] = boekentas1;
        laadbaarArray[5] = boekentas2;
        System.out.println("\n//Laadbaar objecten in een array");
        Arrays.stream(laadbaarArray).forEach(System.out::println);
        var totaalLaadVolume = 0;
        for (var laadbaar : laadbaarArray) {
            totaalLaadVolume += (long) laadbaar.getLaadvolume().getVolume();
        }
        System.out.println("\nHet totale laadvolume=" + totaalLaadVolume + "cm³");
    }
}
