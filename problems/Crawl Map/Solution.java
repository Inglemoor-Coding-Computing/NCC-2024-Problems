import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] keys = in.nextLine().split(" ");
        String[] vals = in.nextLine().split(" ");
        Map<String, String> mp = new HashMap<>();
        String start = "";
        for (int i = 0; i < keys.length; ++i) {
            mp.put(keys[i], vals[i]);
            if (start.isEmpty() || vals[i].compareTo(start) < 0) {
                start = vals[i];
            }
        }
        if (!mp.containsKey(start)) {
            System.out.println("<none>");
            return;
        }
        Set<String> st = new HashSet<>();
        String last = "";
        while (!st.contains(start) && mp.containsKey(start)) {
            last = start;
            st.add(start);
            start = mp.get(start);
            // System.out.println(start);
        }
        System.out.println(last);
        // StarterCode

    }
}