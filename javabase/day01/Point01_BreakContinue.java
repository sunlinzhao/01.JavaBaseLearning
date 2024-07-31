/**
 * @ Author SunLZ
 * @ Project JavaLearning
 * @ Date 2024/5/28
 */
public class Point01_BreakContinue {
    public static void main(String[] args) {
        // 快捷生成 100.fori (正向) / 100.forr (反向)
        out: // 标号：任意表示符加冒号:
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 0; j--) {
                if(i==2){
                    break out; // 带标号的break，可以直接退出到标号处循环/最外层循环
                }
                System.out.println(i);
            }
        }
        System.out.println("*****************************");
        out2:
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 0; j--) {
                if(i==2){
                    continue out2; // 带标号的break，可以直接退出到标号处循环/最外层循环
                }
                System.out.println(i);
            }
        }
    }
}
