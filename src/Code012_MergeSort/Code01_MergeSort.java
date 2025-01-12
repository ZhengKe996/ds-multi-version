package Code012_MergeSort;

import java.io.*;

// 归并排序，acm练习风格
// 测试链接 : https://www.luogu.com.cn/problem/P1177
public class Code01_MergeSort {
    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

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
//        mergeSort1(0, n - 1);
        mergeSort2();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }

    public static void mergeSort1(int l, int r) {
        if (l == r) return;

        int m = l + ((r - l) >> 1);
        mergeSort1(l, m);
        mergeSort1(m + 1, r);
        merge(l, m, r);
    }

    public static void merge(int l, int m, int r) {
        int i = l, a = l, b = m + 1;
        while (a <= m && b <= r) help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];

        while (a <= m) help[i++] = arr[a++];
        while (b <= r) help[i++] = arr[b++];

        for (i = l; i <= r; i++) arr[i] = help[i];
    }

    public static void mergeSort2() {
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) break;

                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }
}


