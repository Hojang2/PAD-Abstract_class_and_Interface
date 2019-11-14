package school.absInt;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {
    private Library lib;
    private Button newLib;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UI/Main.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Knihovna");
        stage.setScene(scene);
        stage.show();

    }

    public void changeScene(String sceneName) throws IOException {
        Parent newSceneFXML = FXMLLoader.load(getClass().getResource(sceneName));
        Scene newScene = new Scene(newSceneFXML);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }
}
