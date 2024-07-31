/**
 * @ Author SunLZ
 * @ Project JavaLearning
 * @ Date 2024/5/29
 */



public class Point01_ObjNums { // 对象数组 test
    public static void main(String[] args) {
        int n = 3;
        Person[] persons = new Person[n]; // Person对象的数组，创建方式与整数数组一致, 引用类型默认值是null
        String[] names = {"张三", "李四", "赵武"};

        for (int i = 0; i < persons.length; i++) { // 初始化， 否则会空指针异常
            persons[i] = new Person(names[i]);
        }
        for (Person person : persons) {
            System.out.println(person.getName());
        }

        System.out.println(Person.getSpecies()); // 通过类名直接访问静态成员变量，不用实例化
        persons[1].showSpecies(); // 实例对象，通过公共方法调用类成员变量
        Person.setSpecies("傻逼");
        persons[0].showSpecies();
        persons[1].showSpecies();
    }
}
