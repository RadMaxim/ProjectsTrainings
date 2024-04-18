package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Friday0404 {
    // Работаем с ArrayList, создаем примитивную базу данных на базе txt документа + делаем check на введенные данные через регулярные выражения
    static Scanner scanner = new Scanner(System.in);
    static int id = 0;
    static ArrayList<Integer> identity = new ArrayList<>();
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<String> phoneNumber = new ArrayList<>();

    static String NamePerson,PhonePerson;



    public static void main(String[] args) throws Exception {



        FileWriter fileWriter = new FileWriter("database.txt");
        FileWriter sorted = new FileWriter("sortedBase.txt");
        while (writeInfoPerson()){

            fileWriter.append("id: ").append(String.valueOf(id)).append(" name:").append(NamePerson).append(" phone:").append(PhonePerson).append(";");
            fileWriter.append("\n");


        }
        sortedData(name,phoneNumber,identity);
        for (int i = 0; i < name.size() ; i++) {
            sorted.append("id: ").append(String.valueOf(identity.get(i))).append(" name:").append(name.get(i)).append(" phone:").append(phoneNumber.get(i)).append(";");
            fileWriter.append("\n");
        }
        sorted.close();
        fileWriter.close();
        System.out.println(name);
    }
    public static boolean writeInfoPerson(){
        System.out.println("Желаете ли вы продолжить, yes or no?");
        if (scanner.next().equals("no")){
            return false;
        }

        System.out.println("Введите имя пользователя:");
        String namePerson = scanner.next();
        System.out.println("Введите номер телефона: ");
        String phonePerson = scanner.next();

        if (checkData(namePerson,phonePerson)){
            System.err.println("Не правильные введенные данные, пробуйте еще раз");
            return true;
        }
        identity.add(id);
        name.add(namePerson);
        phoneNumber.add(phonePerson);
        id++;
        NamePerson = namePerson;
        PhonePerson = phonePerson;
        System.out.println("Запись с уникальным номером прошла...Можно продолжать");
        return true;
    }
    public static boolean checkData(String name, String phone){
        StringBuilder error = checkName(name).append(checkPhone(phone));
        return error.length()>0;
    }
    public static StringBuilder checkName(String name){
        StringBuilder error = new StringBuilder();

        if (name.charAt(0)!=name.toUpperCase().charAt(0)){
            error.append("Имя должно начинаться с большой буквы").append("\n");
        }
        if (name.replaceAll("[A-Za-zА-Яа-я]","").length()!=0){
            error.append("В имени должны быть только буквы").append("\n");
        }
        if (name.length()<2){
            error.append("Слишком короткое имя").append("\n");
        }
        if (name.replaceAll(" ","").length()!=name.length()){
            error.append("Не должно быть пробелов в имени").append("\n");
        }
        return error;
    }
    public static StringBuilder checkPhone(String phone){
            StringBuilder stringBuilder = new StringBuilder();
        if (!(phone.startsWith("+37529")||phone.startsWith("8029")||
                phone.startsWith("+37544")||phone.startsWith("8044")||
                phone.startsWith("+37525")||phone.startsWith("8025"))){
            stringBuilder.append("У номера неправильное начало").append("\n");
        }
        if ((phone.charAt(0)=='+'?phone.substring(1):phone).replaceAll("[0-9]","").length()!=0){
            stringBuilder.append("У номера должны быть цифры").append("\n");
        }
        if ((phone.charAt(0)=='+'?13:11)!=phone.length()){
            stringBuilder.append("Не правильная длинна номера");
        }
        return stringBuilder;
    }
    public static void sortedData(ArrayList<String>name, ArrayList<String>phone,ArrayList<Integer> id){
        for (int i = 0; i < name.size() ; i++) {
            for (int j = 0; j < name.size() ; j++) {
                if (name.get(i).charAt(0)<name.get(j).charAt(0)){

                    String temp = name.get(i);
                    name.set(i, name.get(j));
                    name.set(j,temp);

                    String temp1 = phone.get(i);
                    phone.set(i, name.get(j));
                    phone.set(j,temp1);

                    int temp2 = id.get(i);
                    id.set(i, id.get(j));
                    id.set(j,temp2);
                }
            }
        }
    }
}
