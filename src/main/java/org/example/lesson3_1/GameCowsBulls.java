package org.example.lesson3_1;

import java.util.Scanner;

public class GameCowsBulls {
    void start(int sizeWord, int maxTry) {
        LoggerClass.configureLogger();
        AbstractGame abstractGame = new NumberGame();
        Scanner scanner = new Scanner(System.in);

        while (abstractGame.getGameStatus().equals(GameStatus.RESET)) {
            abstractGame.status = GameStatus.PLAY;
            while (abstractGame.getGameStatus().equals(GameStatus.PLAY)) {
                abstractGame.start(sizeWord, maxTry);
                Answer answer = abstractGame.inputValue(scanner.nextLine());
                System.out.println(answer);
            }
            if (abstractGame.getGameStatus().equals(GameStatus.WIN)) {
                LoggerClass.logger.info("Победа");
                System.out.println("вы победили");
            } else {
                LoggerClass.logger.info("Поражение");
                System.out.println("вы проиграли");
            }

            System.out.println("Хотите посмотреть лог? Нажмите 1, если Да");
            int questionCheckLog = Integer.parseInt(scanner.nextLine());
            if (questionCheckLog == 1) {
                System.out.println("Пожалуйста, лог файл \"log\" добавлен, откройте его");
                System.out.println("Может, перезапуск? Нажмите 1, если Да");
            } else {
                System.out.println("Может, перезапуск? Нажмите 1, если Да");
            }
            int doReset = Integer.parseInt(scanner.nextLine());
            if (doReset == 1) {
                LoggerClass.logger.info("Пользователь выбрал перезапуск");
                LoggerClass.logger.info("-----------------ПЕРЕЗАПУСК-----------------");
                System.out.println("Перезапус инициализирован..");
                abstractGame.status = GameStatus.RESET;
            } else {
                System.out.println("Конец");
            }
        }
    }
}
