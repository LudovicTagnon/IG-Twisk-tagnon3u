package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import twisk.mondeIG.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class VueMondeIG extends Pane implements Observateur {

    protected MondeIG monde;

    public VueMondeIG(MondeIG monde) {
        this.monde = monde;
        this.monde.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
        this.getChildren().clear();

        Iterator<ArcIG> iterateur = this.monde.iterator_arcs();

        System.out.println("Iterateur " + iterateur.hasNext());
        while (iterateur.hasNext()){
            ArcIG arc = iterateur.next();
            VueArcIG vuearcs = new VueArcIG(monde, arc);
            //iterateur.next();
            this.getChildren().add(vuearcs);
        }
        System.out.println("test2");
        for (EtapeIG e: monde) {
            VueActiviteIG a = new VueActiviteIG(monde,e);

            for (PointDeControleIG p: e) {
                VuePointDeControleIG Vuepdc = new VuePointDeControleIG(monde, p);
                Vuepdc.setStyle("-fx-border-color: #1339f7; -fx-border-radius: 5 5 5 5; -fx-background-color: 5 5 5 5");
                this.getChildren().add(Vuepdc);
            }

            a.setAlignment(Pos.CENTER);
            a.relocate(e.getPosX(), e.getPosY());
            a.setStyle("-fx-border-color: #FF3232; -fx-border-radius: 5 5 5 5;");



            this.getChildren().add(a);

        }



    }
}
