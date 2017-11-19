package gui.controls;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderSlider extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();

        Slider sliderLeft = new Slider();
        Slider sliderMiddle = new Slider();
        Slider sliderRight = new Slider();
        Slider sliderTotal = new Slider();

        root.addRow(0, sliderLeft, sliderMiddle, sliderRight);
        root.addRow(1, sliderTotal);
        GridPane.setColumnSpan(sliderTotal, 3);
        root.setPadding(new Insets(10));

        sliderTotal.valueProperty().bind(Bindings.multiply(100, Bindings.divide(sliderLeft.valueProperty().add(sliderMiddle.valueProperty()).add(sliderRight.valueProperty()), sliderLeft.getMax() + sliderMiddle.getMax() + sliderRight.getMax())));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel: Addition von Slidern");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
