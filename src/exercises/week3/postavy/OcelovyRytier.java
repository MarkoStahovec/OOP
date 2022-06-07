package exercises.week3.postavy;

public class OcelovyRytier extends Rytier{
    public OcelovyRytier(int energia) {
        super(energia);
    }
    public OcelovyRytier(int energia, Mec mec) {
        super(energia, mec);
    }
    public OcelovyRytier() {}

    public void utoc(Obor obor) {
//		obor.nastavEnergiu((int) (0.9 * obor.zistiEnergiu()));
/*
		if (mec instanceof SvetelnyMec) {
			udriSvetelnymMecom(obor);
		} else if (mec instanceof OcelovyMec) {
			udriOcelovymMecom(obor);
		} else {
		}
*/
//		mec.udriStatocnyRytier(obor, this);
        mec.udri(obor, this);

        obor.odveta(this);
    }
}
