package methods_package;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Methods_static_void {

    public static void main(String[] args) {
// ריק
        sayHi();
        System.out.println("Bye bye");

// קבוע
        factorial(5L);
        factorial(8);

// משתנה
        for (int i = 1; i <= 10 ; i++) {
            factorial(i);
        }
        // or
        for (int i = 1; i <= 10 ; i++) {
            prime(i);
        }

// קלט
        Scanner scanner = new Scanner(System.in);
        prime(scanner.nextInt());



/**************************************************/

        // תאריך
        Date date = new Date();
        System.out.println(date);

        // תאריך
//        Date date = new Date(); // כי הצהרנו למעלה
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // M גדולה זה month, m קטנה זה minute// H זה 24 שעות
        System.out.println(sdf.format(date));
/*****************************************************/



    } //main



    // create a method that gets an int number as a parameter
    // and prints if the num is prime or not

// ריק
    public static void sayHi(){
        System.out.println("Hello world!");
    }


// קבוע, משתנה וקלט

    public static void factorial(int num){
        int fact = 1;
        for (int i = 2; i <= num ; i++) {
            fact *= i;
        }

        System.out.println("Factorial is: " + fact);
    }
    public static void factorial(long num){
        int fact = 1;
        for (int i = 2; i <= num ; i++) {
            fact *= i;
        }

        System.out.println("Long Factorial is: " + fact);
    }

    public static void prime(int number){
        boolean isPrime = true;
        for (int i = 2; i < number ; i++) {
            if(number % i == 0){
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime? number + " is prime": number + " not prime");
    }
}
