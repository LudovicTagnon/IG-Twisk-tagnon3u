package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

public class EcouteurTemps implements EventHandler<ActionEvent> {

    private MondeIG monde;
    private Label label;
    protected TextInputDialog Delai;
    protected TextInputDialog Ecart_temps;

    public EcouteurTemps(MondeIG monde) {
        this.monde = monde;
        this.label = new Label();
        this.Delai = new TextInputDialog("Delai");
        this.Ecart_temps = new TextInputDialog("Ecart_temps");
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if(monde.getEtapes_selec().size() == 1){
            Delai.setTitle("Donner le délai de l'activité");
            Ecart_temps.setTitle("Donner l'écart temps de l'activité");
            Delai.showAndWait();
            this.monde.getEtapes_selec().get(0).setDelai(Double.parseDouble(Delai.getResult())); // change nom de l'etape selectionne dans l'arraylist
            Ecart_temps.showAndWait();
            this.monde.getEtapes_selec().get(0).setEcart_temps(Double.parseDouble(Ecart_temps.getResult())); // change nom de l'etape selectionne dans l'arraylist
            monde.notifierObservateur();
        }
    }
}
