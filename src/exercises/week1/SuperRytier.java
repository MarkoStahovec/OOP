package exercises.week1;

public class SuperRytier extends Rytier {

    void utok(Obor obor) {
        obor.energia = (int) (0.8 * obor.energia); // (int) len pretypuje float vysledok na int
        obor.odveta(this); // this predstavuje odkaz na aktualny objekt rytiera
    }
}
