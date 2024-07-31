# Stream API

> JDK 8.0 新增，集合更多的是数据结构的封装，主要用来存储数据。如果需要对数据进行多次加工(比如:筛选、排序、聚合等)，可以使用Stream API 将要处理的元素集合看作是一种流，在流的过程中，借助Stream API对流中的元素进行操作整个流操作就是一条流水线，将元素放在流水线上一个个地进行处理。Stream 实质上是对集合对象功能的增强，用来进行各种方便高效的操作。过程就像工人在流线上加工一样。我们只需要告诉流你的要求，流便全在背后自行根据要求元素进行处理，而我们只需要得到最后的结果就可以了。

> 配合lambda表达式使用

```java
public class TestStream {
    public static void main(String[] args) {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero("盖伦", 7000));
        list.add(new Hero("露娜", 5000));
        list.add(new Hero("后羿", 4000));
        list.add(new Hero("孙悟空", 6000));
        Stream<Hero> stream = list.stream(); // 将list转为stream接口; 链式编程
        Stream<Hero> stream1 = stream.filter(hero -> hero.getBlood() >= 5000);// filter 中的参数是断言型接口, 返回值仍然是 Stream
        List<Hero> newList = stream1.collect(Collectors.toList());
        newList.forEach(System.out::println);
        List<Hero> newList1 = list.stream().filter(hero -> hero.getBlood()>=5000).map(hero -> { // map 的参数是Function接口，有参数有返回值
            hero.setBlood(hero.getBlood()-500);
            return hero;
        }).collect(Collectors.toList());
        newList1.forEach(System.out::println);
    }
}
class Hero{
    private String name;
    private Integer blood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public Hero(String name, Integer blood) {
        this.name = name;
        this.blood = blood;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", blood=" + blood +
                '}';
    }
}
```

### 一、Stream 的创建

1. 通过 Collection 接口的 stream() 方法使用集合创建流(Collection内置有stream方法);
2. 使用 Arrays.stream(T[] array) 方法使用数组创建流；
3. 使用 StreamAPI 中的静态方法来创建流；
4. Files类的方法来创建流；

```java

public class TestCreateStream {
    public static void main(String[] args) throws IOException {
        // 1. 通过 Collection 接口的 stream() 方法使用集合创建流(Collection内置有stream方法);
        List<String> list = Arrays.asList("aa", "bb", "cc");
        Stream<String> stream1 = list.stream();
        // 2. 使用 Arrays.stream(T[] array) 方法使用数组创建流；
        String[] strs = {"aa", "bb", "cc"};
        Stream<String> stream2 = Arrays.stream(strs);
        // 3. 使用 StreamAPI 中的静态方法来创建流；
        // 3.1. 有限流
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        // 3.2. 无限流 - 迭代 / 可以用 limit 加以限制
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2); // 从 0 开始
//        stream4.forEach(System.out::println);
        Stream<Integer> stream5 = Stream.iterate(0, x -> x + 2).limit(10);
        stream5.forEach(System.out::println);
        // 3.3. 无限流 - 生成 / 可以用 limit 加以限制
        Stream<Double> stream6 = Stream.generate(Math::random).limit(10);
        stream6.forEach(System.out::println);
        // 3.4 Stream concat 方法合并流
        Stream<String> stream7 = Arrays.stream(new String[]{"aa", "bb", "cc"});
        Stream<String> stream8 = Arrays.stream(new String[]{"aa", "bb", "cc"});
        Stream<String> stream9 = Stream.concat(stream7, stream8);
        // 4. 文件流
        Stream<String> stream10 = Files.lines(Path.of("javabase/resource/data.txt"));
        stream10.forEach(System.out::println);
    }
}
```

---

### 二、Stream 分类和特性

#### 分类

1. 中间操作：每次操作返回一个新的流，可以有多个中间操作；
2. 终端操作：每个流只能进行一次终端操作，终端操作结束后，流无法再次使用，终端操作会产生一个新的值或集合；

#### 特性

1. 不存储数据，按照给定的规则，对数据进行加工计算，一般会输出结果或得到一个新的集合；
2. 不会改变数据源，通常情况下会产生一个新的集合或一个值；
3. 具有延迟执行特性。只有调用终端操作时，中间操作才会执行；👍

#### 与集合的差别

> 1. 什么时候进行计算？
>
> - 集合框架，里面包含当前数据结构中所有的值，我们可以对集合进行增加、删除、修改、检索数据的操作，集合中的元素都是已经计算好的；
> - 流是按需计算，是在用户要求的时候才会计算值；
>
> 2. 外部迭代和内部迭代
>
> - 集合使用外部迭代方式；
> - Stream使用内部迭代方式；

---

### 三、Optional 容器

> - JDK8 版本引入的一个新的容器类，可以代表一个值存在或不存在，不用返回容易出问题的 NullPointerException;
> - Optional 可以含有对象，也可以为空；

#### 常用方法

- empty(): 创建一个空的 Optional；
- of(T t): 创建一个Optional，存储T对象，非空值，如果元素为空，报空指针异常；
- ofNullable(T t):创建一个Optional，存储T对象，可以有空值，如果元素为空，报NoSuchElementException异常；
- get(): 获取Optional中的value值；
- isPresent(): 判断值是否存在，存在返回 true,否则返回 false；
- isEmpty(): 判断值是否存在，不存在返回 true，否则返回 false, 在 JDK11 及以上版本使用；
- orElse(T t): 如果值不为空，则返回值，否则返回给定默认值；
- orElseGet(Supplier): 如果值不为空，则返回值，否则，会执行作为参数传入的supplier接口，并将返回执行结果;

#### 总结

1. 解决什么问题？

> 解决java系统中出现的空指针异常的情况，简化if else对于对象是否为空的判断

2. 不能解决的问题？

> 不能避免所有空指针异常

3. 什么时候使用 Optional？

> - 主要用途作为返回类型。获取返回类型的实例后，可以提取里面的值(在有值的情况下)，也可以提供其他操作(没有值)；
> - 和 StreamAPI 相结合使用；

4. 什么时候不能使用？

> 不要将其用在类中的字段类型，Optional不能序列化 👍
>
> 不要将其用在构造函数和方法的参数上。

```java
public class TestOptional {
    public static void main(String[] args) {
//        Stream<String> stream = Arrays.asList("aa", "bb", "cc").stream();
//        Optional<String> first = stream.findFirst();
//        Optional<String> optional = Optional.empty(); // 返回一个空的Optional实例对象
//        System.out.println(optional.get()); // 空的实例get获取不会报空指针异常，而是返回 NoSuchElementException: No value present
        Optional<String> optional1 = Optional.of("aaa");
        System.out.println(optional1.get());
//        Optional<String> optional2 = Optional.of(getValue()); // of 要求返回非空值，否则会报空指针异常 NullPointerException
//        System.out.println(optional2.get());
        Optional<String> optional3 = Optional.ofNullable(getValue()); // ofNullable，可以返回空值. 为空时报异常 NoSuchElementException: No value present
        boolean present = optional3.isPresent(); // 同样需要判断是否为空
        if(present)
            System.out.println(optional3.get());
        System.out.println(optional3.orElse("hi")); // 返回值如果存在就输出，否则给出默认值，简化判断
        System.out.println(optional3.orElseGet(()->"hi"));

        Student student = new Student("杜甫", 20);
        Optional<Student> optional4 = Optional.ofNullable(student);
        System.out.println(optional4.orElse(new Student("李白", 18))); // orElse 无论Optional是否为空，都执行
        System.out.println(optional4.orElseGet(()->new Student("李白", 18))); // orElseGet 只有当Optional为空才执行，否则不执行

    }

    public static String getValue() {
        double d = Math.random();
        return d > 0.5 ? "hello" : null;
    }
}

class Student{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        System.out.println("执行了Student构造方法");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

---

### 四、流的操作

#### 1. 遍历/匹配/查找

- foreach: 遍历操作；
- findFirst: 查找第一个数据，返回Optional；
- findAny: 查找任意元素，返回Optional，如果是stream，返回第一个元素，相当于findFirst，如果使用的是 parallelstream，返回随机一个元素；
- anyMatch: 只要有一个元素符合判断条件，则返回true，否则返回false；
- noneMatch: 每个元素都不符合判断条件，则返回true，否则返回false；
- allMatch: 每个元素都符合判断条件，则返回true，否则返回false；

```java
public class TestUseStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 30, 40, 50, 60, 70, 80);
        // 遍历
        list.stream().forEach(System.out::println);
        // 查找 1
        Integer integer = list.stream().filter(x -> x > 40).findFirst().orElse(-1);
        System.out.println(integer);
        // 查找 2
        Optional<Integer> any = list.stream().filter(x -> x > 40).findAny(); // 单流
        System.out.println(any.orElse(-1));
        Optional<Integer> any1 = list.parallelStream().filter(x -> x > 40).findFirst(); // 并行流
        Optional<Integer> any2 = list.parallelStream().filter(x -> x > 40).findAny(); // 并行流
        System.out.println(any1.orElse(-1));
        System.out.println(any2.orElse(-1));
        System.out.println("---> " + list.stream().findAny().orElse(-1));
        // 匹配
        boolean b1 = list.stream().allMatch(x -> x > 40);
        boolean b2 = list.stream().anyMatch(x -> x > 40);
        boolean b3 = list.stream().noneMatch(x -> x > 40);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
```

#### 2. 过滤与切片

> 属于中间操作

> 过滤: 也称作筛选，是按照于定的规则校验流中的元素，将所有符合条件的元素提取到一个新的流中的操作；
>
> 切片: 从集合中取出一部分相应的元素重新组成一个集合；
>
> - 将集合截断：limit(long maxSize) 操作, 截断流，最大长度不超过 maxSize;
> - 在集合中跳过指定元素：skip(long n) 操作, 跳过前面元素，从第n个元素获取；
> - 去重：distinct 操作，根据 equals 和 hashcode 方法进行比较，是否重复；

```java
public class TestFilter {
    public static void main(String[] args) {
        // 对基本数据类型的过滤
        Stream<Integer> stream = Stream.of(4, 3, 5, 7, 8, 9, 100, 20);
        stream.filter(x -> x > 10).forEach(System.out::println);
        System.out.println("----------");
        // 对引用类型的过滤
        List<Student> list = new ArrayList<>();
        list.add(new Student("张飞", 18));
        list.add(new Student("李白", 20));
        list.add(new Student("杜甫", 22));
        list.add(new Student("李商隐", 20));
        list.add(new Student("李商隐", 20));
        list.add(new Student("杜康", 16));
        list.add(new Student("杜康", 16));
        list.stream().filter(student -> student.getName().length() > 2).forEach(System.out::println);
        System.out.println("----------");
        // 切片 -> limit 截断
        list.stream().filter(student -> student.getAge() >= 18).limit(2).forEach(System.out::println); // 截取前两个，不足两个时获取全部
        System.out.println("----------");
        // 切片 -> skip 跳过
        list.stream().filter(student -> student.getAge() >= 18).skip(2).forEach(System.out::println); // 跳过前两个，超过全部大小则返回空流
        // 切片 -> distinct 去重
        System.out.println("----------");
        list.stream().distinct() // 依赖于 hashcode 与 equals
                .forEach(System.out::println);
    }
```

#### 3. 聚合操作

> 属于终端操作

- 取最大值

  - max(new Comparator< T >)
- 取最小值

  - min(new Comparator< T >)
- 统计个数

  - count

```java
public class TestAggregate { // 测试流聚合
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bb", "ccccccccccc", "ddd", "eeeeeee", "f");
        // 获取最大长度字符串
        Optional<String> max = list.stream().max(Comparator.comparingInt(String::length));
        max.ifPresent(System.out::println);
        // 获取最小长度字符串
        Optional<String> min = list.stream().min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);
        // 过滤并统计个数
        long count = list.stream().filter(s -> s.length()>=3).count();
        System.out.println(count);
    }
}
```

#### 4. 映射操作

> 属于中间操作

1. map映射操作

> map直接操作数据源，若是引用类型，则原有数据会改变

接收一个函数作为参数，这个函数会被应用到每个元素上，并将其映射成一个新的元素，用于转换其他形式或提取信息。

```java
public class TestMapping {
    public static void main(String[] args) {
        // map 映射操作基本数据类型 【转换】
        List<Double> list = Arrays.asList(3.1415, 1.1234, 8.8765, 4.4321, 7.521, 0.912); // 包装类是 final 不可改变
        list.stream().map(TestMapping::k2).forEach(System.out::println);
        list.forEach(System.out::println);
        System.out.println("------------");
        // map 映射操作引用数据类型 【提取】
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 18));
        list1.add(new Student("李白", 20));
        list1.add(new Student("杜甫", 22));
        list1.stream().map(Student::getName).forEach(System.out::println);
        System.out.println("------------");
        // map 映射操作引用数据类型 【修改】 改变数据源的数据
        list1.stream().map(student -> {
            student.setName("AKA: " + student.getName());
            return student;
        }).forEach(System.out::println);
        list1.forEach(System.out::println);
        System.out.println("------------");
        // map 映射操作引用数据类型 【修改】 不改变数据源的数据
        list1.stream().map(student -> {
            Student student1 = new Student(student.getName(), student.getAge() + 2);
            return student1;
        }).forEach(System.out::println);
        list1.forEach(System.out::println);

    }
    public static double k2(double x){ // 保留两位小数
       return  (int)((x*100)+0.5) / 100d;
    }
}
```

2. flatMap 映射

接收一个函数作为参数，将流中的每个值都换成另一个流，把所有流连接成一个流。

```java
public class TestFlatMap {
    public static void main(String[] args) {
        String str = "a,b,c,d,e";
        f(str).forEach(System.out::println);
        String str1 = "1,2,3,4,5";
        List<String> list = Arrays.asList(str1, str);
        Stream<Stream<String>> streamStream = list.stream().map(TestFlatMap::f);
        streamStream.forEach(s->s.forEach(System.out::println));
        System.out.println("---------");
        list.stream().flatMap(TestFlatMap::f).forEach(System.out::println); // 所有返回的流合成一个流
    }

    public static Stream<String> f(String string) {
        String[] strs = string.split(",");
        return Arrays.stream(strs);
    }
}
```

3. mapToInt mapToLong mapToDouble

以一个映射函数为参数，将流中每一个元素处理后成生一个新流；三个函数生成新的流之后，可以进行很多后续操作，如求最大值、最小值、求和、求平均值、统计个数等；

```java
public class TestMapToX {
    public static void main(String[] args) {
        // 数值
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 2, 4, 6, 8);
        list.stream().mapToInt(x -> x * 10).forEach(System.out::println); // mapToInt 必须返回 int
        System.out.println("----------");
        // 非数值
        List<String> list1 = Arrays.asList("aaaa", "bbb", "c");
        list1.stream().mapToInt(String::length).forEach(System.out::println);
        int sum = list1.stream().mapToInt(String::length).sum();
        OptionalInt max = list1.stream().mapToInt(String::length).max();
        OptionalInt min = list1.stream().mapToInt(String::length).min();
        OptionalDouble average = list1.stream().mapToInt(String::length).average();
        System.out.println("sum " + sum + " max " + max.orElse(-1) + " min " + min.orElse(-1) + " aaverage " + average.orElse(-1));
        // summary 获取所有信息 摘要
        IntSummaryStatistics intSummaryStatistics = Stream.of("1", "2", "3").mapToInt(Integer::valueOf).summaryStatistics();
        System.out.println(intSummaryStatistics);
        // 范围生成流
        int sum1 = IntStream.rangeClosed(1, 100).sum(); // 左右闭区间
        int sum2 = IntStream.range(1, 100).sum(); // 左闭右开区间
        System.out.println(sum1);
        System.out.println(sum2);
        // boxed 将数值流转成 Stream
        Stream<Integer> boxed = IntStream.rangeClosed(1, 100).boxed();
    }
}
```

#### 5. 归约操作

> 属于终端操作

也称作缩减操作，是把一个流缩减成一个值，实现对集合求和、求乘积、求最大值、最小值操作。

```java
public class TestReduce {
    public static void main(String[] args) {
        // 基本数据类型
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        // 使用归约 1
        stream.reduce(Integer::sum).ifPresent(System.out::println);
        // 使用归约 2
        Integer reduce = stream1.reduce(0, Integer::sum); // 有一个初始值
        System.out.println(reduce); // 在流上不能进行两次流操作
        // 乘积
        stream2.reduce((x, y) -> x * y).ifPresent(System.out::println);
        // 最大值
        stream3.reduce((x,y)->x>y?x:y).ifPresent(System.out::println);
        // 引用类型
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 18));
        list1.add(new Student("李白", 20));
        list1.add(new Student("杜甫", 22));
        // 求和
        Integer reduce1 = list1.stream().reduce(0, (sum, student) -> sum += student.getAge(), Integer::sum);
        System.out.println(reduce1);
        Integer reduce2 = list1.stream().map(Student::getAge).reduce(0, Integer::sum);
        System.out.println(reduce2);
    }
}
```

#### 6. 排序操作

> 属于中间操作

- sorted(): 自然排序，要求流中元素要实现 Comparable 接口；
- sorted(Comparator comparator): 自定义排序；

```java
public class TestSorted {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("李白", 18));
        list1.add(new Student("阿甫ssa", 22));
        list1.add(new Student("卜甫s", 22));
        list1.add(new Student("曹甫ss", 22));
        list1.stream().forEach(System.out::println);
        System.out.println("---------");
        list1.stream().sorted(Comparator.comparingInt(Student::getAge)).forEach(System.out::println); // 自定义排序
        // 多重排序
        System.out.println("---------");
        list1.stream().sorted(Comparator.comparingInt(Student::getAge).thenComparingInt(x -> x.getName().length())).forEach(System.out::println);
        // 顺序反转
        System.out.println("---------");
        list1.stream().sorted(Comparator.comparingInt(Student::getAge).reversed()).forEach(System.out::println);
    }
```


#### 7. 收集操作

> 属于最终操作

把一个流收集起来，最终可以是收集成一个值，也可以收集成一个新的集合；因为流不存储数据，如果流操作完成之后，还想继续使用这些经过处理的数据，需要放到一个新的集合中，toList、toSet、toMap、toCollection等相关操作；

- 生成新的集合;
- 统计与计算；

```java
public class TestCollect {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("李白", 18));
        list1.add(new Student("李上瘾", 18));
        list1.add(new Student("曹操", 22));

        // toList
        List<Student> list2 = list1.stream().filter(student -> student.getName().startsWith("李")).collect(Collectors.toList());
        System.out.println(list2);
        // toSet
        Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println(set);
        // toMap
        Map<String, Integer> map = list1.stream().filter(student -> student.getName().startsWith("李")).collect(Collectors.toMap(Student::getName, Student::getAge));// key val
        System.out.println(map);
        // toCollection
        ArrayList<String> collect = Stream.of("aa", "ss", "fff").collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);

        // 统计
        Long aLong = list1.stream().filter(x -> x.getName().startsWith("李")).collect(Collectors.counting());
        Long aLong1 = list1.stream().filter(x -> x.getName().startsWith("李")).count();
        System.out.println(aLong);
        System.out.println(aLong1);
        // 最值
        Optional<Student> collect1 = list1.stream().filter(x -> x.getAge() > 18).collect(Collectors.maxBy(Comparator.comparingInt(Student::getAge)));
        Optional<Student> collect2 = list1.stream().filter(x -> x.getAge() > 18).max(Comparator.comparingInt(Student::getAge));
        System.out.println(collect1.orElse(null));
        System.out.println(collect2.orElse(null));
        // 求和
        Integer collect3 = list1.stream().collect(Collectors.summingInt(Student::getAge));
        int sum = list1.stream().mapToInt(Student::getAge).sum();
        System.out.println(collect3);
        System.out.println(sum);
        // 均值
        Double collect4 = list1.stream().collect(Collectors.averagingDouble(Student::getAge));
        OptionalDouble average = list1.stream().mapToInt(Student::getAge).average(); // 先转为数值流
        System.out.println(collect4);
        System.out.println(average.orElse(-1));
        // 摘要
        IntSummaryStatistics collect5 = list1.stream().collect(Collectors.summarizingInt(Student::getAge));
        IntSummaryStatistics intSummaryStatistics = list1.stream().mapToInt(Student::getAge).summaryStatistics();
        System.out.println(collect5);
        System.out.println(intSummaryStatistics);
    }
}
```


#### 8. 分组操作

> 仍然属于【收集】范畴，属于最终操作

- 分区: partitioningBy，只能分成两组，符合条件的是一组，不符合条件的是另一组；
- 分组: groupingBy，将集合分成多个Map，如可以按员工年龄分组，或者按工资；

```java
public class TestPartitionGroup {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("张飞", 18));
        list1.add(new Student("李白", 19));
        list1.add(new Student("李白", 16));
        // 分区
        Map<Boolean, List<Student>> collect = list1.stream().collect(Collectors.partitioningBy(x -> x.getAge() >= 18));
        collect.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        // 分组
        Map<String, List<Student>> collect1 = list1.stream().collect(Collectors.groupingBy(Student::getName)); // 按名字分组
        collect1.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        Map<Integer, List<Student>> collect2 = list1.stream().collect(Collectors.groupingBy(Student::getAge)); // 按年龄分组
        collect2.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        System.out.println("----------");
        // 多重分组，先名字，后按年龄
        Map<String, Map<Integer, List<Student>>> collect3 = list1.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getAge)));
        collect3.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((x, y) ->{
                System.out.println(x);
                y.forEach(System.out::println);
            });
        });
        // 按年龄分组，返回自定义键
        Map<String, List<Student>> collect4 = list1.stream().collect(Collectors.groupingBy(student -> {
            if (student.getAge() >= 18) return "成年";
            else return "未成年";
        }));
        System.out.println("----------");
        collect4.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }
```

#### 9. 拼接操作

> 仍然属于【收集】范畴，属于终端操作

可以将Stream 中的元素，按指定的特殊符号进行拼接，得到一个字符串；

```java
public class TestJoin {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("李白", 18));
        // joining 无参拼接
        String collect = list1.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println(collect);
        // 一个参数，连接符号
        String collect1 = list1.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.println(collect1);
        // 三个参数：连接符号，前缀，后缀
        String collect2 = list1.stream().map(Student::getName).collect(Collectors.joining(",","AKA: ","@"));
        System.out.println(collect2); // 是拼接后的整个字符串添加前缀和后缀
    }
```


2222
