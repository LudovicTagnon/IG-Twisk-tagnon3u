package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.ArrayList;
import java.util.Objects;

public class EcouteurEntree implements EventHandler<ActionEvent> {

    protected MondeIG monde;

    public EcouteurEntree(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for (EtapeIG etapes_selec: monde.getEtapes_selec()) {
                if(Objects.equals(etapes_selec.getType(), "Entree")){
                    etapes_selec.setType("Activite");
                    this.monde.getEntrees().remove(etapes_selec);
                }else{
                    etapes_selec.setType("Entree");
                    this.monde.getEntrees().add(etapes_selec);
                }
        }
        this.monde.deselectAll();
        this.monde.setEtapes_selec(new ArrayList<EtapeIG>());
        this.monde.notifierObservateur();
    }
}
