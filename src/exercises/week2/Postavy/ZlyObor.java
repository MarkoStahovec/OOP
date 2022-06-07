package exercises.week2.Postavy;

public class ZlyObor extends Obor {
	boolean hladny; // pozor na skryvanie atributov!


	public ZlyObor()
	{

	}

	public ZlyObor(int energia)
	{
		super(energia);
	}

	public void odveta(Rytier rytier) {
		if (zistiHlad())
			zjedz(rytier);
	}
	public void zjedz(Rytier rytier) {
		rytier.nastavEnergiu(0);
	}
}
