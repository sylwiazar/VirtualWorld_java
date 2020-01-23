
package wirtualizacjaswiata;


public class Dane_o_Swiecie {
    
        Komentator komentator;

	Wspolrzedne OrganizmUciekajacyDoUsuniecia;
	Wspolrzedne OrganizmAtakujacyDoUsuniecia;
	Wspolrzedne NowyOrganizm;
	Wspolrzedne OrganizmUciekajacyDoPrzeniesienia;
	Wspolrzedne OrganizmAtakujacyDoPrzeniesienia;
	Wspolrzedne[] ZwierzeciaDoUsuniecia = new Wspolrzedne[4];
	Wspolrzedne nowa_pozycja;
        
        int kierunek_czlowieka ;
        int CzasTrwaniaSpecjalnejUmiejetnosci;
        int CzasDoUruchomieniaSpecjlanejUmiejetnosci;
        boolean AktywowanaSpecjalnaUmiejetnosc;
        
        private int szerokosc;
	private int wysokosc;
	private boolean[][] zajete_pole;
        
    public Dane_o_Swiecie(int wysokosc, int szerokosc, boolean[][] wolne_pole)
    {
          this.kierunek_czlowieka = 0;
          this.wysokosc = wysokosc;
          this.szerokosc = szerokosc;
          this.zajete_pole = wolne_pole;
          this.CzasDoUruchomieniaSpecjlanejUmiejetnosci = 0;
          this.CzasTrwaniaSpecjalnejUmiejetnosci = 0;
          this.AktywowanaSpecjalnaUmiejetnosc = false;
          this.komentator = new Komentator();
          this.OrganizmUciekajacyDoUsuniecia= new Wspolrzedne();
          this.OrganizmAtakujacyDoUsuniecia= new Wspolrzedne();
          this.NowyOrganizm= new Wspolrzedne();
          this.OrganizmUciekajacyDoPrzeniesienia= new Wspolrzedne();
          this.OrganizmAtakujacyDoPrzeniesienia= new Wspolrzedne();
          this.ZwierzeciaDoUsuniecia[0] = new Wspolrzedne();
          this.ZwierzeciaDoUsuniecia[1] = new Wspolrzedne();
          this.ZwierzeciaDoUsuniecia[2] = new Wspolrzedne();
          this.ZwierzeciaDoUsuniecia[3] = new Wspolrzedne();
          this.nowa_pozycja= new Wspolrzedne();
    }

    public int GetSzerokosc()
    {
            return szerokosc;
    }

    public int GetWysokosc()
    {
            return wysokosc;
    }

    public void WyzerujOrganizmy()
    {
        this.OrganizmUciekajacyDoUsuniecia =  new Wspolrzedne();
        this.OrganizmAtakujacyDoUsuniecia =  new Wspolrzedne();
        this.NowyOrganizm = new Wspolrzedne();
        this.OrganizmUciekajacyDoPrzeniesienia = new Wspolrzedne();
        this.OrganizmAtakujacyDoPrzeniesienia = new Wspolrzedne();
        this.ZwierzeciaDoUsuniecia[0]= new Wspolrzedne();
        this.ZwierzeciaDoUsuniecia[1] =  new Wspolrzedne();
        this.ZwierzeciaDoUsuniecia[2] = new Wspolrzedne();
        this.ZwierzeciaDoUsuniecia[3] =  new Wspolrzedne();
    }

    public boolean SprawdzCzyPoleJestWolne(int x, int y) //zwroci true jesli wolne
    {
        return !zajete_pole[x][y];
    }
}

