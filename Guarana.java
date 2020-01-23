
package wirtualizacjaswiata;

import java.awt.Color;

public class Guarana extends Roslina{
    
    private static final char GUARANA = 'G';
    private static final int GUARANA_INICJATYWA = 0;
    private static final int GUARANA_SILA = 0;
    private static final String GUARANA_NAZWA = "Guarana";
    //Zwierze, ktore zjadlo guarane zwieksza swoja sile o dana wartosc
    private static final int ZWIEKSZENIE_SILY_PRZY_ZJEDZENIU_GUARANY = 3;
    public static final int ID = 2;
    
    public Guarana()
    {
        super(GUARANA_NAZWA, GUARANA_SILA, GUARANA_INICJATYWA, GUARANA, new Color(233,87,116));
    }

    public Guarana(int x, int y, int sila, int wiek)
    {
        super(GUARANA_NAZWA, sila, GUARANA_INICJATYWA, GUARANA, wiek, x,y, new Color(233,87,116));
    }
    
    @Override
    public int GetId()
    {
        return 2;
    }
    
    @Override
    public void ZwiekszSileZwierzecia(Organizm org)
    {
	org.SetSila(org.GetSila() + ZWIEKSZENIE_SILY_PRZY_ZJEDZENIU_GUARANY);
    }
}
