package com.slz.javalearing.day22;

/**
 * @author SunLZ
 * @since 1.8
 * @version 1.0
 */
@Anno1(hello = "hello", hello1 = 2, hello2 = String.class, hello3 = Gender.MAN, hello4 = @Anno2, hello5 = {})
public class Speaker {
    static class T{
        public static void test(){};
    }

//    @SuppressWarnings({"static-access"}) // 抑制实例对象访问静态方法的警告
    @SuppressWarnings("all") // 抑制所有警告
    public static void main(String[] args) {
        test1(); // 标记被弃用，但仍然可以调用
        T t = new T();
        t.test(); // 实例对象访问静态方法有警告
    }
    /**
     * @param x 输入参数
     * @return 返回值
     */
    public int test(int x){
        return x;
    }
    @Deprecated(since = "1.6")
    public static int[] test1(int ...x){ // ...参数可以为空
        return x;
    }
}
