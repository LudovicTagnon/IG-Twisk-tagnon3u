package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.Exceptions.TwiskException;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurPDC implements EventHandler<MouseEvent> {

    private MondeIG monde;
    private PointDeControleIG PDC;

    public EcouteurPDC(MondeIG monde, PointDeControleIG pdc) {
        this.monde = monde;
        this.PDC = pdc;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        //System.out.println("handle dans la classe EcouteurPDC");
        try{
            this.monde.setPdc_Choisi(this.PDC);
        }catch(TwiskException ignored){

        }
    }
}
