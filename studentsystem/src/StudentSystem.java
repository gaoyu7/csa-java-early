import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void startStudentSystem(){
        ArrayList<Student> list = new ArrayList<>();
        loop:while (true) {
            System.out.println("--------------欢迎来到CQUPT学生管理系统--------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice){
                case "1"->addstudent(list);
                case "2"->deletestudent(list);
                case "3"->updatestudent(list);
                case "4"->querystudent(list);
                case "5"->{
                    System.out.println("退出");
                    break loop;
                }
            }
        }

    }

    public static void addstudent(ArrayList<Student> list){
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生的id：");
            String student_id = sc.next();
            if (contains(list,student_id)){
                System.out.println("id已经存在，请重新录入");
            }else {
                s.setId(student_id);
                break;
            }
        }


        System.out.println("请输入学生的姓名：");
        String student_name = sc.next();
        s.setName(student_name);

        System.out.println("请输入学生的年龄：");
        int student_age = sc.nextInt();
        s.setAge(student_age);

        System.out.println("请输入学生的家庭住址：");
        String student_address = sc.next();
        s.setAddress(student_address);

        list.add(s);

        System.out.println("学生信息添加成功!");
    }
    public static void deletestudent(ArrayList<Student> list){
        System.out.println("请输入你要删除的id：");
        String id = new Scanner(System.in).next();
        int index = getIndex(list,id);
        if (index >= 0){
            list.remove(index);
            System.out.println("id为："+ id +"的学生删除成功");
        }else {
            System.out.println("学生id不存在，删除失败");
        }
    }
    public static void updatestudent(ArrayList<Student> list){
        System.out.println("请输入要修改学生的id：");
        String id = new Scanner(System.in).next();
        int index = getIndex(list,id);
        if (index >= 0){
            addstudent(list);
        }else {
            System.out.println("id不存在，回到初始菜单");
            return;
        }
    }
    public static void querystudent(ArrayList<Student> list){
        if (list.size()==0){
            System.out.println("当前无学生信息，请添加后查询");
            return;
        }
        System.out.println("id\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getAge()+"\t"+list.get(i).getAddress()+"\t");
        }
    }

    public static boolean contains(ArrayList<Student> list,String id){
        /*for (int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            if (st.getId().equals(id)) {
                return true;
            }
        }
        return false;*/
        return getIndex(list, id) >= 0;
    }

    public static int getIndex(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
