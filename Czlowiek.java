
package wirtualizacjaswiata;

import java.awt.Color;
import java.util.Random;

public class Czlowiek extends Zwierze{
    
    private static final char CZLOWIEK = 'X';
    private static final int CZLOWIEK_INICJATYWA = 4;
    private static final int CZLOWIEK_SILA = 5;
    private static final String CZLOWIEK_NAZWA = "Czlowiek";
    private static final int ZASIEG_RUCHU_DEFAULT = 1;
    public static final int ID = 1;
    
    public Czlowiek()
    {
        super(CZLOWIEK_NAZWA, CZLOWIEK_SILA, CZLOWIEK_INICJATYWA, CZLOWIEK, ZASIEG_RUCHU_DEFAULT, Color.BLACK);
    }

    public Czlowiek(int x, int y, int sila, int wiek)
    {
        super(CZLOWIEK_NAZWA,sila, CZLOWIEK_INICJATYWA, CZLOWIEK, ZASIEG_RUCHU_DEFAULT, wiek, x, y, Color.BLACK);
    }
    
    @Override
    public int GetId()
    {
        return ID;
    }
    
    private int SprawdzZasiegRuchu(Dane_o_Swiecie informacje)
    {
        if (informacje.AktywowanaSpecjalnaUmiejetnosc)
        {
            if (informacje.CzasTrwaniaSpecjalnejUmiejetnosci < 3)
                return 2;
            else
            {
                Random generator = new Random();
                int szansa = generator.nextInt(100);
                if (szansa < 50)
                    return 2;
                else
                    return 1;
            }
        }
        else
            return 1;
    }

    @Override
    public boolean Akcja(Dane_o_Swiecie informacje)
    {
        int kierunek;
        int obecny_zasieg_ruchu = SprawdzZasiegRuchu(informacje);
        int x2 = this.GetX();
        int y2 = this.GetY();

        if (informacje.kierunek_czlowieka == 1)
        {
            if (y2 - obecny_zasieg_ruchu >= 0)
            {
                y2 -= obecny_zasieg_ruchu;
                informacje.nowa_pozycja.x = x2;
                informacje.nowa_pozycja.y = y2;
            }
        }
        else if (informacje.kierunek_czlowieka == 2)
        {
            if (y2 + obecny_zasieg_ruchu < informacje.GetWysokosc())
            {
                y2 += obecny_zasieg_ruchu;
                informacje.nowa_pozycja.x = x2;
                informacje.nowa_pozycja.y = y2;
            }
        }
        else if (informacje.kierunek_czlowieka== 3)
        {
            if (x2 + obecny_zasieg_ruchu < informacje.GetSzerokosc())
            {
                x2 += obecny_zasieg_ruchu;
                informacje.nowa_pozycja.x = x2;
                informacje.nowa_pozycja.y = y2;
            }
        }
        else if (informacje.kierunek_czlowieka == 4)
        {
            if (x2 - obecny_zasieg_ruchu >= 0 )
            {
                x2 -= obecny_zasieg_ruchu;
                informacje.nowa_pozycja.x = x2;
                informacje.nowa_pozycja.y = y2;
            }
        }
        else
        {
            informacje.nowa_pozycja.x = x2;
            informacje.nowa_pozycja.y = y2;
        }
        
        informacje.kierunek_czlowieka = 0;

        if (!informacje.SprawdzCzyPoleJestWolne(x2, y2))//zajete
        {
            return false;
        }
        else
        {
            informacje.OrganizmAtakujacyDoPrzeniesienia.x = x2;
            informacje.OrganizmAtakujacyDoPrzeniesienia.y = y2;

            return true;
        }
    }
}
