package Code013_QuickSort;

import java.io.*;

// 测试链接 : https://www.luogu.com.cn/problem/P1177
public class Code01_QuickSort {
    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StreamTokenizer in = new StreamTokenizer(br);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // input
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }

        // solution
//        quicksort(0, n - 1);
        quickSort2(0, n - 1);
        for (int i = 0; i < n - 1; i++) out.print(arr[i] + " ");
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }

    public static void quicksort(int l, int r) {
        if (l >= r) return;


        int x = arr[l + (int) (Math.random() * (r - l + 1))]; // 枢轴元素

        int mid = partition(l, r, x);
        quicksort(l, mid - 1);
        quicksort(mid + 1, r);
    }

    public static int partition(int l, int r, int x) {
        int a = l, xi = 0; // xi 用于存放<=x区域上任何一个x的位置

        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                swap(a, i);
                if (arr[a] == x) xi = a;
                a++;
            }
        }
        swap(xi, a - 1);
        return a - 1;
    }

    public static void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }


    public static void quickSort2(int l, int r) {
        if (l >= r) return;
        int x = arr[l + (int) (Math.random() * (r - l + 1))]; // 枢轴元素
        partition2(l, r, x);

        int left = first, right = last;
        quickSort2(l, left - 1);
        quickSort2(right + 1, r);
    }

    public static int first, last;

    public static void partition2(int l, int r, int x) {

        first = l;
        last = r;
        int i = l;

        while (i <= last) {
            if (arr[i] == x) i++;
            else if (arr[i] < x) swap(first++, i++);
            else swap(i, last--);
        }
    }
}
