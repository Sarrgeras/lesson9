package com.company.exeptions;

import java.nio.file.FileSystemNotFoundException;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Main {

    private static final Map<Integer, Throwable> EXCEPTION = Map.of(
            0, new RuntimeException("runtime"),
            1, new FileSystemNotFoundException("file is not found"),
            2, new IndexOutOfBoundsException("index exception")
    );

    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.toUpperCase(Locale.ROOT));

        }
        catch (NullPointerException e){
            System.err.println("Some text");
            e.printStackTrace();
            //System.out.println("Error in block catch");
        }
        System.out.println("Code after try-catch");

        Random random = new Random();
        try {
            unsafe(random.nextInt(3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(2);
            e.printStackTrace();
        } catch (FileSystemNotFoundException e){
            System.out.println(1);
            e.printStackTrace();
        } catch (RuntimeException e){
            System.out.println(0);
            e.printStackTrace();
        } catch (Throwable e){
            System.out.println("my exception");
            e.printStackTrace();
        }

    }

    public static void unsafe(int randomValue) throws Throwable{
        Throwable throwable = EXCEPTION.getOrDefault(randomValue, new MyException("This my exception"));
        throw throwable;
    }


}
