package twisk.mondeIG;

import java.util.Random;

public abstract class EtapeIG {
    protected String nom;
    protected String identifiant;
    protected int posX;
    protected int posY;
    protected int largeur;
    protected int hauteur;

    EtapeIG(String nom, String idf, int larg, int haut){
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;

        Random r = new Random();
        posX = r.nextInt(1000-larg);
        posY = r.nextInt(700-haut);
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
}
