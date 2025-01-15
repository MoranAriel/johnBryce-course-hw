package arrays_ex;

import java.util.Random;

public class ex_4_p48 {
    public static void main(String[] args) {
// קלוט נתונים למערך בגודל 20, והחלף את עשרת התאים הראשונים באחרונים
        // Scanner scanner = new Scanner(System.in);
        int[] arr = new int[20];

        System.out.println("These are 20 Random numbers: ");
        for (int i = 0; i < arr.length; i++) {
        //    System.out.println(i+1 + ". Enter a number: ");
        //    int num = scanner.nextInt();
            int num = new Random().nextInt(100)+1;
            arr[i] = num;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[i + 10];
            arr[i + 10] = temp;
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");
        }


    }//main
}//Class
