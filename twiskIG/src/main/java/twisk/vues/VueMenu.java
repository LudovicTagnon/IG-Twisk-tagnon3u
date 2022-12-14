package twisk.vues;

import javafx.application.Platform;
import javafx.scene.control.*;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class VueMenu extends MenuBar implements Observateur{

    protected MondeIG monde;

    protected Menu Fichier;
    protected Menu Edition;
    protected Menu Monde;
    protected Menu Parametres;


    protected MenuItem Quitter;
    protected MenuItem Renommer;
    protected MenuItem Supprimer;

    protected MenuItem Entree;
    protected MenuItem Sortie;
    protected MenuItem Temps;


    public VueMenu(MondeIG monde) {
        monde.ajouterObservateur(this);

        this.monde=monde;

        Fichier = new Menu("Fichier");
        Edition = new Menu("Edition");
        Monde = new Menu("Monde");
        Parametres = new Menu("Parametres");
        Quitter = new MenuItem("Quitter");
        Renommer = new MenuItem("Renommer");
        Supprimer = new MenuItem("Supprimer");
        Entree = new MenuItem("Entree");
        Sortie = new MenuItem("Sortie");
        Temps = new MenuItem("Temps");

        Fichier.getItems().add(Quitter);

        Edition.getItems().addAll(Renommer,Supprimer);

        Monde.getItems().addAll(Entree, Sortie);

        Parametres.getItems().addAll(Temps);

        Supprimer.setOnAction(new EcouteurSupprimer(monde));

        Renommer.setOnAction(new EcouteurRenommer(monde));

        Quitter.setOnAction(event -> Platform.exit());

        Entree.setOnAction(new EcouteurEntree(monde));

        Sortie.setOnAction(new EcouteurSortie(monde));

        Temps.setOnAction(new EcouteurTemps(monde));


        this.setStyle(" -fx-border-color: #32ff5b; -fx-border-radius: 5 5 5 5; -fx-fill: 5 5 5 5");

        this.getMenus().addAll(Fichier, Edition, Monde, Parametres);
    }


    @Override
    public void reagir() {
        //this.getChildren().clear();

        Supprimer.setOnAction(new EcouteurSupprimer(monde));

        Renommer.setOnAction(new EcouteurRenommer(monde));

        Quitter.setOnAction(event -> Platform.exit());

        Entree.setOnAction(new EcouteurEntree(monde));

        Sortie.setOnAction(new EcouteurSortie(monde));

        this.setStyle(" -fx-border-color: #32ff5b; -fx-border-radius: 5 5 5 5; -fx-fill: 5 5 5 5");


        //this.getMenus().addAll(Fichier, Edition);

    }
}
