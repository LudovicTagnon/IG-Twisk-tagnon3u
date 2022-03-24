package twisk.mondeIG;

import twisk.Exceptions.TwiskException;
import twisk.outils.FabriqueIdentifiant;
import twisk.vues.Observateur;
import twisk.vues.VueArcIG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {

    private HashMap<String, EtapeIG> etapes;
    private ArrayList<ArcIG> Arcs;

    private PointDeControleIG pdc_Choisi;

    public MondeIG() {
        this.etapes = new HashMap<String, EtapeIG>();
        this.Obs = new ArrayList<Observateur>();
        //this.ajouter("Activite");
        this.pdc_Choisi=null;
        this.Arcs = new ArrayList<ArcIG>();
    }


    public void ajouter(String type) {
        if (type.equals("Activite")) {
            FabriqueIdentifiant f = FabriqueIdentifiant.getInstance();
            String id = f.getIdentifiantEtape();
            TailleComposants t = TailleComposants.getInstance();
            EtapeIG A = new ActiviteIG("Activite" + id.substring(5), id, t.getLarg(), t.getHaut());
            this.etapes.put(id, A);
            System.out.println(id + "\n");
            this.notifierObservateur();
        }
    }





    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    public Iterator<ArcIG> iterator_arcs() {
        return this.Arcs.iterator();
    }

    public void setPdc_Choisi(PointDeControleIG pdc_Choisi2) throws TwiskException {
        if(this.pdc_Choisi == null) {
            System.out.println("null");
            this.pdc_Choisi = pdc_Choisi2;
        }else{
            System.out.println("Pas null");
            ajouterArc(this.pdc_Choisi, pdc_Choisi2);
            this.pdc_Choisi = null;
        }
        System.out.println("setPDC_choisi dans la classe MONDE IG");
    }

    public void ajouterArc(PointDeControleIG pt1, PointDeControleIG pt2) throws TwiskException {
        //int flag =0;
        //Si l'arc n'existe pas deja
        for (ArcIG arc: this.Arcs) {
            if( (arc.getPDC1().getId() == pt1.getId()) || (arc.getPDC1().getId() == pt2.getId()) ){
                //flag=1;
                this.pdc_Choisi =null;
                throw new TwiskException("Fleche deja cree");
            }

        }
        if(pt2.getId() == pt1.getId()){
            //flag=1;
            this.pdc_Choisi =null;
            throw new TwiskException("Fleche dans la meme activite");
        }
        //if(flag==0){
            ArcIG Arc = new ArcIG(pt1, pt2);
            this.Arcs.add(Arc);
            this.notifierObservateur();
        //}
    }
}