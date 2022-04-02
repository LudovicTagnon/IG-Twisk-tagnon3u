package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

import java.util.ArrayList;
import java.util.HashMap;

public class EcouteurSupprimer implements EventHandler<ActionEvent> {

    private MondeIG monde;

    public EcouteurSupprimer(MondeIG monde) {
        this.monde = monde;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.monde.getEtapes_selec().size() == 0 && this.monde.getArc_selec().size() == 0){ // Si la selection est nulle
            this.monde.setArcs(new ArrayList<ArcIG>());
            this.monde.setEtapes(new HashMap<String, EtapeIG>());
            this.monde.setEtapes_selec(new ArrayList<EtapeIG>());
        }
        else if(this.monde.getEtapes_selec().size() != 0 && this.monde.getArc_selec().size() == 0){ //Si des etapes sont selectionnees
            for(EtapeIG e: this.monde.getEtapes_selec()){ //On supprime les activites selectionnees en commun avec la Hashmap d'etapes
                this.monde.getEtapes().remove(e.getIdentifiant(),e);
            }

            //On cree une Arraylist temporaire d'ArcIGs à supprimer (car reliés à une activite à supprimer)
            ArrayList<ArcIG> arc_tmp = new ArrayList<ArcIG>();
            for (ArcIG arc: this.monde.getArcs()) { //pour chaque arc du monde
                boolean flag = false;
                for (EtapeIG etape: this.monde.getEtapes_selec()) {
                    for (PointDeControleIG pdc: etape.getPdC()) { //pour chaque pdc de chaque activite
                        //On cherche si au - 1 pdc est commun entre l'arc et l'activite
                        if(arc.getPDC1().getPosXCentre() == pdc.getPosXCentre() && arc.getPDC1().getPosYCentre() == pdc.getPosYCentre() ){
                            //this.monde.getArcs().remove(arc);
                            arc_tmp.add(arc); // Si oui, on ajoute l'arc aux arcs temporaires
                        }
                        else if(arc.getPDC2().getPosXCentre() == pdc.getPosXCentre() && arc.getPDC2().getPosYCentre() == pdc.getPosYCentre() ){
                            //this.monde.getArcs().remove(arc);
                            arc_tmp.add(arc); // Si oui, on ajoute l'arc aux arcs temporaires
                        }
                    }

                }
            }
            for(ArcIG arctodel:arc_tmp){
                this.monde.getArcs().remove(arctodel); // On retire chaque arc temporaire trouvé à l'Arraylist d'Arcs du monde;
            }
            this.monde.setEtapes_selec(new ArrayList<EtapeIG>());

        }
        else if(this.monde.getEtapes_selec().size() == 0 && this.monde.getArc_selec().size() != 0){ //Si des arcs sont selectionnes
            for(ArcIG a: this.monde.getArc_selec()){ //On supprime les arcs selectionnés
                this.monde.getArcs().remove(a);
            }
            this.monde.setArc_selec(new ArrayList<ArcIG>());
        }
        else{ // Si des arcs et des etapes sont selectionnes
            for(EtapeIG e: this.monde.getEtapes_selec()){ //On supprime les activites selectionnees en commun avec la Hashmap d'etapes
                this.monde.getEtapes().remove(e.getIdentifiant(),e);
            }

            //On cree une Arraylist temporaire d'ArcIGs à supprimer (car reliés à une activite à supprimer)
            ArrayList<ArcIG> arc_tmp = new ArrayList<ArcIG>();
            for (ArcIG arc: this.monde.getArcs()) { //pour chaque arc du monde
                boolean flag = false;
                for (EtapeIG etape: this.monde.getEtapes_selec()) {
                    for (PointDeControleIG pdc: etape.getPdC()) { //pour chaque pdc de chaque activite
                        //On cherche si au - 1 pdc est commun entre l'arc et l'activite
                        if(arc.getPDC1().getPosXCentre() == pdc.getPosXCentre() && arc.getPDC1().getPosYCentre() == pdc.getPosYCentre() ){
                            //this.monde.getArcs().remove(arc);
                            arc_tmp.add(arc); // Si oui, on ajoute l'arc aux arcs temporaires
                        }
                        else if(arc.getPDC2().getPosXCentre() == pdc.getPosXCentre() && arc.getPDC2().getPosYCentre() == pdc.getPosYCentre() ){
                            //this.monde.getArcs().remove(arc);
                            arc_tmp.add(arc); // Si oui, on ajoute l'arc aux arcs temporaires
                        }
                    }

                }
            }
            for(ArcIG arctodel:arc_tmp){
                this.monde.getArcs().remove(arctodel); // On retire chaque arc temporaire trouvé à l'Arraylist d'Arcs du monde;
            }
            for(ArcIG a: this.monde.getArc_selec()){ //On supprime les arcs selectionnés
                this.monde.getArcs().remove(a);
            }
            this.monde.setEtapes_selec(new ArrayList<EtapeIG>());
            this.monde.setArc_selec(new ArrayList<ArcIG>());
        }
        this.monde.notifierObservateur();
    }
}
