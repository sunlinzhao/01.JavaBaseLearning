1. LinkedList 链表

> 存储结构:
>
> - ArrayList: 底层是数组结构，线性顺序存储
> - LinkedList: 底层是链表结构，非连续，非顺序的存储，对象间是依靠指针域串连起来
>
> 操作性能:
>
> - ArrayList: 适合随机查询数据的操作
> - LinkedList: 适合元素的插入删除操作

```java
public class TestLinkList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        linkedList.addFirst("000");
        linkedList.addLast("999");
        linkedList.add(0, "666");
        for (String s : linkedList) {
            System.out.println(s);
        }
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove("ccc");
    }
}
```

2. Vector 向量

和 ArrayList 处理方式底层都是使用数组结构完成。

> 比较：
>
> - ArrayList在构造方法时，创建的大小为0，当第一次加入元素时，进行扩容。Vector在构造方法时创建的大小为10；
> - ArrayList每次扩容都是原有大小的1.5倍，Vectory扩容时，如果给定了capacityincrement，则新的数组大小为原有数组大小+capacityIncrement，否则扩容为原有大小的2倍；
> - ArrayList 非线程安全，Vector是线程安全的。（但是Vector很少使用了，有其他方式保证线程安全，如 Collections.synchronizedList(list)）；

3. HashSet 哈希表

散列表，也叫哈希表，是根据键和值而直接进行访问的数据结构，可以不经过任何比较，一次直接从表中得到要搜索的元素。通过一种函数使用元素的存储位置和它的键值建立一个映射关系，加快查找的速度，这个函数就叫哈希函数或散列函数，存放记录的数组叫做哈希表。

> 由于哈希函数设计问题，可能会产生哈希冲突:
>
> - 哈希函数:
> - 除留余数法(常用)
> - 直接定址法
> - 平方取中法
> - 折叠法
> - 随机数法
> - 数学分析法

哈希函数设计的越精妙合理，产生哈希冲突的可能性就越低，但是无法避免哈希冲突；解决哈希冲突的问题: 闭散列、开散列

> - 闭散列: 也叫开放定址法，当发生哈希冲突时，如果哈希表未被装满，说明在哈希表中还有空位置，所以，使用该方法，会下一个空位置，使用线性探测，从发生冲突的位置开始，依次向后探测，直到寻找到下一个空位置为止。
> - 开散列: 也叫链地址法或开链法，先是通过散列函数计算关键码，具有相同地址的关键码归于同一个子集合，每一个子集合称为一个桶(哈希桶)，各个桶中的元素通过一个单链表链接起来，各链表的头结点存储在哈希表中。

如果出现了极端情况，所有的数据都冲突到一个桶（链表）中，JDK1.8之后将链表改成红黑树；👍

> HashSet 底层使用 HashMap，将数据存储到hashMap的key上面：
>
> - 特点: 无序性，唯一性
> - 如果存储的数据具有相同的 hashcode，则会调用equals方法再次进行比较
> - 常用方法和 List接口相同
> - 没有List接口中的索引处理方式

```java
public class TestHash {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>(); // 唯一性， 无序性
        mySet.add("aaa");
        mySet.add("bbb");
        mySet.add("ccc");
        mySet.add("ddd"); // equals() 判澌两个数据是否等,如果相等、则将原有数覆盖
        System.out.println(mySet);
        mySet.remove("ccc");
        System.out.println(mySet);
        mySet.add("aaa");
        System.out.println(mySet);
    }
}
```

4. LinkedHashSet

> 有序性、唯一性

> HashSet 的子类，底层实现时 LinkedHashMap, 维护了一个数组 + 双向链表的方式

LinkedHashSet 是根据元素 HashCode 值来决定元素的存储位置，同时，使用链表维护元素的次序，使用元素看起来是以插入顺序保存的。👍

> LinkedHashset中维护的双向链表，每一个节点，都有before和after属性，在添加一个元素时，先求hash值，再求索引，确定这个元素在hashtable中的位置，然后再将元素加入到双向链表。在遍历时可以确保和插入的顺序相一致。不可以出现重复元素。

```java
public class TestLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("aaa");
        linkedHashSet.add("bbb");
        linkedHashSet.add("ccc");
        linkedHashSet.add("ddd");
        System.out.println(linkedHashSet);
    }
}
```

5. TreeSet

底层数据结构是一棵二叉树:

> 在放入数据时，会根据二叉树算法，将数据进行排列, 采用中序遍历，将数据读取出来。所以对于TreeSet来讲，不管放入元素的顺序是什么样的，读取出来时，都是以升序排列。

Treeset泛型里的对象，是要具有排序能力的(实现 Comparable 接口)。❤️ 如果没有实现Comparable接口的话，则需要在Treeset构造方法中，传入Comparator接口的对象。

```Java
public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(6);
        System.out.println(treeSet); // [6, 7, 8, 9]
    }
}
```

6. 排序接口

在做对象的比较排序时，使用两种方式，一种是Comparable接口，一种是Comparator接口

- Comparable
  - 使用Comparable接口的处理方式，让类实现接口，重写compareTo()方法，对其中的某个属性进行大小的比较，小于返回负数，相等返回0，大于返回正数；
  - 使用Comparator接口的处理方式，创建一个接口的实现类，重写compare()方法(传入两个对象)根据业务需求，对两个对象的属性进行比较。将实现类的对象放在TreeSet构造方法中。相当于是一个外部的比较器，更加灵活，耦合度更低一些。更多的情况，是可以使用匿名内部类或lambda表达式的方式。👍

```java
public class Staff implements Comparable<Staff> {
    private String name;
    private Integer age;

    public Staff() {
    }

    public Staff(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(name, staff.name) && Objects.equals(age, staff.age);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Staff o) {
        // 按照哪个属性进行排序
        // 小于传入参数，返回-1，相同，返回0，大于返回1
        return this.age - o.getAge();
    }
}
public class TestComparableComparator {
    public static void main(String[] args) {
        TreeSet<Staff> treeSet = new TreeSet<>(); // Comparable 实现比较
        treeSet.add(new Staff("李白", 22));
        treeSet.add(new Staff("李白", 25));
        treeSet.add(new Staff("李白", 18));
        treeSet.add(new Staff("李白", 20));
        treeSet.add(new Staff("李白", 19));
        System.out.println(treeSet);

        TreeSet<Staff> treeSet1 = new TreeSet<>(new Comparator<Staff>() { // Comparator 实现比较，匿名内部类
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getAge()-o2.getAge();
            }
        }); // Comparator 实现比较
        treeSet1.add(new Staff("李白", 22));
        treeSet1.add(new Staff("李白", 25));
        treeSet1.add(new Staff("李白", 18));
        treeSet1.add(new Staff("李白", 20));
        treeSet1.add(new Staff("李白", 19));
        System.out.println(treeSet1);
    }
}
```

7. Collections 工具类

Arrays 是针对int[] / Object[]数组的工具类(引用类型需要实现Comparable接口，或者sort传入Comparator比较器)；Collections 是针对集合类(List)的工具类；👍 

- sort(list): 按升序排列；
- sort(list, comparator): 按外部比较器规则进行排序；
- reverse(list): 按降序排列；
- shuffle(list): 随机排序；
- swap(list,int,int): 交换两个索引位置的元素；
- max(list): 获取集合中的最大值；
- min(list): 获取集合中的最小值；
- binarySearch(list，Object): 二分查找，返回索引(list必须是有序的);
- fill(list,Object): 填充，用指定的值替换list中的值；
- replaceAll(list,Object,Object): 将list集合中旧元素换成新的元素；
- frequency(collection,Object): 统计元素出现的次数 👍 collection 包括 Set 和 List集合；
- rotate(list,int): 旋转，如果第2个参数为0，则没有改变，如果为正数，则将list集合最后的几位移动到集合前面，如果为负数，则将list集合前几位元素移动到后面;
- 线程同步的处理:  ❤️
  - synchronizedCollection(collection)
  - synchronizedMap(map)
  - synchronizedList(list)
  - synchronizedSet(set)
