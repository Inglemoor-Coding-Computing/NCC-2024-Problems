import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] firstMultipleInput = scanner.nextLine().trim().split(" ");

        int low = Integer.parseInt(firstMultipleInput[0]);

        int high = Integer.parseInt(firstMultipleInput[1]);

        boolean[] good = new boolean[10];
        int low2 = Math.abs(low);
        int high2 = Math.abs(high);
        while (low2 > 0) {
            good[low2 % 10] = true;
            low2 /= 10;
        }
        while (high2 > 0) {
            good[high2 % 10] = true;
            high2 /= 10;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = low + 1; i < high; i++) {
            if (Math.abs(i) % 2 == 1) {
                int cpy = Math.abs(i);
                boolean good1 = false;
                while (cpy > 0) {
                    if (good[cpy % 10])
                        good1 = true;
                    cpy /= 10;
                }
                if (good1) {
                    a.add(i);
                }
            }
        }
        for (int i = 0; i < a.size(); ++i) {
            System.out.print(a.get(i));
            if (i != a.size() - 1)
                System.out.print(" ");
        }
        System.out.println();

    }
}