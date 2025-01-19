package Code019_XOR;

// 返回出现次数小于m次的那种数
// 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
// 测试链接 : https://leetcode.cn/problems/single-number-ii/
public class Code06_OneKindNumberLessMtimes {
    public static int singleNumber(int[] nums) {
        return find(nums, 3);
    }

    /**
     * 在一个整数数组中，找到一个数字，这个数字在数组中出现的次数不能被m整除
     * 该方法通过统计数组中每个数字的二进制表示的每一位出现的次数，来找到这样的数字
     *
     * @param arr 整数数组，其中包含了所有参与计算的数字
     * @param m   用于除法运算的数字，目的是找到出现次数不能被m整除的数字
     * @return 返回一个整数，这个整数的二进制表示中，每一位的1表示该位出现的次数不能被m整除
     */
    public static int find(int[] arr, int m) {
        // 初始化一个长度为32的数组，用于统计数组中所有数字的二进制表示的每一位出现的次数
        int[] cnts = new int[32];

        // 遍历数组中的每个数字
        for (int num : arr) {
            // 遍历数字的二进制表示的每一位，统计每一位1出现的次数
            for (int i = 0; i < 32; i++) {
                cnts[i] += (num >> i) & 1;
            }
        }

        // 初始化答案变量为0，用于存储最终找到的数字
        int ans = 0;

        // 检查每一位出现的次数是否能被m整除，如果不能，就在答案的对应位上设置为1
        for (int i = 0; i < 32; i++) {
            if (cnts[i] % m != 0) {
                ans |= 1 << i;
            }
        }

        // 返回最终找到的数字
        return ans;
    }
}
