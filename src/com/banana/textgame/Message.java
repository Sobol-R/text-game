package com.banana.textgame;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Message {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> friends = new ArrayList<>();
    ArrayList<String> timeMas = new ArrayList<>();
    void getMess() {
        names.add(Main.userName);
        System.out.println("Кому отправить ");
        String friend = Main.keyboard.nextLine();
        friends.add(friend);
        System.out.println("Напишите ваше сообщение:");
        String text = Main.keyboard.nextLine();
        Calendar dating = Calendar.getInstance();
        SimpleDateFormat formating = new SimpleDateFormat("dd MMM YYYY HH:mm:ss");
        String time = formating.format(dating.getTime());
        timeMas.add(time);
        System.out.println("Показать отправленные сообщения?");
        String answer = Main.keyboard.nextLine();
        if (answer.equals("да")) {
            System.out.println("'" + text + "'" + "; Отправитель: " + Main.userName + "; получатель: " + friend + "; отправленно: " + timeMas);
        }
    }
}
