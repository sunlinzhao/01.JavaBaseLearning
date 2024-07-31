package com.slz.javalearing.day10;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/11
 */
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
