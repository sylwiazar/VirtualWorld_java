
package wirtualizacjaswiata;

import java.awt.Color;
import java.util.Random;

public class Zolw extends Zwierze {
    
    private static final char ZOLW = 'Z';
    private static final int ZOLW_INICJATYWA = 1;
    private static final int ZOLW_SILA = 2;
    private static final String ZOLW_NAZWA = "Zolw";
    private static final int ZASIEG_RUCHU_DEFAULT = 1;
    //Prawdopodobienstwo z jakim ZOLW zmieni swoje polozenie w %
    private static final int PRAWDOPODOBIENSTWO_ZMIANY_POLOZENIA_ZOLWIA = 25;
    //Jesli przeciwnik ma mniejszą siłę niż ta wartość, to musi wrocic na swoje miejsce
    private static final int MAKSYMALNA_SILA_PRZECIWNIKA_BY_ZOLW_ODBIL_ATAK = 4;
    public static final int ID = 9;
    
    public Zolw()
    {
       super(ZOLW_NAZWA, ZOLW_SILA, ZOLW_INICJATYWA, ZOLW, ZASIEG_RUCHU_DEFAULT, new Color(17,81,27));
    }

    public Zolw(int x, int y, int sila, int wiek)
    {
        super(ZOLW_NAZWA, sila, ZOLW_INICJATYWA, ZOLW, ZASIEG_RUCHU_DEFAULT, wiek, x, y, new Color(17,81,27));
    }
    
    @Override
    public int GetId()
    {
        return ID;
    }
    
    @Override
    public boolean SprawdzCzyZmieniPolozenie()
    {
        Random generator = new Random();
        return generator.nextInt(100) < PRAWDOPODOBIENSTWO_ZMIANY_POLOZENIA_ZOLWIA;
    }
    
    @Override
    public boolean SprawdzCzyOdbijeAtak(int silaprzeciwnika)
    {
        return silaprzeciwnika <= MAKSYMALNA_SILA_PRZECIWNIKA_BY_ZOLW_ODBIL_ATAK;
    }
}
