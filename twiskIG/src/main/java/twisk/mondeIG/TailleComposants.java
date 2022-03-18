package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

public class TailleComposants {

    private int larg;
    private int haut;

    private static TailleComposants instance = new TailleComposants();

    private TailleComposants(){
        this.larg = 200;
        this.haut = 100;
    }

    public int getLarg() {
        return larg;
    }

    public int getHaut() {
        return haut;
    }

    public static TailleComposants getInstance(){
        return instance;
    }



}
