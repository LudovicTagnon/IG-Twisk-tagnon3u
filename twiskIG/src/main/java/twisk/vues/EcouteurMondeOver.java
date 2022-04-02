package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurMondeOver implements EventHandler<DragEvent> {

    private MondeIG monde;

    public EcouteurMondeOver(MondeIG monde) {
        this.monde = monde;
    }


    @Override
    public void handle(DragEvent dragEvent) {
        System.out.println("onDragOver");
        //final Dragboard dragBoard = dragEvent.getDragboard();

        dragEvent.acceptTransferModes(TransferMode.MOVE);
        dragEvent.consume();
    }
}
