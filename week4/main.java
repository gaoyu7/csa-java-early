package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("第一题:");
        int x = sc.nextInt();
        intreverse(x);
        System.out.println("--------------------------");
        System.out.println("第二题:");
        int n = sc.nextInt();
        System.out.println(climbStairs(n));
        System.out.println("--------------------------");
        System.out.println("第三题:");
        int [] a = {1,2,3};
        System.out.println(subsets(a));
    }
    private static void intreverse(int x) {
        int ans = 0;
        int flag = x > 0 ? 1 : -1;
        x = x > 0 ? x : -x;
        while (x != 0) {
            if (ans != (ans * 10) / 10) {
                System.out.println(0);
                break;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        System.out.println(flag * ans);
    }
    public static int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp)); // 把当前组合加入到结果中
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]); // 把当前元素加入到组合中
            backtrack(result, temp, nums, i + 1); // 继续往下搜索
            temp.remove(temp.size() - 1); // 回溯，把当前元素从组合中移除
        }
    }
}