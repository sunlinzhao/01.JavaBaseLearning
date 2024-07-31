package com.slz.homework.demo1;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Test {
    public static void main(String[] args) {
        BookPaper bookPaper1 = new BookPaper("red", "A");
        BookPaper bookPaper2 = new BookPaper("red", "B");
        Student student1 = new Student("杜甫", bookPaper1);
        Student student2 = new Student("李白", bookPaper2);
        borrow(student1);
        borrow(student2);
    }

    public static void borrow(Student student){
        if("red".equals(student.getBookPaper().color) && "A".equals(student.getBookPaper().type)){
            System.out.println("可以借到《JAVA基础》");
        } else if ("red".equals(student.getBookPaper().color) && "B".equals(student.getBookPaper().type)) {
            System.out.println("可以借到《MYSQL数据库》");
        } else {
            System.out.println("可以借到《JAVA编程思想》");
        }
    }
}
