import java.util.ArrayList;
import java.util.Scanner;

public class DisappearingNames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] names = new String[N];
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            names[i] = in.next();
            arr.add(names[i]);
        }
        int cur = 0, ans = 0;
        while (arr.size() > 0) {
            if (cur % 2 == 0) {
                ++ans;
                arr.remove(0);
            } else {
                ans += arr.size();
                arr.removeLast();
            }
            ++cur;
        }
        System.out.println(ans);
    }
}
