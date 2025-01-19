package Code018_RadixSort;

import java.util.Arrays;

// 基数排序
// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class Code02_RadixSort {
    public static int BASE = 10;

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public static int[] cnts = new int[BASE];

    public int[] sortArray(int[] arr) {
        if (arr.length > 1) {


            int n = arr.length;
            int min = arr[0];
            for (int i = 0; i < n; i++) {
                min = Math.min(min, arr[i]);
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] -= min;
                max = Math.max(max, arr[i]);
            }

            radixSort(arr, n, bits(max));

            for (int i = 0; i < n; i++) {
                arr[i] += min;
            }
        }
        return arr;
    }

    public static int bits(int number) {
        int ans = 0;
        while (number > 0) {
            ans++;
            number /= BASE;
        }
        return ans;
    }

    public static void radixSort(int[] arr, int n, int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);

            for (int i = 0; i < n; i++) cnts[(arr[i] / offset) % BASE]++;

            for (int i = 1; i < BASE; i++) cnts[i] = cnts[i] + cnts[i - 1];

            for (int i = n - 1; i >= 0; i--) {
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }

            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }
    }


}
