package twisk.vues;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurBouton implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurBouton(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.ajouter("Activite");
        //System.out.println("Nouvelle activite\n");
    }
}
