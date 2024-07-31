0. 集合类介绍

- 集合和数组一样，都是用来存储多个数据的结构，也可以称作叫容器。👍
- 数组长度是不可变化的，一旦在初始化数组时指定了数组长度。这个长度不可变，如果需要处理数量变化的数据，数组就无法实现。
- 而且没有办法保存有映射关系的数据(语文-90 ，数学-80)。
- 为了保存数量不确定的数据，以及具有映射关系的数据，提供了集合类。
- 集合类主要负责保存、盛装其他数据。

所有的集合类都在java.util包下，提供了一个表示和操作对象集合的统一架构。包含大量的接口和类, 并且包含了这些接口和实现类的操作算法和数据结构。

集合与数组的区别：

> - 数组的长度不可变，集合类的长度可变;
> - 数组提供的方法有限，对于添加、删除、插入数据操作非常不方便，并且效率不高;
> - 数组中存储数据的特点是: 有序、可重复的 ，对于无序、不可重复的需求，不能满足;
> - 数组中可以存储基本数据类型，也可以存储引用类型。在集合中只能保存引用.类型(保存的是对象的引用地址);👍

在集合和数组中所指的存储，指在内存层面的存储，不涉及到持久化数据。👍

1. 自定义集合类

```java
public class MyArray {
    private Object[] elementDate; // 存储数据的数组
    private int size; // 数组存储元素个数
    private static final int DEFAULT_CAPACITY = 10; // 默认初始空间大小
    private static final Object[] EMPTY_ELEMENTDATE = {}; // 空数组

    public MyArray() {
        elementDate = new Object[DEFAULT_CAPACITY];
    }

    public MyArray(int initialCapacity) {
        if (initialCapacity > 0)
            elementDate = new Object[initialCapacity];
        else if (initialCapacity == 0) {
            elementDate = new Object[]{};
        } else {
            throw new IllegalArgumentException("数组初始化参数异常：" + initialCapacity);
        }
    }

    public int size() {
        return size;
    }

    public void add(Object obj) { // 添加
        if (size >= elementDate.length)
            elementDate = grow();
        elementDate[size] = obj;
        size++;
    }

    public void add(int index, Object obj) { // 插入
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("索引异常" + index);
        }
        if (size >= elementDate.length)
            elementDate = grow();
        System.arraycopy(elementDate, index, elementDate, index+1, size-index);
        elementDate[index] = obj;
        size++;
    }

    public Object remove(int index){ // 删除
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("索引异常" + index);
        }
        Object obj = elementDate[index];
        size--;
        if(size>index){
            System.arraycopy(elementDate, index+1, elementDate, index, size-index);
        }
        elementDate[size] = null;
        return obj;
    }

    public Object get(int index) { // 检索
        if (index < elementDate.length && index >= 0) {
            return elementDate[index];
        } else {
            throw new IllegalArgumentException("索引长度异常");
        }
    }

    public void clear() { // 清除
//        elementDate = EMPTY_ELEMENTDATE;
        int to = size;
        size = 0;
        for (int i = 0; i < to; i++) {
            elementDate[i] = null;
        }
    }

    // 扩容
    public Object[] grow() {
        return Arrays.copyOf(elementDate, elementDate.length * 2); // 每次扩容两倍
    }
}

```

2. 泛型

在我们自定义的集合类中，底层是Object类型的数组，在设计和声明时，不能确定这个容器里到底要存储什么类型的数据。从JDK5版本之后，引入一个新的特性，提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的数据类型。

泛型允许在定义类、接口时通过一个标识来表示其中某个属性的类型或者某个方法的返回值及参数类型。本质是参数化类型，给类型指定一个参数，然后在使用时再指定参数具体的值。

这种参数类型可以用在类、接口、方法中，分别称为泛型类、泛型接口和泛型方法。👍

优点：

> 1. 保证了类型的安全性：如果没有使用泛型，在集合中存储和读取数据，都是Obiect类型，要将数据读取成特定类型，需要对每一个对象进行强制转换，如果存储的对象数据类型错误，在转换时会报异常；
> 2. 消除强制转换：使代码可读性更强，减少出错机会；
> 3. 避免了不必要的拆箱封箱操作；
> 4. 提高代码复用性；

3. 泛型类

> 把泛型定义在类上，格式: `public class 类名<泛型>`

- 泛型类型必须是引用类型，基本数据类型不可以定义泛型类;
- 在类后添加一对尖括号，在尖括号中填类型参数，参数可以有多个，多个参数使用逗号分隔；public class 类名<A,B,C>
- 规范泛型使用字母的表示信息 👍

  > - T: Type (java类)
  > - E: Element (在集合中使用，指集合中存放的元素)
  > - K: Key (键)
  > - V: Value (值)
  > - N: Number(数值类型)
  > - ?: 表示不确定的java类型
  >

4. 泛型接口

> 把泛型定义在接口上，格式: `public interface 接口名<泛型>`

```java
public interface GenericInterface<T> {
    void show(T val);
}
class impl1 implements GenericInterface<String>{ // 这种实现不够灵活，只能指定某一种类型的实现
    @Override
    public void show(String val) {
        System.out.println(val);
    }
}
class impl2<T> implements GenericInterface<T>{ // 直接用泛型类去实现泛型接口，更加灵活，等到实例化时才需要指定类型
    @Override
    public void show(T val) {
        System.out.println(val);
    }
}
public class TestGenericInterface {
    public static void main(String[] args) {
        GenericInterface<String> genericInterface1 = new impl1();
//        GenericInterface<Integer> genericInterface2 = new impl1(); // 报错；实现1不够灵活
        GenericInterface<Integer> genericInterface3 = new impl2<>(); // 实现2足够灵活
        GenericInterface<String> genericInterface4 = new impl2<>();
    }
}
```

5. 泛型方法

在调用方法时指明泛型的具体类型(参数和返回值) // 泛型符`<T>`应该放在所有修饰符之后

> 定义格式:
>
> - 没有返回值类型，有参数： `public <T> void 方法名(T t){}`
> - 有返回值类型，可以有参数，也可以无参数：`public <T> T 方法名([T t]){}`

```java
public class TestGenericFunc { // 测试泛型方法
    public static void main(String[] args) {
        fun1("hello");
        System.out.println((String) fun2());
        System.out.println(fun3("hello"));
    }
    public static <T> void fun1(T t){
        System.out.println(t);
    }
    public static <T> T fun2(){
        return (T) "hello";
    }
    public static <T> T fun3(T t){
        return t;
    }
}
```

6. 泛型

用于解决泛型之间引用 传递的特殊语法，主要分成三种情况：

> - `<?>`: 无边界的通配符
>   - 主要做用是让泛型能够接受未知类型的数据；
>   - 没有赋值之前表示可以接受任何的数据类型；
>   - 赋值之后，不能往里面随便添加元素；
>     - 因为不知道集合的数据类型，只能做读取操作，并且把读到元素当成Object实例操作，但是可以去执行revome移除和clear清空操作。
>     - 用于编写可使用Obiect类中提供的功能使用方法时。
>     - 代码不依赖于类型参数的泛型类方法中。👍
> - `<? extends E>`：固定上边界的通配符；
>   - 协变: 在使用父类类型场景的地方可以故用子类类型
>   - 逆变: 在使用子类类型场景的地方可以使用父类类型
>   - 不变: 不能做到以上两点
>   - 数组是可以协变的，泛型不是协变的；为了解决这个问题，设计出固定上边界的通配符；能够接受指定类及其子类类型的数据。👍
>   - 虽然用的是 extends 关键字，但不限于继承了父类的子类，也可以使用接口的实现类；
>   - 使用上界通配符只能从集合中获取值，而不能将值放入集合中；
> - `<? super E>`: 固定下边界的通配符；
>   - 接受指定类及其父类类型(或者接口)的数据;
>   - 可以读取到集合的数据，按照Object类型处理;
>   - 使用下界通配符可以添加指定类或其子类类型的对象，不能填加父类或接口类型的对象；

> 1. 如果要从集合中获取值，使用上限通配符
> 2. 如果要向集合中放入数据值，使用下限通配符
> 3. 可以为通配符指定上限，也可以指定下限，但不能同时指定两者

```java
public class TestWildcard {
    public static void main(String[] args) {
        Generic1<String> generic1 = new Generic1<>("123");
        func1(generic1);
        Generic1<Integer> generic2 = new Generic1<>(123);
        func1(generic1);

        Generic1<B> bGeneric1 = new Generic1<>(new B());
        Generic1<C> cGeneric1 = new Generic1<>(new C());

        Generic1<Y> yGeneric1 = new Generic1<>(new Y());
        Generic1<Z> zGeneric1 = new Generic1<>(new Z());

        Generic1<A> aGeneric1 = new Generic1<>(new A());
        Generic1<X> xGeneric1 = new Generic1<>(new Y());
    }

    public static void func1(Generic1<?> generic1){ // 无边界通配符
        System.out.println(generic1.t);
    }
    public static void func2(Generic1<? extends A> generic1) { // 固定上边界通配符 / 子类
        System.out.println(generic1.t);
//        generic1.t = new A(); 使用上限通配符只能从集合中获取值，而不能将值放入集合中；
    }
    public static void func3(Generic1<? extends X> generic1) { // 固定上边界通配符 / 实现类
    }
    public static void func4(Generic1<? super C> generic1) { // 固定下边界通配符 / 父类
        Object obj = generic1.t; // 可以读取到集合的数据，按照Object类型处理;
        System.out.println(obj);
        generic1.t = new C(); // 使用下界通配符可以添加指定类或其子类类型的对象，不能填加父类或接口类型的对象；
    }
    public static void func5(Generic1<? super Z> generic1) { // 固定下边界通配符 / 接口
    }
}

class Generic1<T> {
    public T t;
    public Generic1(T t) {
        this.t = t;
    }
}

class A {}
class B extends  A {}
class C extends B {}

interface X{}
class Y implements X{}
class Z implements X{}
```
