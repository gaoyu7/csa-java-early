package week3;

import week3.compute.*;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        System.out.println("<-------第一题------->");
        UseCompute useCompute = new UseCompute();
        Compute addCompute = new addCompute();
        Compute deleteCompute = new deleteCompute();
        Compute mutiplyCompute = new mutiplyCompute();
        Compute divideCompute = new divideCompute();
        useCompute.useCom(addCompute, 6, 2);
        useCompute.useCom(deleteCompute, 6, 2);
        useCompute.useCom(mutiplyCompute, 6, 2);
        useCompute.useCom(divideCompute, 6, 2);

        System.out.println("<-------第二题------->");
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入成绩:");
        try {
            int score = cin.nextInt();
            if (score < 0 || score > 100) {
                throw new Exception();
            } else System.out.println("成绩为：" + score);
        } catch (Exception e) {
            System.out.println("输入的成绩不在规定范围内");
        }

        System.out.println("<-------第三题------->");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数个数：");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            try {
                System.out.println("请输入整数：");
                int a = sc.nextInt();
                if (a < 0) {
                    throw new Exception();
                } else {
                    sum += a;
                }
            } catch (Exception e) {
                System.out.println("必须是正数或者0,请再次输入");
                i -= 1;
            }
        }
        System.out.println("平均值为：" + (float)sum/n);
        System.out.println("<-------第五题------->");
        System.out.println("请输入字符串：");
        String s = sc.next();
        char[] chars = s.toCharArray();
        String[] words = new String[4];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            System.out.println("请输入单词：");
            words[i] = sc.next();
            char[] word = words[i].toCharArray();
            int slow = 0;
            for (int fast = 0; fast < chars.length; fast++) {
                if (chars[fast] == word[slow]) {
                    slow++;
                }
                if (slow == words[i].length()) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
