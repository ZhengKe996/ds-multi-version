package Code019_XOR;


// 找到缺失的数字
// 测试链接 : https://leetcode.cn/problems/missing-number/
public class Code03_MissingNumber {
    /**
     * 使用异或运算寻找缺失的数字
     * 根据异或运算的性质：a ^ a = 0, a ^ 0 = a，可以用来查找缺失的数字
     * 通过计算数组索引和数组值的异或结果，可以找到缺失的数字
     *
     * @param nums 包含n个不重复元素的数组，元素范围为[0, n]
     * @return 返回缺失的数字
     */
    public int missingNumber(int[] nums) {
        // 初始化两个变量，eorAll用于存储所有数字（包括缺失的）的异或结果，eorHas用于存储数组中所有数字的异或结果
        int eorAll = 0, eorHas = 0;

        // 遍历数组，同时计算所有索引值和数组中所有元素值的异或结果
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= i;
            eorHas ^= nums[i];
        }
        // 将数组长度加入异或运算，因为缺失的数字可能是数组长度本身
        eorAll^=nums.length;
        // 两个异或结果再进行异或，得到缺失的数字
        return eorAll ^ eorHas;
    }
}
