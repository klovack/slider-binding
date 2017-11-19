package gui.controls;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderListener extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox root = new VBox(2);

        Slider slider = new Slider();
        Label sliderInfo = new Label("Slider wurde noch nicht bewegt");
        slider.setValue(slider.getMax() / 2);

        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.valueProperty().addListener((obs, oldVal, newVal) -> updateText(oldVal, newVal, sliderInfo, slider));

        root.getChildren().addAll(slider, sliderInfo);
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider Mit Listener");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private void updateText(Number oldVal, Number newVal, Label text, Slider slider)
    {
        int intOldVal = oldVal.intValue();
        int intNewVal = newVal.intValue();

        slider.setValue(intNewVal);
        text.textProperty().bind(new SimpleStringProperty("Änderung des Sliders um " + (intNewVal - intOldVal)));
    }
}
