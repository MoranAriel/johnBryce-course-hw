package basics_package;

import java.util.Scanner;

public class String_ex1 {
    public static void main(String[] args) {
// קלוט מחרוזת.
// אם מס' המחרוזת זוגית, הדפס את האות הראשונה.
// אם לא, הדפס את האות האחרונה

        String str;
        int len;
        char letter;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        str = scanner.nextLine();
        len = str.length();

        if (len % 2 == 0) {
            letter = str.charAt(0);
        } else {
            letter = str.charAt(len - 1);
        }
        System.out.println("The letter is " + letter);

        System.out.println("*****************************");
        //****************************************
       //קריאה למתודה - מצא האם התו כלול בטקסט

        findAChar("Moran", 'o');

    } //main

    public static void findAChar(String text, char c) {
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                found = true;
                break;
            }
        }
        System.out.println(found? "found it!" : "didn't find it");
    }

} // Class
