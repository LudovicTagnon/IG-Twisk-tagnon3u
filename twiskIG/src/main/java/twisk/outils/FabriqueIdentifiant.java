package twisk.outils;

import java.util.Random;

public class FabriqueIdentifiant {

    private int noEtape;

    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();

    public static FabriqueIdentifiant getInstance(){
        return instance;
    }

    public String getIdentifiantEtape(){
        return "Etape" + noEtape++;
    }

}
