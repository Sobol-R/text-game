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
        for (int i = 1; i <= 5; ++i) {
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

    void onNewDay(int dayNumber) {
        System.out.println("День номер" + " " + dayNumber);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ваш код на сегодня");
        String code = keyboard.nextLine();
        money = money + code.length();
        System.out.println("Ваш счет: " + " " + money);
    }




    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {

    }

}
