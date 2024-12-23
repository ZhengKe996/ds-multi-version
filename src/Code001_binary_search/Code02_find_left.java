package Code001_binary_search;

import java.util.Arrays;

public class Code02_find_left {
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
            if (right(arr, num) != findLeft(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    public static int findLeft(int[] arr, int num) {
        int l = 0, r = arr.length - 1, m = 0;

        int ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m] >= num) {
                ans = m;
                r = m - 1;
            } else
                l = m + 1;
        }
        return ans;
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
     * @param arr
     * @param num
     * @return
     */
    public static int right(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

}
