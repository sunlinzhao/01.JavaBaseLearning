/**
 * @ Author SunLZ
 * @ Project JavaLearning
 * @ Date 2024/5/29
 */
public class Person {
    private static String species = "灵长类";
    private String name;
    private String idCard;
    private double height;
    private double weight;
    private String address;

    public void showSpecies(){
        System.out.println("我是" + name + getSpecies()); // 实例方法里允许调用静态方法 / 静态属性
    }

    public static String getSpecies() {
        // this // 静态方法中不允许使用this，this在这里指代实例对象
        // height; // 静态方法中不允许直接使用实例属性，因为只有在对象被创建的时候实例变量才会被初始化
        return species;
    }

    public static void setSpecies(String species) {
        Person.species = species;
    }

    public Person() { // 建议有自定义构造函数时，空的构造函数也要带上，便于无参实例化对象
    }

    public Person(String name) { // 有参构造函数，构造函数的重载
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
