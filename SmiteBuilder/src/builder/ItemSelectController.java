package builder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class ItemSelectController implements Initializable {
    private Main mainClass;
    private GodScreenController godScreen;

    private String damageType = "null";
    private int selectedColumn;
    private Item selectedItem;
    private String tierSelection = "Any";
    private String searchInput = "";

    private ArrayList<Label> hoverLabels = new ArrayList<>(); //contains the labels when hovering an item
    private ArrayList<Item> initialItems = new ArrayList<>(); //contains all items that are first added to the screen
    private ArrayList<Item> tempArray = new ArrayList<>(); //will contain items after filtering
    private String[][] itemTable = new String[9][11]; //columns first, then rows 0,0 is top left. rows increase down. columns increase to the right.

    @FXML ScrollPane itemScroll;
    @FXML GridPane itemGrid;
    @FXML Label noneFound;
    @FXML ImageView itemHover;
    @FXML Label lblItemName;
    @FXML Label lblStat1;
    @FXML Label lblStat2;
    @FXML Label lblStat3;
    @FXML Label lblStat4;
    @FXML Label lblStat5;
    @FXML TextField searchField;
    @FXML ChoiceBox tierFilter;
    @FXML MenuButton statFilter;

    private CheckBox chkPower = new CheckBox("Power");
    private CheckBox chkMana = new CheckBox("Mana");

    public void initialize(URL url, ResourceBundle rb) {
        mainClass = Main.getInstance();
        godScreen = GodScreenController.getInstance();
        damageType = godScreen.getDamageType();
        itemScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        itemScroll.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-background-color:transparent;");
        itemHover.setImage(new Image("itemHover.png"));
        itemHover.setDisable(true);
        itemHover.setOpacity(0);
        itemHover.setFitHeight(120);
        itemHover.setFitWidth(160);
        lblItemName.setOpacity(0);
        lblStat1.setOpacity(0);
        lblStat2.setOpacity(0);
        lblStat3.setOpacity(0);
        lblStat4.setOpacity(0);
        lblStat5.setOpacity(0);
        hoverLabels.add(lblStat1);
        hoverLabels.add(lblStat2);
        hoverLabels.add(lblStat3);
        hoverLabels.add(lblStat4);
        hoverLabels.add(lblStat5);
        selectedColumn = godScreen.getSelectedColumn();
        selectedItem = godScreen.getBuild().get(selectedColumn);
        searchField.textProperty().addListener((observable, oldText, newText)->{
            searchInput = newText;
            searchUpdated();
        });
        tierFilter.setItems(FXCollections.observableArrayList(
                "Any", "Tier 1", "Tier 2", "Tier 3"));
        tierFilter.setValue("Any");
        tierFilter.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                tierSelection = String.valueOf(tierFilter.getItems().get((Integer) number2));
                searchUpdated();
            }
        });
        chkPower.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                searchUpdated();
            }
        });
        CustomMenuItem mPower = new CustomMenuItem(chkPower);
        chkMana.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                searchUpdated();
            }
        });
        CustomMenuItem mMana = new CustomMenuItem(chkMana);
        mPower.setHideOnClick(false);
        mMana.setHideOnClick(false);
        statFilter.getItems().setAll(mPower, mMana);
        initializeItems();
        refreshItems();
    }

    //Adds all items to the temp ArrayList to start
    private void initializeItems(){
        initialItems = (ArrayList<Item>)mainClass.getItemList().clone();
        //Loop filters through damage types
        int count = 0;
        while(count < initialItems.size()){
            if(damageType.equals("M")){
                if(initialItems.get(count).getDamageType().equals("P")){
                    initialItems.remove(count);
                    count--;
                }
            }
            else{
                if(initialItems.get(count).getDamageType().equals("M")){
                    initialItems.remove(count);
                    count--;
                }
            }
            count++;
        }

        //Loop filters through items that are already selected or are not allowed to be built because of other built items
        count = 0;
        while(count < initialItems.size() && initialItems.size() > 0){
            if(godScreen.buildContains(initialItems.get(count).getName())) {
                initialItems.remove(count);
                count--;
            }
            else if(!godScreen.checkBuildable(initialItems.get(count).getName())){
                initialItems.remove(count);
                count--;
            }
            else if((initialItems.get(count).isKatana() && godScreen.getGodClass().equals("Mage")) ||
                    (initialItems.get(count).isKatana() && godScreen.getGodClass().equals("Hunter")) ||
                    (initialItems.get(count).isKatana() && godScreen.getGodClass().equals("Guardian"))){
                initialItems.remove(count);
                count--;
            }
            count++;
        }
        //Checks if boots are built and, if so, removes all other boots from the build
        if(damageType.equals("P") &&
                godScreen.buildContains("Warrior Tabi") ||
                godScreen.buildContains("Ninja Tabi") ||
                godScreen.buildContains("Reinforced Greaves") ||
                godScreen.buildContains("Talaria Boots")){
            count = 0;
            while(count < initialItems.size() && initialItems.size() > 0){
                if(initialItems.get(count).getName().equals("Warrior Tabi") ||
                        initialItems.get(count).getName().equals("Ninja Tabi") ||
                        initialItems.get(count).getName().equals("Reinforced Greaves") ||
                        initialItems.get(count).getName().equals("Talaria Boots") ||
                        initialItems.get(count).getName().equals("Boots") ||
                        initialItems.get(count).getName().equals("Combat Boots")){
                    initialItems.remove(count);
                    count--;
                }
                count++;
            }
        }
        else if(damageType.equals("M") &&
                godScreen.buildContains("Shoes of the Magi") ||
                godScreen.buildContains("Shoes of Focus") ||
                godScreen.buildContains("Reinforced Shoes") ||
                godScreen.buildContains("Traveler's Shoes")){
            count = 0;
            while(count < initialItems.size() && initialItems.size() > 0){
                if(initialItems.get(count).getName().equals("Shoes of the Magi") ||
                        initialItems.get(count).getName().equals("Shoes of Focus") ||
                        initialItems.get(count).getName().equals("Reinforced Shoes") ||
                        initialItems.get(count).getName().equals("Traveler's Shoes") ||
                        initialItems.get(count).getName().equals("Magic Shoes") ||
                        initialItems.get(count).getName().equals("Shoes")){
                    initialItems.remove(count);
                    count--;
                }
                count++;
            }
        }

        //Finally the items are sorted alphabetically
        Collections.sort(initialItems, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                String s1 = i1.getName();
                String s2 = i2.getName();
                return s1.compareToIgnoreCase(s2);
            }
        });
        //Items are copied to tempArray
        tempArray = (ArrayList<Item>)initialItems.clone();
    }

    //Adds all items from the tempArray to the screen
    private void refreshItems() {
        //Clears all grid spaces
        itemGrid.getChildren().clear();

        //makes the notification label for when no gods are found invisible
        noneFound.setOpacity(0);

        //Gets the number of rows required and adds the scroll bar if needed
        double rows = Math.ceil(tempArray.size() / 7.0);

        //Adds/removes scroll bar when necessary
        if (rows > 5) {
            itemScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        } else {
            itemScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        }

        //Reduces the size of the grid so that scrolling is not longer than the list of gods
        double height = (rows * 100) + 8;
        itemGrid.setMaxHeight(height);
        itemGrid.setMinHeight(height);
        itemGrid.setPrefHeight(height);

        //Shows the None Found label and exits the method if no items are on the array
        if(tempArray.size() == 0){
            noneFound.setOpacity(1);
            return;
        }

        int rowCount = 0;
        while (rowCount < rows) {
            //if on the last row, loop through the rest of the temp array.
            if (rowCount + 1 == rows) {
                int count = 0;
                while (count < tempArray.size()) {
                    itemTable[count][rowCount] = tempArray.get(count).getName();
                    count++;
                }
            }
            //if not on the last row, loop through one row then remove it from the temp array.
            else {
                int count = 0;
                while (count < 7) {
                    itemTable[count][rowCount] = tempArray.get(count).getName();
                    count++;
                }
                count = 0;
                while (count < 7) {
                    tempArray.remove(0);
                    count++;
                }
            }
            rowCount++;
        }

        //now loops through the table of image names and adds all images with listeners to the grid pane
        rowCount = 0;
        while (rowCount < rows) {
            boolean toBreak = false;
            int columnCount = 0;
            while (columnCount < 7) {
                if (itemTable[columnCount][rowCount] == null) {
                    toBreak = true;
                    break;
                }
                Label itemName = new Label();
                itemName.setText(itemTable[columnCount][rowCount]);
                itemName.setDisable(true);
                itemName.setOpacity(1);
                itemName.setStyle("-fx-font-size: 11;");
                ImageView hover = new ImageView(new Image("hover.png"));
                hover.setFitWidth(87);
                hover.setFitHeight(87);
                hover.setDisable(true);
                hover.setVisible(false);
                ImageView itemImage = new ImageView(new Image(itemTable[columnCount][rowCount] + ".png"));
                String item = itemTable[columnCount][rowCount];
                GridPane.setHalignment(itemImage, HPos.CENTER);
                GridPane.setValignment(itemImage, VPos.CENTER);
                GridPane.setHalignment(hover, HPos.CENTER);
                GridPane.setValignment(hover, VPos.CENTER);
                GridPane.setHalignment(itemName, HPos.CENTER);
                GridPane.setValignment(itemName, VPos.BOTTOM);
                itemImage.setFitWidth(67);
                itemImage.setFitHeight(67);
                int column = columnCount;
                int row = rowCount;

                itemImage.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        itemSelected(item);
                    }
                });
                itemImage.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        itemImage.setFitWidth(87);
                        itemImage.setFitHeight(87);
                        hover.setVisible(true);
                        itemName.setOpacity(0);
                        if(row == 0){
                            itemHover.setLayoutY(itemScroll.getLayoutY() + (row * 100) + 75);
                        }
                        else{
                            itemHover.setLayoutY(itemScroll.getLayoutY() + (row * 100) - 85);
                        }
                        if(column == 6){
                            itemHover.setLayoutX(column * 100 - 75);
                        }
                        else if(column == 5){
                            itemHover.setLayoutX(column * 100 + 30);
                        }
                        else{
                            itemHover.setLayoutX(column * 100 + 75);
                        }
                        itemHover.setOpacity(1);

                        //This section sets all hover labels to the right text
                        Item itemObj = mainClass.getItem(itemTable[column][row]);
                        ArrayList<String> statsUsed = itemObj.getStatsUsed();
                        int numStats = statsUsed.size();
                        lblItemName.setText(item);
                        int count = 0;
                        while(count < numStats){
                            hoverLabels.get(count).setText(itemObj.getStat(count));
                            count++;
                        }

                        lblItemName.setLayoutX(itemHover.getLayoutX() + 5);
                        lblItemName.setLayoutY(itemHover.getLayoutY() + 5);
                        lblItemName.setOpacity(1);
                        count = 0;
                        while(count < numStats){
                            hoverLabels.get(count).setLayoutX(itemHover.getLayoutX() + 5);
                            hoverLabels.get(count).setLayoutY(itemHover.getLayoutY() + 30 + (count * 20));
                            hoverLabels.get(count).setOpacity(1);
                            count++;
                        }
                    }
                });
                itemImage.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        itemImage.setFitWidth(67);
                        itemImage.setFitHeight(67);
                        hover.setVisible(false);
                        itemName.setOpacity(1);
                        itemHover.setOpacity(0);
                        lblItemName.setOpacity(0);
                        lblStat1.setOpacity(0);
                        lblStat2.setOpacity(0);
                        lblStat3.setOpacity(0);
                        lblStat4.setOpacity(0);
                        lblStat5.setOpacity(0);
                    }
                });
                itemGrid.add(itemImage, columnCount, rowCount);
                itemGrid.add(hover, columnCount, rowCount);
                itemGrid.add(itemName, columnCount, rowCount);
                columnCount++;
            }
            if (toBreak) {
                break;
            }
            rowCount++;
        }
    }

    private void itemSelected(String n){
        godScreen.itemSelected(n);
        Stage stage = (Stage) itemScroll.getScene().getWindow();
        stage.close();
    }

    private void searchUpdated(){
        int columnCount = 0;
        while(columnCount < 9){
            int rowCount = 0;
            while(rowCount < 11){
                itemTable[columnCount][rowCount] = null;
                rowCount++;
            }
            columnCount++;
        }

        tempArray = (ArrayList<Item>)initialItems.clone();

        //Removes items that do not contain the characters in the search box
        String search = searchField.getText().toLowerCase();
        int count = 0;
        while(count < tempArray.size()){
            if(!tempArray.get(count).getName().toLowerCase().contains(search)){
                tempArray.remove(count);
                count--;
            }
            count++;
        }

        //Removes items that do not match the tier selection
        if(!tierSelection.equals("Any")) {
            int tier;
            if(tierSelection.equals("Tier 1")){
                tier =1;
            }
            else if(tierSelection.equals("Tier 2")){
                tier = 2;
            }
            else{
                tier = 3;
            }
            count = 0;
            while (count < tempArray.size()) {
                if(tempArray.get(count).getTier() != tier){
                    tempArray.remove(count);
                    count--;
                }
                count++;
            }
        }

        //Removes items that do not match the stat selections
        if(chkPower.isSelected()){
            count = 0;
            while(count < tempArray.size()){
                boolean power = false;
                if(tempArray.get(count).getStatsUsed().contains("physicalPower") ||
                        tempArray.get(count).getStatsUsed().contains("magicalPower")){
                    power = true;
                }
                if(!power){
                    tempArray.remove(count);
                    count--;
                }
                count++;
            }
        }
        if(chkMana.isSelected()){
            count = 0;
            while(count < tempArray.size()){
                if(!tempArray.get(count).getStatsUsed().contains("mana")){
                    tempArray.remove(count);
                    count--;
                }
                count++;
            }
        }
        refreshItems();
    }
}
