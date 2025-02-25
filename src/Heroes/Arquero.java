package Heroes;

import Armas.ArmaEspecial;

public class Arquero extends Heroe{
    private int precision;
    private int flechas;

    public Arquero(String nombre, int nivel, int vida, int precision, int flechas, ArmaEspecial armaEspecial) {
        super(nombre, nivel, vida, armaEspecial);
        this.precision = precision;
        this.flechas = flechas;
    }

    public void disparar() {
        System.out.println("Tira un dado de 20 para disparar!");
        int tirada = tirarDado();

        if (vida < 1) {
            System.out.println("No puedes disparar, estás muerto!");
        } else {
            if (tirada == 1) {
                System.out.println("Has sacado un 1 y has pifiado! Se te ha roto la flecha");
                this.flechas--;
            } else if (tirada > 1 && tirada <= 10) {
                System.out.println("Has sacado un " + tirada + "! Lanzas la flecha a un árbol e infliges 0 de daño");
            } else if (tirada > 10 && tirada < 20) {
                System.out.println("Has sacado un " + tirada + " y aciertas el disparo! Has infligido " + armaEspecial.getDaño() * tirada + " puntos de daño");
            } else if (tirada == 20) {
                System.out.println("Has sacado un 20! Le atraviesas el cráneo con la flecha y cae desplomado al suelo");
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Arquero, Precision: " + precision + ", nºFlechas: " + flechas + "]";
    }
}
