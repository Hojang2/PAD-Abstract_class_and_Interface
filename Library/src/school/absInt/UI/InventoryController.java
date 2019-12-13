package school.absInt.UI;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import school.absInt.Book;
import school.absInt.Library;
import school.absInt.Template;

import java.io.File;
import java.util.ArrayList;

public class InventoryController {

    private Library lib;

    @FXML
    private Pagination InventoryPagination;

    @FXML
    private TableView<Template> InventoryTable;

    @FXML
    private TableColumn<Template, String> columnName;

    @FXML
    private TableColumn<Template, String> columnAuthor;

    @FXML
    private TableColumn<Template, Integer> columnPages;

    @FXML
    private TableColumn<Template, String> columnISBN;

    @FXML
    private TableColumn<Template, Integer> columnDurability;

    InventoryController(Library LibraryClass){
        this.lib = LibraryClass;

        System.out.println(lib);

        columnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        columnPages.setCellValueFactory(new PropertyValueFactory<>("Pages"));
        columnISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        columnDurability.setCellValueFactory(new PropertyValueFactory<>("Durability"));
/*
        Book b = new Book("Hobit", "J.R.R. Tolkien", 300, "978-80-257-1949-9", 40);

        lib.addPublication(b);

        fillTable(10, 1);

 */
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

    private void fillTable(int itemsOnPage, int page){
        ArrayList<Template> depositeArrayList = lib.getDeposite();

        ArrayList<Template> depositeArrayListEdited = new ArrayList<Template>();

        for(int i = (0+itemsOnPage*(page-1)); i < (itemsOnPage*page); i++){
            if(i<depositeArrayList.size()){
                depositeArrayListEdited.add(depositeArrayList.get(i));
            }else{
                break;
            }
        }

        ObservableList<Template> depositList = FXCollections.observableArrayList(depositeArrayListEdited);
        InventoryTable.setItems(depositList);
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
