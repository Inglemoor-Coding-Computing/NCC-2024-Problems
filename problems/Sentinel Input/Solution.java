import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String cur = in.nextLine();
            if (cur.equals("<end>"))
                return;
            System.out.println(cur);
        }
    }
}
