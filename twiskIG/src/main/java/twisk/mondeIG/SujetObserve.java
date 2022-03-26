package twisk.mondeIG;

import twisk.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {
    protected ArrayList<Observateur> Obs;

    public void ajouterObservateur(Observateur v) {
        this.Obs.add(v);
    }

    public void notifierObservateur() {
        for (Observateur o : this.Obs) {
            o.reagir();
        }
//        for(int i=0; i< this.Obs.size(); i++){
//            Obs.get(i).reagir();
//        }
    }

}
