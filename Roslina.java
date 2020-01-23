
package wirtualizacjaswiata;

import java.awt.Color;
import java.util.Random;

public class Roslina extends Organizm{
    
    private static final int ROZPRZESTRZENIANIE_ROSLIN = 5;
    
    public Roslina(String nazwa, int sila, int inicjatywa, char symbol, Color kolor)
    {
        super(nazwa, sila, inicjatywa, symbol,kolor);
    }

    public Roslina(String nazwa, int sila, int inicjatywa, char symbol, int wiek, int x, int y, Color kolor)
    {
        super(nazwa, sila, inicjatywa, symbol, wiek, x, y,kolor);
    }

    @Override
    public void Kolizja(Organizm org, Dane_o_Swiecie informacje)
    {}

    public boolean ZasiejRosline()
    {
        Random generator = new Random();
        return generator.nextInt(100) < ROZPRZESTRZENIANIE_ROSLIN;
    }

    @Override
    public boolean Akcja(Dane_o_Swiecie informacje)
    {
        //działa wyłącznie dla barszczu
        //Zwraca true, jesli roslina sie rozprzestrzenia
        if (ZasiejRosline()) 
        {
            Wspolrzedne pozycja_rodzica = new Wspolrzedne();
            pozycja_rodzica.x = this.GetX();
            pozycja_rodzica.y = this.GetY();
            Wspolrzedne pozycja_dla_dziecka = ZnajdzPozycjeXOddalonaOdDanegoOrganizmu(pozycja_rodzica.x,pozycja_rodzica.y, informacje, 1);

            //Jesli pozycja dziecka i rodzica są takie same, to znaczy, że wokół rodzica nie ma wolnego miejsca, w którym mogłoby zasiać roślinę
            if (pozycja_dla_dziecka.x != pozycja_rodzica.x || pozycja_dla_dziecka.y != pozycja_rodzica.y)
            {
                informacje.NowyOrganizm = pozycja_dla_dziecka;
                informacje.komentator.NoweOrganizmy(this.GetNazwa());
            }
        }
            
        this.ZabijWszystkieSasiednieOrganizmy(this.GetX(), this.GetY(), informacje);
        
        return true;
    }
}