import Armas.ArmaEspecial;
import Heroes.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Heroe> gremio = new LinkedList<Heroe>();
    static ArrayList<ArmaEspecial> arsenal = new ArrayList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArmaEspecial espada = new ArmaEspecial("Scalibur", 34);
        arsenal.add(espada);
        ArmaEspecial rayo = new ArmaEspecial("Rayo Cegador", 12);
        arsenal.add(rayo);

        Heroe heroes = new Heroe("Heroe", 1, 100, espada);
        gremio.add(new Guerrero("Germán", 14,100,36, espada));
        gremio.add(new Mago("Daniel",23,150,400, rayo));

        int opcion = -1;
        menu();

        try {
        while (opcion != 9) {
            System.out.print("Elige una opcion: ");
                opcion = sc.nextInt();
                System.out.println("------------------------------------------------");

                switch (opcion) {
                    case 1:
                        System.out.println("Vamos a añadir un héroe al gremio!");
                        heroes.addHeroe(gremio);
                        break;

                    case 2:
                        System.out.println("Vamos a añadir un nuevo arma al arsenal!");
                        espada.addArmaEspecial();
                        break;

                    case 3:
                        System.out.println("Vamos a eliminar un héroe del gremio!");
                        heroes.removeHeroe(gremio);
                        break;

                    case 4:
                        System.out.println("Vamos a buscar un héroe por su nombre!");
                        sc.nextLine();
                        System.out.print("Primero introduce su nombre: ");
                        String nombre = sc.nextLine();

                        if (heroes.findHeroe(nombre, gremio)) {
                            System.out.println("Hemos encontrado al héroe! Sus stats son:");
                            heroes.toString();
                        } else {
                            System.out.println("No existe el héroe que buscas.");
                        }
                        System.out.println("------------------------------------------------");
                        break;

                    case 5:
                        printGremio();
                        break;

                    case 6:
                        espada.printWeapons(arsenal);
                        break;

                    case 7:
                        play();
                        break;

                    case 8:
                        menu();
                        break;

                    case 9:
                        System.out.println("Saliendo del programa...");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error. Solo puedes introducir números!");
        }
    }

    public static void play() {
        Scanner sc = new Scanner(System.in);

        if (gremio.isEmpty()) {
            System.out.println("No hay héroes con los que jugar.");
            return;
        }

        printGremio();
        System.out.print("Introduce el nombre del héroe con el que quieras jugar: ");
        String nombre = sc.nextLine();

        Heroe seleccionado = null;
        for (Heroe h : gremio) {
            if (h.getNombre().equalsIgnoreCase(nombre)) {
                seleccionado = h;
                break;
            }
        }

        if (seleccionado == null) {
            System.out.println("No existe un héroe con ese nombre.");
            System.out.println("------------------------------------------------");
            return;
        }
                    if (seleccionado instanceof Guerrero) {
                        System.out.println(nombre + " va a realizar un ataque! Tira un dado de 20");
                        ((Guerrero) seleccionado).atacar();
                    } else if (seleccionado instanceof Mago) {
                        System.out.println(nombre + " va a lanzar un hechizo! Tira un dado de 20");
                        ((Mago) seleccionado).hechizar();
                    } else if (seleccionado instanceof Asesino) {
                        System.out.println(nombre + " va realizar una ataque sigiloso! Tira un dado de 20");
                        ((Asesino) seleccionado).asesinar();
                    } else if (seleccionado instanceof Arquero) {
                        System.out.println(nombre + " va a efectuar un disparo! Tira un dado de 20");
                        ((Arquero) seleccionado).disparar();
                    }
                }

    public static void menu() {
        System.out.println("1. Añadir un nuevo héroe\n" +
                "2. Añadir un nuevo arma al arsenal\n" +
                "3. Eliminar un héroe por su nombre\n" +
                "4. Buscar un héroe y mostrar sus stats\n" +
                "5. Listar todos los héroes registrados en el gremio\n" +
                "6. Listar armas del arsenal\n" +
                "7. Jugar con un héroe\n" +
                "8. Imprimir menú\n" +
                "9. Salir del programa");
    }

    public static void printGremio() {
        if (gremio.isEmpty()) {
            System.out.println("El gremio está vacío.");
            System.out.println("------------------------------------------------");
            return;
        }

        System.out.println("Héroes en el gremio:");
        for (Heroe h : gremio) {
            System.out.println(h.toString());
        }
        System.out.println("------------------------------------------------");
    }
}