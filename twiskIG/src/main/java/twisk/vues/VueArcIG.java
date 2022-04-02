package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VueArcIG extends Pane implements Observateur{

    protected Line ligne;
    protected Polyline polyligne;

    public VueArcIG(MondeIG monde, ArcIG arc){
        this.ligne = new Line(arc.getPDC1().getPosXCentre(), arc.getPDC1().getPosYCentre(), arc.getPDC2().getPosXCentre(),arc.getPDC2().getPosYCentre());
        //this.setStyle("-fx-border-color: #f90000; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
        ligne.setStrokeWidth(5);

        this.ligne.setOnMouseClicked(new EcouteurSelect(monde, arc));

        this.polyligne = new Polyline();
        setPolyligne(arc.getPDC1(),arc.getPDC2(), arc);

        this.getChildren().add(this.ligne);
        System.out.println("ajout de la ligne a l'affichage dans la classe VueArcIG");
    }

    public void setPolyligne(PointDeControleIG P1, PointDeControleIG P2, ArcIG arc){
        double x1 = P1.getPosXCentre();
        double x2 = P2.getPosXCentre();
        double y1 = P1.getPosYCentre();
        double y2 = P2.getPosYCentre();

        double inclinaison = (y1-y2)/(x1-x2);

        double angle = Math.atan(inclinaison);
        double fleche = x1>x2 ? Math.toRadians(30) : -Math.toRadians(220);
        double longueur_fleche = 15;

        double point1x = x2 + longueur_fleche * Math.cos(angle - fleche);
        double point2x = x2 + longueur_fleche * Math.cos(angle + fleche);
        double point1y = y2 + longueur_fleche * Math.sin(angle - fleche);
        double point2y = y2 + longueur_fleche * Math.sin(angle + fleche);

        if(arc.isSelected()){
            this.polyligne.setStroke(Color.YELLOW);
            this.ligne.setStroke(Color.YELLOW);
            this.polyligne.setFill(Color.YELLOW);
            this.ligne.setFill(Color.YELLOW);

        }else{
            this.polyligne.setStroke(Color.BLACK);
            this.ligne.setStroke(Color.BLACK);
            this.polyligne.setFill(Color.BLACK);
            this.ligne.setFill(Color.BLACK);
        }
        this.polyligne.getPoints().addAll(x2, y2, point1x,point1y,point2x,point2y,x2,y2);
        this.polyligne.setStrokeWidth(2.5);

        this.getChildren().add(this.polyligne);


    }
    @Override
    public void reagir() {

    }
}
