package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurRenommer implements EventHandler<ActionEvent> {

    private MondeIG monde;

    public EcouteurRenommer(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(monde.getEtapes_selec().size()==1){

        }else{

        }
    }
}
