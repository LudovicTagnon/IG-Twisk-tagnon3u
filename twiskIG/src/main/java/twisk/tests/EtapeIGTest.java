package twisk.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.mondeIG.TailleComposants;
import twisk.outils.FabriqueIdentifiant;

import java.util.ArrayList;

class EtapeIGTest {

    ArrayList<PointDeControleIG> PdC;
    ActiviteIG Etape;

    @BeforeEach
    void setUp() {
        this.PdC = new ArrayList<PointDeControleIG>();

        FabriqueIdentifiant f = FabriqueIdentifiant.getInstance();
        String id = f.getIdentifiantEtape();
        TailleComposants t = TailleComposants.getInstance();

        this.Etape = new ActiviteIG("Activite" + id.substring(5), id, t.getLarg(), t.getHaut());

        this.PdC.add(new PointDeControleIG(Etape, Etape.getPosX()-Etape.getLargeur()/2, Etape.getPosY()));
        this.PdC.add(new PointDeControleIG(Etape, Etape.getPosX()+Etape.getLargeur()/2, Etape.getPosY()));
        this.PdC.add(new PointDeControleIG(Etape, Etape.getPosX(), Etape.getPosY()+Etape.getHauteur()/2));
        this.PdC.add(new PointDeControleIG(Etape, Etape.getPosX(), Etape.getPosY()-Etape.getHauteur()/2));
    }

    @Test
    void getPdC() {
        for (int i = 0; i < 4; i++) {
            //System.out.println(Etape.getPdC().get(i).getId() + " X=" + Etape.getPdC().get(i).getPosXCentre() + " Y=" + Etape.getPdC().get(i).getPosYCentre() );
        }

    }
}