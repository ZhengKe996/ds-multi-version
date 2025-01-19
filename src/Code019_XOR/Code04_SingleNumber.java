package Code019_XOR;

//  只出现一次的数字
// 测试链接 : https://leetcode.cn/problems/single-number/
public class Code04_SingleNumber {
    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) eor ^= num;
        return eor;
    }
}
