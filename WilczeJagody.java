
package wirtualizacjaswiata;

import java.awt.Color;

public class WilczeJagody extends Roslina {
    
    private static final char WILCZE_JAGODY = 'J';
    private static final int WILCZE_JAGODY_INICJATYWA = 0;
    private static final int WILCZE_JAGODY_SILA = 99;
    private static final String WILCZE_JAGODY_NAZWA = "Jagody";
    public static final int ID = 7;
    
    public WilczeJagody()
    {
        super(WILCZE_JAGODY_NAZWA, WILCZE_JAGODY_SILA, WILCZE_JAGODY_INICJATYWA, WILCZE_JAGODY, new Color(110,18,100));
    }

    public WilczeJagody(int x, int y, int sila, int wiek)
    {
        super(WILCZE_JAGODY_NAZWA, sila, WILCZE_JAGODY_INICJATYWA, WILCZE_JAGODY, wiek, x, y, new Color(110,18,100));
    }

    @Override
    public boolean ZjedzenieSmiertelnejRosliny()
    {
	return true;
    }
    
    @Override
    public int GetId()
    {
        return ID;
    }  
}
