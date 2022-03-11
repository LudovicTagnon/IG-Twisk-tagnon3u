package twisk.mondeIG;

import javafx.scene.control.Button;
import twisk.outils.FabriqueIdentifiant;
import twisk.vues.Observateur;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MondeIG implements Iterable<EtapeIG>{

    private HashMap<String,EtapeIG> etapes;
    private ArrayList<Observateur> Obs;
    private VueMondeIG VM;
    private VueOutils VO;

    public MondeIG() {
        this.etapes = new HashMap<String,EtapeIG>();
        this.ajouter("Activite");
        this.Obs = new ArrayList<>();
    }

    public void ajouter(String type){
        if (type == "Activite"){

            FabriqueIdentifiant f = FabriqueIdentifiant.getInstance();
            ActiviteIG A = new ActiviteIG("Exemple", f.toString(), 30,20);
            this.etapes.put(f.getIdentifiantEtape(),A);
        }
    }

    public void ajouterObservateur(Observateur v){
        this.Obs.add(v);
    }

    void notifierObservateur(){

    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return null;
    }

    public HashMap<String, EtapeIG> getEtapes() {
        return etapes;
    }
}
