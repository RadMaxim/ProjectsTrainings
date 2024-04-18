package org.example;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
// Формирование подобия на базу данных в обычном txt документе
public class Les1904 {
    private static final HashMap<String, String> dataPerson = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Fill in the details of 5 users...");
        HashMap<String, String> persons = fillDetails();
        System.out.println("Запись данных в txt файл.....");
        writingData();
    }
    public static HashMap<String, String> fillDetails(){
        for (int i = 0; i <5; i++) {
            System.out.println("Введите данные пользователя в формате: nickname_location");
            String[] data = scanner.next().split("_");
            while (checkDetails(data)){
                if (dataPerson.containsKey(data[0])){
                    System.out.println("Такой nickname создан...Введите еще раз)");
                    data = scanner.next().split("_");
                }
                else {
                    dataPerson.put(data[0],data[1]);
                    break;
                }
            }


        }
        return dataPerson;
    }
    public static boolean checkDetails(String[] data){
        if (data.length!=2)return false;
        if (data[0].replaceAll("[A-Za-z0-9]","").length()>0){
            System.out.println("The nickname must contain only numbers and English letters");
            return false;
        }
        if (data[1].charAt(0)!=data[1].toUpperCase().charAt(0)){
            System.out.println("The city must begin with a capital letter");
            return false;
        }
        return true;
    }
    public static void writingData() throws Exception{
        FileWriter fileWriter = new FileWriter("DataPerson.txt");
        fileWriter.append("|").append("<Nickname>").append("|").append("<Location>").append("|").append("\n");

        for (Map.Entry<String, String> data:dataPerson.entrySet()) {
            fileWriter.append("|").append(data.getKey()).append("|").append(data.getValue()).append("|").append("\n");
        }
        fileWriter.close();

    }
}
