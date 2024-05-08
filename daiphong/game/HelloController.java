package org.example.demo9;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController extends interfaceGame{
    Time time = new Time("00:00:00");
    private int currentPoint = 0;
//    private Background defaultBackground;
//    private int currentNum;
    private int numQues;
    private Map<Integer,String> map = new HashMap<>();
    private Map<Integer, String> map1 = new HashMap<>();
    private Map<Integer, String> map2 = new HashMap<>();
    private Map<Integer, String> map3 = new HashMap<>();
    private Map<Integer, String> map4 = new HashMap<>();
    private Map<Integer, String> map5 = new HashMap<>();
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                        if(time.getCurrentTime().equals(alarmTime.getText())){
                            //System.out.println("ALARM!");
                            alarmTime.setText("Time's up");
                            // Tạo một đối tượng Media từ tập tin nhạc
                            Media media = new Media(new File("C:\\Users\\antoan\\Downloads\\435577__dangale__phone-ringing-5-times-then-picked-up-uk-gpo-746.wav").toURI().toString());

                            // Tạo một đối tượng MediaPlayer từ đối tượng Media
                            MediaPlayer mediaPlayer = new MediaPlayer(media);

                            // Phát nhạc
                            mediaPlayer.play();

                        }
                        time.oneSecondPassed();
                        timer.setText(time.getCurrentTime());
                    }));
    @FXML
    public void onNextClick(){
        button1.setBackground(Background.fill(Color.LIGHTGRAY));
        button2.setBackground(Background.fill(Color.LIGHTGRAY));
        button3.setBackground(Background.fill(Color.LIGHTGRAY));
        button4.setBackground(Background.fill(Color.LIGHTGRAY));
        Random rand2 = new Random();
        int nums = map.size();
        numQues = rand2.nextInt(nums) + 1;
        textField.setText(map.get(numQues));

        Random rand = new Random();
        int num = rand.nextInt(4) + 1;
        if (num == 1){
            button1.setText(map1.get(numQues));
            button2.setText(map2.get(numQues));
            button3.setText(map3.get(numQues));
            button4.setText(map4.get(numQues));
        }
        if (num == 2){
            button1.setText(map2.get(numQues));
            button2.setText(map1.get(numQues));
            button3.setText(map3.get(numQues));
            button4.setText(map4.get(numQues));
        }
        if (num == 3){
            button1.setText(map3.get(numQues));
            button2.setText(map2.get(numQues));
            button3.setText(map1.get(numQues));
            button4.setText(map4.get(numQues));
        }
        if (num == 4){
            button1.setText(map4.get(numQues));
            button2.setText(map2.get(numQues));
            button3.setText(map3.get(numQues));
            button4.setText(map1.get(numQues));
        }

    }
    @FXML
    public void onChooseClick(){
        // Xử lý sự kiện khi một button được nhấn
        EventHandler<ActionEvent> buttonHandler = event -> {
            Button clickedButton = (Button) event.getSource();
            //System.out.println("Button clicked: " + clickedButton.getText());
            if (clickedButton.getText().equals(map5.get(numQues))){
                clickedButton.setBackground(Background.fill(Color.LIGHTBLUE));
                // Tạo một đối tượng Media từ tập tin nhạc
                Media media = new Media(new File("C:\\Users\\antoan\\Downloads\\456162__bwg2020__correct-2.wav").toURI().toString());

                // Tạo một đối tượng MediaPlayer từ đối tượng Media
                MediaPlayer mediaPlayer = new MediaPlayer(media);

                // Phát nhạc
                mediaPlayer.play();
                currentPoint = currentPoint + 10;
                points.setText(String.valueOf(currentPoint));
            } else{
                clickedButton.setBackground(Background.fill(Color.RED));
                // Tạo một đối tượng Media từ tập tin nhạc
                Media media = new Media(new File("C:\\Users\\antoan\\Downloads\\161694__zaxtor99__error.wav").toURI().toString());

                // Tạo một đối tượng MediaPlayer từ đối tượng Media
                MediaPlayer mediaPlayer = new MediaPlayer(media);

                // Phát nhạc
                mediaPlayer.play();
            }
            // Thực hiện xử lý tương ứng với button được nhấn
        };
        // Gán cùng một xử lý sự kiện cho tất cả các button
        button1.setOnAction(buttonHandler);
        button2.setOnAction(buttonHandler);
        button3.setOnAction(buttonHandler);
        button4.setOnAction(buttonHandler);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alarmTime.setText("0:1:0");
        timer.setText(time.getCurrentTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        BufferedReader reader = null;
        try {
            String filePath = "cauhoi.txt";
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder ques = new StringBuilder();
            int index = 1;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
//                map.put(index,line);
//                index ++;
                if (count == 0) ques.append(line);
                //System.out.println(line);
                if (count == 0 && ques.charAt(ques.length()-1) == '.') {
                    map.put(index, ques.toString());
                }
                if (ques.charAt(ques.length()-1) != '.') ques.append("\n");
                if (count > 0 && count <= 5){
                    if (count == 1) map1.put(index,line);
                    else if (count == 2) map2.put(index,line);
                    else if (count == 3) map3.put(index,line);
                    else if (count == 4) map4.put(index,line);
                    else map5.put(index,line);
                }
                if (ques.charAt(ques.length()-1) == '.'){
                    if (count <= 4){
                        count ++;
                    } else {
                        index++;
                        count = 0;
                        ques.setLength(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}