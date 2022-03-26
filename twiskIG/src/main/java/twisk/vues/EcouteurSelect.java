package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.Exceptions.TwiskException;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSelect implements EventHandler<MouseEvent> {
    private MondeIG monde;
    EtapeIG Etape;

    public EcouteurSelect(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        Etape = etape;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        //System.out.println("handle dans la classe EcouteurSelect");
        this.monde.setSelect(this.Etape);
        this.monde.notifierObservateur();
    }
}
