/**
 * @ Author SunLZ
 * @ Project JavaLearning
 * @ Date 2024/5/28
 */
public class Point04_Return {
    public static void main(String[] args) {
        int a = 5;
        int b = 4;
        judge(a,b);
    }
    public static void judge(int a, int b){
        if(a>=b){
            System.out.println("符合要求");
            return; // 跳出当前方法回到主调函数，针对返回值为空的方法
        }
        System.out.println("不符合要求");
    }
}
