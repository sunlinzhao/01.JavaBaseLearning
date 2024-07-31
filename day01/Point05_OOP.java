/**
 * @ Author SunLZ
 * @ Project JavaLearning
 * @ Date 2024/5/28
 */
public class Point05_OOP { // 一个.java文件中只能有一个public修饰的类，并且必须与文件名相同
    private String color;
    private int speed;
    private int price;

    // 快捷键生成 Getter / Setter 方法： Alt + Insert
    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private class innerClass{ // 内部类

    }

}

//public class Car{ // 一个.java文件中只能有一个public修饰的类，并且必须与文件名相同
//}

/*
* Java不允许在顶层（top-level）使用private修饰符;
* private关键字主要用于类的成员（如方法和变量），
* 用来限制对这些成员的访问仅限于定义它们的类内部。
* 对于顶级类（即直接在.java文件中定义，不属于任何其他类的类），
* 有效的访问修饰符只有public（使类对外公开）和默认访问（也称为包私有，即不写任何访问修饰符，此时类只能被同一个包内的其他类访问）。
* */
class Demo{

}