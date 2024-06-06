import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NewtonRaphsonRoots {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split(" ");
        int[] coefficients = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            coefficients[i] = Integer.parseInt(parts[i]);
        }

        List<Double> roots = findRealRoots(coefficients);
        for (double root : roots) {
            System.out.printf("%.3f\n", root);
        }
    }

    // Evaluate the polynomial at x
    public static double polynomial(int[] coefficients, double x) {
        double result = 0;
        int degree = coefficients.length - 1;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, degree - i);
        }
        return result;
    }

    // Evaluate the derivative of the polynomial at x
    public static double derivative(int[] coefficients, double x) {
        double result = 0;
        int degree = coefficients.length - 1;
        for (int i = 0; i < coefficients.length - 1; i++) {
            result += (degree - i) * coefficients[i] * Math.pow(x, degree - i - 1);
        }
        return result;
    }

    // Newton-Raphson method to find a root starting from an initial guess
    public static double newtonRaphson(int[] coefficients, double initialGuess, double tolerance, int maxIterations) {
        double x = initialGuess;
        for (int i = 0; i < maxIterations; i++) {
            double fx = polynomial(coefficients, x);
            double fPrimeX = derivative(coefficients, x);

            if (Math.abs(fPrimeX) < tolerance) { // Avoid division by zero
                break;
            }

            double nextX = x - fx / fPrimeX;
            if (Math.abs(nextX - x) < tolerance) {
                return nextX;
            }
            x = nextX;
        }
        return x;
    }

    // Find all unique real roots of the polynomial
    public static List<Double> findRealRoots(int[] coefficients) {
        double tolerance = 1e-4;
        int maxIterations = 1000;
        List<Double> roots = new ArrayList<>();
        double[] initialGuesses = linspace(-10000, 10000, 10000); // Generate 10000 initial guesses in range [-10000,
                                                                  // 10000]

        for (double guess : initialGuesses) {
            double root = newtonRaphson(coefficients, guess, tolerance, maxIterations);
            if (Math.abs(polynomial(coefficients, root)) < tolerance) {
                boolean isUnique = true;
                for (double existingRoot : roots) {
                    if (Math.abs(root - existingRoot) < 0.001) { // Check for uniqueness within a tighter tolerance
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    roots.add(root);
                }
            }
        }
        Collections.sort(roots);
        return roundRoots(roots, 3);
    }

    // Generate an array of linearly spaced values
    public static double[] linspace(double start, double end, int num) {
        double[] result = new double[num];
        double step = (end - start) / (num - 1);
        for (int i = 0; i < num; i++) {
            result[i] = start + i * step;
        }
        return result;
    }

    // Round the roots to the nearest thousandth
    public static List<Double> roundRoots(List<Double> roots, int decimalPlaces) {
        List<Double> roundedRoots = new ArrayList<>();
        for (double root : roots) {
            double roundedRoot = Math.round(root * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
            if (!roundedRoots.contains(roundedRoot)) {
                roundedRoots.add(roundedRoot);
            }
        }
        return roundedRoots;
    }
}
