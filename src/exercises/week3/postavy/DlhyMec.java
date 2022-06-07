package exercises.week3.postavy;

public class DlhyMec extends Mec{
    public DlhyMec(int vyrobneCislo) {
        super(vyrobneCislo);
    }

    //	public void udriRytier(Obor obor, Rytier rytier) {
    public void udri(Obor obor, Rytier rytier) {
        if (rytier.zistiEnergiu() >= obor.zistiEnergiu())
            obor.nastavEnergiu((int) (0.9 * obor.zistiEnergiu()));
        System.out.println("r-dm");
    }
    //	public void udriStatocnyRytier(Obor obor, StatocnyRytier rytier) {
    public void udri(Obor obor, StatocnyRytier rytier) {
        obor.nastavEnergiu((int) (0.9 * obor.zistiEnergiu()));
        System.out.println("sr-dm");
    }

    public void udri(Obor obor, OcelovyRytier rytier) {
        obor.nastavEnergiu((int) (0.9 * obor.zistiEnergiu()));
        System.out.println("or-dm");
    }
}
