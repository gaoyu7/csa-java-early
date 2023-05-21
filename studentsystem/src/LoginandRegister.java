import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LoginandRegister {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1登录 2注册 3忘记密码");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose){
                case "1"-> login(list);
                case "2"-> register(list);
                case "3"-> forgetPassword(list);
                case "4"-> {
                    System.out.println("退出");
                    System.exit(0);
                }

                default -> System.out.println("没有这个选项");
            }
        }
    }
    private static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        if (!contains(list,username)){
            System.out.println("当前用户" + username + "未注册,请先注册");
            return;
        }

        System.out.println("请输入身份证号码：");
        String personID = sc.next();
        System.out.println("请输入手机号码：");
        String phoneNumber = sc.next();

        int index = findindex(list,username);
        User user = list.get(index);
        if (!(user.getPersonID().equalsIgnoreCase(personID) && user.getPhoneNumber().equals(phoneNumber))){
            System.out.println("身份证号码或者手机号码输入有误，不能修改密码");
            return;
        }
        while (true) {
            System.out.println("请输入新的密码：");
            String password = sc.next();
            System.out.println("请再次输入新的密码：");
            String againpassword = sc.next();
            if (password.equals(againpassword)){
                System.out.println("两次密码输入一致");
                user.setPassword(password);
                System.out.println("修改成功！");
                break;
            }else {
                System.out.println("两次密码输入不一致，请重新输入");
                continue;
            }
        }

    }
    private static int findindex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }
    private static void register(ArrayList<User> list) {
        User u = new User();
        //键盘录入用户名
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            boolean flag1 = checkUsername(username);
            if (!flag1){
                System.out.println("用户格式不满足条件，需要重新输入"); 
                continue;
                }
            boolean flag2 = contains(list,username);
            if (flag2){
                System.out.println("用户名" + username + "已存在，请重新输入");
            }else {
                System.out.println("用户名" + username + "可用");
                u.setUsername(username);
                break;
            }
        }
        //键盘录入密码
        while (true) {
            System.out.println("请输入注册密码：");
            String password = sc.next();
            System.out.println("请再次输入注册密码：");
            String againpassword = sc.next();
            if (!password.equals(againpassword)){
                System.out.println("两次密码输入不一致。请重新输入");
                continue;
            }else {
                System.out.println("两次密码一致，继续录入其他数据");
                u.setPassword(password);
                break;
            }
        }
        //键盘录入身份证号码
        while (true) {
            System.out.println("请输入身份证号码：");
            String personID = sc.next();
            boolean flag = checkpersonID(personID);
            if (flag){
                System.out.println("身份证号码满足要求");
                u.setPersonID(personID);
                break;
            }else {
                System.out.println("身份证号码格式有误，请重新输入");
            }
        }
        //键盘录入手机号码
        while (true) {
            System.out.println("请输入手机号码：");
            String phoneNumber = sc.next();
            boolean flag = checkphoneNumber(phoneNumber);
            if (flag){
                System.out.println("手机号码格式输入正确");
                u.setPhoneNumber(phoneNumber);
                break;
            }else {
                System.out.println("手机号格式输入错误，请重新输入");
            }
        }

        list.add(u);
        System.out.println("注册成功！");
    }
    private static boolean checkphoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11){
            return false;
        }
        if (phoneNumber.startsWith("0")){
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (!(c >= '0'&&c <= '9')){
                return false;
            }
        }
        return true;
    }
    private static boolean checkpersonID(String personID) {
        if (personID.length() != 18){
            return false;
        }
        if (personID.startsWith("0")){
            return false;
        }
        for (int i = 0; i < personID.length()-1; i++) {
            char c = personID.charAt(i);
            if (!(c >= '0'&&c <= '9')){
                return false;
            }
        }
        char c = personID.charAt(personID.length()-1);
        if (c >= '0' && c <= '9' || c == 'x' || c == 'X'){
            return true;
        }else {
            return false;
        }
    }
    private static boolean contains(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkUsername(String username) {
        if (username.length() < 3 || username.length() > 15){
            return false;
        }
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                count++;
                break;
            }
        }
        return count > 0;

    }
    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0;i < 3;i++) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            if (!contains(list,username)){
                System.out.println("用户未注册，请先注册用户");
                break;
            }
            System.out.println("请输入密码：");
            String password = sc.next();
            String rightCode = getCode();
            while (true) {
                System.out.println("当前验证码为：" + rightCode);
                System.out.println("请输入验证码：");
                String code = sc.next();
                if (code.equalsIgnoreCase(rightCode)){
                    System.out.println("验证码正确");
                    break;
                }else {
                    System.out.println("验证码错误");
                    continue;
                }
            }
            User userInfo = new User(username,password,null,null);
            boolean result = checkUserInfo(list,userInfo);
            if (result){
                System.out.println("登录成功，可以开始使用学生管理系统");
                StudentSystem ss = new StudentSystem();
                ss.startStudentSystem();
                return;
            }else {
                System.out.println("登录失败，用户名或密码错误");
                System.out.println("还剩" + (2 - i) +"次机会");
                if ((2-i) == 0){
                    System.out.println("当前账号已锁定，请联系ZHY管理员，QQ：1470479826");
                }
            }
        }

    }
    private static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(userInfo.getUsername()) && list.get(i).getPassword().equals(userInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }
    //生成一个验证码
    private static String getCode(){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        int number = r.nextInt(10);
        sb.append(number);
        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length-1];
        arr[arr.length-1] = temp;
        return new String(arr);
    }
}
