package org.example;

import java.util.Arrays;

public class Main {
    //Изучаем методы строк
    static String firstName = "Maxim";
    static String secondName = "Radchuk";
    static String country = "Brest";
    static String email = "radchuk.maksime@gmail.com";
    static String password = "Mm123!";
    static String todo = "Sleep, Eat, Play, watch movie";
    public static void main(String[] args) {
        concatonationString();
        String infoWeather = weatherForecast(country);
        System.out.println(infoWeather);
        System.out.println(Arrays.toString(splitString(todo)));
        System.out.println(checkPassword(password));
        System.out.println(checkEmail(email));

    }
    public static void concatonationString(){
        String result = firstName+" "+secondName;
        System.out.println(result);
    }
    public static String weatherForecast(String country){
        switch (country){
            case "Minsk":return "Облочно";
            case "Brest":return "Ясно";
            default:return "Облочно, с прояснениями";
        }
    }
    public static String[] splitString(String todo){
        String[] result = todo.split(",");
        return result;
    }
    public static String checkPassword(String password){
        String result = "";
        if (password.length()<8){
            result+=" Пароль очень короткий";
        }
        if (password.charAt(0)==password.toUpperCase().charAt(0)){
            result+=" Пароль не должен начинаться с большой буквы";
        }
        return result;

    }
    public static String checkEmail(String email){
        int el = email.indexOf("@");
        if (el<0){
            return "В email нет специального символа @";
        }
        if (!email.contains("gmail.com")){
            return "В email нет окончания gmail.com";
        }
        return "Корректный email";
    }
// самостоятельное
//    Проверить свой номер телефона
//            1) колличество символов
//            2) Номер телефона должен начинатся на 8029 или на +37529
//            3) Определить какой оператор
}