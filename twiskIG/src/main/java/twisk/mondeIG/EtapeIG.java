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

    EtapeIG(String nom, String idf, int larg, int haut){
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;
        this.PdC = new ArrayList<PointDeControleIG>();
        this.selected = false;

        Random r = new Random();
        posX = r.nextInt(1000-larg);
        posY = r.nextInt(700-haut);

        this.PdC.add(new PointDeControleIG(this, this.posX, this.posY+this.hauteur/2));
        this.PdC.add(new PointDeControleIG(this, this.posX+this.largeur, this.posY+this.hauteur/2));
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
}
