package org.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
// Узнаем в чем отличие HashMap от TreeMap. Создаем список дел
public class Les1904_1 {
    public static HashMap<String,String> data = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    public static String time = "";
    public static String myCase = "";
    public static void main(String[] args) {
        System.out.println("Список дел.....");
        while (!time.equals("23:00")){
            System.out.println("Введите время - ");
            time = scanner.nextLine();
            System.out.println("Введите дело - ");
            myCase = scanner.nextLine();
            if (!data.containsKey(time)) {
                data.put(time,myCase);
            }

        }
        TreeMap<String, String> sort = new TreeMap<>(data);

        System.out.println(data);
        System.out.println(sort);
    }
}
