import java.util.Scanner;

/**
 * @ Author SunLZ
 * @ Project JavaLearning
 * @ Date 2024/5/28
 */
public class Point03_Varargs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arg = new int[num];
        for(int i=0; i<num; i++){
            arg[i] = in.nextInt();
        }
        // add(arg); 是正确的的，可变参数可以在子方法中当作数组，但不能直接传递数组
        System.out.println(add(arg)); // 可变参数是兼容数组类型参数的，但是数组类型参数不兼容可变参数
        if(num > 1)
            System.out.println(add(arg[0], arg[1]));
        else System.out.println(add(arg[0]));
        in.close();
    }


    public static int add(int... s){ // 传递可变参数，s实际上是一个数组，但是长度根据传递的实际情况确定
        int n = s.length;
        int sum = 0;
        for (int i=0; i<n; i++){
            sum+=s[i];
        }
        return sum;
    }
    // 相同方法名，数组参数和可变参数会被认为是一个方法，所以可变参数方法和数组方法不能重载
//    public static int add(int[] s){
//
//    }
}
