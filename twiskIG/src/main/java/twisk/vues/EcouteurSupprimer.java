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
        if(this.monde.getEtapes_selec().size() == 0){
            this.monde.setArcs(new ArrayList<ArcIG>());
            this.monde.setEtapes(new HashMap<String, EtapeIG>());
            this.monde.setEtapes_selec(new ArrayList<EtapeIG>());
        }
        else{
            for(EtapeIG e: this.monde.getEtapes_selec()){
                this.monde.getEtapes().remove(e.getIdentifiant(),e);
            }

            ArrayList<ArcIG> arc_tmp = new ArrayList<ArcIG>();
            for (ArcIG arc: this.monde.getArcs()) {
                boolean flag = false;
                for (EtapeIG etape: this.monde.getEtapes_selec()) {
                    for (PointDeControleIG pdc: etape.getPdC()) {
                        if(arc.getPDC1().getPosXCentre() == pdc.getPosXCentre() && arc.getPDC1().getPosYCentre() == pdc.getPosYCentre() ){
                            //this.monde.getArcs().remove(arc);
                            arc_tmp.add(arc);
                        }
                        else if(arc.getPDC2().getPosXCentre() == pdc.getPosXCentre() && arc.getPDC2().getPosYCentre() == pdc.getPosYCentre() ){
                            //this.monde.getArcs().remove(arc);
                            arc_tmp.add(arc);
                        }
                    }

                }
            }
            for(ArcIG arctodel:arc_tmp){
                this.monde.getArcs().remove(arctodel);
            }
            this.monde.setEtapes_selec(new ArrayList<EtapeIG>());

        }
        this.monde.notifierObservateur();
    }
}
