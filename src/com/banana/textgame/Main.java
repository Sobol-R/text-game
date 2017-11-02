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

    /*
     * Метод с логикой игры.
     */
    private void start() {
        onStart();
        for (int i = 1; i <= 2; ++i) {
            onNewDay(i);
        }
        onFinish();
    }

    /*
     * Метод вызывается один раз при старте игры.
     */
    void onStart() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String userName = keyboard.nextLine();
        System.out.println("Привет" + " " + userName);

    }
        /*
        int number = 321;
        int number2 = 333;
        String текст = "Привет";
        String имя = "Ростик";
        System.out.println(number + number2);
        System.out.println(текст + " " + имя + "!");

 for(int i = 3; i >= 1; i--) {

     System.out.println(i);
    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
        int money = 0;
        int coffePrize = 2;

    void onNewDay(int dayNumber) {
        System.out.println("День номер" + " " + dayNumber);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ваше действивие");
        String action = keyboard.nextLine();

        if (action.equals("Выпить кофе")) {

            if (money < coffePrize) {
                System.out.println("Не хватает денег!");
            } else if (money >= coffePrize) {
                money = money - coffePrize;

              }
        } else if (action.equals("Написать код")) {
            System.out.println("Ваш код на сегодня");
            String code = keyboard.nextLine();
            money = money + code.length();
            System.out.println("Ваш счет: " + " " + money);
            if (code.length() < 10) {
                System.out.println("Холявщик!");
            }
        } else {
            System.out.println("Хорошая работа!");}

    }






    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {
    }
}
