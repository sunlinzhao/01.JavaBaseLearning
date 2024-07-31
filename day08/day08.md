1. Math类

- Math类中提供了大量用于数学运算的相关方法。
- Math类是使用final修饰的终结类，不能产生子类。
- Math类中的方法都是static修饰的静态方法，可以通过类名.方法名直接调用。

2. Random类

java.util下有一个Random类，根据随机算法的起源数字（种子）进行一些迭代变化，来产生随机数。

虽然Random类产生的数字是随机的，但在相同种子数下的相同次数产生的随机数是相同的。（伪随机）

> - Random(): 以系统自身的时间为种子类来构造Random对象
> - Random(long): 可以自己来选定具体的种子数来构造Random对象
> - nextInt():获取int类型的随机数
> - nextlnt(int):获取0(包含)到给定值(不包含)之间的随机数
> - nextlong():获取long类型的随机数
> - nextFloat():获取一个随机单精度浮点数0到1之间
> - nextDouble():获取一个随机双精度浮点数 0到1之间
> - nextBoolean(): 返回一个随机boolean类型的值

3. BigInteger 和 BigDecimal

BigInteger可以支持任意长度的整数；BigDecimal可以支持任意精度的浮点数；用于作精确计算

> divideAndRemainder(): 求除法商和余数，返回的是BigInteger数组

```java
public class TestBigInteger {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("123456789123456789");
        System.out.println(bi1);

        BigInteger bi2 = BigInteger.valueOf(123456789L);
        System.out.println(bi2);

        double d1 = 3.14;
        int x = 10;
        System.out.println(d1*x);

        BigDecimal bd1 = new BigDecimal("3.14");
        BigDecimal bd2 = new BigDecimal("10");
        System.out.println(bd1.multiply(bd2));;

        System.out.println(bd1.intValue());
        System.out.println(bi2.intValue());

        BigDecimal bd3 = bd1.divide(bd2, RoundingMode.UP);
        System.out.println(bd3);

        BigDecimal[] bds = bd1.divideAndRemainder(bd2);
        System.out.println(bds[0]);
        System.out.println(bds[1]);
    }
}
```

4. 枚举类 Enum

Enum枚举: 列举，从给定的值中列举，通常都是有固定值，只能从固定值中去做选择。

> 语法: 定义: [修饰符] enum 枚举名 {}

- 所有枚举类型，实际上是继承了 java.lang.Enum 类;
- 枚举中定义的实际是常量, 枚举在switch中的应用: byte short int char string 枚举

```java
public enum Status {
    IN("入库", 1), OUT("出库", 2); // 实参
    public String show; // 给枚举量添加属性，定义枚举类对应的常量，必须是private
    public int index;
    Status() {
    }
    Status(String show, int index) { // 顺序要对应（形参）；构造函数，默认私有的
        this.show = show;
        this.index = index;
    }
    @Override
    public String toString() {
        return show + "_" + index;
    }
}
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Status.IN);
        for (Status s: Status.values()) {
            System.out.println(s);
        }
        Status s1 = Status.IN;
        Status s2 = Status.OUT;
        switch (s2){
            case IN:
                System.out.println("入库");
                break;
            case OUT:
                System.out.println("出库");
                break;
            default:
                System.out.println("未知");
        }
        System.out.println(s1.toString());
        System.out.println(Status.OUT.ordinal()); // 获取枚举成员的索引位置
        System.out.println(Status.IN.ordinal()); // 获取枚举成员的索引位置

        Status s3 = Status.valueOf("IN"); // 将字符串转换为枚举实例
        System.out.println(s3);

        System.out.println(Status.OUT.compareTo(Status.IN)); // compareTo(): 比较两个枚举成员在定义
    }
}
```

5. Timer 定时器

java.util 包下，用于定时任务

```java
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // 匿名内部类
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 0, 1000);
//        timer.cancel(); // 取消定时任务
    }
}
```

6. System 类

java.lang.System 系统

> - currentTimeMillis(): 获取从1970-01-01 00:00:00到现在的毫秒数
> - exit(0): 退出java虚拟机 0 代表正常退出，否则为异常退出
> - getenv(String): 获取指定的环境变量
> - getProperty(String): 获取系统属性
> - getProperties(): 获取所有系统属性
> - arraycopy(源,源索引,目标,目标索引,长度): 从源数组指定索引位置复制给定长度到目标数组的索引位置
> - gc(): 执行垃圾回收

```java
public class TestSystem {
    public static void main(String[] args) {
        String JAVA_HOME = System.getenv("JAVA_HOME"); // 获取环境变量
        System.out.println(JAVA_HOME);

        String p = System.getProperty("os.name"); // 获取系统属性
        System.out.println(p);

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {10, 20, 30, 40, 50};
        System.arraycopy(arr1, 2, arr2, 2, 3);
        System.out.println(Arrays.toString(arr2));
        System.gc();
    }
}
```
