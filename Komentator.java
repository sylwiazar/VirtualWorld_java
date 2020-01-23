
package wirtualizacjaswiata;


public class Komentator {
    
    public String zjedzone_rosliny;
    public String w_wyniku_walk_zgineli;
    public String nowe_organizmy ;
    public String zjedli_trujace_rosliny ;
    
    public Komentator()
    {
        this.zjedzone_rosliny = new String();
        this.w_wyniku_walk_zgineli = new String();
        this.nowe_organizmy = new String();
        this.zjedli_trujace_rosliny = new String();
        this.zjedzone_rosliny="Zjedzone rosliny w danej turze: ";
        this.w_wyniku_walk_zgineli="W wyniku walk zgineli: ";
        this.nowe_organizmy="Nowe organizmy na planszy: ";
        this.zjedli_trujace_rosliny="Trujace rosliny zabily: ";
    }

    void WWynikuWalkZgineli(String nazwa)
    {
            this.w_wyniku_walk_zgineli+=nazwa;
            this.w_wyniku_walk_zgineli+=" ,";
    }

    void ZjedzoneRosliny(String nazwa)
    {
            this.zjedzone_rosliny+=nazwa;
            this.zjedzone_rosliny+= " ,";
    }

    void NoweOrganizmy(String nazwa)
    {
            this.nowe_organizmy+=nazwa;
            this.nowe_organizmy+=" ,";
    }

    void ZjedliTrujaceRosliny(String nazwa)
    {
            this.zjedli_trujace_rosliny+=nazwa;
            this.zjedli_trujace_rosliny+=" ,";
    }

    void WypiszKomentarze()
    {
        System.out.println(zjedzone_rosliny);
        System.out.println(w_wyniku_walk_zgineli);
        System.out.println(nowe_organizmy);
        System.out.println(zjedli_trujace_rosliny);

	this.zjedzone_rosliny="Zjedzone rosliny w danej turze: ";
	this.w_wyniku_walk_zgineli="W wyniku walk zgineli: ";
	this.nowe_organizmy="Nowe organizmy na planszy: ";
	this.zjedli_trujace_rosliny = "Trujace rosliny zabily: ";    
    }
}