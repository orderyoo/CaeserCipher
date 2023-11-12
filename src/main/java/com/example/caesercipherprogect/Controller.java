package com.example.caesercipherprogect;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ParametersForCommander parameters = new ParametersForCommander();
    AlphabetGenerator alphabetGenerator = new AlphabetGenerator();
    Stage stage = new Stage();
    @FXML
    private TextArea textFieldInput;
    @FXML
    private ChoiceBox<String> languageChoiceBox;
    @FXML
    private ChoiceBox<Integer> movChoiceBox;
    @FXML
    private Button encoderButton;
    @FXML
    private Button decoderButton;
    public void actionTextField(KeyEvent event){
        String s = textFieldInput.getText();
        parameters.setText(s);
    }
    public void selectLanguage(ActionEvent event){
        String language = languageChoiceBox.getValue();
        parameters.setLanguage(language);
        movChoiceBox.getItems().clear();
        List<Integer> listInt = new ArrayList<Integer>(){{
            if(parameters.getLanguage().equals("Русский")){
                int a = 1;
                for(int i = 0; i < alphabetGenerator.lowercaseAlphabetRu.size(); i++){
                    add(a);
                    a++;
                }
            } else if (parameters.getLanguage().equals("Английский")){
                int a = 1;
                for(int i = 0; i <  alphabetGenerator.lowercaseAlphabetEn.size(); i++){
                    add(a);
                    a++;
                }
            }
        }};
        movChoiceBox.getItems().addAll(listInt);
    }
    @FXML
    public void selectMov(ActionEvent event){
        parameters.setMov(movChoiceBox.getValue());
    }
    public void actionEncoderButton(ActionEvent event){
        String s = CaesarCipher.commander(parameters.getText(), parameters.getLanguage(), parameters.getMov(), true, alphabetGenerator);
        TextArea textArea = new TextArea(s);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(textArea);
        Scene scene = new Scene(hBox, 512, 256);
        stage.setScene(scene);
        stage.show();
    }
    public void actionDecoderButton(ActionEvent event){
        String s = CaesarCipher.commander(parameters.getText(), parameters.getLanguage(), parameters.getMov(), false, alphabetGenerator);
        TextArea textArea = new TextArea(s);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(textArea);
        Scene scene = new Scene(hBox, 512, 256);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        languageChoiceBox.getItems().addAll(FXCollections.observableArrayList("Русский", "Английский"));
        languageChoiceBox.setOnAction(this::selectLanguage);
        movChoiceBox.setOnAction(this::selectMov);
        encoderButton.setOnAction(this::actionEncoderButton);
        decoderButton.setOnAction(this::actionDecoderButton);
    }
}