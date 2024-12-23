# 二分查找（二分搜索）

有序数组的查找，时间复杂度`O(logn)`

## 简单的二分查找
```java
public static boolean exist(int[] arr, int num) {
    if (arr == null || arr.length == 0) return false;

    int l = 0, r = arr.length - 1, m = 0;
    while (l <= r) {
        m = l + ((r - l) >> 1);
        if (arr[m] == num) return true;
        else if (arr[m] > num) r = m - 1;
        else l = m + 1;
    }
    return false;
}
```

## 查找>=num的最左位置
```java
public static int findLeft(int[] arr, int num) {
    int l = 0, r = arr.length - 1, m = 0;
    int ans = -1;
    while (l <= r) {
        m = l + ((r - l) >> 1);
        if (arr[m] >= num) {
            ans = m;
            r = m - 1;
        } else
            l = m + 1;
    }
    return ans;
}
```

## 查找<=num的最右位置
```java
public static int findRight(int[] arr, int num) {
    int ans = -1;
    int l = 0, r = arr.length - 1, m = 0;
    while (l <= r) {
        m = l + ((r - l) >> 1);
        if (arr[m] <= num) {
            ans = m;
            l = m + 1;
        } else {
            r = m - 1;
        }
    }
    return ans;
}

```

## 二分搜索不一定发生在有序数组上的情况（峰值问题）
`峰值元素是指其值严格大于左右相邻值的元素`
```java
public static int findPeakElement(int[] arr) {
    int n = arr.length;
    if (arr.length == 1) return 0; // 只有一个元素，这个元素就是峰值

    if (arr[0] > arr[1]) return 0; // 峰值在起点时

    if (arr[n - 1] > arr[n - 2]) return n - 1;// 峰值在终点时

    // 峰值点在[1,n-1]上 某侧的l...r都有峰值
    int l = 1, r = n - 2, m = 0, ans = -1;
    while (l <= r) {
        m = l + ((r - l) >> 1);
        if (arr[m - 1] > arr[m]) r = m - 1;
        else if (arr[m] < arr[m + 1]) l = m + 1;
        else {
            ans = m;
            break; // 找到一个峰值点
        }
    }
    return ans;
}
```