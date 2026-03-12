import java.util.*;

public class Minoperations {

    public static int minOperations(int[] nums, int x) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0)
            return -1;

        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        if (maxLen == -1)
            return -1;

        return nums.length - maxLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        int result = minOperations(nums, x);

        System.out.println("Minimum operations: " + result);

        sc.close();
    }
}

