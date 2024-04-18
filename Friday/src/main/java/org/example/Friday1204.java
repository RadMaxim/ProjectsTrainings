package org.example;

import java.util.*;

public class Friday1204 {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Integer> places = new ArrayList<>();
    private static final ArrayList<Integer> number = new ArrayList<>();
    // Работа с ArrayList, делаем приложение для кинотеатра
    static {
        System.out.println("Запасные места");
        for (int i = 0; i <5 ; i++) {
            places.add(random.nextInt(10,100));
        }
    }
    public static void main(String[] args) {
        AllTickets();
        System.out.println("Продаем места....");
        System.out.println("Какие места вы хотите купить?");
        boolean state =  SellTickets();
        if (state){
            System.out.println("Появились новые места под номерами: ");
            number.addAll(places);
            System.out.println(number);
        }
    }
    public static void AllTickets(){
        for (int i = 0; i <10 ; i++) {
            number.add(random.nextInt(10));
        }
        System.out.println("Купили 10 билетов: наши места: ");
        System.out.println(number);
    }
    public static boolean SellTickets(){
        ArrayList<Integer> removeArrayList = new ArrayList<>();
        String[] places = buyPlaces();
        System.out.println(Arrays.toString(places));
        for (int i = 0; i < places.length ; i++) {
            removeArrayList.add(Integer.valueOf(places[i]));
        }
        number.removeAll(removeArrayList);
        System.out.println(number);
        return number.size()==0;
    }
    public static String[] buyPlaces(){
        String place  = scanner.nextLine();
        return place.split(" ");
    }
}
