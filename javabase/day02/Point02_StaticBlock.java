/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/29
 */
public class Point02_StaticBlock { // 静态代码块测试
    public static void main(String[] args) {
        Student student = new Student(); // 执行顺序： 静态代码块 -> 构造代码块 -> 无参构造函数
        Student student1 = new Student("sb"); // 执行顺序： 静态代码块 -> 构造代码块 -> 有参构造函数
        // 静态代码块只在类加载时执行一次
        // 构造代码块每次创建对象都执行一次
        // 构造方法在每次创建对象都执行相应的构造方法
        Student.showCount();
    }
}

class Student {
    private String name;
    private static int count = 0; // 静态成员变量，用于统计该类被实例化的多少次 / 该类创建了多少个对象

    public static void showCount(){
        System.out.println("Student was be created " + count + " times");
    }

    public Student() {
        System.out.println("无参构造函数");
//        count++;
    }

    public Student(String name) {
        this.name = name;
        System.out.println("有参构造函数");
//        count++;
    }

    { // 非静态/实例初始化块
        System.out.println("构造代码块");
        count++; // 每次创建对象都会执行这个实例初始化代码块一次，所以这里适合做一些公共的操作，从构造函数中提取出来，减少代码量
    }

    static {
        System.out.println("静态代码块");
    }
}
