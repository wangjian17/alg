package leetcode.offer;

public class algSort51 {

    // 本题可以转换为Leetcode315题
    // 逆序对的数量的和其实就是每个元素后面小于当前元素的和
    // 这里简单的一点是不需要映射

    int result = 0;

    int[] temp;

    public int reversePairs(int[] nums) {

        if (nums.length == 0) return 0;
        // 初始化
        temp = new int[nums.length];

        sort(nums, 0, nums.length - 1);

        return result;
    }

    private void sort(int[] nums, int left, int right) {

        // 终止条件
        if (left == right) return;

        int mid = (right - left) / 2 + left;

        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        // 拷贝数组
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int p1 = left, p2 = mid + 1;
        for (int p = left; p <= right; p++) {

            if (p1 == mid + 1 || (p2 <= right && temp[p2] < temp[p1])) {
                nums[p] = temp[p2++];
            }else{
                nums[p] = temp[p1++];
                result += p2 - mid - 1;
            }
        }
    }

}
