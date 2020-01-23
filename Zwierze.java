
package wirtualizacjaswiata;


import java.awt.Color;
import java.util.Random;

public class Zwierze extends Organizm {
    
    int zasieg_ruchu;
     
    public Zwierze(String nazwa, int sila, int inicjatywa, char symbol, int zasieg_ruchu, Color kolor)
    {
        super(nazwa, sila, inicjatywa, symbol, kolor);
        this.zasieg_ruchu = zasieg_ruchu;
    }

    public Zwierze(String nazwa, int sila, int inicjatywa, char symbol, int zasieg_ruchu, int wiek, int x, int y, Color kolor)	
    {
        super(nazwa, sila, inicjatywa, symbol, wiek, x,y, kolor);
	this.zasieg_ruchu = zasieg_ruchu;
    }
   
    @Override
    public boolean Akcja(Dane_o_Swiecie informacje)
    {
	informacje.nowa_pozycja = WylosujPozycje(this.GetX(), this.GetY(), informacje, zasieg_ruchu);

	if (!informacje.SprawdzCzyPoleJestWolne(informacje.nowa_pozycja.x, informacje.nowa_pozycja.y))//zajete
	{	
		return false; //Dzięki temu, w kolejnym etapie wywoła się kolizja
	}
	else
	{	
		informacje.OrganizmAtakujacyDoPrzeniesienia = informacje.nowa_pozycja;
		return true;
	}
    }

    @Override
    public void Kolizja(Organizm org, Dane_o_Swiecie informacje)
    {
	int sila_rywala = org.GetSila();
	org.ZwiekszSileZwierzecia(this);
	if (SprawdzCzyToTeSameOrganizmy(org)) //Jesli tak, to nastepuje rozmnazanie
	{
            Wspolrzedne	pozycja_dla_dziecka1 = ZnajdzPozycjeXOddalonaOdDanegoOrganizmu(this.GetX(), this.GetY(), informacje, 1);
            Wspolrzedne	pozycja_dla_dziecka2 = ZnajdzPozycjeXOddalonaOdDanegoOrganizmu(org.GetX(), org.GetY(), informacje, 1);

		//sprawdza, czy istnieje jakies wolne miejsce dla dziecka, jesli tak to nowe zwierze sie rodzi
		if (pozycja_dla_dziecka1.x != this.GetX() || pozycja_dla_dziecka1.y != this.GetY()) //dla pierwszego rodzica
		{
			informacje.NowyOrganizm = pozycja_dla_dziecka1;
			informacje.komentator.NoweOrganizmy(this.GetNazwa());
		}
		else if (pozycja_dla_dziecka2.x != org.GetX() || pozycja_dla_dziecka2.y != org.GetY())//dla drugiego rodzica
		{
			informacje.NowyOrganizm = pozycja_dla_dziecka2;
			informacje.komentator.NoweOrganizmy(this.GetNazwa());
		}//else nie znaleziono miejsca dla dziecka, wiec nowe zwierze sie nie rodzi
	}
	else
	{
		if (org.ZjedzenieSmiertelnejRosliny())
		{
			informacje.OrganizmAtakujacyDoUsuniecia.x = this.GetX();
                        informacje.OrganizmAtakujacyDoUsuniecia.y = this.GetY();
			informacje.OrganizmUciekajacyDoUsuniecia.x = org.GetX();
                        informacje.OrganizmUciekajacyDoUsuniecia.y = org.GetY();
			informacje.komentator.ZjedliTrujaceRosliny(this.GetNazwa());
		}
		else
		{
			if (sila_rywala > this.GetSila()) // jesli sila przeciwnika jest wieksza, to organizm umiera
			{
				if (SprawdzCzyOdwazySieWalczycZSilniejszymOrganizmem(org.GetSila())) //Organizm podejmuje walke
				{
					informacje.OrganizmAtakujacyDoUsuniecia.x = this.GetX(); //nie przezyl
                                        informacje.OrganizmAtakujacyDoUsuniecia.y = this.GetY(); //nie przezyl
					informacje.komentator.WWynikuWalkZgineli(this.GetNazwa());
				}
				//else nic sie nie dzieje, bo lis jesli wyczuł że na jego docelowym polu jest silniejszy organizm, wiec pozostał na swoim miejscu
			}
			else //jest silniejszy, badz rowny -> ale zaatakowal wiec ma szanse wygrywac
			{
				if (org.SprawdzCzyOdbijeAtak(this.GetSila()))
				{
					//nic sie nie dzieje, bo przeciwnik odbil atak, wiec organizm i przeciwnik zostaja na swoim miejscu
				}
				else if (org.CzyWMomencieAtakuUcieknieNaInneMiejsce())
				{
                                    //Wspolrzedne nowa_pozycja = new Wspolrzedne();
					 Wspolrzedne nowa_pozycja = ZnajdzPozycjeXOddalonaOdDanegoOrganizmu(org.GetX(),org.GetY(), informacje, zasieg_ruchu);

					if (nowa_pozycja.x == org.GetX() && nowa_pozycja.y == org.GetY())
					{
						informacje.OrganizmUciekajacyDoUsuniecia.x = org.GetX();
                                                informacje.OrganizmUciekajacyDoUsuniecia.y = org.GetY();
						informacje.komentator.WWynikuWalkZgineli(org.GetNazwa());
						informacje.OrganizmAtakujacyDoPrzeniesienia.x = org.GetX();
                                                informacje.OrganizmAtakujacyDoPrzeniesienia.y = org.GetY();
					}
					else
					{
						informacje.OrganizmUciekajacyDoPrzeniesienia = nowa_pozycja;
						informacje.OrganizmAtakujacyDoPrzeniesienia.x = org.GetX();
                                                informacje.OrganizmAtakujacyDoPrzeniesienia.y = org.GetY();
					}
				}
				else // Jesli przeciwnik nie odbil ataku i nie uciekl na inne miejsce, przegrywa
				{
					
                                        informacje.OrganizmUciekajacyDoUsuniecia.x = org.GetX();
                                        informacje.OrganizmUciekajacyDoUsuniecia.y = org.GetY();

					if(org instanceof Roslina)
						informacje.komentator.ZjedzoneRosliny(org.GetNazwa());
					else
						informacje.komentator.WWynikuWalkZgineli(org.GetNazwa());

					informacje.OrganizmAtakujacyDoPrzeniesienia.x = org.GetX();
                                        informacje.OrganizmAtakujacyDoPrzeniesienia.y = org.GetY();
				}
			}
		}
	}
}

    public Wspolrzedne WykonajRuch(int zasieg_ruchu, Dane_o_Swiecie informacje, Wspolrzedne pozycja)
    {
        boolean quit = true;
	do
	{
             Random generator = new Random();    
		int kierunek = generator.nextInt(4);
		if (kierunek == 0 && pozycja.y - zasieg_ruchu >= 0) //Gora
		{
			pozycja.y-=zasieg_ruchu;
                        quit = false;
		}
		else if (kierunek == 1 && pozycja.x + zasieg_ruchu < informacje.GetSzerokosc()) //Prawo
		{
			pozycja.x += zasieg_ruchu;
			quit = false;
		}
		else if (kierunek == 2 && pozycja.y + zasieg_ruchu < informacje.GetWysokosc()) //Dol
		{
			pozycja.y += zasieg_ruchu;
			quit = false;
		}
		else if(pozycja.x - zasieg_ruchu >= 0)//Lewo
		{
			pozycja.x -= zasieg_ruchu;
			quit = false;
		}
	} while(quit);
	return pozycja;
    }

    public boolean SprawdzCzyToTeSameOrganizmy(Organizm org)
    {
	if(this instanceof Antylopa && org instanceof Antylopa )
		return true;
	else if (this instanceof Lis && org instanceof Lis )
		return true;
	else if (this instanceof Wilk && org instanceof Wilk)
		return true;
	else if (this instanceof Zolw && org instanceof Zolw)
		return true;
	else if (this instanceof Owca && org instanceof Owca)
		return true;

	return false;
    }

    public int GetZasiegRuchu()
    {
	return zasieg_ruchu;
    }
}
