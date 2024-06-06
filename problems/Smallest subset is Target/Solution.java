import java.math.BigInteger;
import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> subsets;

    public static void dfs(int index, int target, ArrayList<Integer> arr, ArrayList<Integer> cur) {
        if (target < 0)
            return;
        if (index == arr.size()) {
            if (target == 0) {
                var copy = new ArrayList<Integer>(cur);
                subsets.add(copy);
            }
            return;
        }
        cur.add(arr.get(index));
        var copy = new ArrayList<Integer>(cur);
        dfs(index + 1, target - arr.get(index), arr, copy);
        cur.remove(cur.size() - 1);
        var copy1 = new ArrayList<Integer>(cur);
        dfs(index + 1, target, arr, copy1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        subsets = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String[] input = in.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; ++i) {
            arr.add(Integer.parseInt(input[i]));
        }
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(0, T, arr, cur);
        Collections.sort(subsets, (a, b) -> {
            if (a.size() != b.size())
                return a.size() - b.size();
            BigInteger prod1 = BigInteger.ONE, prod2 = BigInteger.ONE;
            for (int num : a)
                prod1 = prod1.multiply(new BigInteger("" + num));
            for (int num : b)
                prod2 = prod2.multiply(new BigInteger("" + num));
            return prod1.compareTo(prod2);
        });
        if (subsets.size() == 0) {
            System.out.println("<none>");
        } else {
            Collections.sort(subsets.get(0));
            for (int i = 0; i < subsets.get(0).size(); ++i) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(subsets.get(0).get(i));
            }
        }
    }
}
