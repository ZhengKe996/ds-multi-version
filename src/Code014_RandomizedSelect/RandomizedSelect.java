package Code014_RandomizedSelect;

// 测试链接 : https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class RandomizedSelect {
    public int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    public static int first, last;

    public static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r; ) {
            partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
            if (i < first) r = first - 1;
            else if (i > last) l = last + 1;
            else {
                ans = arr[i];
                break;

            }
        }
        return ans;
    }

    public static void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;

        while (i <= last) {
            if (arr[i] == x) i++;
            else if (arr[i] < x) swap(arr, first++, i++);
            else swap(arr, i, last--);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
