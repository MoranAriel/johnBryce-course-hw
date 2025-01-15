package arrays_ex;

import java.util.Scanner;

public class Ex_7_p48 {
    public static void main(String[] args) {
// קלוט נתונים למערך בגודל 10. הדפס כמה הם ספרות, כמה אותיות וכמה אחרים
        Scanner scanner = new Scanner(System.in);
        char[] arr = new char[10];
        int digitCount = 0, letterCount = 0, otherCount = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter a character: ");
            arr[i] = scanner.next().charAt(0);
            if (arr[i] >= '0' && arr[i] <= '9') {
                digitCount++;
            } else if (arr[i] >= 'a' && arr[i] <= 'z' || arr[i] >= 'A' && arr[i] <= 'Z') {
                letterCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("Number of digits: " + digitCount + "\nNumber of letters: " + letterCount + "\nand others: " + otherCount);

    }
}
