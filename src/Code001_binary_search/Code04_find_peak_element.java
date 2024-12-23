package Code001_binary_search;
// 测试链接 : https://leetcode.cn/problems/find-peak-element/

public class Code04_find_peak_element {

    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (arr.length == 1)
            return 0; // 只有一个元素，这个元素就是峰值

        if (arr[0] > arr[1])
            return 0; // 峰值在起点时

        if (arr[n - 1] > arr[n - 2])
            return n - 1;// 峰值在终点时

        // 峰值点在[1,n-1]上 每一步的l...r都有峰值
        int l = 1, r = n - 2, m = 0, ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m - 1] > arr[m])
                r = m - 1;
            else if (arr[m] < arr[m + 1])
                l = m + 1;
            else {
                ans = m;
                break; // 找到一个峰值点
            }
        }
        return ans;
    }
}
