import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        String c = in.next();
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}