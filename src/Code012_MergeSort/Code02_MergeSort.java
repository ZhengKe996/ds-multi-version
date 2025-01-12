package Code012_MergeSort;

// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class Code02_MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
//            mergeSort1(nums);
            mergeSort2(nums);
        }
        return nums;
    }

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public static void mergeSort1(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l, a = l, b = m + 1;
        while (a <= m && b <= r) help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        while (a <= m) help[i++] = arr[a++];
        while (b <= r) help[i++] = arr[b++];

        for (i = l; i <= r; i++) arr[i] = help[i];
    }

    /**
     * 非递归
     *
     * @param arr
     */
    public static void mergeSort2(int[] arr) {
        int n = arr.length;
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) break;

                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
        }
    }
}
