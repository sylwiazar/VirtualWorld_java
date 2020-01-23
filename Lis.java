
package wirtualizacjaswiata;

import java.awt.Color;

public class Lis extends Zwierze{
    
    private static final char LIS = 'L';
    private static final int LIS_INICJATYWA = 7;
    private static final int LIS_SILA = 3;
    private static final String LIS_NAZWA = "Lis";
    private static final int ZASIEG_RUCHU_DEFAULT = 1;
    public static final int ID = 3;
    
    public Lis()
    {    
        super(LIS_NAZWA, LIS_SILA, LIS_INICJATYWA, LIS, ZASIEG_RUCHU_DEFAULT, new Color(226,148,46));
    }

    public Lis(int x, int y, int sila, int wiek)
    {
      super(LIS_NAZWA, sila, LIS_INICJATYWA, LIS, ZASIEG_RUCHU_DEFAULT, wiek, x, y, new Color(226,148,46));
    }
    
    @Override
    public int GetId()
    {
        return 3;
    }
    
    @Override
    public boolean SprawdzCzyOdwazySieWalczycZSilniejszymOrganizmem(int sila_przeciwnika)
    {
        return sila_przeciwnika <= this.GetSila();
    }
}