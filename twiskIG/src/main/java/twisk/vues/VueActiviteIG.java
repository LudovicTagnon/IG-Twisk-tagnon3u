package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.ArrayList;

public class VueActiviteIG extends VueEtapeIG{

    protected Label TitreActivite;
    protected HBox hbox;

    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
    }

    @Override
    public void reagir() {

    }
}
