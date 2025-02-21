package Heroes;
import Armas.ArmaEspecial;
import java.util.Scanner;

public class Mago extends Heroe{
    private int mana;

    public Mago(String nombre, int nivel, int vida, int mana, ArmaEspecial armaEspecial) {
        super(nombre, nivel, vida, armaEspecial);
        this.mana = mana;
    }

    public void hechizar() {
        System.out.println("Tira un dado de 20 para lanzar un hechizo!");
        int tirada = tirarDado();

        if (vida < 1){
            System.out.println("No puedes atacar, estás muerto");
        } else if (mana < 100) {
            System.out.println("No tienes suficiente mana para lanzar el hechizo!");
        } else {
            if (tirada == 1) {
                System.out.println("Pifia! Te lanzas un hechizo a tí mismo y te haces 100 puntos de daño!");
            } else if (tirada > 1 && tirada <= 10) {
                System.out.println("Intentas lanzar un hechizo pero no eres capaz de conseguirlo!");
            } else if (tirada > 10 && tirada < 20) {
                System.out.println("Has lanzado un hechizo! Has infligido " + armaEspecial.getDaño()*tirada + " puntos de daño y has consumido 100 de maná");
            } else if (tirada == 20) {
                System.out.println("Crítico! Has reducido al enemigo a cenizas y gastas 100 de maná");
            }
        }
    }

    public void regenerarMana() {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuánto tiempo vas a descansar?(min): ");
        int tiempo = sc.nextInt();

        System.out.println("Has regenerado " + tiempo*25 + " puntos de maná");
    }

    @Override
    public String toString() {
        return super.toString() + ", Maná: " + mana + "]";
    }
}
