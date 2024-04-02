import java.util.*;

public class CommonPrimeDivisor {

    public static void main(String [] args) {
        System.out.printf("Hello common prime divisor solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java CommonPrimeDivisor%n");
            return;
        }
        int [] A = new int [] {15, 10, 3};
        int [] B = new int [] {75, 30, 5};
        CommonPrimeDivisor commonPrimeDivisor = new CommonPrimeDivisor();
        int numberOfPositions = commonPrimeDivisor.solution(A, B);
        System.out.printf("The number of positions with common prime divisors is %d%n", numberOfPositions);
    }

    public int solution(int [] A, int [] B) {

        int result = 0;
        System.out.printf("array A is %s%n", Arrays.toString(A));
        System.out.printf("array B is %s%n", Arrays.toString(B));

        for(int i = 0; i < A.length; i++) {
            System.out.printf("for index = %d%n", i);
            int aValue = A[i];
            int bValue = B[i];
            if (hasCommonPrimeDivisors(aValue, bValue)) {
                System.out.printf("index i %d has common prime divisors - increment%n", i);
                result++;
            }
        }

        return result;
    }

    public boolean hasCommonPrimeDivisors(int a, int b) {

            System.out.printf("given a = %d and b = %d%n", a, b);

            int gcd_of_a_and_b = gcd(a, b);
            System.out.printf("gcd(a, b) is %d%n", gcd_of_a_and_b);

            int gcdA = 0;
            int gcdB = 0;
            int quotientA = a;
            int quotientB = b;

            while (quotientA != 1) {
                System.out.printf("while quotient a %d is not equal to 1%n", quotientA);
                gcdA = gcd(quotientA, gcd_of_a_and_b);
                System.out.printf("gcd of quotient a %d%n", gcdA);
                if (gcdA == 1) {
                    // found that current quotientA and gcd_of_a_and_b are coprime
                    // they will not have the same set of common prime divisors
                    System.out.printf("gcd of quotient a is equal to 1 - coprime with gcd of a and b%n");
                    break;
                }
                System.out.printf("Apply gcd of quotient a to the quotient a%n");
                quotientA = quotientA / gcdA;
                System.out.printf("Revised quotient a %d%n", quotientA);
            }

            // When quotientA == 1 then the quotient values of a share common prime divisors with gcd of a and b
            // When quotientA != 1 then the quotient values of a do not share common prime divisors with gcd of a and b
            if (quotientA != 1) {
                return false;
            }

            while (quotientB != 1) {
                System.out.printf("while quotient b %d is not equal to 1%n", quotientB);
                gcdB = gcd(quotientB, gcd_of_a_and_b);
                System.out.printf("gcd of quotient b %d%n", gcdB);
                if (gcdB == 1) {
                    // found that current quotientB and gcd_of_a_and_b are coprime
                    // they will not have the same set of common prime divisors
                    System.out.printf("gcd of quotient b is equal to 1 - coprime with gcd of a and b%n");
                    break;
                }
                System.out.printf("Apply gcd of quotient b to the quotient b%n");
                quotientB = quotientB / gcdB;
                System.out.printf("Revised quotient b %d%n", quotientB);
            }

            // When quotientB == 1 then the quotient values of b share common prime divisors with gcd of a and b
            // When quotientB != 1 then the quotient values of b do not share common prime divisors with gcd of a and b
            return quotientB == 1;

    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
