package basics_package;

import java.util.Scanner;

public class Char_basics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        char [] arr = new char [5]; // מערך תווים
        System.out.print("enter 5 letters --> ");
        for (int i = 0 ; i < arr.length ; i++) {
            arr[i] = scanner.next().charAt(0); // קח את התו הראשון שמוקלד (ולכן 0), במקום ה-0 במחרוזת (אם תוקש)

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }


    }//main
}//Class
