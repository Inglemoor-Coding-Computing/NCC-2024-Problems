import java.util.Scanner;

public class ConsonantalNames {

    public static boolean isConsonant(char c) {
        if (c >= 'A' && c <= 'Z')
            c += ('a' - 'A');
        return c != 'a' && c != 'e' && c != 'i' && c != 'u' && c != 'o' && c != ' ';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read in names
        int N = in.nextInt();
        in.nextLine();
        String[] names = new String[N];

        for (int i = 0; i < N; ++i) {
            names[i] = in.nextLine();
        }

        // Read in queries
        int Q = in.nextInt();
        for (int i = 0; i < Q; ++i) {
            int query = in.nextInt();

            int answer = 0;
            // calculate answer for current query
            for (String name : names) {
                int numberOfConsonants = 0;
                for (char c : name.toCharArray()) {
                    if (isConsonant(c))
                        ++numberOfConsonants;
                }
                if (numberOfConsonants >= query)
                    ++answer;
            }

            System.out.println(answer);
        }
    }
}