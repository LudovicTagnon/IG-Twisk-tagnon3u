package twisk.mondeIG;

import javafx.scene.control.Button;
import twisk.outils.FabriqueIdentifiant;
import twisk.vues.Observateur;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MondeIG implements Iterable<EtapeIG> {

    private HashMap<String, EtapeIG> etapes;
    private ArrayList<Observateur> Obs;


    public MondeIG() {
        this.etapes = new HashMap<String, EtapeIG>();
        this.Obs = new ArrayList<>();
        this.ajouter("Activite");
    }


    public void ajouter(String type) {
        if (type.equals("Activite")) {
            this.notifierObservateur();
            FabriqueIdentifiant f = FabriqueIdentifiant.getInstance();
            String id = f.getIdentifiantEtape();
            TailleComposants t = TailleComposants.getInstance();
            EtapeIG A = new ActiviteIG("Activite" + id.substring(5), id, t.getLarg(), t.getHaut());
            this.etapes.put(id, A);
            System.out.println(id + "\n");
        }
    }

    public void ajouterObservateur(Observateur v) {
        this.Obs.add(v);
    }

    void notifierObservateur() {
//        for (Observateur o : this.Obs) {
//            o.reagir();
//        }
        for(int i=0; i< this.Obs.size(); i++){
            Obs.get(i).reagir();
        }
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }
}