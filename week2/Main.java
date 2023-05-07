package week2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        //TODO:在此编写第一题测试代码
        monkey monkey = new monkey();
        monkey.speak();
        people people = new people();
        people.speak();
        people.think();
        System.out.println("<-------第二题------->");
        //TODO:在此编写第二题测试代码
        new Car(4, 1150.0, 3);
        System.out.println("-------------------------");
        new Truck(6, 15000.0, 1, 3000.0);
        System.out.println("-------------------------");
        new Car(4, 1150.0, 6);
        System.out.println("-------------------------");
        new Truck(6, 15000.0, 1, 7000.0);
        System.out.println("<-------第三题------->");
        //TODO:在此编写第三题测试代码
        System.out.println(getSum("88888888888888888", "25461213124533465"));
        System.out.println(getSum("13829579081298345918257", "438823897418920918472193"));
        System.out.println("<-------第四题------->");
        //TODO:在此编写第四题测试代码
        System.out.println("<-------第五题------->");
        //TODO:在此编写第五题测试代码
        String[] strs1 = new String[]{"f1ower","f1ow","f1ight"};
        System.out.println(longestCommonPrefix(strs1));
        String[] strs2 = new String[]{"dog","racecar '","car"};
        System.out.println(longestCommonPrefix(strs2));
    }

    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for (int i = a.length() - 1; i >= 0; --i) {
            la.add(a.charAt(i) - '0');

        }
        for (int i = b.length() - 1; i >= 0; --i) {
            lb.add(b.charAt(i) - '0');

        }
        if (la.size() > lb.size()) {
            for (int i = 0; i < (la.size() - lb.size()); i++) {
                lb.add(0);
            }
        } else if (lb.size() > la.size()) {
            for (int i = 0; i < (lb.size() - la.size()); i++) {
                la.add(0);
            }
        }
        Integer[] listA = la.toArray(new Integer[0]);
        Integer[] listB = lb.toArray(new Integer[0]);
        for (int i = 0; i < listA.length; i++) {
            int sum = listA[i] + listB[i];
            if (i != listA.length - 1) {
                if (sum > 9) {
                    sum -= 10;
                    listA[i + 1] += 1;
                }
            }
            c = sum + c;
        }
        return c;
    }
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        if (strs.length == 0) {
            return "";
        }
        ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }

}


class monkey {
    private String name;

    public monkey() {
    }

    public monkey(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("咿咿呀呀 ......  ");
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "monkey{name = " + name + "}";
    }
}

class people extends monkey {
    public people() {
        super();
    }

    public people(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("小样儿，不错嘛！会说话了！");
    }

    public void think() {
        System.out.println("别说话！认真思考！");
    }
}

class Vehicle {
    private int wheels;
    private double weight;

    public Vehicle() {
    }

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    /**
     * 获取
     *
     * @return wheels
     */
    public int getWheels() {
        return wheels;
    }

    /**
     * 设置
     *
     * @param wheels
     */
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    /**
     * 获取
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * 设置
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Vehicle{wheels = " + wheels + ", weight = " + weight + "}";
    }

    public void ifover() {

    }
}

class Car extends Vehicle {
    private int loader;

    public Car() {

    }

    public Car(int wheels, double weight, int loader) {
        super(wheels, weight);
        this.loader = loader;
        //输出方法写入带参构造
        System.out.println("车轮的个数是：" + super.getWheels() + "车重：" + super.getWeight());
        System.out.println("这是一辆小车，能载6人，实载" + this.loader + "人");
        if (this.loader >= 5) {
            System.out.println("你超员了！");
        }
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    @Override
    public void ifover() {

    }
}

class Truck extends Vehicle {
    private int loader;
    private double payload;

    public Truck() {

    }

    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight);
        this.loader = loader;
        this.payload = payload;
        System.out.println("车轮的个数是：" + super.getWheels() + "车重：" + super.getWeight());
        System.out.println("这是一辆卡车，能载3人，实载" + this.loader + "人");
        if (this.loader >= 5) {
            System.out.println("你超员了！");
            return;
        }
        System.out.println("这是一辆卡车，能载5000kg，你已装载" + this.payload + "kg");
        if (this.payload >= 5000) {
            System.out.println("你超载了");
        }
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public void ifover() {
        if (this.loader > 3 || this.payload > 5000) {
            System.out.println("卡车已超载");
        }
    }

}