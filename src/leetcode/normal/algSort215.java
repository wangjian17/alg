package leetcode.normal;

public class algSort215 {

    public int findKthLargest(int[] nums, int k) {

        // 第k大就是第n - k小（从0开始）
        int n = nums.length;
        k = n - k;

        // 这里使用快速查找算法
        int left = 0, right = n - 1;

        while (left <= right){
            int mid = partition(nums, left, right);
            if (k == mid ) {
                return nums[mid];
            }
            else if (k <mid){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return -1;

    }

    private int partition(int[] nums, int left, int right) {

        int i = left + 1, j = right;
        int anchor = nums[left];

        while (i <= j) {

            while (i < right && nums[i] <= anchor) {
                ++i;
            }

            while (j > left && nums[j] > anchor){
                --j;
            }

            // 这个等号只会在边界取到
            if (i >= j) break;

            swap(nums, i, j);
        }

        swap(nums, j, left);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
