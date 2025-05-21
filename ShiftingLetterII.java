// Save this as ShiftingLetterII.java (no spaces, class name matches filename)

public class ShiftingLetterII {

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int diff[] = new int[n + 1];

        for (int i = 0; i < shifts.length; i++) {
            int L = shifts[i][0];
            int R = shifts[i][1];
            int dir = shifts[i][2];
            int x;

            if (dir == 0) {
                x = -1; // backward shift
            } else {
                x = 1;  // forward shift
            }

            diff[L] += x;
            if (R + 1 < n) {
                diff[R + 1] -= x;
            }
        }

        // Prefix sum to get net shifts
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shift = diff[i] % 26;
            if (shift < 0) shift += 26;

            arr[i] = (char)((arr[i] - 'a' + shift) % 26 + 'a');
        }

        return new String(arr);
    }

    // Optional: main method to test your code
    public static void main(String[] args) {
        ShiftingLetterII sol = new ShiftingLetterII();

        String s = "abc";
        int[][] shifts = {
            {0, 0, 1},  // shift 'a' forward by 1 → 'b'
            {1, 2, 0}   // shift 'b' and 'c' backward by 1 → 'a' and 'b'
        };

        System.out.println(sol.shiftingLetters(s, shifts)); // Expected output: "bab"
    }
}
