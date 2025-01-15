package arrays_ex;

import java.util.Scanner;

public class ex_3_p48 {
    public static void main(String[] args) {
// קלוט נתונים למערך בגודל 10 ובדוק האם קיים תא שערכו שווה
// לסכום כל התאים האחרים. אם כן, הדפס את מיקומו במערך
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[10];
        int sum = 0;

        System.out.println("Enter " + arr.length + " values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sum / 2) {
                System.out.println("index number " + i + " is the answer!");

                return;
            }
        }

        System.out.println("No such index is found :(");

    }//main
}//Class