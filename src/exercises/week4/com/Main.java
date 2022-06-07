package exercises.week4.com;

public class Main {
	// metoda ako druhy parameter ocakava instanciu typu Dekorovanie,
	// ale kedze toto rozhranie je tzv. funkcionalne (functional),
	// cize obsahuje len jednu abstraktnu metodu,
	// mozno namiesto instancie poskytnut odkaz na metodu
	public void dekorujVsetko(String[] p, Dekoracia d) {
		for (int i = 0; i < p.length; i++) {
			p[i] = d.dekoruj(p[i]);
		}
	}

	public static void main(String[] args) {
		String[] p = {"aaa", "bbb", "ccc"};
		
		Main m = new Main();

		// 1: dekoracia pomocou metody dekoruj() objektu d:
	//	Dekoracia d = new DekoraciaPlusom();
	//	m.dekorujVsetko(p, d::dekoruj);

		// dekoracia pomocou anonymnej triedy odvodenej od rozhrania Dekoracia:
/*		m.dekorujVsetko(p, new Dekoracia() {
			public String dekoruj(String s) {
				return s + "+";
			}
		});
*/
		// 2: dekoracia pomocou lambda vyrazu - trieda DekoraciaPlusom nie je potrebna:
/*		Dekoracia dl = (String s) -> { return s + "+"; };
		m.dekorujVsetko(p, dl);
*/
		// 3: to iste, ale kratsie - s vyuzitim automatickej inferencie typov:
/*		Dekoracia dl = s -> { return s + "+"; };
		m.dekorujVsetko(p, dl);
*/
		// 4: alebo este kratsie - bez klauzuly return:
/*		Dekoracia dl = s -> s + "+";
		m.dekorujVsetko(p, dl);
*/		
		// 5: dekoracia pomocou lambda vyrazu bez pomenovania operacie
//		m.dekorujVsetko(p, s -> { return s + "+"; });

		// 6: najkratsi variant:
		m.dekorujVsetko(p, s -> s + "+");
		
		for (String s : p) 	
			System.out.println(s);
	
	}
}
