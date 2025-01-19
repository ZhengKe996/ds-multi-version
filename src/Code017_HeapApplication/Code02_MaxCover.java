package Code017_HeapApplication;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

// 最多线段重合问题
// 测试链接 : https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
// leetcode vip 测试链接 : https://leetcode.cn/problems/meeting-rooms-ii/

public class Code02_MaxCover {
    public static int MAXN = 10001;
    public static int[][] line = new int[MAXN][2];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StreamTokenizer in = new StreamTokenizer(br);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                line[i][0] = (int) in.nval;
                in.nextToken();
                line[i][1] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }


    // 小根堆，堆顶0位置
    public static int[] heap = new int[MAXN];

    // 堆的大小
    public static int size;


    public static int compute() {
        size = 0;
        Arrays.sort(line, 0, n, (a, b) -> a[0] - b[0]); // 给线段按起点 排序
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // i: line[i][0]-line[i][1]
            while (size > 0 && heap[0] <= line[i][0]) pop();

            add(line[i][1]);
            ans = Math.max(ans, size);
        }
        return ans;
    }

    /**
     * i
     * left child = 2i+1
     * right child = 2i+2
     * parent = (i-1)/2
     *
     * @param x
     */
    public static void add(int x) {
        heap[size] = x;
        int i = size++;

        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public static void pop() {
        swap(0, --size);
        int i = 0, l = 1;

        while (l < size) {
            int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l; // if right child > left child

            best = heap[best] < heap[i] ? best : i;// if best child ? i
            if (best == i) break;

            swap(i, best); // adjust

            i = best;
            l = i * 2 + 1; // left child
        }


    }
}
