#include <vector>
using namespace std;

const int MAXN = 50001;
int arr[MAXN];

class Code04_ReversePairs {
public:
    int reversePairs(vector<int>& nums) {
        return counts(nums, 0, nums.size() - 1);
    }

private:
    int counts(vector<int>& arr, int l, int r) {
        if (l == r) return 0;

        int m = l + ((r - l) >> 1);

        return counts(arr, l, m) + counts(arr, m + 1, r) + merge(arr, l, m, r);
    }

    int merge(vector<int>& arr, int l, int m, int r) {
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long long)arr[i] > (long long)arr[j] * 2) j++;

            ans += j - m - 1;
        }

        vector<int> help(r - l + 1);
        int i = 0, a = l, b = m + 1;

        while (a <= m && b <= r) help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];

        while (a <= m) help[i++] = arr[a++];
        while (b <= r) help[i++] = arr[b++];

        for (i = 0; i < help.size(); i++) arr[l + i] = help[i];

        return ans;
    }
};
