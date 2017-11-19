package gui.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderProgress extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();
        root.setPrefSize(300, 100);

        Slider slider = new Slider();
        GridPane.setColumnSpan(slider, 2);
        slider.setMax(2);
        slider.setMin(-2);

        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator();

        progressBar.progressProperty().bind(slider.valueProperty());
        progressIndicator.progressProperty().bind(slider.valueProperty());

        root.addRow(0, slider);
        root.addRow(1, progressBar, progressIndicator);

        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel: Slider und Progress");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
