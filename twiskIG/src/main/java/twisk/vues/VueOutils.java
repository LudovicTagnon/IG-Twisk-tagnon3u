package twisk.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.TilePane;
import twisk.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur {

    protected Button bouton;
    protected MondeIG monde;

    public VueOutils(MondeIG monde) {
        super();
        this.monde = monde;

         this.bouton = new Button("Nouvelle Activité");

         this.bouton.setOnAction(new EcouteurBouton(monde));

         this.getChildren().addAll(this.bouton);

         this.monde.ajouterObservateur(this);

         this.tooltip();

    }

    @Override
    public void reagir() {

    }

    public void tooltip(){
        Tooltip userTip = new Tooltip("Ajouter activite");
        this.bouton.setTooltip(userTip);
    }
}
