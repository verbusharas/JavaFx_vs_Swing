package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    private static TextField tfVardas;
    private static Text txtUzrasas;
    private static final String YELLOW_STYLE = "-fx-background-color: #eeff00";
    private static final String GREY_STYLE = "-fx-background-color: #888888";
    private static final java.awt.Color GREY_COLOR = new Color(136,136,136);
    private static final java.awt.Color YELLOW_COLOR = new Color(238,255,0);

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Layouts
        VBox vMaketas = new VBox();
        vMaketas.setPadding(new Insets(100,100,100,100));
        vMaketas.setSpacing(20);
        vMaketas.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        Pane bottomPane = new Pane();
        Pane topPane = new Pane();
        Pane leftPane = new Pane();
        Pane rightPane = new Pane();
        Pane centerPane = new Pane();

        // Initialization of elements
        tfVardas = new TextField();
        Button btMygtukas = new Button("spausti".toUpperCase());
        txtUzrasas = new Text();

        // Setting the element properties
        btMygtukas.setOnAction(e -> buttonPressed());
        tfVardas.setPromptText("Tavo vardas");
        bottomPane.setStyle(YELLOW_STYLE);
        bottomPane.setMinHeight(10);
        topPane.setStyle(YELLOW_STYLE);
        topPane.setMinHeight(10);
        leftPane.setStyle(YELLOW_STYLE);
        leftPane.setMinWidth(10);
        rightPane.setStyle(YELLOW_STYLE);
        rightPane.setMinWidth(10);
        centerPane.setStyle(GREY_STYLE);
        centerPane.setMinSize(590,590);

        borderPane.setBottom(bottomPane);
        borderPane.setTop(topPane);
        borderPane.setLeft(leftPane);
        borderPane.setRight(rightPane);
        borderPane.setCenter(centerPane);

        // Filling the layouts
        vMaketas.getChildren().addAll(tfVardas, btMygtukas, txtUzrasas);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JAVA_FX vs Swing");
        Scene manoScena = new Scene(borderPane);
        primaryStage.setScene(manoScena);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void buttonPressed() {
        String ivestasTekstas = tfVardas.getText().equals("") ? "Niekas neįvesta" : tfVardas.getText();
        System.out.println(ivestasTekstas);
        txtUzrasas.setText(ivestasTekstas);
    }

    public static void main(String[] args) {
        launch(args);

        JFrame frame = new JFrame("SWING vs JavaFx");

        JButton btGenericButton = new JButton("spausti".toUpperCase());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);

        JPanel bottomPane = new JPanel();
        bottomPane.setBackground(YELLOW_COLOR);
        frame.getContentPane().add(BorderLayout.SOUTH,bottomPane);

        JPanel topPane = new JPanel();
        topPane.setBackground(YELLOW_COLOR);
        frame.getContentPane().add(BorderLayout.NORTH,topPane);

        JPanel leftPane = new JPanel();
        leftPane.setBackground(YELLOW_COLOR);
        frame.getContentPane().add(BorderLayout.WEST,leftPane);

        JPanel rightPane = new JPanel();
        rightPane.setBackground(YELLOW_COLOR);
        frame.getContentPane().add(BorderLayout.EAST,rightPane);

        JPanel centerPane = new JPanel();
        centerPane.setBackground(GREY_COLOR);
        frame.getContentPane().add(BorderLayout.CENTER,centerPane);
    }
}

