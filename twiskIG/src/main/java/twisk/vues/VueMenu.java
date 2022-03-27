package twisk.vues;

import javafx.application.Platform;
import javafx.scene.control.*;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class VueMenu extends MenuBar implements Observateur{

    protected MondeIG monde;

    protected Menu Fichier;
    protected Menu Edition;

    protected MenuItem Quitter;
    protected MenuItem Renommer;
    protected MenuItem Supprimer;


    public VueMenu(MondeIG monde) {
        monde.ajouterObservateur(this);

        this.monde=monde;

        Fichier = new Menu("Fichier");
        Edition = new Menu("Edition");
        Quitter = new MenuItem("Quitter");
        Renommer = new MenuItem("Renommer");
        Supprimer = new MenuItem("Supprimer");

        Fichier.getItems().add(Quitter);

        Edition.getItems().addAll(Renommer,Supprimer);

        Supprimer.setOnAction(new EcouteurSupprimer(monde));

        Renommer.setOnAction(new EcouteurRenommer(monde));

        Quitter.setOnAction(event -> Platform.exit());

        this.setStyle(" -fx-border-color: #32ff5b; -fx-border-radius: 5 5 5 5; -fx-fill: 5 5 5 5");

        this.getMenus().addAll(Fichier, Edition);
    }


    @Override
    public void reagir() {
        //this.getChildren().clear();

        Supprimer.setOnAction(new EcouteurSupprimer(monde));

        Renommer.setOnAction(new EcouteurRenommer(monde));

        Quitter.setOnAction(event -> Platform.exit());

        this.setStyle(" -fx-border-color: #32ff5b; -fx-border-radius: 5 5 5 5; -fx-fill: 5 5 5 5");





        //this.getMenus().addAll(Fichier, Edition);

    }
}
