package basics_package;

import java.util.Random;

public class Random_basics {
    public static void main(String[] args) {

        //Math.random - btw 1-10:
        int x = (int)(Math.random()*10)+1; // תמיד נותן דאבל (בין 0 ל-1) לכן עושים קאסטינג לאינט
        System.out.println("a number between 1-10: " + x);


        // or new Random.nextInt - btw 1-100:
        int z = new Random().nextInt(100)+1;
        System.out.println("a number between 1-100: " + z);

        //new Random()
        Random random = new Random();
        int num = random.nextInt(100)+1;
        System.out.println("a number between 1-100: " + num);

        // use of .length
        String abc = "Moran";
        int len = abc.length();
        System.out.println("length of " + abc + " is " + len);


    } // main
} // Class
