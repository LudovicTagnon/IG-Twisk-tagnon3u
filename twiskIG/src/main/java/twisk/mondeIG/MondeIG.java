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
    private ArrayList<ArcIG> arc_selec;
    private ArrayList<EtapeIG> Entrees;
    private ArrayList<EtapeIG> Sorties;


    public MondeIG() {
        this.etapes = new HashMap<String, EtapeIG>();
        this.Obs = new ArrayList<Observateur>();
        this.etapes_selec = new ArrayList<EtapeIG>();
        this.arc_selec = new ArrayList<ArcIG>();
        this.Entrees = new ArrayList<>();
        this.Sorties = new ArrayList<>();
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
    public void setSelect(ArcIG arc){
        if(!arc.selected){
            this.arc_selec.add(arc);
        }else{
            this.arc_selec.remove(arc);
        }
        arc.selected = !arc.isSelected();
    }

    public void ajouterArc(PointDeControleIG pt1, PointDeControleIG pt2) throws TwiskException {

        //Si un arc existe déjà à ces 2 points là
        for (ArcIG arc: this.Arcs) {
            if( ((arc.getPDC1().getPosXCentre() == pt1.getPosXCentre()) && (arc.getPDC2().getPosXCentre() == pt2.getPosXCentre()) && (arc.getPDC1().getPosYCentre() == pt1.getPosYCentre()) && (arc.getPDC2().getPosYCentre() == pt2.getPosYCentre())) ){
                //flag=1;
                this.pdc_Choisi =null;
                throw new TwiskException("Flèche déjà crée entre ces 2 points de contrôles");
            }
            if((arc.getPDC1().getId() == pt1.getId() &&  arc.getPDC2().getId() == pt2.getId()) || (arc.getPDC1().getId() == pt2.getId() &&  arc.getPDC2().getId() == pt1.getId())){
                this.pdc_Choisi =null;
                throw new TwiskException("Flèche déjà crée entre ces 2 activités");
            }
        }

        //Fleche dans la meme activite
        if(pt2.getId() == pt1.getId()){
            //flag=1;
            this.pdc_Choisi =null;
            throw new TwiskException("Flèche dans la même activité");
        }
        //if(flag==0){
            ArcIG Arc = new ArcIG(pt1, pt2);
            this.Arcs.add(Arc);
            this.notifierObservateur();
        //}
    }

    public void setEtapes(HashMap<String, EtapeIG> etapes) {
        this.etapes = etapes;
    }

    public void setArcs(ArrayList<ArcIG> arcs) {
        Arcs = arcs;
    }

    public void setEtapes_selec(ArrayList<EtapeIG> etapes_selec) {
        this.etapes_selec = etapes_selec;
    }

    public HashMap<String, EtapeIG> getEtapes() {
        return etapes;
    }

    public ArrayList<ArcIG> getArcs() {
        return Arcs;
    }

    public ArrayList<EtapeIG> getEtapes_selec() {
        return etapes_selec;
    }

    public PointDeControleIG getPdc_Choisi() {
        return pdc_Choisi;
    }

    public ArrayList<ArcIG> getArc_selec() {
        return arc_selec;
    }

    public void setArc_selec(ArrayList<ArcIG> arc_selec) {
        this.arc_selec = arc_selec;
    }

    public void setEntrees(ArrayList<EtapeIG> entrees) {
        Entrees = entrees;
    }

    public void setSorties(ArrayList<EtapeIG> sorties) {
        Sorties = sorties;
    }

    public ArrayList<EtapeIG> getEntrees() {
        return Entrees;
    }

    public ArrayList<EtapeIG> getSorties() {
        return Sorties;
    }

    public void deselectAll(){
        for (EtapeIG e: this.getEtapes_selec()) {
            e.setSelected(false);
        }
    }
}