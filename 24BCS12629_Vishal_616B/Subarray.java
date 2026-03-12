import java.util.*;

public class Subarray {

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public static int count(int[] nums, int k) {
        int ans = 0;
        int curr = 0;

        for (int num : nums) {
            if (num <= k) {
                curr++;
            } else {
                curr = 0;
            }
            ans += curr;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter left value: ");
        int left = sc.nextInt();

        System.out.print("Enter right value: ");
        int right = sc.nextInt();

        int result = numSubarrayBoundedMax(nums, left, right);

        System.out.println("Number of valid subarrays: " + result);

        sc.close();
    }
}
