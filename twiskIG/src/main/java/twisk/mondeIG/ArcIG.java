package twisk.mondeIG;

import javafx.scene.shape.Line;

public class ArcIG {

    protected PointDeControleIG PDC1;
    protected PointDeControleIG PDC2;
    protected boolean selected;


    public ArcIG(PointDeControleIG pt1, PointDeControleIG pt2){
        this.PDC1 = pt1;
        this.PDC2 = pt2;
        this.selected=false;
    }

    public PointDeControleIG getPDC1() {
        return PDC1;
    }

    public PointDeControleIG getPDC2() {
        return PDC2;
    }

    public boolean isSelected() {
        return selected;
    }
}
