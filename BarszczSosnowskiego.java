
package wirtualizacjaswiata;

import java.awt.Color;


public class BarszczSosnowskiego extends Roslina{
    
    private static final char BARSZCZ_SOSNOWSKIEGO = 'B';
    private static final int BARSZCZ_SOSNOWSKIEGO_INICJATYWA = 0;
    private static final int BARSZCZ_SOSNOWSKIEGO_SILA = 10;
    private static final String BARSZCZ_SOSNOWSKIEGO_NAZWA = "Barszcz Sosnowskiego";
    public static final int ID = 0;
    
    public BarszczSosnowskiego()	
    {
      super(BARSZCZ_SOSNOWSKIEGO_NAZWA, BARSZCZ_SOSNOWSKIEGO_SILA, BARSZCZ_SOSNOWSKIEGO_INICJATYWA, BARSZCZ_SOSNOWSKIEGO, new Color(87,233,199));
    }

    public BarszczSosnowskiego(int x, int y, int sila, int wiek)
    {
       super(BARSZCZ_SOSNOWSKIEGO_NAZWA,sila, BARSZCZ_SOSNOWSKIEGO_INICJATYWA, BARSZCZ_SOSNOWSKIEGO, wiek, x, y, new Color(87,233,199));
    }
    
    @Override
    public int GetId()
    {
        return ID;
    }
    
    @Override
    public boolean ZjedzenieSmiertelnejRosliny()
    {
            return true;
    }

    @Override
    public void ZabijWszystkieSasiednieOrganizmy(int x, int y, Dane_o_Swiecie informacje)
    {
	if (x + 1 < informacje.GetSzerokosc())
	{
            if (!informacje.SprawdzCzyPoleJestWolne(x+1, y))
            {
                informacje.ZwierzeciaDoUsuniecia[0] = new Wspolrzedne (x + 1, y);
            }
	}
	if (x - 1 >= 0)
	{
            if (!informacje.SprawdzCzyPoleJestWolne(x - 1, y))
            {

                informacje.ZwierzeciaDoUsuniecia[1] = new Wspolrzedne (x - 1, y);
            }
	}
	if (y + 1 < informacje.GetWysokosc() )
	{
            if (!informacje.SprawdzCzyPoleJestWolne(x, y+1))
            {
                informacje.ZwierzeciaDoUsuniecia[2] = new Wspolrzedne (x , y + 1);
            }
	}
	if (y - 1 >= 0)
	{
            if (!informacje.SprawdzCzyPoleJestWolne(x, y - 1))
            {
                        informacje.ZwierzeciaDoUsuniecia[3] = new Wspolrzedne (x , y - 1);
            }            
	}      
    }
}
