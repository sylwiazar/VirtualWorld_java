
package wirtualizacjaswiata;

import java.awt.Color;
import java.util.Random;


public abstract class Organizm {

    int sila; 
    int inicjatywa;
    int wiek; 
    int x;
    int y;
    char symbol;
    String nazwa;
    Color kolor;

    public Organizm(String nazwa, int sila, int inicjatywa, char symbol, Color kolor)
    {
        this.nazwa = nazwa;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.symbol = symbol;
        this.wiek = 0;
        this.kolor = kolor; 
    }
    
    public Color GetKolor()
    {
         return this.kolor;
    }

    public Organizm(String nazwa, int sila, int inicjatywa, char symbol, int wiek, int x, int y, Color kolor)
    {
        this.nazwa = nazwa;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.symbol = symbol;
        this.wiek = wiek;
        this.x = x;
        this.y = y;
        this.kolor = kolor;
    }

    public void Rysuj()
    {
            System.out.printf("%c", this.GetSymbol());
    }

    public Wspolrzedne ZnajdzPozycjeXOddalonaOdDanegoOrganizmu(int x, int y, Dane_o_Swiecie informacje, int zasieg_ruchu)
    {
	boolean czyjestwolnemiejsce = false;
	if (x - zasieg_ruchu >= 0 && informacje.SprawdzCzyPoleJestWolne(x - zasieg_ruchu, y))
	{
		czyjestwolnemiejsce = true;
	}
	if (x + zasieg_ruchu <= informacje.GetSzerokosc()- 1 && informacje.SprawdzCzyPoleJestWolne(x + zasieg_ruchu, y))
	{
		czyjestwolnemiejsce = true;
	}
	if (y - zasieg_ruchu >= 0 && informacje.SprawdzCzyPoleJestWolne(x, y - zasieg_ruchu))
	{
		czyjestwolnemiejsce = true;
	}
	if (y + zasieg_ruchu < informacje.GetWysokosc() && informacje.SprawdzCzyPoleJestWolne(x, y + zasieg_ruchu))
	{
		czyjestwolnemiejsce = true;
	}
	if (czyjestwolnemiejsce)
	{
		while (true)
		{
                   // Wspolrzedne nowa_pozycja = new Wspolrzedne();
		Wspolrzedne nowa_pozycja = WylosujPozycje(x,y, informacje, zasieg_ruchu);
			if (informacje.SprawdzCzyPoleJestWolne(nowa_pozycja.x, nowa_pozycja.y))
			{
				return nowa_pozycja;
			}
		}
	}
	else
        {
            Wspolrzedne pozycja = new Wspolrzedne();
            pozycja.x = x;
            pozycja.y = y;
            return pozycja;
            
        }
		
    }

    public Wspolrzedne WylosujPozycje(int x, int y, Dane_o_Swiecie informacje, int zasieg_ruchu)
    {
	while (true)
	{
                Random generator = new Random();
		int kierunek = generator.nextInt(4);
		if (kierunek == 0 && x - zasieg_ruchu >= 0)
		{
			x -= zasieg_ruchu;
			break;
		}
		else if (kierunek == 1 && x + zasieg_ruchu < informacje.GetSzerokosc())
		{
			x += zasieg_ruchu;
			break;
		}
		else if (kierunek == 2 && y - zasieg_ruchu >= 0)
		{
			y -= zasieg_ruchu;
			break;
		}
		else if(y + zasieg_ruchu < informacje.GetWysokosc())
		{
			y += zasieg_ruchu;
			break;		
		}
	}
        Wspolrzedne pozycja = new Wspolrzedne();
        pozycja.x =x;
        pozycja.y = y;
        return pozycja;
    }

    public boolean SprawdzCzyZmieniPolozenie()
    {
            return true;
    }

    public void ZwiekszSileZwierzecia(Organizm org)
    {
    }

    public boolean SprawdzCzyOdwazySieWalczycZSilniejszymOrganizmem(int sila_przeciwnika)
    {
            return true;
    }

    public boolean ZjedzenieSmiertelnejRosliny()
    {
            return false;
    }

    public boolean CzyWMomencieAtakuUcieknieNaInneMiejsce()
    {
            return false;
    }

    public boolean SprawdzCzyOdbijeAtak(int sila_przeciwnika)
    {
            return false;
    }

    public void ZabijWszystkieSasiednieOrganizmy(int x, int y, Dane_o_Swiecie informacje)
    {
    }

    public void SetPozycja(int x, int y)
    {
           this.x = x;
           this.y = y;
    }

    public void SetSila(int nowaSila)
    {
            this.sila = nowaSila;
    }

    public void SetWiek(int wiek)
    {
            this.wiek = wiek;
    }

    public char GetSymbol()
    {
            return this.symbol;
    }

    public String GetNazwa()
    {
            return this.nazwa;
    }

    public int GetSila()
    {
            return this.sila;
    }

    public int GetInicjatywa()
    {
            return this.inicjatywa;
    }

    public int GetWiek() 
    {
            return this.wiek;
    }

    public int GetX()
    {
            return this.x;
    }
    public int GetId()
    {
        return -1;
    }
    public int GetY()
    {
            return this.y;
    }
    
    public void Kolizja(Organizm org, Dane_o_Swiecie informacje)
    {}
    
    public boolean Akcja( Dane_o_Swiecie informacje)
    {
    return false;
    }
}
