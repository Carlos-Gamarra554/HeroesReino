package Heroes;
import Armas.ArmaEspecial;
import java.util.Scanner;

public class Mago extends Heroe{
    private int mana;

    public Mago(String nombre, int nivel, int vida, int mana, ArmaEspecial armaEspecial) {
        super(nombre, nivel, vida, armaEspecial);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void hechizar() {
        int tirada = tirarDado();

        if (vida < 1){
            System.out.println("No puedes atacar, estás muerto");
        } else if (mana < 100) {
            System.out.println("No tienes suficiente mana para lanzar el hechizo!");
        } else {
            if (tirada == 1) {
                System.out.println("Has sacado un 1 y has pifiado! Te lanzas un hechizo a tí mismo y te haces 25 puntos de daño!");
                this.vida -= 25;
            } else if (tirada > 1 && tirada <= 10) {
                System.out.println("Has sacado un " + tirada + "! Intentas lanzar un hechizo pero no eres capaz de conseguirlo!");
            } else if (tirada > 10 && tirada < 20) {
                System.out.println("Has sacado un " + tirada + " y lanzas un hechizo! Has infligido " + armaEspecial.getDaño()*tirada + " puntos de daño y has consumido 100 de maná");
                this.mana -= 100;
            } else if (tirada == 20) {
                System.out.println("Has sacado un 20! Has reducido al enemigo a cenizas y gastas 100 de maná");
                this.mana -= 100;
            }
        }
        System.out.println("------------------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Mago, Maná: " + mana + "]";
    }
}
