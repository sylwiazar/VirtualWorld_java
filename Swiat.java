
package wirtualizacjaswiata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Swiat {
    
    int kolejka_ruchowx[];
    int kolejka_ruchowy[];
    int szerokosc_planszy;
    int wysokosc_planszy;
    int ile_organizmow;
    Dane_o_Swiecie informacje;
    //sprawdza czy dane pole planszy jest zajete
    boolean[][] czy_zajete;
    Organizm[][] organizmy;
        
    
    Swiat( int szerokosc_planszy,  int wysokosc_planszy)
    {   
	this.szerokosc_planszy = szerokosc_planszy;
	this.wysokosc_planszy = wysokosc_planszy;
	this.organizmy = new Organizm[szerokosc_planszy][wysokosc_planszy];
	this.czy_zajete = new boolean[szerokosc_planszy][wysokosc_planszy];
        this.kolejka_ruchowx = new int[400];
        this.kolejka_ruchowy = new int[400];

        for(int i = 0; i < szerokosc_planszy*wysokosc_planszy; i++)
        {
            this.kolejka_ruchowx[i] = -1;
            this.kolejka_ruchowy[i] = -1;
        }

	this.ile_organizmow = 0;
	this.informacje = new Dane_o_Swiecie(wysokosc_planszy, szerokosc_planszy, czy_zajete);

        DodajOrganizm(new Lis(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Antylopa(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Owca(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Wilk(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Zolw(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Czlowiek(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new BarszczSosnowskiego(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Guarana(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Mlecz(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new Trawa(), LosujWolnaPozycje(), -1);
        DodajOrganizm(new WilczeJagody(), LosujWolnaPozycje(), -1);
        
        int ile = szerokosc_planszy * wysokosc_planszy / 8 - 10;
	Random generator = new Random();
        
	while (ile>0)
	{        
            int losuj = generator.nextInt(10);
            if (losuj == 0)
            {
            DodajOrganizm(new Lis(), this.LosujWolnaPozycje(), -1);
            }
            else if (losuj == 1)
            {
		DodajOrganizm(new Antylopa(), this.LosujWolnaPozycje(),-1);
            }			
            else if (losuj == 2)
            {
		DodajOrganizm(new Owca(), this.LosujWolnaPozycje(),-1);
            }
            else if (losuj == 3)
            {
            	DodajOrganizm(new Wilk(), this.LosujWolnaPozycje(),-1);
            }
            else if (losuj == 4)
            {
            	DodajOrganizm(new Zolw() , this.LosujWolnaPozycje(),-1);
            }
            else if (losuj == 5)
            {
            	DodajOrganizm(new BarszczSosnowskiego(), this.LosujWolnaPozycje(),-1);
            }
            else if (losuj == 6)
            {
            	DodajOrganizm(new Guarana(), this.LosujWolnaPozycje(),-1);
            }
            else if (losuj == 7)
            {
		DodajOrganizm(new Mlecz(), this.LosujWolnaPozycje(),-1);
            }
            else if (losuj == 8)
            {
            	DodajOrganizm(new Trawa(), this.LosujWolnaPozycje(),-1);
            }
            else
            {
               	DodajOrganizm(new WilczeJagody(), LosujWolnaPozycje(),-1);
            }
         
            ile--;
	}
    }
    
    void SortujOrganizmy()
    {
	for (int i = szerokosc_planszy * wysokosc_planszy - 1; i>0 ; i--)
	{
            for (int j = szerokosc_planszy * wysokosc_planszy - 1; j > 0 ; j--)
            {
		if (kolejka_ruchowx[j] == -2)
		{
        		kolejka_ruchowx[j] = -1;
			kolejka_ruchowy[j] = -1;
		}
		if ((kolejka_ruchowx[j-1] >=0)&&(kolejka_ruchowx[j] >= 0))
		{
                    if ((organizmy[kolejka_ruchowx[j]][kolejka_ruchowy[j]].GetInicjatywa()) > (organizmy[kolejka_ruchowx[j - 1]][kolejka_ruchowy[j - 1]].GetInicjatywa()))
                    {
                        int  tmpx = kolejka_ruchowx[j];
                        int  tmpy = kolejka_ruchowy[j];
                        kolejka_ruchowx[j]=kolejka_ruchowx[j-1];
                        kolejka_ruchowy[j]=kolejka_ruchowy[j-1];
                        kolejka_ruchowx[j-1]= tmpx;
                        kolejka_ruchowy[j-1]= tmpy;
                    }
                    else if((organizmy[kolejka_ruchowx[j]][kolejka_ruchowy[j]].GetInicjatywa()) == (organizmy[kolejka_ruchowx[j - 1]][kolejka_ruchowy[j - 1]].GetInicjatywa()))
                    {
			if ((organizmy[kolejka_ruchowx[j]][kolejka_ruchowy[j]].GetWiek()) > (organizmy[kolejka_ruchowx[j - 1]][kolejka_ruchowy[j - 1]].GetWiek()))
			{
                            int  tmpx = kolejka_ruchowx[j];
                            int  tmpy = kolejka_ruchowy[j];
                            kolejka_ruchowx[j]=kolejka_ruchowx[j-1];
                            kolejka_ruchowy[j]=kolejka_ruchowy[j-1];
                            kolejka_ruchowx[j-1]= tmpx;
                            kolejka_ruchowy[j-1]= tmpy;
                        }
                    }
		}
                else if(kolejka_ruchowx[j - 1] < 0)
                {
                    int  tmpx = kolejka_ruchowx[j];
                    int  tmpy = kolejka_ruchowy[j];          
                    kolejka_ruchowx[j]=kolejka_ruchowx[j-1];
                    kolejka_ruchowy[j]=kolejka_ruchowy[j-1];
                    kolejka_ruchowx[j-1]= tmpx;
                    kolejka_ruchowy[j-1]= tmpy;
                }	
            }
	}
    }
    
    private Wspolrzedne LosujWolnaPozycje()
    {
        Random generator = new Random();
        Wspolrzedne pozycja = new Wspolrzedne();
            
        while (true)
	{	
            pozycja.x = generator.nextInt(this.szerokosc_planszy);
            pozycja.y = generator.nextInt(this.wysokosc_planszy);
            if (czy_zajete[pozycja.x][pozycja.y] == false)
            {
                czy_zajete[pozycja.x][pozycja.y] = true;
                return pozycja;
            }		
	}
    }
    
    public final void DodajOrganizm(Organizm org, Wspolrzedne pozycja, int j)
    {  
	czy_zajete[pozycja.x][pozycja.y] = true;
	this.organizmy[pozycja.x][pozycja.y] = org;

	for (int i = 0; i < wysokosc_planszy * szerokosc_planszy; i++)
	{
            if (j >= 0)
            {
		if (i < j &&  kolejka_ruchowx[i] == -2)
		{
                    kolejka_ruchowx[i] = pozycja.x;
                    kolejka_ruchowy[i] = pozycja.y;
                    break;
                }
		}
		if (kolejka_ruchowx[i] == -1)
		{
                    kolejka_ruchowx[i] = pozycja.x;
                    kolejka_ruchowy[i] = pozycja.y;
                    break;
		}
	}
	
	this.ile_organizmow++;
	this.organizmy[pozycja.x][pozycja.y].SetPozycja(pozycja.x, pozycja.y);
    }
    
    void PrzeniesOrganizm(Organizm org, int a, int b, int x, int y, int i)
    {
        Wspolrzedne pozycja = new Wspolrzedne();
        pozycja.x = x;
        pozycja.y = y;
        
        if (org instanceof Antylopa)
            DodajOrganizm(new Antylopa(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof BarszczSosnowskiego )
		 DodajOrganizm(new BarszczSosnowskiego(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof Guarana )
		 DodajOrganizm(new Guarana(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof Lis )
		 DodajOrganizm(new Lis(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof Mlecz )
		 DodajOrganizm(new Mlecz(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof Owca)
		 DodajOrganizm( new Owca(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof Trawa )
		 DodajOrganizm(new Trawa(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof WilczeJagody )
		 DodajOrganizm( new WilczeJagody(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
	else if (org instanceof Wilk )
		 DodajOrganizm(new Wilk(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
        else if (org instanceof Zolw)
		 DodajOrganizm( new Zolw(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
         else if (org instanceof Czlowiek)
		 DodajOrganizm( new Czlowiek(x,y,org.GetSila(),org.GetWiek()), pozycja, -1);
    
	organizmy[a][b] = null;
	czy_zajete[a][b] = false;
	czy_zajete[x][y] = true;

	for (int j = 0; j < szerokosc_planszy * wysokosc_planszy; j++)
	{
            if ((kolejka_ruchowx[j] == a) && (kolejka_ruchowy[j] ==b))
            {
		kolejka_ruchowx[j] = -2;
                kolejka_ruchowy[j] = -2;
		break;
            }
	}
        this.ile_organizmow--;
    }
    
    Organizm NoweDziecko(Organizm rodzic)
    {
	Organizm organizm;
	if (rodzic instanceof Antylopa)
		return new Antylopa();
	else if (rodzic instanceof BarszczSosnowskiego )
		return new BarszczSosnowskiego();
	else if (rodzic instanceof Guarana )
		return new Guarana();
	else if (rodzic instanceof Lis )
		return new Lis();
	else if (rodzic instanceof Mlecz )
		return new Mlecz();
	else if (rodzic instanceof Owca)
		return new Owca();
	else if (rodzic instanceof Trawa )
		return new Trawa();
	else if (rodzic instanceof WilczeJagody )
		return new WilczeJagody();
	else if (rodzic instanceof Wilk )
		return new Wilk();
	else
		return new Zolw();
    }

    public void NastepnaTura()
    {
        if (informacje.AktywowanaSpecjalnaUmiejetnosc)
	{
            informacje.CzasTrwaniaSpecjalnejUmiejetnosci++;
            if (informacje.CzasTrwaniaSpecjalnejUmiejetnosci > 5)
            {
		informacje.AktywowanaSpecjalnaUmiejetnosc = false;
		informacje.CzasTrwaniaSpecjalnejUmiejetnosci = 0;
		informacje.CzasDoUruchomieniaSpecjlanejUmiejetnosci = 5;
            }
	}
	else
	{
            if(informacje.CzasDoUruchomieniaSpecjlanejUmiejetnosci>0)
                informacje.CzasDoUruchomieniaSpecjlanejUmiejetnosci--;
	}
           
        informacje.komentator.WypiszKomentarze();
	SortujOrganizmy();
        System.out.println("nastepna");
	int ilosc_organizmow_przed_rozpoczeciem_tury = ile_organizmow;

	for (int i = 0; i < ilosc_organizmow_przed_rozpoczeciem_tury; i++)
	{
		if (kolejka_ruchowx[i] != -2 && kolejka_ruchowx[i] != -1) //organizm, ktory był pod tym adresem został usunięty z planszy
		{
			organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]].SetWiek(organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]].GetWiek()+1);
                        organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]].SetPozycja(kolejka_ruchowx[i], kolejka_ruchowy[i]);
			informacje.WyzerujOrganizmy();
                        int  help = kolejka_ruchowx[i];
                        int help2= kolejka_ruchowy[i];
			if (organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]].SprawdzCzyZmieniPolozenie())
			{
				if (!organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]].Akcja(informacje))
				{
                                    Wspolrzedne pozycja_organizmu_do_walki = informacje.nowa_pozycja;
                                    organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]].Kolizja(organizmy[pozycja_organizmu_do_walki.x][pozycja_organizmu_do_walki.y], informacje);
				}
				else
				{
                                    Wspolrzedne pozycja = new Wspolrzedne();
                                    pozycja = informacje.OrganizmAtakujacyDoPrzeniesienia;
				}
			}
                       
			if (informacje.OrganizmUciekajacyDoUsuniecia.x >= 0)
			{
  				UsunOrganizm(organizmy[informacje.nowa_pozycja.x][informacje.nowa_pozycja.y], informacje.nowa_pozycja.x, informacje.nowa_pozycja.y,i);
			}
			if (informacje.OrganizmAtakujacyDoUsuniecia.x >= 0)
			{
				UsunOrganizm(organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]], kolejka_ruchowx[i], kolejka_ruchowx[i], i);
			}
			if (informacje.NowyOrganizm.x >= 0)
			{
				Organizm dziecko = NoweDziecko(organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]]);
				DodajOrganizm(dziecko, informacje.NowyOrganizm, i);
			}
			if (informacje.OrganizmUciekajacyDoPrzeniesienia.x >= 0)
                        {
				PrzeniesOrganizm(organizmy[informacje.nowa_pozycja.x][informacje.nowa_pozycja.y], informacje.nowa_pozycja.x,  informacje.nowa_pozycja.y,informacje.OrganizmUciekajacyDoPrzeniesienia.x,informacje.OrganizmUciekajacyDoPrzeniesienia.y,i);
			}
			if (informacje.OrganizmAtakujacyDoPrzeniesienia.x >= 0)
			{
				PrzeniesOrganizm(organizmy[kolejka_ruchowx[i]][kolejka_ruchowy[i]], kolejka_ruchowx[i],kolejka_ruchowy[i], informacje.OrganizmAtakujacyDoPrzeniesienia.x,informacje.OrganizmAtakujacyDoPrzeniesienia.y,i);
			}
                        
			int ilosc = 3;
			while (ilosc>=0)
			{
                            if (informacje.ZwierzeciaDoUsuniecia[ilosc].x>=0)
                            {
				if (organizmy[informacje.ZwierzeciaDoUsuniecia[ilosc].x][informacje.ZwierzeciaDoUsuniecia[ilosc].y] instanceof Zwierze)
                                {
                                    informacje.komentator.ZjedliTrujaceRosliny(organizmy[informacje.ZwierzeciaDoUsuniecia[ilosc].x][informacje.ZwierzeciaDoUsuniecia[ilosc].y].GetNazwa());
                                    UsunOrganizm(organizmy[informacje.ZwierzeciaDoUsuniecia[ilosc].x][informacje.ZwierzeciaDoUsuniecia[ilosc].y], informacje.ZwierzeciaDoUsuniecia[ilosc].x,informacje.ZwierzeciaDoUsuniecia[ilosc].y , i);	
				}
                            }
                                ilosc--;
			}     
		}		
	}
    }
   boolean SprawdzPozycje(Wspolrzedne pozycja)
    {
	if (pozycja.x < 0 || pozycja.x >= szerokosc_planszy || pozycja.y < 0 || pozycja.y >= wysokosc_planszy)
		return false;
	return !(this.czy_zajete[pozycja.x][pozycja.y]);
    } 
   
    void ZapiszStanGry() throws IOException
    {
        PrintWriter zapis = new PrintWriter("StanGry.txt");
        String stan_gry = new String();
        stan_gry = String.valueOf(this.ile_organizmow);
        stan_gry += " ";
        stan_gry += String.valueOf(this.informacje.CzasDoUruchomieniaSpecjlanejUmiejetnosci);
        stan_gry += " ";
        stan_gry += String.valueOf(this.informacje.CzasTrwaniaSpecjalnejUmiejetnosci);
        stan_gry += " ";
        
        if(this.informacje.AktywowanaSpecjalnaUmiejetnosc)
        {
            stan_gry+= "1 ";
        }
        else 
            stan_gry+="0 ";
        
        zapis.println(stan_gry);
        
        for (int i = 0; i < this.szerokosc_planszy; i++)
        {
            for (int j = 0; j < this.wysokosc_planszy; j++)
            {
                if (organizmy[i][j] != null)
                {
                    stan_gry = String.valueOf( organizmy[i][j].GetSila());
                    stan_gry += " ";
                    stan_gry += String.valueOf( organizmy[i][j].GetWiek());
                    stan_gry += " ";
                    stan_gry += String.valueOf( organizmy[i][j].GetId());
                    stan_gry += " ";
                    stan_gry += String.valueOf( i);
                    stan_gry += " ";
                    stan_gry += String.valueOf( j);
                    stan_gry += " ";
                    zapis.println(stan_gry);                            
                }  
            }
        }

        zapis.close();
    } 
  
    void OdczytzPliku() throws FileNotFoundException, IOException
    {
        for (int i = 0; i < szerokosc_planszy; i++)
	{
            for (int j = 0; j < wysokosc_planszy; j++)
            {
		organizmy[i][j] = null;
		czy_zajete[i][j] = false;
            }
        }
               
        for (int i = 0 ; i < 400 ; i ++)
        {
            kolejka_ruchowx[i] = -1;
            kolejka_ruchowy[i] = -1;
        }
        
        File plik = new File("StanGry.txt");
        BufferedReader bufor = new BufferedReader(new FileReader("StanGry.txt"));
        String s = bufor.readLine();
        String[] kolejno = s.split(" ");
                
        ile_organizmow = Integer.parseInt(kolejno[0]);
        informacje.CzasDoUruchomieniaSpecjlanejUmiejetnosci = Integer.parseInt(kolejno[1]);
        informacje.CzasTrwaniaSpecjalnejUmiejetnosci = Integer.parseInt(kolejno[2]);
        informacje.AktywowanaSpecjalnaUmiejetnosc =Integer.parseInt(kolejno[3]) == 1;
                
        for (int i = 0; i < ile_organizmow; i++)
        {
            s = bufor.readLine();
            kolejno = s.split(" ");
            
            int sila = Integer.parseInt(kolejno[0]);
            int wiek = Integer.parseInt(kolejno[1]);
            int symbol = Integer.parseInt(kolejno[2]);
            int x = Integer.parseInt(kolejno[3]);
            int y = Integer.parseInt(kolejno[4]);
            
            char zwierze = ' ';
            if(symbol == 10)
                zwierze = 'A';
            else if(symbol == 0)
                zwierze = 'B';
            else if(symbol ==1)
                zwierze = 'X';
            else if(symbol ==2)
                zwierze = 'G';
            else if(symbol ==3)
                zwierze = 'L';
            else if(symbol ==4)
                zwierze = 'M';
            else if(symbol ==5)
                zwierze = 'O';
            else if(symbol ==6)
                zwierze = 'T';
            else if(symbol ==7)
                zwierze = 'J';
            else if(symbol ==8)
                zwierze = 'W';
            else if(symbol ==9)
                zwierze = 'Z';
                    
            PrzywrocDoZycia(zwierze, x, y, sila, wiek);
            czy_zajete[x][y] = true;
            kolejka_ruchowx[i] = x;
            kolejka_ruchowy[i] = y;
            ile_organizmow--;      
    }
  }
    
    void PrzywrocDoZycia(char nazwa, int x, int y, int sila, int wiek)
    {
        Wspolrzedne pozycja = new Wspolrzedne();
        pozycja.x = x;
        pozycja.y=y;
        
        if (nazwa== 'A')
            DodajOrganizm(new Antylopa(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'B' )
		 DodajOrganizm(new BarszczSosnowskiego(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'G' )
		 DodajOrganizm(new Guarana(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'L' )
		 DodajOrganizm(new Lis(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'M' )
		 DodajOrganizm(new Mlecz(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'O')
		 DodajOrganizm( new Owca(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'T' )
		 DodajOrganizm(new Trawa(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'J' )
		 DodajOrganizm( new WilczeJagody(x,y,sila,wiek), pozycja, -1);
	else if (nazwa== 'W')
		 DodajOrganizm(new Wilk(x,y,sila,wiek), pozycja, -1);
        else if (nazwa== 'Z')
		 DodajOrganizm( new Zolw(x,y,sila,wiek), pozycja, -1);
         else if (nazwa== 'X')
		 DodajOrganizm( new Czlowiek(x,y,sila,wiek), pozycja, -1);

    }
    
    void UsunOrganizm(Organizm org, int x, int y, int i)
    {
        organizmy[x][y] = null;
        czy_zajete[x][y] = false;
        this.ile_organizmow--;
        
        for (int j = 0; j < szerokosc_planszy * wysokosc_planszy; j++)
        {
            if ((kolejka_ruchowx[j] == x) && (kolejka_ruchowy[j] == y))
            {
                kolejka_ruchowx[j] = -2;
                kolejka_ruchowy[j] = -2;
                break;
            }		
        }
    }
    
    int GetSzerokosc()
    {
        return this.szerokosc_planszy;
    }

    int GetIlosc_Organizmow()
    {
        return this.ile_organizmow;
    }
        
    int GetWysokosc()
    {
        return this.wysokosc_planszy;
    }
}
