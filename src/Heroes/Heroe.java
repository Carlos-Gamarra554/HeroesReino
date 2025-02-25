package Heroes;
import Armas.ArmaEspecial;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Heroe {
    private String nombre;
    private int nivel;
    protected int vida;
    ArmaEspecial armaEspecial;

    public Heroe(String nombre, int nivel, int vida,ArmaEspecial armaEspecial) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        this.armaEspecial = armaEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public ArmaEspecial getArmaEspecial() {
        return armaEspecial;
    }

    public static int tirarDado() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(20) + 1;

        return numeroAleatorio;
    }

    public void addHeroe(LinkedList<Heroe> gremio) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Qué tipo de héroe deseas añadir?\n" +
                "1: Guerrero/a\n" +
                "2: Mago/a\n" +
                "3: Arquero/a\n" +
                "4: Asesino/a\n" +
                "Elige una subopción: ");

        int opcion;

        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Error. Solo debes introducir números entre 1 y 4.");
            return;
        }

        if (opcion < 1 || opcion > 4) {
            System.out.println("Error. Solo debes introducir números entre 1 y 4.");
            return;
        }
        System.out.println("------------------------------------------------");

        System.out.print("Nombre del héroe: ");
        String nombre = sc.nextLine();

        if (findHeroe(nombre, gremio)) {
            System.out.println("El héroe ya existe.");
            return;
        }

        try {
            System.out.print("Nivel: ");
            int nivel = sc.nextInt();
            sc.nextLine();

            System.out.print("Puntos de vida: ");
            int vida = sc.nextInt();
            sc.nextLine();

            int atributoExtra;

            switch (opcion) {
                case 1:
                    System.out.print("Fuerza: ");
                    atributoExtra = sc.nextInt();
                    sc.nextLine();

                    ArmaEspecial arma = armaEspecial.getArmaEspecial();
                    gremio.add(new Guerrero(nombre, nivel, vida, atributoExtra, arma));
                    break;

                case 2:
                    System.out.print("Mana: ");
                    atributoExtra = sc.nextInt();
                    sc.nextLine();

                    arma = armaEspecial.getArmaEspecial();
                    gremio.add(new Mago(nombre, nivel, vida, atributoExtra, arma));
                    break;

                case 3:
                    System.out.print("Precisión: ");
                    atributoExtra = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nº de Flechas: ");
                    int flechas = sc.nextInt();
                    sc.nextLine();

                    arma = armaEspecial.getArmaEspecial();
                    gremio.add(new Arquero(nombre, nivel, vida, atributoExtra, flechas, arma));
                    break;

                case 4:
                    System.out.print("Sigilo: ");
                    atributoExtra = sc.nextInt();
                    sc.nextLine();

                    arma = armaEspecial.getArmaEspecial();
                    gremio.add(new Asesino(nombre, nivel, vida, atributoExtra, arma));
                    break;
            }
            System.out.println("Héroe añadido con éxito!");
            System.out.println("------------------------------------------------");
        } catch (NumberFormatException e) {
        System.out.println("Error. Solo puedes introducir números!");
            System.out.println("------------------------------------------------");
        }
    }

    public boolean removeHeroe(LinkedList<Heroe> gremio) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del héroe que quieras eliminar: ");
        String nombre = sc.nextLine();

        for (Heroe h : gremio) {
            if(findHeroe(nombre, gremio) == true) {
                gremio.remove(h);
                System.out.println("Héroe eliminado exitosamente del gremio!");
                return true;
            } else {
                System.out.println("No se ha encontrado al héroe");
            }
        }
        return false;
    }

    public boolean findHeroe(String nombre, LinkedList<Heroe> gremio) {
        for (Heroe h : gremio) {
            if(h.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "-" + nombre + " [Nivel:" + nivel + ", Vida: " + vida + ", Arma Especial: " + armaEspecial.toString();
    }
}
