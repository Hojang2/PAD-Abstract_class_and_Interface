package school.absInt.UI;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import school.absInt.Library;
import school.absInt.Template;

import java.io.File;

public class InventoryController {

    private Library lib;

    @FXML
    private Pagination InventoryPagination;

    @FXML
    private TableView<Template> InventoryTable;

    @FXML
    private TableColumn columnName;

    @FXML
    private TableColumn columnAuthor;

    @FXML
    private TableColumn columnPages;

    @FXML
    private TableColumn columnISBN;

    @FXML
    private TableColumn columnDurability;

    InventoryController(Library LibraryClass){
        this.lib = LibraryClass;

        System.out.println(lib);


    }

    @FXML
    private void saveLib(ActionEvent event) throws Exception{
        DirectoryChooser dirChooserSave = new DirectoryChooser();

        File selectedDirectory = dirChooserSave.showDialog(null);

        if(selectedDirectory == null){
            System.out.println("You haven't selected any dir.");
        }else{
            String path = selectedDirectory.getAbsolutePath();
            System.out.println(path);

            //lib.serialization(path);
        }
    }

    private void fillTable(){

    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
