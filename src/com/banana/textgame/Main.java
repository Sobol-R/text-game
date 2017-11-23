package com.banana.textgame;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    int coffePrize = 2;
    static String[] languages = {"Java", "JavaScript" , "C++", "C#", "Brainfuck"};
    Scanner keyboard = new Scanner(System.in);
    int coursePrize = 20;
    User user = new User();

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

            if (user.money < coffePrize) {
                System.out.println("Не хватает денег!");
            } else if (user.money >= coffePrize) {
                user.money = user.money - coffePrize;
                System.out.println("- 2$");
                alertMoney();
            }
        } else if (action.equals("кодить")) {
            System.out.println("Ваш код на сегодня");
            String code = keyboard.nextLine();
            user.money = user.money + code.length();
            System.out.println("Ваш счет: " + " " + user.money + "$");
            if (code.length() < 10) {
                System.out.println("Холявщик!");
            } else if (code.length() >= 10) {
                System.out.println("Хорошая работа!");
            }
        } else if (action.equals("изучить")) {
            learnLanguages();
        } else if (action.equals("изучённые языки")) {
            user.printInfo();
        } else if (action.equals("пицца")) {
            pizza();
        } else if (action.equals("работа")) {
            findJobs();
        }

    }

    void learnLanguages() {
        System.out.println("Какой язык будешь учить?");
        String language = keyboard.nextLine();

        for (int i = 0; i < languages.length; i++) {
            if (languages[i].equals(language)) {
                user.knownLanguages[i] = true;
                user.money -= 20;
                System.out.println("Стоимость обучения: " + coursePrize + "$");
                alertMoney();
            }
        }
    }

    void pizza() {
        boolean flag = false;
        while (flag == false) {
            System.out.println("Сколько кусков хотите съесть?");
            try {
                int s = keyboard.nextInt();
                int quantity = s;
                pizza(quantity);
                flag = true;
            } catch (Exception e) {
                System.out.println("Ошибочка :(");
                keyboard.nextLine();
            }
        }
    }
    void pizza(int quantity) {
        System.out.println("Вы скушали: " + quantity + " кусков");
        Pizza pizza = new Pizza();
        user.money -= pizza.getPrice(quantity);
        alertMoney();
    }
    void alertMoney() {
        System.out.println("На счету осталось: " + user.money + "$");
    }

    int getPoints() {
        int points = user.money;
        for (int i = 0; i < user.knownLanguages.length; i++) {
            if (user.knownLanguages[i] == true) {
                points += 10;
            }
        }
        return points;
    }
    void findJobs() {
        String[] someJobs = {"Google", "Яндекс", "Mail.ru", "vk"};
        Collections.addAll(user.jobs, someJobs);
        for (String word : user.jobs) {
            System.out.println(word);
        }
        System.out.println("Где хотите работать?");
        String answer = keyboard.nextLine();
        switch (answer) {
            case "Google" :
                System.out.println("Необходимо пройти собеседование в Google");
            case "Яндекс" :
                System.out.println("Необходимо пройти собеседование в Яндекс");
            case "Mail.ru" :
                System.out.println("Необходимо пройти собеседование в Mail.ru");
            case "vk" :
                System.out.println("Необходимо пройти собеседование в vk");
        }
    }
    /*
     * Метод вызывается по завершению игры.
    */
    void onFinish() {
        System.out.println("Игра закончена, ваш счет: " + user.money + "$");
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
