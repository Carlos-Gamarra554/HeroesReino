package Armas;
import java.util.ArrayList;
import java.util.Scanner;

public class ArmaEspecial {
    private String nombre;
    private int daño;
    private static ArrayList<ArmaEspecial> ar = new ArrayList<>();

    public ArmaEspecial(String nombre, int daño) {
        this.nombre = nombre;
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void printWeapons(ArrayList<ArmaEspecial> ar) {
        if (ar.isEmpty()) {
            System.out.println("No hay armas disponibles.");
            System.out.println("------------------------------------------------");
            return;
        }

        int indice = 1;
        System.out.println("Armas en el arsenal:");
        for (ArmaEspecial armaEspecial : ar) {
            System.out.println(indice + ". " + armaEspecial.getNombre() + " (Daño: " + armaEspecial.getDaño() + ")");
            indice++;
        }
        System.out.println("------------------------------------------------");
    }

    public void addArmaEspecial() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del nuevo arma: ");
        String nombre = sc.nextLine();
        for (ArmaEspecial ar : ar) {
            if (ar.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Este arma ya existe!");
                return;
            }
        }

        System.out.print("Ahora especifica el daño que hará: ");
        if (!sc.hasNextInt()) {
            System.out.println("Error. Debes introducir un número");
        } else {
            int daño = sc.nextInt();
            sc.nextLine();

            ar.add(new ArmaEspecial(nombre, daño));
            System.out.println("Arma añadida con éxito a tu arsenal!");
            System.out.println("------------------------------------------------");
        }
    }

    public ArmaEspecial getArmaEspecial() {
        if (ar.isEmpty()) {
            System.out.println("No hay armas disponibles.");
            return null;
        }

        Scanner sc = new Scanner(System.in);
        printWeapons(ar);
        System.out.print("Selecciona un arma especial para tu héroe: ");
        int arma = 0;

        if (sc.hasNextInt()) {
            arma = sc.nextInt();
            sc.nextLine();

            if (arma < 1 || arma > ar.size()) {
                System.out.println("Selección inválida. Por favor, elige un número entre 1 y " + ar.size());
                return getArmaEspecial();
            }
        }
        return ar.get(arma - 1);
    }

    @Override
    public String toString() {
        return nombre + " (Daño:" + daño + ")";
    }
}
