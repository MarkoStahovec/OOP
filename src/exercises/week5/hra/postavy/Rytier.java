package exercises.week5.hra.postavy;

import java.io.*;
import java.util.*;

public class Rytier implements Energia, Serializable, BojovaZlozka {
	public static final long serialVersionUID = 0;

	public List<Rytier> vyberBojovnikov() {
		List<Rytier> jednotlivci = new ArrayList<>();
		jednotlivci.add(this);
		return jednotlivci;
	}
	
	private int energia;
	protected Mec mec;

	public Rytier(int energia) {
		nastavEnergiu(energia);
	}
	public Rytier(int energia, Mec mec) {
		nastavEnergiu(energia);
		this.mec = mec;
	}
	public Rytier() {
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
	
	public int ukazMec() {
		return mec.zistiVyrobneCislo();
	}

	public Mec zistiMec() {
		return mec;
	}

	public void utoc(Obor obor) {
		mec.udri(obor, this);		
		obor.odveta(this); 
	}
}
