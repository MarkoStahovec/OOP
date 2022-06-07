package exercises.week3.strat;

import java.lang.*;


//Strategy

public class Sifrovac {
    private Sifra sifra;
    public Sifrovac(Sifra sifra) {
        this.sifra = sifra;
    }
    public void sifrujText(String text) {
        //for(int i = 0; i < text.length(); i++)
            //text[i] = sifra.sifruj(text.charAt(i));
    }
}





interface Sifra {
    char sifruj(char c);
}

class SifraA implements Sifra {
    public char sifruj(char c) {
        return (char) (c+1);
    }
}

class SifraB implements Sifra {
    public char sifruj(char c) {
        return (char) (c - 1);
    }
}



