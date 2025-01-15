package methods_package;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Methods_static_NOT_void {
    public static void main(String[] args) {
        // לשמור את התוצאה של המתודה בתוך משתנה
        int result = addTwoNumbers(-45, 500);
        System.out.println(result * 2);

        // להדפיס תוצאה שהמתודה מחזירה
        System.out.println(addTwoNumbers(3, 7));

        // לקחת את התוצאה שהמתודה המקומית מחזירה,
        // ולשלוח אותה למתודה שנמצאת בקלאס אחר בפרויקט
        Methods_static_void.prime(addTwoNumbers(1, 2));


        // חישוב מס אבסולוטי
        int x = Math.abs(-7);
        System.out.println(x);

    }


    public static int addTwoNumbers(int num1, int num2) {
        //System.out.println(num1+num2);
        return num1 + num2;
    }

}

