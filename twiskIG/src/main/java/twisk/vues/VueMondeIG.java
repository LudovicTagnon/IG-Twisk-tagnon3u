package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.MondeIG;

public class VueMondeIG extends Pane implements Observateur {

    MondeIG monde;

    public VueMondeIG(MondeIG monde) {
        this.monde = monde;

        //this.monde.
    }

    @Override
    public void reagir() {

    }
}
