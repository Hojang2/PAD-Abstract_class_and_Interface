package school.absInt.UI;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import school.absInt.Library;

import java.io.File;

public class MainMenuController extends Application {
    @FXML
    private Button buttonNewLib;

    @FXML
    private Button buttonLoadLib;

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

    @FXML
    private void newLibButton(ActionEvent event) throws Exception{
        Parent newSceneFXML = FXMLLoader.load(getClass().getResource("NewLib.fxml"));
        Scene newScene = new Scene(newSceneFXML);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void loadLibButton(ActionEvent event) throws Exception{
        DirectoryChooser dirChooserLoad = new DirectoryChooser();

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if(selectedDirectory == null){
            System.out.println("You haven't selected any dir.");
        }else{
            String path = selectedDirectory.getAbsolutePath();
            System.out.println(path);
            Library lib = new Library(selectedDirectory.getName());

            lib.deserialization(path);

            Parent newSceneFXML = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
            Scene newScene = new Scene(newSceneFXML);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(newScene);
            window.show();
        }
/*


 */
    }


    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
