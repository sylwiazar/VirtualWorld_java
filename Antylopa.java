
package wirtualizacjaswiata;

import java.awt.Color;
import java.util.Random;

public class Antylopa extends Zwierze {
    
    private static final char ANTYLOPA = 'A';
    private static final int ANTYLOPA_INICJATYWA = 4;
    private static final int ANTYLOPA_SILA = 4;
    private static final String ANTYLOPA_NAZWA = "Antylopa";
    private static final int ZASIEG_RUCHU_ANTYLOPY = 2;
    public static final int ID = 10;
    
    public Antylopa()
    {
        super(ANTYLOPA_NAZWA, ANTYLOPA_SILA, ANTYLOPA_INICJATYWA,ANTYLOPA, ZASIEG_RUCHU_ANTYLOPY, new Color(227,240,111));
    }
     
    public Antylopa (int x, int y, int sila, int wiek)
    {
        super(ANTYLOPA_NAZWA,sila, ANTYLOPA_INICJATYWA, ANTYLOPA, ZASIEG_RUCHU_ANTYLOPY, wiek, x, y, new Color(227,240,111));
    }
    
    @Override
    public boolean CzyWMomencieAtakuUcieknieNaInneMiejsce()
    {
        Random generator = new Random();
        int szansa_na_ucieczke = generator.nextInt(100);
	
        return szansa_na_ucieczke < 50;
    }
    
    @Override
    public int GetId()
    {
        return ID;
    }
}
