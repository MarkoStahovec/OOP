package logovanie;
import postavy.*;

public aspect Logovanie {
/*	
	before(): call(* Obor.odveta(..)) {
		System.out.println("odveta");
	}
*/
	before(Obor o): call(* Obor.odveta(..)) && target(o) {
		System.out.println("pred odvetou: hladny = " + o.zistiHladny());
	}

	after(Obor o): call(* Obor.odveta(..)) && target(o) {
		System.out.println("po odvete: hladny = " + o.zistiHladny());
	}
}
