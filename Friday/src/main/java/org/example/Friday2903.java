package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class Friday2903 {
    // работа со строками
    private static final String text = "Hello! Thank you for creating your JetBrains Account. To complete your registration, click the link below: Confirm your account" +
             "Yours truly, https://sites.google.com/view/robocode-belarus/%D0%BF%D1%80%D0%B5%D0%B7%D0%B5%D0%BD%D1%82%D0%B0%D1%86%D0%B8%D0%B8 " +
            "The JetBrains Team " +
            "https://www.jetbrains.com" +
            "The Drive to Develop";
    public static void main(String[] args) throws Exception {
        System.out.println(text);

        System.out.println("Колличество слов в тектсе: "+ getNumber(text));
        System.out.println("Избавляемся от ненужных знаков: "+newText(text));
        System.out.println("Самое длинное слово: "+findLongWord(text));
        System.out.println(findLink(text));
        System.out.println(findNamesLink(findLink(text)));
        Data();
    }
    //посчитать колличество слов в тексте
    public static int getNumber(String text){
        String[] arrayWord = text.split(" ");
        return arrayWord.length;
    }
    // убрать лишние символы
    public static String newText(String text){
        return  text.replaceAll("[.,?;!:-]"," ");

    }
    // найти самое длинное слово
    public static String findLongWord(String text){
        String[] arrayWord = newText(text).split(" ");
        for (int i = 0; i < arrayWord.length ; i++) {
            for (int j = 0; j < arrayWord.length ; j++) {
                if (arrayWord[i].length()>arrayWord[j].length()){
                    String temp = arrayWord[i];
                    arrayWord[i]=arrayWord[j];
                    arrayWord[j]=temp;
                }

            }
        }
        return arrayWord[0];
    }
    // найти ссылки в тексте
    public static StringBuilder findLink(String text){
            StringBuilder links = new StringBuilder();
            String[] arrayText = text.split(" ");
        for (int i = 0; i < arrayText.length; i++) {
            if (arrayText[i].contains("http")){
                links.append(arrayText[i]).append("\n");
            }
        }
        return links;
    }
    // найти в ссылках имена
    public static StringBuilder findNamesLink(StringBuilder links){
        String[] linksArray = links.toString().split("\n");
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < linksArray.length ; i++) {
            int res = linksArray[i].contains("://") ?linksArray[i].indexOf("://")+3:-1;
            int res1 = linksArray[i].indexOf("/",res)==-1?linksArray[i].length():linksArray[i].indexOf("/",res);
            String result = linksArray[i].substring(res,res1);
            stringBuilder.append(result).append("\n");
        }
        return stringBuilder;
    }
    public static void Data() throws Exception{
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.append(text);
        fileWriter.close();
    }

}
