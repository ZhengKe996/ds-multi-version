package Code019_XOR;

// 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
// 测试链接 : https://leetcode.cn/problems/single-number-iii/
public class Code05_DoubleNumber {
    /**
     * 寻找数组中出现一次的两个数字
     * 该方法利用位运算的特性，高效地找到数组中只出现一次的两个数字
     * 其他数字都出现了两次
     *
     * @param nums 输入的整数数组
     * @return 包含两个只出现一次数字的数组
     */
    public int[] singleNumber(int[] nums) {
        // 初始化第一个异或结果
        int eor1 = 0;
        // 遍历数组，计算所有数字的异或结果
        for (int num : nums) {
            eor1 ^= num;
        }

        // 获取异或结果的最低位的1，用于区分两个不同的数字
        int rightOne = eor1 & (-eor1);
        // 初始化第二个异或结果
        int eor2 = 0;
        // 再次遍历数组，根据最低位的1将数组分为两组，并计算每组的异或结果
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor2 ^= num;
            }
        }
        // 返回两个只出现一次的数字
        return new int[]{eor2, eor1 ^ eor2};
    }
}
