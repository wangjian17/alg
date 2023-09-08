package leetcode.normal;

public class algBi33 {

    public int search(int[] nums, int target) {

        // 左开右闭合
        int left = 0, right = nums.length - 1;

        // 4 6 7 8 9 1 2
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            int value = nums[mid];

            if (value == target) return mid;
            // 如果左边有序
            else if (value >= nums[0]) {

                    // 在左边
                if (target >= nums[left] && target < value){
                    right = mid - 1;
                }else {
                    // 在右边
                    left = mid + 1;
                }
            // 右边有序
            }else {

                if (target <= nums[right] && target > value) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
