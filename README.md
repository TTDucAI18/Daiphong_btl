# Application to support learning English using Java

## Author
Group Đại Phong (Lọ tương)
1. Trương Trọng Đức - 23020360
2. Nguyễn Văn Duy - 23020348
3. Nguyễn Đăng Dương - 23020350

## Description
The application is designed to support learning English. The application is written in Java and uses the JavaFX library. 
1. The application is designed to support learning English.
2. The application is written in Java and uses the JavaFX library.
3. The application has two types of dictionaries: English-Vietnamese and Vietnamese-English.
4. The application use E_V.txt files to store data.

## UML diagram
![UML diagram](

## Installation
1. Clone the project from the repository.
2. Open the project in the Intellij IDE.
3. Run the project.
4. If you want to change the data, you can change the E_V.txt files.

## Usage
1. the default mode: English - Vietnamese dictionary. If you want to translate Vietnamese to English, click the Translate button.
2. Search for a word in the dictionary and click the Search button, there will be hints right under the word, and the pronunciation and the meaning will be shown.
3. To add a new word, click the Add button (Plus icon), then the scene will be switched to a new scene where you can add a word, its pronunciation and its meaning.
4. To delete a word, click the Delete button (Minus icon), then the text area under will shown "delete successfully" if the word exists in Dictionary.
5. To search for the synonym of a word, type the word first and then click the syn button (Pencil icon).
6. To translate Vietnamese to English or translate a long sentence in English or Vietnamese, click the translate button, the the scene will be switched where you can type any sentences.
7. To pronounce the word, click the Pronounce button (Speaker icon).
8. To practice, click the Practice button (Play icon), then the application will display a Game window.
   + In the Game window, you will start playing right away. In order to get results, and return to dictionary, you have to play the game to learn english.
   + The appplication will display a "next" button to be clicked to move to the next question. The application also has limited time which is in red color. When the time runs to it, the game will be finished.
   + The application will display a question that has some spaces, you need to choose the right needed words or sentence by click one of four choices below and the system will automatically check the answer.
   + If the answer is correct, the chosen button will turn light blue and a correct-answer music will be played, and also you will be give 10 scores.
   + If the answer is incorrect, the chosen button will turn red and a incorrect-answer music will be played, and also the correct answer will be appeared for you to know by turning light blue. Of course you will not be give 10 scores.
   + When the time is up, the scene will be switched to a result scene, and there will be a song which shows the time has been up already. In this scene, your score and level will be appeared and the level is evaluated based on your score.
   + To exit the game, click the Exit/Back button (Cross icon).
   + To play again, click the game button (Play icon) again. Everything will be reset.
9. To exit the application, click the Exit button (Cross icon).

## Demo
![Demo](

## Future improvements
1. Add more dictionaries.
2. Add more complex games.
3. Optimize the word lookup algorithm.
4. Use a database to store data.
5. More better interfaces.
6. Words and questions and answers in game will be displayed much better.
7. Add more languages.
8. Add more complex methods for dictionary.

## Project status
The project is completed.

## Notes
The application is written for educational purposes.
