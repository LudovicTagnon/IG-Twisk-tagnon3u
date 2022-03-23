package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public abstract class VueEtapeIG extends VBox implements Observateur {

    protected Label Label;
    protected EtapeIG etape;
    protected MondeIG monde;

    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;

        this.setMinHeight(etape.getHauteur());
        this.setMaxHeight(etape.getHauteur());

        this.setMinWidth(etape.getLargeur());
        this.setMaxWidth(etape.getLargeur());

        this.Label = new Label(etape.getNom());
        this.getChildren().add(Label);
    }
}
