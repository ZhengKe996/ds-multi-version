#include <vector>
#include <algorithm>

using namespace std;

const int MAXN = 50001;
int help[MAXN];

class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        if (nums.size() > 1) {
            mergeSort2(nums);
        }
        return nums;
    }

private:
    void mergeSort1(vector<int>& arr) {
        sort(arr, 0, arr.size() - 1);
    }

    void sort(vector<int>& arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    void merge(vector<int>& arr, int l, int m, int r) {
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
    void mergeSort2(vector<int>& arr) {
        int n = arr.size();
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) break;

                r = min(l + (step << 1) - 1, n - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
        }
    }
};
