package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){

        MondeIG monde = new MondeIG();

        BorderPane root = new BorderPane();

        VueOutils VO = new VueOutils(monde);
        VueMondeIG VM = new VueMondeIG(monde);

        root.setBottom(VO);
        root.setCenter(VM);

        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
