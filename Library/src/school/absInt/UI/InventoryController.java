package school.absInt.UI;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import school.absInt.Book;
import school.absInt.Library;
import school.absInt.Template;

import javax.imageio.IIOException;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InventoryController{

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



    }


    public void init() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        columnPages.setCellValueFactory(new PropertyValueFactory<>("Pages"));
        columnISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        columnDurability.setCellValueFactory(new PropertyValueFactory<>("Durability"));

        InventoryPagination.setPageCount(lib.getDeposite().size()/10);

        fillTable(10, 1);
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
    private Stage addItem(ActionEvent event) throws IIOException {
        ItemController itemController = new ItemController();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "Inventory.fxml"
                )
        );

        loader.setController(itemController);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        stage.show();

        return stage;
    }


    @FXML
    private Stage showReaders(ActionEvent event) throws IIOException{
        ReadersController readController = new ReadersController();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "Inventory.fxml"
                )
        );

        loader.setController(readController);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        stage.show();

        return stage;
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
