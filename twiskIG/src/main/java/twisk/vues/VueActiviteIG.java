package twisk.vues;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.ArrayList;

public class VueActiviteIG extends VueEtapeIG implements Observateur {

    protected HBox hbox;
    protected Rectangle rectangle;


    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        this.hbox = new HBox();

        this.setOnMouseClicked(new EcouteurSelect(monde, this.etape));

//        this.setWidth(etape.getLargeur());
//        this.setHeight(etape.getHauteur());


        if(etape.isSelected()){
            this.setStyle("-fx-border-color: #ffc403; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
        }else{
            this.setStyle("-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
        }
        this.rectangle = new Rectangle();
//        this.rectangle.setX(this.etape.getPosX()-this.etape.getLargeur()+20);
//        this.rectangle.setY(this.etape.getPosY()-this.etape.getHauteur()+20);
        this.rectangle.setWidth(this.etape.getLargeur()/4);
        this.rectangle.setHeight(this.etape.getHauteur()/4);



        if(this.etape.getType() == "Entree"){
            this.rectangle.setFill(Color.RED);
            this.getChildren().addAll(hbox,rectangle);
        }else if(this.etape.getType() == "Sortie"){
            this.rectangle.setFill(Color.BLUE);
            this.getChildren().addAll(hbox,rectangle);
        }
        else {
            this.getChildren().add(hbox);
            this.getChildren().remove(rectangle);
        }

    }

    @Override
    public void reagir() {
    }

}
