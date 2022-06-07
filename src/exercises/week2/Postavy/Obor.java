package exercises.week2.Postavy;
import exercises.week2.Energia.Energia;
import exercises.week2.Mec.Mec;

public class Obor implements Energia {
	private boolean hladny;
	private int energia;

	public Obor()
	{

	}

	public boolean zistiHlad()
	{
		return hladny;
	}

	public Obor(int energia)
	{
		nastavEnergiu(energia);
	}
	
	public void nastavEnergiu(int energia) {
		this.energia = energia;
	}
	public void zvysEnergiu(int energia) {
		this.energia += energia;
	}
	public void znizEnergiu(int energia) {
		this.energia -= energia;
	}
	public int zistiEnergiu() {
		return energia;
	}

	public void nastav(boolean hladny) {
		this.hladny = hladny;
	}

	public void nastav(int energia, boolean hladny) {
		nastavEnergiu(energia);
		this.hladny = hladny;
	}

	public void odveta(Rytier rytier) {
		if (zistiEnergiu() > rytier.zistiEnergiu())
//			rytier.energia = (int) (0.9 * rytier.energia);
			// k energii sa uz neda pristupit priamo, lebo je private
			rytier.nastavEnergiu((int) (0.9 * rytier.zistiEnergiu()));
	}
}

