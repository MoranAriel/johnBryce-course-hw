package basics_package;

import java.util.Scanner;

public class String_input_basics {
    public static void main(String[] args) {
// String - BASICS examples

// 1:  השמה
        String a = "Hello Moran.";
        String b = "How old are you?";
        int c =  33;
        String msg = a + b + " I'm " + c + " years old.";
        // or
        //String msg = String.format("%s %s I'm %d years old.", a,b,c);

        System.out.println(msg);


        System.out.println("***************************************");
        //************************************************************

//2:

        String str1 = new String("Moran");
        System.out.println("your name is " + str1);



        System.out.println("***************************************");
        //************************************************************

//3: input - קלט

        System.out.println("Enter your full name:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println("your name is " + str);



        System.out.println("***************************************");
        //************************************************************


//4: input (stops saving the value after pressing space key)

        System.out.println("Enter your full name:");
     // Scanner scanner = new Scanner(System.in);   //כי כבר הגדרנו בדוגמאות הקודמות
        String str2 = scanner.next();

        System.out.println("Your name is " + str2);

    } //main
}    //Class
