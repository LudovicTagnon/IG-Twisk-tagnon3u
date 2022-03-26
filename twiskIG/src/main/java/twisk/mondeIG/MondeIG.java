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
    private ArrayList<EtapeIG> etapes_selec;
    private PointDeControleIG pdc_Choisi;


    public MondeIG() {
        this.etapes = new HashMap<String, EtapeIG>();
        this.Obs = new ArrayList<Observateur>();
        this.etapes_selec = new ArrayList<EtapeIG>();
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
            this.pdc_Choisi = pdc_Choisi2;
        }else{
            ajouterArc(this.pdc_Choisi, pdc_Choisi2);
            this.pdc_Choisi = null;
        }
        //System.out.println("setPDC_choisi dans la classe MONDE IG");
    }

    public void setSelect(EtapeIG etape){
        if(!etape.selected){
            this.etapes_selec.add(etape);
        }else{
            this.etapes_selec.remove(etape);
        }
        etape.selected = !etape.isSelected();
        for (EtapeIG E: this.etapes_selec) {
            System.out.println(E.getIdentifiant());
        }
        //System.out.println("setPDC_choisi dans la classe MONDE IG");
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