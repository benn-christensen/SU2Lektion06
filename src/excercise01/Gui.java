package excercise01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gui extends Application {
    private String[] name;
    private String[] house;
    private String[] images;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        initContent(gridPane);
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initContent(GridPane gridPane) {
        loadData();
        ListView<String> listView = new ListView<>();
        listView.getItems().setAll(name);
        listView.setOnMouseClicked(event -> {
            GridPane gridPane1 = new GridPane();
            gridPane1.add(new ImageView(new Image(images[listView.getSelectionModel().getSelectedIndex()])), 0, 0);
            Scene scene = new Scene(gridPane1);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        });
        ToggleGroup toggleGroup = new ToggleGroup();
        gridPane.add(listView, 0, 0);
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        Arrays.stream(house).distinct().forEach(houseName -> {
            RadioButton radioButton = new RadioButton(houseName);
            radioButton.setUserData(houseName);
            hBox.getChildren().add(radioButton);
            toggleGroup.getToggles().add(radioButton);
        });
        RadioButton radioButton = new RadioButton("All");
        radioButton.setUserData("All");
        hBox.getChildren().add(radioButton);
        toggleGroup.getToggles().add(radioButton);
        toggleGroup.selectedToggleProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.getUserData().equals("All")) {
                        listView.getItems().setAll(name);
                    } else {
                        List<String> names = new ArrayList<>();
                        for (int index = 0; index < house.length; index++) {
                            if (house[index].equals(newValue.getUserData())) {
                                names.add(name[index]);
                            }
                        }
                        listView.getItems().setAll(names);
                    }
                });
        gridPane.add(hBox, 0, 1);
    }

    private void loadData() {
        name = new String[]{"Harry Potter", "Hermione Granger", "Ron Weasley", "Draco Malfoy", "Luna Lovegood"};
        house = new String[]{"Gryffindor", "Gryffindor", "Gryffindor", "Slytherin", "Ravenclaw"};
        images = new String[]{"https://ik.imagekit.io/hpapi/harry.jpg", "https://ik.imagekit.io/hpapi/hermione.jpeg", "https://ik.imagekit.io/hpapi/ron.jpg", "https://ik.imagekit.io/hpapi/draco.jpg", "https://ik.imagekit.io/hpapi/luna.jpg"};
    }
}
