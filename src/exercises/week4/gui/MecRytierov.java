package exercises.week4.gui;

import exercises.week4.postavy.Mec;
import exercises.week4.stret.Stret;
import javafx.scene.control.*;
import exercises.week4.stret.SledovatelStretu;
import exercises.week4.stret.Stret;

public class MecRytierov extends TextField implements SledovatelStretu {
    private Stret stret;
    private int vyrobne_cislo;

    public MecRytierov(Stret stret) {
        super();
        this.stret = stret;
    }

    public void upovedom() {
        vyrobne_cislo = 0;

        for (int i = 0; i < stret.zistiPocetBojovnikov(); ++i)
            vyrobne_cislo = stret.zistiRytiera(i).zistiMec().zistiVyrobneCislo();

        setText(Integer.toString(vyrobne_cislo));
    }
}
