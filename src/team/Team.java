package team;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Team extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //instantiate the Dashboard class to show it
        Dashboard app =  new Dashboard();
        primaryStage.setScene(app.dashboard());
        primaryStage.setTitle("Team UI");
        primaryStage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
