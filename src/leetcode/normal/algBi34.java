package leetcode.normal;

public class algBi34 {

    public int[] searchRange(int[] nums, int target) {

        int left = lowerBound(nums, target);
        int right = upBound(nums, target);

        if (left == right) return new int[]{-1, -1};
        return new int[]{left, right - 1};
    }

    private int upBound(int[] nums, int target) {
        int ans = nums.length;
        int left = 0, right = ans - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }


    // 找一个大于等于target的索引
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        int ans = nums.length;

        while (left <= right){
            int mid = (right - left) / 2 + left;

            if (nums[mid] >= target){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;

    }

}
