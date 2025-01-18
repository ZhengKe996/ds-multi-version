package Code015_HeapSort;

import java.io.*;

// 测试链接 : https://www.luogu.com.cn/problem/P1177
public class Code01_HeapSort {

    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
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
        heapSort2();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapInsert(int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int i, int size) {
        int l = i * 2 + 1;// Left Children
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l; // Max Value in Left or Right Children
            best = arr[best] > arr[i] ? best : i;

            if (best == i) break;
            swap(best, i);
            i = best;
            l = i * 2 + 1;
        }
    }


    /**
     * 使用堆排序算法进行排序的函数
     * 该方法首先构建一个最大堆，然后交换堆顶元素与堆中最后一个元素，减小堆的大小，重新调整为最大堆，重复此过程直到堆为空
     */
    public static void heapSort1() {
        // 从第一个元素开始，逐个插入到堆中，构建最大堆
        for (int i = 0; i < n; i++) heapInsert(i);

        int size = n;
        // 当堆的大小大于1时，重复执行交换和重新调整堆的操作
        while (size > 1) {
            // 将堆顶元素（最大值）与当前堆的最后一个元素交换
            swap(0, --size);
            // 从堆顶开始重新调整堆，使其满足最大堆的性质
            heapify(0, size);
        }
    }

    /**
     * 使用另一种堆排序算法进行排序的函数
     * 该方法从最后一个非叶子节点开始，自下而上、自右而左调整堆，构建最大堆，然后通过交换和重新调整完成排序
     */
    public static void heapSort2() {
        // 从最后一个非叶子节点开始，自下而上、自右而左调整堆，构建最大堆
        for (int i = n - 1; i >= 0; i--) heapify(i, n);

        int size = n;
        // 当堆的大小大于1时，重复执行交换和重新调整堆的操作
        while (size > 1) {
            // 将堆顶元素（最大值）与当前堆的最后一个元素交换
            swap(0, --size);
            // 从堆顶开始重新调整堆，使其满足最大堆的性质
            heapify(0, size);
        }
    }
}
