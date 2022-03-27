package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurRenommer implements EventHandler<ActionEvent> {

    private MondeIG monde;
    private Label label;
    protected TextInputDialog texte;


    public EcouteurRenommer(MondeIG monde) {
        this.monde = monde;
        this.label = new Label();
        this.texte = new TextInputDialog("Renommer");
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(monde.getEtapes_selec().size()==1){
            texte.setTitle("Renommer l'activite");
            texte.setContentText("Nouveau nom:");
            texte.setX(this.monde.getEtapes_selec().get(0).getPosX());
            texte.setY(this.monde.getEtapes_selec().get(0).getPosY());
            texte.showAndWait();
            this.monde.getEtapes_selec().get(0).setNom(texte.getResult()); // change nom de l'etape selectionne dans l'arraylist
            //this.monde.getEtapes().get(this.monde.getEtapes_selec().get(0).getIdentifiant()).setNom(texte);// change nom de l'etape selectionne dans la hashmap
            //System.out.println(this.monde.getEtapes().get(this.monde.getEtapes_selec().get(0).getNom()));
            monde.notifierObservateur();
        }else{

        }
    }
}
