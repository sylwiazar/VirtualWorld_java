
package wirtualizacjaswiata;

import java.awt.Color;

public class Trawa extends Roslina{
    
    private static final char TRAWA = 'T';
    private static final int TRAWA_INICJATYWA = 0;
    private static final int TRAWA_SILA = 0;
    private static final String TRAWA_NAZWA = "Trawa";
    public static final int ID = 6;
    
    public Trawa()
    {   
      super(TRAWA_NAZWA, TRAWA_SILA, TRAWA_INICJATYWA, TRAWA, new Color(11,210,97));
    }

    public Trawa(int x, int y, int sila, int wiek)
    {
        super(TRAWA_NAZWA, sila, TRAWA_INICJATYWA, TRAWA, wiek, x, y, new Color(11,210,97));
    }
    
    @Override
        public int GetId()
    {
        return ID;
    }
}
