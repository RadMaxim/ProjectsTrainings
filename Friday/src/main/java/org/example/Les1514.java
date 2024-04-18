package org.example;

import java.util.Arrays;

public class Les1514 {
    // работа с потоками, разбираем что такое потоки, работем с volatile, synchronized и с ключевым словом this
   volatile int  count = 0;
    static int times = 0;
    static volatile   StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws Exception{
        One one = new One();

        Two two = new Two();
        stringBuilder.append("\n");
        two.start();
        one.start();

        one.join();
        two.join();
        System.out.println(new Les1514().count);
        System.out.println(stringBuilder);
        String str = stringBuilder.toString();
        String[] arr = str.split("plus");
        System.out.println(Arrays.toString(arr));

    }
    public static class One extends Thread{
        @Override
        public void run() {
            while (times<100){
                times++;
                new Les1514().subtractCount();
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static class Two extends Thread{
        @Override
        public void run() {
            while (times<100){
                new Les1514().addCount();
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
    public  void subtractCount(){
        synchronized (this){
            count--;
        }
        System.out.println(count);
        stringBuilder.append("minus");

    }
    public void addCount(){

        synchronized (this){
            count++;
        }
        stringBuilder.append("plus");
        System.out.println(count);

    }
}
