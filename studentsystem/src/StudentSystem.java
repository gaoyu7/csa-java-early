import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentSystem {

    public static void startStudentSystem()
     {
        ArrayList<Student> list = new ArrayList<>();
        loop:
        while (true) {
            System.out.println("--------------欢迎来到CQUPT学生管理系统--------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5.按姓氏升序排序");
            System.out.println("6.按成绩降序排序");
            System.out.println("7.查看某科平均分");
            System.out.println("8:退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice) {
                case "1" -> addstudent(list);
                case "2" -> deletestudent(list);
                case "3" -> updatestudent(list);
                case "4" -> querystudent(list);
                case "5" -> sortbyname(list);
                case "6" -> sortbyscores(list);
                case "7" -> querysingleavescore(list);
                case "8" -> {
                    System.out.println("退出");
                    break loop;
                }
            }
        }

    }

    public static void addstudent(ArrayList<Student> list) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生的学号：");
            String student_id = sc.next();
            if (contains(list, student_id)) {
                System.out.println("学号已经存在，请重新录入");
            } else {
                s.setId(student_id);
                break;
            }
        }


        System.out.println("请输入学生的姓名：");
        String student_name = sc.next();
        s.setName(student_name);

        System.out.println("请输入学生的数学成绩");
        float mathscores = sc.nextFloat();
        s.setMathscores(mathscores);

        System.out.println("请输入学生的英语成绩");
        float englishscores = sc.nextFloat();
        s.setEnglishscores(englishscores);

        System.out.println("请输入学生的数学成绩");
        float computerscores = sc.nextFloat();
        s.setComputerscores(computerscores);

        s.setAllscores(mathscores + englishscores + computerscores);

        list.add(s);

        System.out.println("学生信息添加成功!");
    }

    public static void deletestudent(ArrayList<Student> list) {
        System.out.println("请输入你要删除的学号：");
        String id = new Scanner(System.in).next();
        int index = getIndex(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("学号为：" + id + "的学生删除成功");
        } else {
            System.out.println("学生学号不存在，删除失败");
        }
    }

    public static void updatestudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号：");
        String id = new Scanner(System.in).next();
        int index = getIndex(list, id);
        if (index<0){
            System.out.println("学号不存在，回到初始菜单");
            return;
        }
        Student s = list.get(index);
        System.out.println("请输入要修改的学生姓名：");
        String student_name = sc.next();
        s.setName(student_name);

        System.out.println("请输入要修改的学生数学成绩");
        float mathscores = sc.nextFloat();
        s.setMathscores(mathscores);

        System.out.println("请输入要修改的学生英语成绩");
        float englishscores = sc.nextFloat();
        s.setEnglishscores(englishscores);

        System.out.println("请输入要修改的学生数学成绩");
        float computerscores = sc.nextFloat();
        s.setComputerscores(computerscores);

        s.setAllscores(mathscores + englishscores + computerscores);

        System.out.println("学生信息修改成功！");
    }
    public static void querystudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息，请添加后查询");
            return;
        }
        System.out.println("学号\t\t\t姓名\t数学成绩\t英语成绩\tc语言成绩");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t" + list.get(i).getMathscores() + "\t" + list.get(i).getEnglishscores() + "\t" + list.get(i).getComputerscores() + "\t");
        }
    }

    public static boolean contains(ArrayList<Student> list, String id) {
        /*for (int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            if (st.getId().equals(id)) {
                return true;
            }
        }
        return false;*/
        return getIndex(list, id) >= 0;
    }

    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void sortbyname(ArrayList<Student> list) {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().charAt(0) - o2.getName().charAt(0);
            }
        });
        System.out.println("排序完毕");
    }

    public static void sortbyscores(ArrayList<Student> list) {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o2.getAllscores() - o1.getAllscores());
            }
        });
        System.out.println("排序完毕");
    }

    public static void querysingleavescore(ArrayList<Student> list) {
        System.out.println("请输入你要查找的科目名称：");
        System.out.println("1.数学");
        System.out.println("2.英语");
        System.out.println("3.C语言");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        switch (choice) {
            case "1" -> mathave(list);
            case "2" -> englishave(list);
            case "3" -> computerave(list);
        }
    }

    private static void mathave(ArrayList<Student> list) {

        float sum = 0;
        for (Student student : list) {
            sum += student.getMathscores();
        }
        System.out.println("该科平均分为：" + sum / list.size());
    }

    private static void englishave(ArrayList<Student> list) {

        float sum = 0;
        for (Student student : list) {
            sum += student.getEnglishscores();
        }
        System.out.println("该科平均分为：" + sum / list.size());
    }

    private static void computerave(ArrayList<Student> list) {

        float sum = 0;
        for (Student student : list) {
            sum += student.getComputerscores();
        }
        System.out.println("该科平均分为：" + sum / list.size());
    }
}
