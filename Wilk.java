
package wirtualizacjaswiata;

import java.awt.Color;

public class Wilk extends Zwierze{
    
    private static final char WILK = 'W';
    private static final int WILK_INICJATYWA = 5;
    private static final int WILK_SILA = 9;
    private static final String WILK_NAZWA = "Wilk";
    private static final int ZASIEG_RUCHU_DEFAULT = 1;
    public static final int ID = 8;
    
    public Wilk()
    {  
       super(WILK_NAZWA, WILK_SILA, WILK_INICJATYWA, WILK, ZASIEG_RUCHU_DEFAULT, new Color(87,68,24));
    }

    public Wilk(int x, int y, int sila, int wiek)
    {
        super(WILK_NAZWA, sila, WILK_INICJATYWA, WILK, ZASIEG_RUCHU_DEFAULT, wiek, x,y, new Color(87, 68, 24));
    }
    
    @Override
    public int GetId()
    {
        return ID;
    }
        
}
