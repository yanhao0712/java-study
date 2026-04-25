import java.util.Arrays;
import java.util.Scanner;

 class ArraysTest {
    public static void main(String[] args) {
        int[] arr1 = {10, 50, 40, 30};
        int[] arr2 = {10, 50, 40, 30};

        // 1. 打印数组
        System.out.println("打印内容：" + Arrays.toString(arr1)); // [10, 50, 40, 30]

        // 2. 比较内容
        System.out.println("内容相等吗：" + Arrays.equals(arr1, arr2)); // true

        // 3. 排序
        Arrays.sort(arr1);
        System.out.println("排序后：" + Arrays.toString(arr1)); // [10, 30, 40, 50]

        // 4. 二分查找（必须先排序！）
        int index = Arrays.binarySearch(arr1, 30);
        System.out.println("30的索引是：" + index); // 1
    }
}





































