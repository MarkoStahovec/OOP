package exercises.week4.gui;

import exercises.week4.stret.Stret;
import javafx.scene.control.*;
import exercises.week4.stret.SledovatelStretu;
import exercises.week4.stret.Stret;

public class EnergiaBojovnikov extends TextField implements SledovatelStretu {
	private Stret stret;
	private int energia;

	public EnergiaBojovnikov(Stret stret) {	
		super();
		this.stret = stret;
	}

	public void upovedom() {
		energia = 0;
		
		for (int i = 0; i < stret.zistiPocetBojovnikov(); ++i)
			energia += stret.zistiRytiera(i).zistiEnergiu() + stret.zistiObra(i).zistiEnergiu();

		setText(Integer.toString(energia));
	}
}
