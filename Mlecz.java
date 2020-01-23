
package wirtualizacjaswiata;

import java.awt.Color;
import java.util.Random;

public class Mlecz extends Roslina{
    
    private static final char MLECZ = 'M';
    private static final int MLECZ_INICJATYWA = 0;
    private static final int MLECZ_SILA = 0;
    private static final String MLECZ_NAZWA = "Mlecz";
    //Ilosc prob, jakie podejmuje MLECZ, by sie rozprzestrzenic
    private static final int PROBY_ROZPRZESTRZENIENIA_MLECZA = 3; 
    public static final int ID = 4;
    
    public Mlecz()
    {
        super(MLECZ_NAZWA, MLECZ_SILA, MLECZ_INICJATYWA, MLECZ, new Color(255,214, 13));
    }

    public Mlecz(int x, int y, int sila, int wiek)
    {
       super(MLECZ_NAZWA, sila, MLECZ_INICJATYWA, MLECZ, wiek, x, y,new Color(255,214, 13));
    }
    
    @Override
    public int GetId()
    {
        return ID;
    }
    
    @Override
    public boolean ZasiejRosline()
    {
	int ilosc_prob = PROBY_ROZPRZESTRZENIENIA_MLECZA;
        Random generator = new Random();
        
	if( generator.nextInt(100) < 5)
        return true;
        if( (generator.nextInt(100)) < 5)
	 return true;
	return generator.nextInt(100) < 5;
    }
}