package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public abstract class VueEtapeIG extends VBox implements Observateur {

    protected Label Label_nom;
    protected Label Label_type;
    protected Label Label_delai;
    protected Label Label_Ecart_Temps;

    protected EtapeIG etape;
    protected MondeIG monde;



    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;

        this.setMinHeight(etape.getHauteur());
        this.setMaxHeight(etape.getHauteur());

        this.setMinWidth(etape.getLargeur());
        this.setMaxWidth(etape.getLargeur());

        this.Label_nom = new Label();
        this.Label_delai = new Label();
        this.Label_Ecart_Temps = new Label();
        this.Label_type = new Label();

        this.Label_nom.setText(etape.getNom());
        this.Label_type.setText("Type: " + etape.getType());
        this.Label_delai.setText("Delai: " + etape.getDelai());
        this.Label_Ecart_Temps.setText("Ecart Temps: : " + etape.getEcart_temps());

        //this.rectangle = new Rectangle(etape.getPosX(), etape.getPosY(), etape.getLargeur(), etape.getHauteur());
        //rectangle.setFill(Color.TRANSPARENT);

//        currentImage = new ImageView();
//        currentImage.setImage(this.snapshot(null, null));
//        currentImage.setId(this.getClass().getSimpleName() + System.currentTimeMillis());

//        final WritableImage capture = this.snapshot(null, null);


        this.setOnDragDetected(new EcouteurActivite(monde, etape, this));

        this.getChildren().setAll(Label_nom, Label_type, Label_delai, Label_Ecart_Temps);


    }
}
