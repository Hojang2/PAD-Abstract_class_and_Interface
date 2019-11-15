package school.absInt.UI;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainMenu extends Application {
    private Button newLib;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Knihovna");
        stage.setScene(scene);
        stage.show();

    }
    /*
    public void newLibButtonAction(ActionEvent event) throws IOException {
        Parent newSceneFXML = FXMLLoader.load(getClass().getResource("NewLib.fxml"));
        Scene newScene = new Scene(newSceneFXML);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

     */
    /*
    public void loadLibButtonAction(ActionEvent event){
        Parent newSceneFXML = FXMLLoader(getClass().getResource("Core.fxml"));
        Scene newScene = new Scene(newSceneFXML);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }
     */
}
