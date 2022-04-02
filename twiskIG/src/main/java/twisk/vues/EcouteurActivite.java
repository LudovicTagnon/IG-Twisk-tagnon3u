package twisk.vues;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.FabriqueIdentifiant;

public class EcouteurActivite implements EventHandler<MouseEvent> {

    private MondeIG monde;
    private Dragboard db;
    private final EtapeIG etape;
    //private final ClipboardContent content;
    private final VueEtapeIG VE;
    //private WritableImage capture;





    public EcouteurActivite(MondeIG monde, EtapeIG etape, VueEtapeIG VE) {
        this.monde = monde;
        this.etape = etape;
        this.VE = VE;
        //this.content = new ClipboardContent();
        //this.capture = capture;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        ClipboardContent content = new ClipboardContent();
        WritableImage capture = VE.snapshot(null, null);

        System.out.println("handle Ecouteuractivite");
        this.db = VE.startDragAndDrop(TransferMode.MOVE);

        content.putString(etape.getIdentifiant());
        //content.putImage(capture);

        db.setContent(content);

        mouseEvent.consume();

        //this.monde.notifierObservateur();
    }
}
