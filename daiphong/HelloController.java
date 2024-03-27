package org.example.demo7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    private TextField textField;
    @FXML
    private ListView listView;
    @FXML
    private ListView textArea;
    HashMap<String,String> words = new HashMap<>();
    @FXML
    public void onOpenClick(){
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
                String word = matcher.group(1);
                String meaning = matcher.group(3);
                words.put(word,meaning);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onClick(){
        String typedWord = textField.getText();
        for (String key:words.keySet()){
            if (key.charAt(0) == typedWord.charAt(0)){
                listView.getItems().add(key);
            }
        }
    }
    @FXML
    public void OnSearchClick(){
        String typedWord = textField.getText();
        for (String key:words.keySet()){
            if (key.contains(typedWord)){
                textArea.getItems().add("  -  "+key);
                textArea.getItems().add("        "+words.get(key));
               // listView.getItems().add(key); can phai them vao dau
            }
        }
    }
}