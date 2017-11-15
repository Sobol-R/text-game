package com.banana.textgame;

import java.util.ArrayList;

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

    /* ПРИМЕР РАБОТЫ МЕТОДА С ВОЗРАЩЕНИЕМ

    String join(char symbol, int size) {
        String s = "";
        for (int i = 0; i < size; ++i) {
            s += symbol;
        }
        System.out.println(s);
        return s;
    }*/


        void onStart () {

  /*          ArrayList numbers = new ArrayList();
            for (int i = 1; i <= 666; i++) {
                if (i %7 == 0) {
                    numbers.add(i);
                }
             }
            System.out.println(numbers);*/

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
            onFinish();
        } else if (age < 13 && suitableAge <= 4 && suitableAge != 1) {
            System.out.println("Вы слишком малы, приходите через через " + suitableAge + " года");
            onFinish();
        } else if (age < 13 && suitableAge >= 5) {
            System.out.println("Вы слишком малы, приходите через через " + suitableAge + " лет");
            onFinish();
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
                alertMoney();
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
            }
        } else if (action.equals("изучить")) {
            learnLanguages();
        } else if (action.equals("изучённые языки")) {
            printKnownLanguage();
        } else if (action.equals("пицца")) {
            pizza();
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
                alertMoney();
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
    void pizza() {
        System.out.println("Сколько кусков хотите съесть?");
        int quantity = keyboard.nextInt();
        keyboard.nextLine();
        pizza(quantity);
    }
    void pizza(int quantity) {
        System.out.println("Вы скушали: " + quantity + " кусков");
        money -= 2 * quantity;
        alertMoney();
    }
    void alertMoney() {
        System.out.println("На счету осталось: " + money + "$");
    }
    int getPoints() {
        int points = money;
        for (int i = 0; i < knownLanguages.length; i++) {
            if (knownLanguages[i] == true) {
                points += 10;
            }
        }
        return points;
    }
    /*
     * Метод вызывается по завершению игры.
    */
    void onFinish() {
        System.out.println("Игра закончена, ваш счет: " + money + "$");
        System.out.println("Вы набрали очков: " + getPoints());
        System.out.println("Изученные языки: ");
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
