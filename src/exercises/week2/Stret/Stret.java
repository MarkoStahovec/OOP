package exercises.week2.Stret;

import exercises.week2.Energia.Energia;
import exercises.week2.Postavy.*;
import exercises.week2.Mec.Mec;

public class Stret {
	static void stret(Obor obor, Rytier rytier) {
		rytier.utok(obor);
	}
	
	// aj obor, aj rytier su bytosti, ktore disponuju energiou
	// rozhranie umozni jednotny pristup
	// potom mozeme definovat metodu, ktora zisti rozdiel energii akychkolvek dvoch bytosti
	static int zistiRozdielEnergii(Energia bytost1, Energia bytost2) {
		return bytost1.zistiEnergiu() - bytost2.zistiEnergiu();
	}


	public static void main(String[] args) {
		Obor[] o = new Obor[100];
		Rytier[] r = new Rytier[100];
		
		// toto je len inicializacia poli obrov a rytierov tak, aby sa prejavili rozne kombinacie
		for (int i = 0; i < 20; i++) {
			r[i] = new StatocnyRytier(140, new Mec(i));
			o[i] = new ZlyObor(50);
			o[i].nastav(true);

	//		o[i].zjedz(); // metoda zjedz() nie je v rozhrani triedy Obor!
/*			
			System.out.println(zistiRozdielEnergii(o[i], r[i]) + " " +
					zistiRozdielEnergii(r[i], o[i]) + " " +
					zistiRozdielEnergii(r[i], r[i]));
*/
		}

		for (int i = 20; i < 40; i++) {
			r[i] = new Rytier(50, new Mec(i));
			o[i] = new ZlyObor(50);
			o[i].nastav(false);
		}

		for (int i = 40; i < 100; i++) {
			r[i] = new Rytier(50, new Mec(i));
			o[i] = new StrasidelnyObor();
			o[i].nastav(50, true);
		}
		
		for (int i = 0; i < 100; i++) {
			stret(o[i], r[i]);
			System.out.println(i + ":" + "rytier " + r[i].zistiEnergiu() +
					" / " + "obor " + o[i].zistiEnergiu() + " mec: " + r[i].ukazMec());
		}
	}
}
