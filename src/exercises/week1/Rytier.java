package exercises.week1;

public class Rytier {
	int energia;
	double rand;
	
	void utok(Obor obor) {
		rand = Math.random();
		obor.energia = (int) (rand * obor.energia); // (int) len pretypuje float vysledok na int
		obor.odveta(this); // this predstavuje odkaz na aktualny objekt rytiera
		System.out.println(this);
	}
}
