package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.Exceptions.TwiskException;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSelect implements EventHandler<MouseEvent> {
    private MondeIG monde;
    EtapeIG Etape;
    ArcIG Arc;

    public EcouteurSelect(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.Arc=null;
        Etape = etape;
    }

    public EcouteurSelect(MondeIG monde, ArcIG arc) {
        this.monde = monde;
        this.Etape=null;
        Arc = arc;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        //System.out.println("handle dans la classe EcouteurSelect");
        if(this.Etape != null){
            this.monde.setSelect(this.Etape);
        }
        if(this.Arc!=null){
            this.monde.setSelect(this.Arc);
        }
        this.monde.notifierObservateur();
    }
}
