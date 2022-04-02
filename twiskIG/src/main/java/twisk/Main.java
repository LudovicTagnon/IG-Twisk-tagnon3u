package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){

        MondeIG monde = new MondeIG();

        BorderPane root = new BorderPane();

        VueOutils VO = new VueOutils(monde);
        VueMondeIG VM = new VueMondeIG(monde);
        VueMenu Vmenu = new VueMenu(monde);

        root.setBottom(VO);
        root.setCenter(VM);
        root.setRight(Vmenu);


        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
