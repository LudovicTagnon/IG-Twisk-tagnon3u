package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurMondeDropped implements EventHandler<DragEvent> {

    private MondeIG monde;
    VueMondeIG VM;
    VueActiviteIG VA;

    public EcouteurMondeDropped(MondeIG monde, VueMondeIG VM) {
        this.monde = monde;
        this.VM = VM;
    }


    @Override
    public void handle(DragEvent dragEvent) {

        System.out.println("onDragDropped");

        boolean success = false;
        try {
            System.out.println("test if EcouteurMondeDropped");

            this.VA = (VueActiviteIG) dragEvent.getGestureSource();
            VA.etape.move((int) dragEvent.getX() - VA.etape.getLargeur()/2,(int) dragEvent.getY() - VA.etape.getHauteur()/2);
            success = true;
            this.monde.notifierObservateur();
        } catch (Exception ex){

        } finally {
            dragEvent.setDropCompleted(success);
            dragEvent.consume();
        }
    }


}
