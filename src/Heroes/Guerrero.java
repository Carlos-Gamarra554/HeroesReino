package Heroes;

import Armas.ArmaEspecial;

public class Guerrero extends Heroe{
    private int fuerza;

    public Guerrero(String nombre, int nivel, int vida, int fuerza, ArmaEspecial armaEspecial) {
        super(nombre, nivel, vida, armaEspecial);
        this.fuerza = fuerza;
    }

    public void atacar() {
        int tirada = tirarDado();

        if (vida < 1){
            System.out.println("No puedes atacar, estás muerto");
        } else {
                if (tirada == 1) {
                    System.out.println("Has sacado un " + tirada + " y has pifiado! La espada se te escapa de las manos y se te cae al suelo");
                } else if (tirada > 1 && tirada <= 10) {
                    System.out.println("Has sacado un " + tirada + ". Lanzas un ataque al aire y fallas!");
                } else if (tirada > 10 && tirada < 20) {
                    System.out.println("Has sacado un " + tirada + " y atacas a tu enemigo! Has infligido " + (fuerza+armaEspecial.getDaño())+tirada + " puntos de daño");
                } else if (tirada == 20) {
                    System.out.println("Has sacado un " + tirada + "! Le cortas la cabeza a tu enemigo de un tajazo!");
                }
            }
        System.out.println("------------------------------------------------");
        }

    @Override
    public String toString() {
        return super.toString() + ", Fuerza: " + fuerza + "]";
    }
}
