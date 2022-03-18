package twisk.vues;

import javafx.scene.shape.Circle;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;


public class VuePointDeControleIG extends Circle implements Observateur{

    protected MondeIG monde;

    protected PointDeControleIG pdc;

    public VuePointDeControleIG(MondeIG monde, PointDeControleIG pdc){

        monde.ajouterObservateur(this);

        this.pdc = pdc;
        this.monde = monde;

        this.setCenterX(pdc.getPosXCentre());
        this.setCenterY(pdc.getPosYCentre());
        this.setRadius(10);
        System.out.println("Boucle ajoute cercle");


    }

    @Override
    public void reagir() {

    }
}
