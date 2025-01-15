package methods_package;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex_1 {
    // מתודות
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        myName(name);
        myName("Moran");
        f3();
        date();
    }

    public static void myName(String name) {
        System.out.println(name);
    }

    public static void f3() {
        System.out.println("f3");
        f2();
    }

    public static void f2() {
        System.out.println("f2");
    }

    public static void date() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy ** dd.MM.yy ** HH:mm:ss"); // M גדולה זה month, m קטנה זה minute// H זה 24 שעות
        System.out.println(sdf.format(date));
    }


} //Class
