#include <vector>
#include <cstdlib> // for rand()
#include <ctime>   // for time()

class Code02_QuickSort {
public:
    std::vector<int> sortArray(std::vector<int>& nums) {
        if (nums.size() > 1) {
            quickSort2(nums, 0, nums.size() - 1);
        }
        return nums;
    }

private:
    void quickSort2(std::vector<int>& nums, int l, int r) {
        if (l >= r) return;

        int x = nums[l + rand() % (r - l + 1)];
        int left, right;
        partition2(nums, l, r, x, left, right);

        quickSort2(nums, l, left - 1);
        quickSort2(nums, right + 1, r);
    }

    void partition2(std::vector<int>& arr, int l, int r, int x, int& left, int& right) {
        left = l;
        right = r;
        int i = l;

        while (i <= right) {
            if (arr[i] == x) i++;
            else if (arr[i] < x) std::swap(arr[left++], arr[i++]);
            else std::swap(arr[i], arr[right--]);
        }
    }
};