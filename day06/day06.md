> API：(Application Programming Interface)应用编程接口

1. Object 类

- 位于java.lang包下，这是所有类的直接或间接的父类，是java中唯一没有父类的类；
- 包括JDK带的类和用户自定义的类，都是从Object扩展来的；
- Object类中的所有方法，都是可以被子类继承的；
- Object类有构造方法。

> Object 的 finalize方法（用于垃圾回收），JDK9之后被弃用了

2. equals 方法

- 比较两个对象引用的地址值是否相等，默认情况使用==来做判断;
- 只能比较引用类型, 不能比较基本数据类型。一般都被子类方法覆盖，根据子类的要求进行重写;
- equals 方法和==的区别: ==判断是同一地址/对象，equals重写后可以判断值是否相等，同一地址/对象一定相等，值相等不一定是同一地址/对象;
- equals 重写原则： ❤️
  - 自反性: 对于任何非空引用x，x.equals(x)应该返回true;
  - 对称性: 对于任何引用x和y，如果x.equals(y)返回true，则y.equals(x)也应该返回true;
  - 传递性: 对于任何引用x、y和z，如果x.equals(y)返回true,y.equals(z)返回true，则x.equals(z)也应该返回true;
  - 一致性: 如果x和y引用的对象没有发生变化，则反复调用x.equals(y)应该返回同样的结果;
  - 非空性: 对于任意非空引用x，调用x.equals(null)应该返回false;

```java
public class Dog {
    public String name;
    public String type;
    public int age;

    public Dog(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){ // 判断为空 【非空性】
            return false;
        }
        if(this==obj){
            return true; // 占用同一块地址，则值一定相等 【自反性】
        }
        if(obj instanceof Dog){ // 判断同一类型 【一致性、传递性】
            Dog dog = (Dog) obj;
            return this.name.equals(dog.name) && this.type.equals(dog.type) && this.age== dog.age;
        }
        return super.equals(obj); // 不是同一类型，调用父类equals方法比较 【对称性】
    }
}
public class Husky extends Dog{ // 哈士奇
    public String temper; // 脾气

    public Husky(String name, String type, int age, String temper) {
        super(name, type, age);
        this.temper = temper;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){ // 【非空性】
            return false;
        }
        if(obj==this){ // 【自反性】
            return true;
        }
        if(obj instanceof Husky) { // 【一致性 / 传递性】
            Husky husky = (Husky) obj; // 如果不是 Husky 及其子类，就不会进入这个判断，比如其父类，就直接调用父类 equals 方法
            return this.temper.equals(husky.temper) && super.equals(obj);
        }
        return super.equals(obj); // 【对称性】 父类，就直接调用父类 equals 方法
    }
}
public class Test {
    public static void main(String[] args) {
        Dog dog1 = new Dog("大黄", "中华田园犬", 5);
        Dog dog2 = new Dog("小白", "哈士奇", 3);
        Dog dog3 = new Dog("大黄", "中华田园犬", 5);
        Dog dog4 = new Dog("大黄", "中华田园犬", 5);

        Husky husky1 = new Husky("小白", "哈士奇", 3, "暴躁");
        Husky husky2 = new Husky("小黑", "哈士奇", 3, "温和");
        Husky husky3 = new Husky("小白", "哈士奇", 3, "温和");

        System.out.println(dog2.equals(husky1));
        System.out.println(husky1.equals(dog2));
        System.out.println(husky2.equals(dog2));
        System.out.println(dog2.equals(husky2));

        System.out.println(husky2.equals(husky3));

//        System.out.println(dog1.equals(dog1)); // 自反性
//
//        System.out.println(dog2.equals(dog1)); // 对称性
//        System.out.println(dog1.equals(dog2));
//
//        System.out.println(dog1.equals(dog3)); // 传递性
//        System.out.println(dog3.equals(dog4));
//        System.out.println(dog1.equals(dog4));
//
//        System.out.println(dog1.equals(null)); // 非空性
    }
}
```

3. hashCode 方法

hashCode方法: hashcode(哈希码|散列码)是一种编码方式，在Java类中，每个对象都会有一个hashcode，java可以通过hashcode来识别一个对象。如果没有重写，通常将内存地址转换为int数组进行返回。

通过hashCode方法，获取到一个int值，这个值就是哈希码, 也叫散列码。作用就是确定对象在hash表中的索引位置。

建议: 重写equals方法时，要同时重写hashCode方法。

> 因为 hashCode 用来定义索引位置，以提高效率，但同时，可能会发生哈希冲突问题。当发生冲突时，就需要equals方法判断是否是重复对象。
>
> 如果只重写hashCode，当发生冲突时，即使两个对象相等，也不会判定为重复，导致存储了大量重复元素。如果只重写了equals方法，则两个相等的对象，内存地址不同，还是会产生重复元素的问题。两个方法最好同时重写，hashcode用来保证性能，equals方法用来保证可靠。

```java
@Override
    public int hashCode() {
        return Objects.hash(name, type, age);
    }
```

- 约定：如果两个对象满足 equals() 相等，那么它们的 hashCode() 必须相等。这是因为在哈希表中，如果两个对象相等，它们应该存储在同一个位置，这依赖于它们具有相同的哈希码。👍 （避免重复存储）
- 不等价性：如果两个对象不满足 equals() 相等，它们的 hashCode() 可能相等也可能不相等。但是，如果两个对象的 hashCode() 相等，还需要通过 equals() 来确定它们是否真的相等。👍

4. toString 方法

```java
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
```

- 打印对象时默认调用 Object 的toString方法，如下：一般需要进行重写

```java
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```


5. native 关键字 😕

- native 修饰的方法称为本地方法；
- native方法是 java 和其他语言协作的时候来使用的，底层不是iava实现,是由c、c++实现；
- native不是java实现，所以直接调用就可以，不需要管底层如何实现；
- navtive方法是java用于调用底层操作系统的方法，java只能调用，不能查看和修改；
- java是跨平台语言，面向应用层，失去对底层的控制，想要调用底层的方法，就必须使用 native 方法间接调用底层操作系统的方法；
- 随着java的不断发展，native 方法会减少；
- native 是一个关键字，修饰的方法，只声明，不实现；
- native 方法加载到本地栈中。

6. clone 方法 👍

- 方法由 native 关键字修饰；
- 方法由 protected 修饰，一个类要重写clone方法，需要将访问修饰符改成 public，保证其他所有的类都能够访问这个类的clone方法；
- 作用: 创建出一个和当前类相同类型的对象，将当前对象复制一份，并且属性相同，得到一个当前对象的副本，两个对象指向不同的内存地址；
- clone 有浅拷贝和深拷贝区分，对于引用类型的性，要使用深拷贝做处理： ❤️
  - 浅拷贝：重写时直接调用Object的clone方法，多于基本类型字段复制值，对于引用类型字段复制引用地址；
  - 深拷贝：重写时基本类型字段使用Object的clone方法复制值，引用类型字段复制地址。
- 代码编写要求:
  - 必须要实现 Cloneable 接口
  - 重写 clone 方法，使用 public 修饰
  - 要处理 CloneNotsupportedException 异常

```java
public class Student implements Cloneable{ // 实现 Cloneable 接口，这是一个声明，只有实现了这个接口才可以使用clon
    public String name;
    public Book book;
    public Student(String name, Book book) {
        this.name = name;
        this.book = book;
    }
    @Override
    public Object clone() throws CloneNotSupportedException { // 改为 public 方法，并向上抛出 CloneNotSupportedException 异常
        // 【注意：这里是安全的父类强转子类，因为super这里调用的是父类方法，但是其运行的实例对象是子类类型】
        Student student =  (Student) super.clone(); // 调用Object的clone方法，处理基本类型字段
        student.book = (Book) book.clone(); // 处理引用类型字段
        return student;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", book=" + book.toString() +
                '}';
    }
}
public class Book implements Cloneable {
    public String name;
    public int price;
    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 只有基本类型字段，调用Object的clone方法即可，属于浅拷贝
    }
}
public class TestClone {
    public static void main(String[] args) {
        Student student1 = new Student("李白", new Book("《计算机组成原理》", 12));
        try { // 捕捉异常
            // 【注意：这里是安全的父类强转子类，因为super这里调用的是父类方法，但是其运行的实例对象是子类类型，可以安全地转为子类，没有问题】
            Student student2 = (Student) student1.clone(); // 由于调用父类的clone方法，返回是Object类型，这里需要强转成Student
            student2.book.name = "《数据结构》";
            System.out.println(student1);
            System.out.println(student2);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```


7. 包装类 Wrapper

- 基本数据类型(8种),不是对象，提供了包装来，将基本数据类型封装成对象来操作；
- 基本数据类型通过包装类能够完成相互转换(除去boolean)，和String类做转换；
- 包装类中还包括了基本数据类型相关处理的属性和其他方法。

> 🔴 获取最大值MAX_VALUE、最小值MIN VALUE
> 🔴 转换:
>
> - 自动拆箱: 将包装类转成基本数据类型
> - 自动封箱: 将基本数据类型转成包装类
>   - 将字符串转换成包装类，调用Xxx.value0f()方法;
>   - 将包装类转成基本数据类型(自动拆箱)xxxValue()方法;
>   - 将字符串转成基本数据类型，Xxx.parseXxx()方法;
>   - 将包装类转成字符串，toString() / String.valueOf();
> - compare()比较方法: 相同为0，前边小为负，前边大为正
> - toBinaryString() 二进制转换

Integer 有缓存处理 IntegerCache，-128到127之间，在此范围内，使用==判断，会得到true，超过此范围，返回为false，应该使用equals来判断值是否相等。❤️ 

```java
public class TestWrapper {
    public static void main(String[] args) {
        int x = 10;
        Integer y = Integer.valueOf(x); // 基本类型转包装类
        int z = y.intValue(); // 包装类转基本类型
        Character c = 's';
        char cc = c.charValue();
        String xs = String.valueOf(x); // 基本转字符串
        String ys = y.toString(); // 包装类转字符串
        String str = "123";
        int xstr = Integer.parseInt(str); // 字符串解析为基本类型

        Integer num1 = 128;
        Integer num2 = 128;
        Integer num3 = 125;
        Integer num4 = 125;
        System.out.println(num1==num2); // false
        System.out.println(num1.equals(num2)); // true
        System.out.println(num3==num4); // true
        System.out.println(num3.equals(num4)); // true
    }
}
```
