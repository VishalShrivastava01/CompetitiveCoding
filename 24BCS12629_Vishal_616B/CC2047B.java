import java.util.*;

public class CC2047B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            char[] arr = s.toCharArray();

            int[] freq = new int[26];
            for (char c : arr) freq[c - 'a']++;

            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > freq[max]) max = i;
            }

            int min = -1;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0 && i != max &&
                        (min == -1 || freq[i] < freq[min])) {
                    min = i;
                }
            }

            if (min == -1) {
                System.out.println(s);
                continue;
            }

            char maxChar = (char) ('a' + max);
            char minChar = (char) ('a' + min);

            for (int i = 0; i < n; i++) {
                if (arr[i] == minChar) {
                    arr[i] = maxChar;
                    break;
                }
            }

            System.out.println(new String(arr));
        }
    }
}
