package Heroes;

import Armas.ArmaEspecial;

public class Asesino extends Heroe{
    private int sigilo;

    public Asesino(String nombre, int nivel, int vida, int sigilo, ArmaEspecial armaEspecial) {
        super(nombre, nivel, vida, armaEspecial);
        this.sigilo = sigilo;
    }

    public void asesinar() {
        System.out.println("Tira un dado de 20 para asesinar!");
        int tirada = tirarDado();

        if (vida < 1){
            System.out.println("No puedes atacar, estás muerto");
        } else {
            if (tirada == 1) {
                System.out.println("Has sacado un 1 y has pifiado! Te tropiezas y te haces 15 puntos de daño!");
                this.vida -= 15;
            } else if (tirada > 1 && tirada <= 10) {
                System.out.println("Has sacado un " + tirada + "! Intentas clavar el cuchillo pero te pillan, debes huir!");
            } else if (tirada > 10 && tirada < 20) {
                System.out.println("Has sacado un " + tirada + " y atacas al enemigo! Le has infligido " + armaEspecial.getDaño()*tirada + " puntos de daño");
            } else if (tirada == 20) {
                System.out.println("Has sacado un 20! Has asesinado al enemigo");
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Asesino, Sigilo=" + sigilo + "]";
    }
}
