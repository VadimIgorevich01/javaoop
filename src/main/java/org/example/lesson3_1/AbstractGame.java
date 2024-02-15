package org.example.lesson3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGame implements Game {

    private int sizeWord;
    private int maxTry;
    private String computerWord;
    GameStatus status = GameStatus.RESET;

    private String generateWord(int type) {
        List<String> alf = new ArrayList<>();
        if (type == 1) {
            NumberGame numberGame = new NumberGame();
            alf = numberGame.generateCharList();
        } else if (type == 2) {
            RuWordGame ruWordGame = new RuWordGame();
            alf = ruWordGame.generateCharList();
        } else {
            EnWordGame enWordGame = new EnWordGame();
            alf = enWordGame.generateCharList();
        }
        Random random = new Random();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sizeWord; i++) {
            int randIndex = random.nextInt(alf.size());
            result.append(alf.get(randIndex));
            alf.remove(randIndex);
        }
        LoggerClass.logger.info("JVM создал: " + result);
        return result.toString();
    }

   protected abstract List<String> generateCharList();
    int gameType;


    String gameTypeMeaning(int gameType) {
        String result = null;
        switch (gameType) {
            case 1:
                result = "Загадывается число"; break;
            case 2:
                result = "Загадывается РУ слово"; break;
            case 3: result = "Загадывается EN слово"; break;

        }
        return result;
    }
    @Override
    public void start(int sizeWord, int maxTry) {
        System.out.println("Что отгадываем? Введите 1 для числа, 2 для РУ слова и 3 для EN слова");
        Scanner scanner = new Scanner(System.in);
        gameType = Integer.parseInt(scanner.nextLine());
        this.sizeWord = sizeWord;
        System.out.println("Выбран тип игры " + gameType);
        LoggerClass.logger.info("Выбран тип игры " + gameType + " - " + gameTypeMeaning(gameType));
        computerWord = generateWord(gameType);
        this.maxTry = maxTry;
        System.out.println("Введите " + sizeWord + " символов, чтобы отгадать загаданное. У вас " + maxTry + " попыток");
    }

    @Override
    public Answer inputValue(String value) {
        if (status != GameStatus.PLAY) {
            throw new RuntimeException("вы не начали игру!");
        }
        LoggerClass.logger.info("Пользователь ввел " + value);

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < computerWord.length(); i++) {
            if (computerWord.charAt(i) == value.charAt(i)) {
                bulls++;
                cows++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cows++;
            }
        }
        maxTry--;
        if (maxTry == 0) {
            status = GameStatus.LOOSE;
        }
        if (bulls == sizeWord) {
            status = GameStatus.WIN;
        }
        LoggerClass.logger.info("Результат игры: " + new Answer(bulls, cows, maxTry).resultForLogger());
        return new Answer(bulls, cows, maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }
}
