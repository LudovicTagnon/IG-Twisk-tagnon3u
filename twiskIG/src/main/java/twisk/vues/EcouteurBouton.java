package twisk.vues;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurBouton implements EventHandler<ActionEvent> {
    MondeIG monde;

    public EcouteurBouton(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.ajouter("Nouvelle Activite");
        //System.out.println("Nouvelle activite\n");
    }
}
