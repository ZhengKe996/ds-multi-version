#include <iostream>
#include <vector>
using namespace std;
// 测试链接 : https://leetcode.cn/problems/find-peak-element/

int findPeakElement(const vector<int> &arr)
{
    int n = arr.size();
    if (n == 1)
        return 0; // 只有一个元素，这个元素就是峰值

    if (arr[0] > arr[1])
        return 0; // 峰值在起点时

    if (arr[n - 1] > arr[n - 2])
        return n - 1; // 峰值在终点时

    // 峰值点在[1,n-1]上，每一步的l...r范围内都包含峰值
    int l = 1, r = n - 2, m = 0, ans = -1;
    while (l <= r)
    {
        m = l + ((r - l) >> 1); // 计算中点m
        if (arr[m - 1] > arr[m])
            r = m - 1; // 峰值在左半部分
        else if (arr[m] < arr[m + 1])
            l = m + 1; // 峰值在右半部分
        else
        {
            ans = m; // 找到一个峰值点
            break;
        }
    }
    return ans; // 返回找到的峰值点的索引
}