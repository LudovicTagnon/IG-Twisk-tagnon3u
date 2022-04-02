package twisk.mondeIG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class EtapeIG implements Iterable<PointDeControleIG> {
    protected String nom;
    protected String identifiant;
    protected ArrayList<PointDeControleIG> PdC;
    protected int posX;
    protected int posY;
    protected int largeur;
    protected int hauteur;
    protected boolean selected;
    protected String Type;
    protected double Delai;
    protected double Ecart_temps;


    EtapeIG(String nom, String idf, int larg, int haut){
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;
        this.PdC = new ArrayList<PointDeControleIG>();
        this.selected = false;
        this.Type = "Activite";
        this.Delai = 0;
        this.Ecart_temps = 0;

        Random r = new Random();
        posX = r.nextInt(1000-larg);
        posY = r.nextInt(700-haut);

        this.PdC.add(new PointDeControleIG(this, this.posX, this.posY+this.hauteur/2)); // gauche
        this.PdC.add(new PointDeControleIG(this, this.posX+this.largeur, this.posY+this.hauteur/2)); // droite
        this.PdC.add(new PointDeControleIG(this, this.posX+this.largeur/2, this.posY+this.hauteur)); //bas
        this.PdC.add(new PointDeControleIG(this, this.posX+this.largeur/2, this.posY)); //haut
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getNom() {
        return nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return this.PdC.iterator();
    }

    public boolean isSelected() {
        return selected;
    }

    public ArrayList<PointDeControleIG> getPdC() {
        return PdC;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setPdC(ArrayList<PointDeControleIG> pdC) {
        PdC = pdC;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void move(int x, int y){
        this.setPosX(x);
        this.setPosY(y);
        this.PdC.get(0).setPosXCentre(x);
        this.PdC.get(0).setPosYCentre(y+this.hauteur/2);

        this.PdC.get(1).setPosXCentre(x+this.largeur);
        this.PdC.get(1).setPosYCentre(y+this.hauteur/2);

        this.PdC.get(2).setPosXCentre(x+this.largeur/2);
        this.PdC.get(2).setPosYCentre(y+this.hauteur);

        this.PdC.get(3).setPosXCentre(x+this.largeur/2);
        this.PdC.get(3).setPosYCentre(y);

    }

    public void setType(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }

    public double getDelai() {
        return Delai;
    }

    public double getEcart_temps() {
        return Ecart_temps;
    }

    public void setDelai(double delai) {
        Delai = delai;
    }

    public void setEcart_temps(double ecart_temps) {
        Ecart_temps = ecart_temps;
    }
}
