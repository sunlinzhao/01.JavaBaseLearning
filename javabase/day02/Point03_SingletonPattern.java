/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/29
 */
public class Point03_SingletonPattern { // 单例模式 test
    // 单例模式: 保证一个类只能创建一个实例对象，自行实例化，并向整个系统提供这个对象。
    // 实现: 构造方法私有
    public static void main(String[] args) {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        System.out.println(hungrySingleton1==hungrySingleton2);

        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton2==lazySingleton1);

        NonSingleton nonSingleton1 = new NonSingleton();
        NonSingleton nonSingleton2 = new NonSingleton();
        System.out.println(nonSingleton2==nonSingleton1);
    }

}

class NonSingleton { // 非单例

    public NonSingleton() {
    }
}

class HungrySingleton { // 饿汉式，类加载时就创建实例
    // 类加载初始化时就创建实例，并且设为 static，所有实例都拥有。final 设为常量，不可更改
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() { // 私有化构造函数，不允许外部创建实例
    }

    public static HungrySingleton getInstance(){ // 暴露一个共有方法获取创建的实例
        return hungrySingleton;
    }
}

class LazySingleton { // 懒汉式，创建对象是才判断是否已经创建实例，没有则创建
    private static LazySingleton lazySingleton; // 声明但不创建, 不声明为final，因为还未创建

    private LazySingleton() { // 私有化构造函数，不允许外部创建实例
    }

    public static LazySingleton getInstance() { // 暴露一个共有方法获取创建的实例
        if(lazySingleton==null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}