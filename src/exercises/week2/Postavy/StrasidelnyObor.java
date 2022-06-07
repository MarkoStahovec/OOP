package exercises.week2.Postavy;

public class StrasidelnyObor extends ZlyObor
{

    @Override
    public void zjedz(Rytier rytier) {
        super.zjedz(rytier);
        zarev();
    }

    void zarev()
    {
        System.out.println("ARRRRGHH!");
    }
}
