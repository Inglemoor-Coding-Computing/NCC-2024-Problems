import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> s = new ArrayList<>();
        while (in.hasNextLine()) {
            String cur = in.nextLine();
            if (cur.equals("<end>"))
                break;
            s.add(cur);
        }
        Collections.sort(s);
        if (s.size() == 0)
            return;
        int begin, mid, end;
        if (s.size() % 2 == 0) {
            mid = (s.size() / 2) - 1;
            begin = 0;
            end = s.size() - 1;
        } else {
            mid = s.size() / 2;
            begin = 0;
            end = s.size() - 1;
        }
        System.out.println(s.get(begin));
        System.out.println(s.get(mid));
        System.out.println(s.get(end));

    }
}