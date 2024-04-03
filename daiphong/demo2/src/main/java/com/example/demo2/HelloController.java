package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;
import java.util.List;

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
    private Stack<String> stk = new Stack<>();
    HashMap<String, String> words = new HashMap<>();

    @FXML
    public void onOpenClick() {
        sayWelcome.setText("WELCOME TO THE DICTIONARY");
        try {
            String filePath = "D:\\code\\oop\\demo2\\src\\main\\java\\com\\example\\demo2\\E_V.txt";

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

            String[] parts = matcher.pattern().split("<html>");
            // Duyệt qua các kết quả và in ra màn hình
            while (matcher.find()) {
                String word = matcher.group(1);
                String meaning = matcher.group(3);
                words.put(word, meaning);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClick() {
        String typedWord = textField.getText();

        listView.getItems().clear();

        for (String key : words.keySet()) {
            if (key.startsWith(typedWord)) {
                listView.getItems().add(0, key);
            }
        }
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textField.setText(newValue); // Thiết lập văn bản trong TextField thành từ được chọn
            }
        });
    }


    @FXML
    public void OnSearchClick() {
        String typedWord = textField.getText();
        ObservableList<String> items = listView.getItems();
        for (String item:items){
            if (items.contains(typedWord)){
                textArea.getItems().add("  -  " + item);
                textArea.getItems().add("        " + words.get(item));
            }
        }
        if (!stk.contains(typedWord)) {
            stk.push(typedWord);
        }
    }

    @FXML
    public void OnDeleteClick() {
        Button bt = new Button();
        textField.clear(); // Xóa nội dung của TextField
        listView.getItems().clear(); // Xóa tất cả các mục trong ListView
        if (!stk.empty())
            for (String str : stk) {
                listView.getItems().add(0,str);
            }
        textArea.getItems().clear();
        StackPane root = new StackPane();
        root.getChildren().add(bt);
    }
}