package Code001_binary_search;

import java.util.Arrays;

public class Code01_find_num {
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            Arrays.sort(arr);
            int num = (int) (Math.random() * V);
            if (right(arr, num) != exist(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");

    }

    /**
     * 对数器：生成随机数组
     * 
     * @param n
     * @param v
     * @return
     */
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * v) + 1;
        return arr;
    }

    /**
     * 验证 前提是arr有序
     * 
     * @param sortedArr
     * @param num
     * @return
     */
    public static boolean right(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num)
                return true;
        }

        return false;
    }

    /**
     * 二分查找板子
     * 
     * @param arr
     * @param num
     * @return
     */
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return false;

        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m] == num)
                return true;
            else if (arr[m] > num)
                r = m - 1;
            else
                l = m + 1;
        }
        return false;
    }
}
