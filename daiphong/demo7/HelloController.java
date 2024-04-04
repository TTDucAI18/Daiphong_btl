package org.example.demo7;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kotlin.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    private TextField textField;
    @FXML
    private ListView<String> listView;
    @FXML
    private ListView textArea;
    @FXML
    private Button sayWelcome;
    @FXML
    private Button button;
    private HashMap<String, Pair> words = new HashMap<>();
    private Stack<String> st = new Stack<>();
    String currentWord;
    private String typedWord;
    @FXML
    public void onOpenClick(){
        sayWelcome.setText("WELCOME TO THE ENGLISH VIETNAMESE DICTIONARY");
        try {
            // Đường dẫn tới file HTML của bạn
            String filePath = "C:\\Users\\antoan\\Downloads\\Javacode\\oop\\E_V.txt";

            // Đọc file HTML
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            // Tách các từ điển từ nội dung HTML
            Pattern pattern = Pattern.compile("<html><i>(.*?)</i><br/><ul><li><b><i>(.*?)</i></b><ul><li><font color='#cc0000'><b>(.*?)</b></font>");
            Matcher matcher = pattern.matcher(content.toString());

            // Duyệt qua các kết quả và in ra màn hình
            while (matcher.find()) {
                String pronoun = "";
                String word = matcher.group(1);
                if (word.contains("/")) {
                    pronoun = word.substring(word.indexOf('/'));
                    char c = word.charAt(0);
                    word = word.substring(word.indexOf(c), word.indexOf('/')).trim();
                }
                String meaning = matcher.group(3);
                Pair pair = new Pair(pronoun, meaning);
                words.put(word, pair);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onClick(){
        typedWord = textField.getText();
        typedWord = typedWord.toLowerCase();
        listView.getItems().clear();
        for (String key : words.keySet()) {
            if (key.startsWith(typedWord)) {
                listView.getItems().addFirst(key);
            }
        }
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textField.setText(newValue); // Thiết lập văn bản trong TextField thành từ được chọn
            }
        });
    }
    @FXML
    public void OnSearchClick(){
        typedWord = textField.getText();
        typedWord = typedWord.toLowerCase();
        if (typedWord.isEmpty()){
            textArea.getItems().add("ENSURE TO TYPE OR CHOOSE A WORD FIRST. PLEASE TRY AGAIN");
        } else if (words.containsKey(typedWord)){
            textArea.getItems().add("  -  " + typedWord + " " + words.get(typedWord).getFirst());
            textArea.getItems().add("        " + words.get(typedWord).getSecond());
            if (!st.contains(typedWord)) {
                st.add(typedWord);
            }
        } else {
            textArea.getItems().add("SORRY :( "+"\n"+"WE DO NOT FIND OUT THE WORD YOU WANT TO LOOK FOR :("+"\n"
            +"PLEASE CHECK THE SPELLING. IF IT IS FALSE, PLEASE TRY AGAIN."+"\n"+"OTHERWISE WE SUGGEST THE ADDING WORD METHOD");
        }
    }
    @FXML
    public void onDeleteClick(){
        textField.clear();
        listView.getItems().clear();
        textArea.getItems().clear();
        for (String x : st) {
            listView.getItems().addFirst(x);
        }
    }

}