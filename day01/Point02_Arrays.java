import java.util.Arrays;

/**
 * @ Author SunLZ
 * @ Project JavaLearning
 * @ Date 2024/5/28
 */
public class Point02_Arrays {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 2, 0, 9};
        Arrays.sort(nums); // 排序
        int id = Arrays.binarySearch(nums, 3); // 二分查找，必须先排序，找不到返回负值
        System.out.println(id);
        System.out.println(Arrays.toString(nums));// 数组转成字符串

        Arrays.fill(nums, 1); // 填充
        System.out.println(Arrays.toString(nums));

        Arrays.fill(nums, 1, 3, 0); // 选择填充：不包括结束位置
        System.out.println(Arrays.toString(nums));

        int[] new_nums = Arrays.copyOf(nums, nums.length); // 拷贝数组
        System.out.println(Arrays.toString(new_nums));

        int[] new_nums_parts = Arrays.copyOfRange(nums, 0, 3); // 部分拷贝数组， 不包括结束位置
        System.out.println(Arrays.toString(new_nums_parts));

        int[] x = {5, 3, 4, 1, 2};
        int[] y = Arrays.copyOf(x, x.length);
        boolean res = Arrays.equals(x, y); // 数组比较，每一个对应位置是否都相同
        System.out.println("比较结果：" + res);

        // 将数组元素按字典顺序比较; 相同返问0，如果前面比后面小，返回负数，前面比后面大，返画正数
        int ans = Arrays.compare(x, y);
        System.out.println("比较结果：" + ans);

        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
//        System.out.println(Arrays.deepToString(arr));
    }
}
