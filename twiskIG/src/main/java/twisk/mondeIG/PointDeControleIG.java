package twisk.mondeIG;

public class PointDeControleIG {
    private int posXCentre;
    private int posYCentre;

    private String id;

    public PointDeControleIG(EtapeIG E, int posX, int posY) {
        this.id = E.getIdentifiant();
        this.posXCentre = posX;
        this.posYCentre = posY;
    }

    public int getPosXCentre() {
        return posXCentre;
    }

    public int getPosYCentre() {
        return posYCentre;
    }

    public String getId() {
        return id;
    }

    public void setPosXCentre(int posXCentre) {
        this.posXCentre = posXCentre;
    }

    public void setPosYCentre(int posYCentre) {
        this.posYCentre = posYCentre;
    }
}
