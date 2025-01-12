package Code012_MergeSort;

// 测试链接 : https://leetcode.cn/problems/reverse-pairs/
public class Code04_ReversePairs {
    public static int MAXN = 50001;
    public static int[] help = new int[MAXN];


    public int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1);
    }

    public static int counts(int[] arr, int l, int r) {
        if (l == r) return 0;

        int m = l + ((r - l) >> 1);

        return counts(arr, l, m) + counts(arr, m + 1, r) + merge(arr, l, m, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) arr[i] > (long) arr[j] * 2) j++;

            ans += j - m - 1;
        }

        int i = l, a = l, b = m + 1;

        while (a <= m && b <= r) help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];

        while (a <= m) help[i++] = arr[a++];
        while (b <= r) help[i++] = arr[b++];

        for (i = l; i <= r; i++) arr[i] = help[i];

        return ans;
    }

}
