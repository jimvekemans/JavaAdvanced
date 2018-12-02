package Serialization;

import java.io.*;
import java.time.LocalDateTime;

public class SerializationApp {
    public static void main(String[] args) {

        Spaarrekening spaarrekening = new Spaarrekening("500", "Angiolillo", "BE75064215");

        String text = new String("This is some text");

        serializeWriter(spaarrekening);
        serializeReader("MyFileSerialized.ser");


    }

    public static void serializeWriter(Spaarrekening spaarrekening) {
        LocalDateTime date = LocalDateTime.now();
        try (FileOutputStream file = new
                FileOutputStream("MyFileSerialized.ser");
             ObjectOutputStream out = new ObjectOutputStream(file)) {
//            out.writeObject(spaarrekening.getName());
//            out.writeObject(spaarrekening.getSaldo());
//            out.writeObject(spaarrekening.getRekNummer());
            out.writeObject(spaarrekening);
            out.writeObject(date);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void serializeReader(String fileInput) {
        try (FileInputStream file = new
                FileInputStream(fileInput);
             ObjectInputStream in = new ObjectInputStream(file)) {
            Spaarrekening spaarrekening = (Spaarrekening) in.readObject();
            LocalDateTime date = (LocalDateTime) in.readObject();
            System.out.println(date);
            System.out.println(spaarrekening.getName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Spaarrekening implements Serializable {

    private String saldo;
    private String name;
    private String rekNummer;


    public Spaarrekening(String saldo, String name, String rekNummer) {
        this.saldo = saldo;
        this.name = name;
        this.rekNummer = rekNummer;

    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRekNummer() {
        return rekNummer;
    }

    public void setRekNummer(String rekNummer) {
        this.rekNummer = rekNummer;
    }
}
