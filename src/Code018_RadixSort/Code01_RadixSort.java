package Code018_RadixSort;

import java.io.*;
import java.util.Arrays;

// 基数排序，acm练习风格
// 测试链接 : https://www.luogu.com.cn/problem/P1177
public class Code01_RadixSort {
    public static int BASE = 10;
    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int[] help = new int[MAXN];
    public static int[] cnts = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        sort();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }

    public static void sort() {
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }
        // 根据最大值在BASE进制下的位数，决定基数排序做多少轮
        radixSort(bits(max));
        // 数组中所有数都减去了最小值，所以最后不要忘了还原
        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }
    }

    /**
     * 计算一个整数在给定基数下表示的位数
     * 该方法旨在确定一个整数在特定基数下需要多少位来表示
     *
     * @param number 要分析的整数
     * @return 整数在给定基数下表示的位数
     */
    public static int bits(int number) {
        // 初始化位数计数器
        int ans = 0;
        // 当number大于0时，继续循环
        while (number > 0) {
            // 每经过一次循环，表示number在给定基数下占用的位数增加
            ans++;
            // 将number除以BASE，以确定是否还有更高的位数
            number /= BASE;
        }
        // 返回计算出的位数
        return ans;
    }

    public static void radixSort(int bits) {
        // 理解的时候可以假设BASE = 10
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                cnts[(arr[i] / offset) % BASE]++;
            }
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i] + cnts[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                // 前缀数量分区的技巧
                // 数字提取某一位的技巧
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }
    }

}
