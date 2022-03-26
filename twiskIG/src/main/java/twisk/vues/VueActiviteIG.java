package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.ArrayList;

public class VueActiviteIG extends VueEtapeIG implements Observateur {

    protected HBox hbox;

    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        this.hbox = new HBox();

        this.setOnMouseClicked(new EcouteurSelect(monde, this.etape));
        //System.out.println(etape.isSelected());
        //this.setStyle("-fx-border-color: #FF3232; -fx-border-radius: 5 5 5 5;");

        if(etape.isSelected()){
            this.setStyle("-fx-border-color: #ffc403; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
        }else{
            this.setStyle("-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
        }

        this.getChildren().add(hbox);

    }

    @Override
    public void reagir() {
    }

}
