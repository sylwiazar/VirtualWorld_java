package wirtualizacjaswiata;

import java.awt.Color;

public class Owca extends Zwierze{
    
    private static final char OWCA = 'O';
    private static final int OWCA_INICJATYWA = 4;
    private static final int OWCA_SILA = 4;
    private static final String OWCA_NAZWA = "Owca";
    private static final int ZASIEG_RUCHU_DEFAULT = 1;
    public static final int ID = 5;
    
    public Owca()
    {
        super(OWCA_NAZWA, OWCA_SILA, OWCA_INICJATYWA, OWCA, ZASIEG_RUCHU_DEFAULT, new Color(176,169,169));
    }

    public Owca(int x, int y, int sila, int wiek)
    {
       super(OWCA_NAZWA, sila, OWCA_INICJATYWA, OWCA, ZASIEG_RUCHU_DEFAULT, wiek, x, y, new Color(176,169,169));
    }
    
    @Override
        public int GetId()
    {
        return ID;
    }
}
