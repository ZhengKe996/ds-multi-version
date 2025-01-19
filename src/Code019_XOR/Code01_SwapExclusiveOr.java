package Code019_XOR;

public class Code01_SwapExclusiveOr {
    /**
     * 主函数，用于演示变量交换和数组元素交换
     */
    public static void main(String[] args) {
        // 初始化变量a和b
        int a = -2323;
        int b = 10;

        // 使用异或操作交换变量a和b的值
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // 打印交换后的值
        System.out.println(a);
        System.out.println(b);

        // 初始化数组arr
        int[] arr = {3, 5};

        // 调用swap函数交换数组中的元素
        swap(arr, 0, 1);

        // 打印交换后的数组元素
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        // 再次调用swap函数，但这次交换的是相同位置的元素
        swap(arr, 0, 0);

        // 打印数组元素，验证交换操作
        System.out.println(arr[0]);
    }

    /**
     * 交换数组中两个指定位置的元素
     * 此方法演示了如何通过异或操作交换数组中的元素，不使用临时变量
     *
     * @param arr    数组
     * @param index1 第一个元素的位置
     * @param index2 第二个元素的位置
     */
    public static void swap(int[] arr, int index1, int index2) {
        // 通过异或操作交换数组中的两个元素
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
