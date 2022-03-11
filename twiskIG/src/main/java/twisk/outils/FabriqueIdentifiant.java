package twisk.outils;

import java.util.Random;

public class FabriqueIdentifiant {

    private int noEtape;

    private static FabriqueIdentifiant instance;

    public static FabriqueIdentifiant getInstance(){
        instance = new FabriqueIdentifiant();
        return instance;
    }


    public String getIdentifiantEtape(){
//        Random rd = new Random();
//        this.noEtape = rd.nextInt();
//        return Integer.toString(this.noEtape);
        return instance.toString();
    }

    @Override
    public String toString() {
        return "" + noEtape;
    }
}
