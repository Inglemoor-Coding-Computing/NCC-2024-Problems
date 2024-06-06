import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and R
        int N = scanner.nextInt();
        int R = scanner.nextInt();

        // Read points
        BigDecimal[][] points = new BigDecimal[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = scanner.nextBigDecimal();
            }
        }

        // Perform rotation
        BigDecimal[][] rotatedPoints = rotateAroundSegment(points, R);

        // Output the result
        for (BigDecimal[] point : rotatedPoints) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%.2f", point[j]);
                if (j < 2)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static BigDecimal[][] rotateAroundSegment(BigDecimal[][] points, int degrees) {
        // Convert degrees to radians
        BigDecimal theta = BigDecimal.valueOf(Math.toRadians(degrees));

        // Extract the first two points defining the segment
        BigDecimal[] p1 = points[0];
        BigDecimal[] p2 = points[1];

        // Vector from p1 to p2
        BigDecimal[] segmentVector = {
                p2[0].subtract(p1[0]),
                p2[1].subtract(p1[1]),
                p2[2].subtract(p1[2])
        };

        // Normalize the segment vector to get the rotation axis direction
        BigDecimal segmentLength = length(segmentVector);
        BigDecimal[] axis = {
                segmentVector[0].divide(segmentLength, MathContext.DECIMAL128),
                segmentVector[1].divide(segmentLength, MathContext.DECIMAL128),
                segmentVector[2].divide(segmentLength, MathContext.DECIMAL128)
        };

        // Perform rotation
        BigDecimal cosTheta = BigDecimal.valueOf(Math.cos(theta.doubleValue()));
        BigDecimal sinTheta = BigDecimal.valueOf(Math.sin(theta.doubleValue()));
        BigDecimal oneMinusCos = BigDecimal.ONE.subtract(cosTheta);

        BigDecimal[][] rotationMatrix = {
                { cosTheta.add(axis[0].multiply(axis[0]).multiply(oneMinusCos)),
                        axis[0].multiply(axis[1]).multiply(oneMinusCos).subtract(axis[2].multiply(sinTheta)),
                        axis[0].multiply(axis[2]).multiply(oneMinusCos).add(axis[1].multiply(sinTheta)) },
                { axis[1].multiply(axis[0]).multiply(oneMinusCos).add(axis[2].multiply(sinTheta)),
                        cosTheta.add(axis[1].multiply(axis[1]).multiply(oneMinusCos)),
                        axis[1].multiply(axis[2]).multiply(oneMinusCos).subtract(axis[0].multiply(sinTheta)) },
                { axis[2].multiply(axis[0]).multiply(oneMinusCos).subtract(axis[1].multiply(sinTheta)),
                        axis[2].multiply(axis[1]).multiply(oneMinusCos).add(axis[0].multiply(sinTheta)),
                        cosTheta.add(axis[2].multiply(axis[2]).multiply(oneMinusCos)) }
        };

        // Apply rotation to all points
        BigDecimal[][] rotatedPoints = new BigDecimal[points.length][3];
        for (int i = 0; i < points.length; i++) {
            rotatedPoints[i] = addVectors(multiplyMatrixVector(rotationMatrix, subtractVectors(points[i], p1)), p1);
        }

        return rotatedPoints;
    }

    public static BigDecimal[] subtractVectors(BigDecimal[] a, BigDecimal[] b) {
        BigDecimal[] result = new BigDecimal[3];
        for (int i = 0; i < 3; i++) {
            result[i] = a[i].subtract(b[i]);
        }
        return result;
    }

    public static BigDecimal[] multiplyMatrixVector(BigDecimal[][] m, BigDecimal[] v) {
        BigDecimal[] result = new BigDecimal[3];
        for (int i = 0; i < 3; i++) {
            result[i] = BigDecimal.ZERO;
            for (int j = 0; j < 3; j++) {
                result[i] = result[i].add(m[i][j].multiply(v[j]));
            }
        }
        return result;
    }

    public static BigDecimal[] addVectors(BigDecimal[] a, BigDecimal[] b) {
        BigDecimal[] result = new BigDecimal[3];
        for (int i = 0; i < 3; i++) {
            result[i] = a[i].add(b[i]);
        }
        return result;
    }

    public static BigDecimal length(BigDecimal[] vector) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal component : vector) {
            sum = sum.add(component.pow(2));
        }
        return sum.sqrt(MathContext.DECIMAL128);
    }
}
