package builder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable{
    private ArrayList<God> tempArray = new ArrayList<>(); //will contain gods after filtering
    private God[][] godTable = new God[9][11]; //columns first, then rows 0,0 is top left. rows increase down. columns increase to the right.

    private Main mainClass;

    String searchInput = "";
    String pantheonSelection = "Any";
    String typeSelection = "Any";

    @FXML AnchorPane screenPane;
    @FXML GridPane godGrid;
    @FXML ScrollPane godScroll;
    @FXML TextField searchField;
    @FXML Label noneFound;
    @FXML ChoiceBox pantheonFilter;
    @FXML ChoiceBox typeFilter;

    public void initialize(URL url, ResourceBundle rb) {
        mainClass = Main.getInstance();
        initializeGods();
        initializeOther();
        refreshGods();
    }

    private void initializeGods(){
        //Adds all gods to the temp array to start
        int count = 0;
        while(count < mainClass.getGodList().size()){
            String name = mainClass.getGodList().get(count).getName();
            String type = mainClass.getGodList().get(count).getType();
            String pantheon = mainClass.getGodList().get(count).getPantheon();
            String url = mainClass.getGodList().get(count).getURL();
            tempArray.add(new God(name, type, pantheon, url));
            count++;
        }

        Collections.sort(tempArray, new Comparator<God>() {
            @Override
            public int compare(God god, God g1) {
                String s1 = god.getName();
                String s2 = g1.getName();
                return s1.compareToIgnoreCase(s2);
            }
        });
    }

    private void initializeOther(){
        godScroll.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-background-color:transparent;");
        godScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        searchField.textProperty().addListener((observable, oldText, newText)->{
            searchInput = newText;
            searchUpdated();
        });
        pantheonFilter.setItems(FXCollections.observableArrayList(
                "Any", "Celtic", "Chinese", "Egyptian", "Greek", "Hindu", "Mayan", "Norse", "Roman", "Slavic"));
        pantheonFilter.setValue("Any");
        pantheonFilter.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                pantheonSelection = String.valueOf(pantheonFilter.getItems().get((Integer) number2));
                searchUpdated();
            }
        });

        typeFilter.setItems(FXCollections.observableArrayList(
                "Any", "Assassin", "Guardian", "Hunter", "Mage", "Warrior"));
        typeFilter.setValue("Any");
        typeFilter.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                typeSelection = String.valueOf(typeFilter.getItems().get((Integer) number2));
                searchUpdated();
            }
        });
    }

    //This method is to be run once tempArray is sorted with all the gods to be displayed in order.
    //It takes care of drawing the images and adding any events associated with them
    private void refreshGods(){
        //Clears all grid spaces
        godGrid.getChildren().clear();

        //makes the notification label for when no gods are found invisible
        noneFound.setOpacity(0);

        //Gets the number of rows required and adds the scroll bar if needed
        double rows = Math.ceil(tempArray.size()/9.0);

        //Adds/removes scroll bar when necessary
        if(rows > 5){
            godScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        }
        else{
            godScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        }

        //Reduces the size of the grid so that scrolling is not longer than the list of gods
        double height = (rows * 100) + 8;
        godGrid.setMaxHeight(height);
        godGrid.setMinHeight(height);
        godGrid.setPrefHeight(height);

        int rowCount = 0;
        while(rowCount < rows){
            //if on the last row, loop through the rest of the temp array.
            if(rowCount + 1 == rows){
                int count = 0;
                while(count < tempArray.size()){
                    String name = tempArray.get(count).getName();
                    String type = tempArray.get(count).getType();
                    String pantheon = tempArray.get(count).getPantheon();
                    String url = tempArray.get(count).getURL();
                    godTable[count][rowCount] = new God(name, type, pantheon, url);
                    count++;
                }
            }
            //if not on the last row, loop through one row then remove it from the temp array.
            else{
                int count = 0;
                while(count < 9){
                    String name = tempArray.get(count).getName();
                    String type = tempArray.get(count).getType();
                    String pantheon = tempArray.get(count).getPantheon();
                    String url = tempArray.get(count).getURL();
                    godTable[count][rowCount] = new God(name, type, pantheon, url);
                    count++;
                }
                count = 0;
                while(count < 9){
                    tempArray.remove(0);
                    count++;
                }
            }
            rowCount++;
        }

        //now loops through the table of image names and adds all images with listeners to the grid pane
        rowCount = 0;
        while(rowCount < rows){
            boolean toBreak = false;
            int columnCount = 0;
            while(columnCount < 9){
                if(godTable[columnCount][rowCount] == null){
                    toBreak = true;
                    break;
                }
                Label godName = new Label();
                godName.setText(godTable[columnCount][rowCount].getName());
                godName.setDisable(true);
                godName.setOpacity(1);
                ImageView hover = new ImageView(new Image("hover.png"));
                hover.setFitWidth(87);
                hover.setFitHeight(87);
                hover.setDisable(true);
                hover.setVisible(false);
                ImageView godImage = new ImageView(new Image(godTable[columnCount][rowCount].getURL()));
                God god = godTable[columnCount][rowCount];
                GridPane.setHalignment(godImage, HPos.CENTER);
                GridPane.setValignment(godImage, VPos.CENTER);
                GridPane.setHalignment(hover, HPos.CENTER);
                GridPane.setValignment(hover, VPos.CENTER);
                GridPane.setHalignment(godName, HPos.CENTER);
                GridPane.setValignment(godName, VPos.BOTTOM);
                godImage.setFitWidth(67);
                godImage.setFitHeight(67);
                int column = columnCount;
                godImage.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        godSelected(god);
                    }
                });
                godImage.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        godImage.setFitWidth(87);
                        godImage.setFitHeight(87);
                        hover.setVisible(true);
                        godName.setOpacity(0);
                    }
                });
                godImage.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        godImage.setFitWidth(67);
                        godImage.setFitHeight(67);
                        hover.setVisible(false);
                        godName.setOpacity(1);
                    }
                });
                godGrid.add(godImage, columnCount, rowCount);
                godGrid.add(hover, columnCount, rowCount);
                godGrid.add(godName, columnCount, rowCount);
                columnCount++;
            }
            if(toBreak){
                break;
            }
            rowCount++;
        }
    }

    private void godSelected(God g){
        mainClass.setGod(g.getName());
        try{
            setGodScreen();
        }
        catch(IOException e){
            System.out.println("Failed to load god screen");
        }
    }

    private void setGodScreen() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("GodScreen.fxml"));
        screenPane.getChildren().setAll(pane);
    }

    private void searchUpdated(){
        tempArray.clear();
        int columnCount = 0;
        while(columnCount < 9){
            int rowCount = 0;
            while(rowCount < 11){
                godTable[columnCount][rowCount] = null;
                rowCount++;
            }
            columnCount++;
        }
        String search = searchInput.toLowerCase();
        int count = 0;
        while(count < mainClass.getGodList().size()){
            if(mainClass.getGodList().get(count).getName().toLowerCase().contains(search)){
                tempArray.add(mainClass.getGodList().get(count));
            }
            count++;
        }

        //Remove elements that do not fit pantheon filter
        if(!(pantheonSelection.equals("Any"))){
            count = 0;
            while(count < tempArray.size()){
                if(!(tempArray.get(count).getPantheon().equals(pantheonSelection))){
                    tempArray.remove(count);
                    count--;
                }
                count++;
            }
        }

        //Remove elements that do not fit class filter
        if(!(typeSelection.equals("Any"))){
            count = 0;
            while(count < tempArray.size()){
                if(!(tempArray.get(count).getType().equals(typeSelection))){
                    tempArray.remove(count);
                    count--;
                }
                count++;
            }
        }

        Collections.sort(tempArray, new Comparator<God>() {
            @Override
            public int compare(God god, God g1) {
                String s1 = god.getName();
                String s2 = g1.getName();
                return s1.compareToIgnoreCase(s2);
            }
        });
        refreshGods();
        if(tempArray.size() == 0){
            noneFound.setOpacity(1);
        }
    }
}
