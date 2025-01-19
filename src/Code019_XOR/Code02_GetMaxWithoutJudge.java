package Code019_XOR;

// 测试链接 : https://www.nowcoder.com/practice/d2707eaf98124f1e8f1d9c18ad487f76
public class Code02_GetMaxWithoutJudge {
    /**
     * 获取两个整数中的最大值
     * 该方法通过比较两个整数的符号以及它们差的符号来确定最大值
     *
     * @param a 第一个整数
     * @param b 第二个整数
     * @return 两个整数中的最大值
     */
    public static int getMax(int a, int b) {
        // 计算a和b的差值，用于后续判断它们的相对大小
        int c = a - b;
        // 获取a的符号，正数为1，负数为0
        int sa = sign(a);
        // 获取b的符号，正数为1，负数为0
        int sb = sign(b);
        // 获取a和b差值的符号，正数为1，负数为0
        int sc = sign(c);
        // 判断a和b的符号是否不同，用于确定它们是否跨越了0点
        int diffAB = sa ^ sb;
        // 判断a和b的符号是否相同，用于确定它们是否同为正数或负数
        int sameAB = flip(diffAB);
        // 根据a和b的符号以及它们差值的符号，决定是否返回a
        int returnA = diffAB * sa + sameAB * sc;
        // 翻转returnA的值，决定是否返回b
        int returnB = flip(returnA);
        // 根据returnA和returnB的值，选择返回a或b
        return a * returnA + b * returnB;
    }

    /**
     * 判断一个整数的符号
     *
     * @param n 输入的整数
     * @return 正数返回1，负数返回0
     */
    private static int sign(int n) {
        // 如果n为非负数，返回1；否则返回0
        return flip(n >>> 31);
    }

    /**
     * 翻转一个整数的值
     *
     * @param n 输入的整数
     * @return 输入为0则返回1，输入为1则返回0
     */
    private static int flip(int n) {
        // 翻转n的值，0变1，1变0
        return n ^ 1;
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(getMax(a, b));

    }


}
