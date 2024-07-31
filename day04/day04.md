1. 组合关系

- 继承关系：is a 🔴
- 组合关系：has a 🔴

> 组合关系: 在一个类中，包含另外一个类的对象，可以完成代码复用。

👍 代码复用时，使用继承关系还是组合关系？

> 设计原则: 合成聚合复用原则
>
> 能使用组合关系实现代码复用，尽量使用组合关系，而少用继承关系。

---

2. 接口

> 接口实现也符合里氏代换原则：接口出现的地方，其实现类也可以出现，即把接口的实现类赋值/传给接口; ❤️
>
> 类的继承符合里氏代换原则：父类出现的地方，子类也可以出现，即把子类赋值或者传给父类；

接口实现关系：like a 🔴

> 接口：一套规范，一套行为协议
>
> `[访问修饰符] interface 接口名{}`

- 接口中的数据成员，默认全部是公有的静态常量：`public static final`，不加声明也是；👍
- 在 JDK1.8 之前，接口中的方法，默认全部是公有的抽象方法：`public abstract`，不加声明也是；👍
- 类和接口的关系：class 类名 implements 接口名 （实现关系）；
- 接口不是类，没有构造方法，不能实例化；
- 接口可以实现多继承；

  > ```java
  > public interface Test2 extends Test, Test1 { // 接口可以实现多继承
  > }
  > class implTest implements Test2 {
  >     @Override
  >     public void fun(){
  >
  >     }
  > }
  > class implTest1 implements Test2, Test { // 一个接口可以被多个类实现, 一个类可以实现多个接口
  >     @Override
  >     public void fun(){
  >
  >     }
  > }
  > ```
  >
- 一个接口可以被多个类实现；
- 一个类可以实现多个接口；
- 一个类可以在继承一个父类的同时，实现一个或多个接口；（且父类中已经重写的方法，子类中可以不用重写实现）

  > ```java
  > class implTest2 extends implTest1 implements Test1, Test{
  > }
  > ```
  >

---

4. 接口的设计模式

- 接口的多态：把实现类声明成接口类型

  > 接口名 对象名 = new 实现类名();
  >

  > ```java
  > public class TestHero {
  >     public static void main(String[] args) {
  >         Attack shoot = new Shooter();
  >         Attack thrower = new Thrower();
  >         shoot.start();
  >         thrower.start();
  >     }
  > }
  > public interface Attack {
  >     void start();
  > }
  > public abstract class Hero implements Attack{
  > }
  >
  > class Shooter extends Hero{
  >     @Override
  >     public void start(){
  >         System.out.println("射箭 -> -> ->");
  >     }
  > }
  >
  > class Thrower extends Hero{
  >     @Override
  >     public void start(){
  >         System.out.println("投石 -o -o -o");
  >     }
  > }
  >
  > ```
  >
- 接口和抽象类的区别

  - 接口不能含有非抽象方法(JDK1.8之前)，抽象类可以有非抽象方法；
  - 一个类可以实现多个接口，但只能继承一个直接父类；
  - 接口之间可以多继承；
  - 接口是一套纯粹的规范；
  - 继承是有要求有关系两个类。对于无关的可以实现同一个接口。
- 简单工厂模式 👍

  - 简单工厂模式 - 静态工厂 (接口有多个实现类，工厂方法根据传入参数决定返回哪个实现类)
    > ```java
    > public class Test {
    >     public static void main(String[] args) {
    >         Fruit fruit1 = Factory.getFruit("apple");
    >         Fruit fruit2 = Factory.getFruit("banana");
    >         if(fruit1!=null){
    >             fruit1.plant();
    >             fruit1.grow();
    >             fruit1.harvest();
    >         }
    >         if(fruit2!=null){
    >             fruit2.plant();
    >             fruit2.grow();
    >             fruit2.harvest();
    >         }
    >     }
    > }public class Banana implements Fruit{
    >     @Override
    >     public void plant() {
    >         System.out.println("香蕉种植");
    >     }
    >
    >     @Override
    >     public void grow() {
    >         System.out.println("香蕉生长");
    >     }
    >
    >     @Override
    >     public void harvest() {
    >         System.out.println("香蕉收获");
    >     }
    > }public interface Fruit {
    >     void plant();
    >     void grow();
    >     void harvest();
    > }
    > public class Apple implements Fruit{
    >
    >     @Override
    >     public void plant() {
    >         System.out.println("苹果种植");
    >     }
    >
    >     @Override
    >     public void grow() {
    >         System.out.println("苹果生长");
    >     }
    >
    >     @Override
    >     public void harvest() {
    >         System.out.println("苹果收获");
    >     }
    > }
    > public class Factory {
    >     public static Fruit getFruit(String s){ // 静态工厂
    >         if("apple".equals(s)){
    >             return new Apple();
    >         } else if("banana".equals(s)){
    >             return new Banana();
    >         }
    >         return null;
    >     }
    > }
    >
    > ```
    >
- 工厂模式 ❤️

  - 开闭原则：对软件的扩展开放，对修改关闭

> 抽象工厂 -> 接口 <- 抽象产品
>
> 具体工厂 -> 实现类 <- 具体产品

在简单工厂模式中，只有一个工厂负责生产产品，一旦有新的产品，需要修改工厂方法，这违背了开闭原则。所以使用接口抽象工厂，不同的具体工厂生产不同的产品，当有新产品时，只需要扩展新的具体工厂即可，不需要修该原先的代码。

```java
public class Test {
    public static void main(String[] args) {
        Factory factory = new AppleFactory();
        Fruit fruit = factory.getFruit();
        fruit.grow();
        fruit.plant();
        fruit.harvest();
    }
}
public interface Factory { // 抽象工厂
    Fruit getFruit();
}
public interface Fruit { // 抽象产品
    void plant();
    void grow();
    void harvest();
}
public class AppleFactory implements Factory{ // 具体工厂
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
public class Apple implements Fruit{ // 具体产品
    @Override
    public void plant() {
        System.out.println("苹果种植");
    }

    @Override
    public void grow() {
        System.out.println("苹果生长");
    }

    @Override
    public void harvest() {
        System.out.println("苹果收获");
    }
}
```

- 缺省适配模式 ❤️

A接口有抽象方法x, y, z；B想要实现A中的x方法，但是不想实现y, z方法。此时，引入抽象类C，由C用空方法实现A中的所有方法。B就可以继承C，就可以选择性地重写某个方法。

```java
public interface A {
    void x();
    void y();
    void z();
}
public abstract class C implements A{
    @Override
    public void x() {}
    @Override
    public void y() {}
    @Override
    public void z() {}
}
public class B extends C{
    @Override
    public void x() {
        System.out.println("B重写了C中实现了A的方法");
    }
}
```

- JDK1.8之后接口新增的方法 👍
  - default 方法
    - 被修饰的方法，可以不被实现，可以被重写，有默认的代码；
      > ```java
      >     default void k(){
      >         System.out.println("默认的代码");
      >     }
      > ```
      >
  - static 方法
    - 同类的静态方法一样，可以通过接口名调用；
  - private 方法 （JDK9）
    - 同类的私有方法一样，在不想被外部访问到的前提下，在内部实现代码的复用；

---

4. 内部类

在一个类中，定义另一个类，称作内部类。

- 内部类可以访问外部类中的属性和方法（无视访问修饰符），不需要创建外部类的对象；
- 外部类要访问内部类的属性和方法，需要创建内部类的对象；
- 如果内部类有和外部类同名变量和方法，则在内部类中，内部类的变量和方法优先级更高；
- 访问修饰符
  > 外部类，修饰符 public default
  > 内部类，修饰符 public protcted default private
  >

分类：

- 定义在外部类的成员位置
  - 成员内部类
    - 可以直接访问外部类的变量和方法(包括私有和静态修饰的)；
    - 不能使用static声明变量和方法；
    - 编译后生成的class文件命名为 "外部类名$内部类名” ；
    - 不能直接创建内部类对象，必须要通过外部类对象去创建内部类对象； 🔴
    - 如果外部类和内部类具有相同名称的成员变量或方法，内部类可以直接访问内部类的成员变量和方法的，如果内部类访问外部类的成员变量或方法时，需要this关键字 `Outer.this.x`
      > ```java
      > Outer outer = new outer();
      > outer.Inner inner = outer.new Inner();
      > ```
      >
  - 静态内部类
    - 使用static修饰的内部类，不能直接访问外部类的非静态成员变量和方法；
    - 可以创建静态变量和方法；
    - 静态内部类创建对象时，不需要创建外部类的对象，直接可以创建内部类对象；
      > ```java
      > Outer.StaticInner staticInner = new Outer.StaticInner();
      > System.out.println(staticInner.k);
      > System.out.println(Outer.StaticInner.y);
      > ```
      >
- 定义在外部类局部位置（代码块、方法体中）
  - 局部内部类
    - 定义在外部类的方法或代码块中;
    - 可以直接访问外部类的所有成员变量和方法(包括私有的)；
    - 不能使用访问修饰符(地位相当于局部变量)；
    - 以使用final修饰，防止其他类去继承；
    - 作用范围就在当前的方法或代码块中；👍
    - 局部内部类访问方法中的变量，jdk1.8之前，必须要求变量是使用final修饰，jdk1.8之后，加入了语法糖，默认有final修饰, 所以在局部内部类方法中，可以访问，但不能修改。如果局部变量发生了改变，对于匿名内部来讲，是不知道的，所以为了保证数据运行的一致性，使用final来修饰。😕
      - 从内部类引用的局部变量必须是final变量或实际上的最终变量(保证一致性)，不能修改；
      - 没有被内部内引用的局部变量则可以是非final的；(在内部类被调用时，内部类引用的局部变量才会被编译成final);
  - 匿名内部类 ❤️
    - 没有名字的一种嵌套类；
    - 在实际开发过程中，一个接口/父类的方法在程序中只会执行一次，如果为了使用它，要创建它的实现类或者子类去进行重写。此时，我们可以使用匿名内部类的方式，减少代码冗余；
    - 语法: `new 接口/父类(){'重写方法'}`
    - 常与 Lamada 表达式一起使用

```java
public class Outer {
    private int x = 100;
    private static int z = 10;

    class Inner { // 成员内部类
        public int x = 10;

        public void showX() {
            System.out.println("成员内部类调用外部类同名属性：" + Outer.this.x); // 成员内部类调用外部类同名属性
            System.out.println("成员内部类调用自身同名属性：" + x);
        }
    }

    static class StaticInner { // 静态内部类
        static public int y = 10;
        int k = 10;

        static void fun() {
        }
    }

    public void fun() {
        int m = 0;
        class InnerLocal { // 局部内部类
            void fun() {
                System.out.println(m);
            }
        }
        InnerLocal innerLocal = new InnerLocal();
        innerLocal.fun();
    }

    public static void main(String[] args) {
        Compute compute = new Compute() { // 匿名内部类 : 直接 new 一个接口并实现方法，没有名字
            @Override
            public void add(int x, int y) {
                System.out.println(x + y);
            }
        };
        compute.add(2, 3);

        Compute1 compute1 = new Compute1(){ // 匿名内部类 : 直接 new 一个父类并实现方法，没有名字
            @Override
            void add1(int x, int y) {
                System.out.println(x+y);
            }
        };
        compute1.add1(3, 3);
    }
}

interface Compute {
    void add(int x, int y);
}
abstract class Compute1 {
    abstract void add1(int x, int y);
}
```

- 编译后的文件

![image-20240602190054117](https://s2.loli.net/2024/06/02/RB6hgwa32zPcVNJ.png)
