package com.banana.textgame;

import java.util.Scanner;

public class Main {

    /*
     * Главный метод.
     * hjsdfgabk
     * новый коммент, новый коммент2
     */
    public static void main(String[] args) {
        // вызывает метод start()
        new Main().start();
    }
    boolean game = true;
    /*
     * Метод с логикой игры.
     */
    private void start() {
        onStart();
        while (game == true) {
            if (check == true) {
                for (int i = 1; i <= 5; ++i) {
                    onNewDay(i);
                }
                onFinish();
            }
        }
    }

    boolean check = false;

    /*
     * Метод вызывается один раз при старте игры.
     */
        void onStart () {
        Scanner keyboard = new Scanner(System.in);
        String[] variants = {"Кто вы такой?", "Как вас зовут?", "Представьтесь"};
        String v = variants[(int) (Math.random() * variants.length)];
        System.out.println(v);
      //  System.out.println("Как вас зовут?");
        String userName = keyboard.nextLine();
        System.out.println("Привет " + userName + ", сколько вам лет?");
        int age = keyboard.nextInt();
        int suitableAge = 13 - age;
        if (age < 13 && suitableAge == 1) {
            System.out.println("Вы слишком малы, приходите через через " + suitableAge + " год");
        } else if (age < 13 && suitableAge <= 4 && suitableAge != 1) {
            System.out.println("Вы слишком малы, приходите через через " + suitableAge + " года");
        } else if (age < 13 && suitableAge >= 5) {
            System.out.println("Вы слишком малы, приходите через через " + suitableAge + " лет");
        } else {
            System.out.println("Все ОК, запускаем игру!");
            check = true;
        }
    }
    //Глобальные переменные
    int money = 0;
    int coffePrize = 2;
    String[] languages = {"Java", "JavaScript" , "C++", "C#", "Brainfuck"};
    boolean[] knownLanguages = {true, false, false, false, false};
    Scanner keyboard = new Scanner(System.in);
    int coursePrize = 20;

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
    void onNewDay(int dayNumber) {
        System.out.println("День номер" + " " + dayNumber);
        System.out.println("Ваше действивие");
        String action = keyboard.nextLine();

        /*  //пример работы switch
        switch (action) {
            case "кофе":
                System.out.println("- 2$");
                System.out.println("Осталось денег на счету : " + money + "$");
                break;
            case "кодить":
                System.out.println("Ваш код на сегодня");
                String code = keyboard.nextLine();
                money = money + code.length();
                System.out.println("Ваш счет: " + " " + money + "$");
                break;
            default:
                System.out.println("операция не поддерживается!");
        }*/

        if (action.equals("Выпить кофе")) {

            if (money < coffePrize) {
                System.out.println("Не хватает денег!");
            } else if (money >= coffePrize) {
                money = money - coffePrize;
                System.out.println("- 2$");
                System.out.println("Осталось денег на счету : " + money + "$");
            }
        } else if (action.equals("кодить")) {
            System.out.println("Ваш код на сегодня");
            String code = keyboard.nextLine();
            money = money + code.length();
            System.out.println("Ваш счет: " + " " + money + "$");
            if (code.length() < 10) {
                System.out.println("Холявщик!");
            } else if (code.length() >= 10) {
                System.out.println("Хорошая работа!");
            }
        } else if (action.equals("казино")) {
            if (money <= 0) {
                System.out.println("У вас нету денег, заработайте и приходите!");
            } else {
                System.out.println("Проходите!");
            for (boolean playKasino = true; playKasino == true; ) {
                    Scanner keyboard2 = new Scanner(System.in);
                    System.out.println("сделайте вашу ставку " + "      " + " (На счету: " + money + "$" + ")");
                    int rate = keyboard2.nextInt();
                    if (rate > money) {
                        System.out.println("Ставка должна быть не больше имеющейся суммы денег");
                    } else if (rate <= money) {
                        money = money - rate;
                        System.out.println("-" + rate + "$");
                        System.out.println("Денег осталось: " + money + "$");
                        int firstNum = 1; //от
                        int lastNum = 3; //до
                        int randomNum = firstNum + (int) (Math.random() * lastNum); //генерация рандомного числа
                        System.out.println("Введите число от 1 до 3");
                        int num = keyboard2.nextInt();
                        keyboard2.nextLine();
                        System.out.println("Выпало число: " + randomNum);
                        if (num == randomNum) {
                            int winRate = rate * 2;
                            money = money + winRate;
                            System.out.println("Вы победили! " + "+" + winRate + "$");
                        } else {
                            System.out.println("Вы проиграли! ");
                        }
                        System.out.println("Денег стало: " + money + "$");
                        System.out.println("Сыграть еще раз?");
                        String answer = keyboard2.nextLine();

                        if (answer.equals("да") && money > 0) {
                            playKasino = true;
                        } else if (answer.equals("нет")) {
                            playKasino = false;
                        } else if (money <= 0) {
                            System.out.println("Недостатачно денег");
                            playKasino = false;
                        } else if (answer.length() == 0) {
                            playKasino = true;
                        } else {
                            System.out.println("Операция не поддерживается");
                            playKasino = false;
                        }
                    } else {System.out.println("Операция не поддерживается");}
                }
            }
        } else if (action.equals("изучить")) {
            learnLanguages();
        } else if (action.equals("изучённые языки")) {
            printKnownLanguage();
        }

    }

    void learnLanguages() {
        System.out.println("Какой язык будешь учить?");
        String language = keyboard.nextLine();

        for (int i = 0; i < languages.length; i++) {
            if (languages[i].equals(language)) {
                knownLanguages[i] = true;
                money -= 20;
                System.out.println("Стоимость обучения: " + coursePrize + "$");
                System.out.println("На счету осталось: " + money + "$");
            }
        }
    }
    void printKnownLanguage() {
        System.out.println("Эти языки вы теперь знаете: ");
        for (int i = 0; i < languages.length; i++) {
            if (knownLanguages[i] == true) {
                System.out.println(languages[i]);
            }
        }
    }


    /*
     * Метод вызывается по завершению игры.
    */
    void onFinish() {
        System.out.println("Игра закончена, ваш счет: " + money + "$");
        System.out.println("Изученные языки: ");
        for (int i = 0; i < languages.length; i++) {
            if (knownLanguages[i] == true) {
                System.out.println(languages[i]);
            }
        }
        System.out.println("Играть заново?");
        Scanner keyboard3 = new Scanner(System.in);
        String answer = keyboard3.nextLine();
        if (answer.equals("да")) {
            game = true;
        } else if (answer.equals("нет")) {
            game = false;
        }
    }
}
