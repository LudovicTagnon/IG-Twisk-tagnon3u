package twisk.Exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class TwiskException extends Exception{
    public TwiskException(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        PauseTransition pause = new PauseTransition(Duration.seconds(4));
        alert.setTitle("Attention");
        alert.setHeaderText("Erreur");
        alert.setContentText(message);
        pause.setOnFinished(actionEvent -> alert.close());
        alert.show();
        pause.play();
    }
}
