package week1;

import java.util.Random;

public class code {
    public static void main(String[] args) {
        System.out.println("1.B,2.B,3.D,4.B,5.D");
        showTriangle(5);
        reverseString("helllo");
        isPalindrome(123454321);
        ShuiXianHua();
        arraysDemo();
    }

    public static void showTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            String line = "";
            for (int n1 = n; n1 >= i; n1--) {
                line += " ";
            }
            for (int i1 = 1; i1 <= (2 * i - 1); i1++) {
                line += "*";
            }
            System.out.println(line);
        }
    }

    public static void reverseString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        s = String.valueOf(chars);
        System.out.println(s);
    }

    public static String ReverseString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        s = String.valueOf(chars);
        return s;
    }

    public static void isPalindrome(int num) {
        boolean flag = false;
        String StrNum = num + "";
        if (ReverseString(StrNum).equals(StrNum)) {
            flag = true;
        }
        if (flag) {
            System.out.println("是的");
        } else
            System.out.println("不是");
    }

    public static void ShuiXianHua() {
        for (int i = 100; i < 1000; i++) {
            if (shuixianhua(i)) {
                System.out.printf("%d ", i);
                System.out.println();
            }
        }
    }

    private static boolean shuixianhua(int i) {
        String num = i + "";
        int[] Num = new int[3];
        int sum = 0;
        //方法一
        /*
        for (int i1 = 0; i1 < chars.length; i1++) {
            Num[i1] = (int) chars[i1] - 48;
        }
        int sum = 0;
        for (int a : Num) {
            sum += a*a*a;
        }*/
        //方法二
        for (char c : num.toCharArray()) {
            int a = (int) c - 48;
            sum += a * a * a;
        }
        if (sum == i) {
            return true;
        }
        return false;
    }

    public static void arraysDemo() {
        int[] a = new int[10];
        Random rd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt(100);
        }
        int max = a[0], min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(max + " " + min);
    }
}
