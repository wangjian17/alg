package leetcode.normal;

public class algGreedy53 {

    public int maxSubArray(int[] nums) {

        // 必须要初始化为第一个元素
        int result = nums[0];

        int temp = 0;

        for (int num : nums) {
            if (temp < 0) {
                temp = 0;
            }

            temp += num;
            result = Math.max(result, temp);
        }

        return result;
    }
}
