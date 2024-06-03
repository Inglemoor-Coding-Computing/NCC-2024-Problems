import java.util.ArrayList;
import java.util.Scanner;

public class DisappearingNamesLinear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // don't need names
        for (int i = 0; i < N; ++i) {
            in.next();
        }

        int cur = N - 1, ans = 0;
        for (int i = 0; i < N; ++i) {
            if (i % 2 == 0) {
                ++ans;
            } else {
                ans += cur;
                cur -= 2;
            }
        }
        System.out.println(ans);
    }
}
