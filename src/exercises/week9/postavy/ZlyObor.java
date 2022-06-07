package exercises.week9.postavy;

public class ZlyObor extends Obor {
	public static final long serialVersionUID = 0;
	
	public ZlyObor(int energia, boolean hladny) {
		super(energia, hladny);
	}
	public ZlyObor(int energia) {
		super(energia);
	}
	public ZlyObor() {
		super();
	}	
	
	public void odveta(Rytier rytier) {
		if (zistiHladny())
			zjedz(rytier);
	}
	public void zjedz(Rytier rytier) {
		rytier.nastavEnergiu(0);
	}

}
