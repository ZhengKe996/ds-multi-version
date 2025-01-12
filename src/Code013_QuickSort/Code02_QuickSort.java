package Code013_QuickSort;

// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class Code02_QuickSort {
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
//            quickSort(nums, 0, nums.length - 1);
            quickSort2(nums, 0, nums.length - 1);
        }

        return nums;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int x = nums[l + (int) (Math.random() * (r - l + 1))];
        int mid = partition(nums, l, r, x);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    public static int partition(int[] nums, int l, int r, int x) {
        int a = l, xi = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= x) {
                swap(nums, a, i);
                if (nums[a] == x) xi = a;
                a++;
            }
        }
        swap(nums, xi, a - 1);
        return a - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort2(int[] nums, int l, int r) {
        if (l >= r) return;

        int x = nums[l + (int) (Math.random() * (r - l + 1))];
        partition2(nums, l, r, x);

        int left = first, right = last;

        quickSort2(nums, l, left - 1);
        quickSort2(nums, right + 1, r);
    }

    public static int first, last;

    public static void partition2(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;

        while (i <= last) {
            if (arr[i] == x) i++;
            else if (arr[i] < x) swap(arr, first++, i++);
            else swap(arr, i, last--);
        }
    }

}
