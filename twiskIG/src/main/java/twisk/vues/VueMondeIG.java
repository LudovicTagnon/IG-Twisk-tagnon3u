package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.ArrayList;
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
        for (EtapeIG e: monde) {
            VueActiviteIG a = new VueActiviteIG(monde,e);
            a.setAlignment(Pos.CENTER);
            a.relocate(e.getPosX(), e.getPosY());
            a.setMinHeight(50);
            a.setMinWidth(100);
            a.setStyle("-fx-border-color: #FF3232; -fx-border-radius: 5 5 5 5;");
            this.getChildren().add(a);
        }
    }
}
