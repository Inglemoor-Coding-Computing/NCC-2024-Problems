import java.util.*;

public class Solution {
    public static boolean isPrime(int x) {
        if (x <= 1)
            return false;
        if (x == 2)
            return true;
        if (x % 2 == 0)
            return false;
        int sqrt = (int) Math.sqrt(x);
        for (int i = 3; i <= sqrt; i += 2) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static ArrayList<Integer> getPrimes(int upperBound) {
        var ret = new ArrayList<Integer>();
        if (2 <= upperBound)
            ret.add(2);
        for (int i = 3; i < upperBound; ++i) {
            if (isPrime(i))
                ret.add(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int primeUpperBound = in.nextInt();
        // BigDecimal target = new BigDecimal(in.next());
        double target = in.nextDouble();
        var primes = getPrimes(primeUpperBound);
        int n = primes.size();
        double a = 0.0, b = 0.0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                double c = primes.get(i);
                double d = primes.get(j);
                if (a == 0.0) {
                    a = c;
                    b = d;
                } else {
                    if (Math.abs((a / b) - target) > Math.abs((c / d) - target)) {
                        a = c;
                        b = d;
                    }
                }
            }
        }
        System.out.println((int) a + " " + (int) b);
    }
}