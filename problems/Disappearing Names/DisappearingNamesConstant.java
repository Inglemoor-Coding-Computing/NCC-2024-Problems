import java.util.ArrayList;
import java.util.Scanner;

public class DisappearingNamesConstant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; ++i) {
            in.next();
        }

        int ans = 0;
        if (N % 2 == 1) {
            int numEvens = N / 2;
            int evenSum = 2 * ((numEvens) * (numEvens + 1) / 2);
            int oneSum = N - numEvens;
            ans = oneSum + evenSum;
        } else {
            int numOdds = N / 2;
            int evenSum = 2 * ((numOdds) * (numOdds + 1) / 2);
            int oddSum = (N * (N + 1) / 2) - evenSum;
            int oneSum = N - numOdds;
            ans = oddSum + oneSum;
        }
        System.out.println(ans);
    }
}
