package exercises.week9.gui;

import exercises.week9.stret.*;

import javafx.scene.control.*;
import javafx.application.*;

public class EnergiaBojovnikov extends TextField implements SledovatelStretu {
	private Stret stret;
	private int energia;

	public EnergiaBojovnikov(Stret stret) {	
		super();
		this.stret = stret;
	}
	
	public void upovedom() {
		energia = stret.energiaObrov() + stret.energiaRytierov();
		Platform.runLater(() -> setText(Integer.toString(energia)));
	}
}
