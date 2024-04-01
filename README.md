# Puzzles-CommonPrimeDivisors

Check whether two numbers have the same (common) prime divisors.

## Problem

A *prime* is a positive integer X that has exactly two divisors: 1 and X.
The first few prime integers are 2, 3, 5, 7, 11 and 13.

A prime D is called a *prime divisor* of a positive integer P
if there exists a positive integer K such that D \* K = P.
For example, 2 and 5 are prime divisors of 20.

You are given two positive integers N and M.
The goal is to check whether the sets of prime divisors
of integers N and M are exactly the same.

For example, given:

- N = 15 and M = 75, the prime divisors are the same: {3, 5};
- N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5}
- N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}

Write a function:

```
class Solution { public int solution(int [] A, int [] B); }
```

that, given two non-empty arrays A and B of Z integers,
returns the number of positions K for which
the prime divisors of A[K] and B[K] are exactly the same.

For example, given:

```
    A[0] = 15       B[0] = 75
    A[1] = 10       B[1] = 30
    A[2] = 3        B[2] = 5
```

The function should return 1, because only one pair (15, 75) has the same set of prime divisors.

Write an **efficient** algorithm for the following assumptions:

- Z is an integer within the range [1..6,000];
- each element of arrays A and B is an integer within the range [1..2,147,483,647]

## Background Information

To be successful, first one must be versed in the Euclidean algorithm.

It solves the problem of computing the greatest common divisor (gcd) of two positive integers.

### Original version of Euclid's algorithm

It is based on subtraction. We recursively subtract the smaller number from the larger.
The stop condition is when the two numbers are equal.

```
def gcd(a, b):
    if a == b:
        return a
    if a > b:
        gcd(a - b, b)
    else:
        gcd(a, b - a)
```

Time complexity is linear (based on n = a + b): O(n). This is the worst-cas complexity,
because x + y decreases with every step.

The more efficient version of the algorithm shortcuts these steps,
instead replacing the larger of the two numbers by its remainder
when divided by the smaller of the two.

With this version, the algorithm stops when reaching a zero remainder.

For two given numbers *a* and *b*:

- if b divides a (b | a), then gcd(a, b) = b,
- otherwise gcd(a, b) = gcd(b, a mod b).

Notice that the function is self-sorting.
When a < b, then b does not divide a.
The otherwise case is called.
When a < b, then the quotient is 0 and the remainder is a.
The recursive call to gcd(b, a mod b) is gcd(b, a), where b > a.
The parameters input are now a > b.

```
def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a mod b)
```

### Coprimes - converse of gcd

if gcd(a, b) = 1, then *a* and *b* are said to be coprime (or, relatively prime).
This property does not imply that *a* or *b* are themselves prime numbers.
For example, 6 and 35 factor as 6 = 2 x 3 and 35 = 5 x 7, so they are not prime,
but their prime factors are different, so 6 and 35 are coprime,
with no common factors other than 1.

The coprime property can be used to prove whether N and M have the same set of prime divisors,
by showing that it is not the case that N and M are coprime.

The greatest common divisor of two numbers a and b is the product of the prime factors shared by the two numbers.


Where A and B are arrays of integers,
for every pair of A and B values,
get that gcd.

Keep checking whether the next quotient is the smallest quotient.

When the gcd of quotient of a is 1 relative to the gcd of values a and b,
then these values are coprime, and will not have common prime divisor.

When the smallest quotient is found, then the result of quotient / gcd_of_that_value is 1.

```
def haveCommonPrimeDivisors(a, b):
    for every i in A and B:
        gcd_of_a_and_b = gcd(a, b)

        // define a gcd variable just for a
        int gcd_value_of_a

        // define a gcd variable just for b
        int gcd_value_of_b

        // define temporary value to track a quotient of divisors
        int quotient_a = a

        // define temporary value to track b quotient of divisors
        int quotient_b = b

        while quotient_a != 1:
            gcd_value_of_a = gcd(quotient_a, gcd_of_a_and_b)
            if gcd_value_of_a == 1:
                break
            quotient_a = quotient_a / gcd_value_of_a
        if quotient_a != 1:
            return false

        while quotient_b != 1:
            gcd_value_of_b = gcd(quotient_b, gcd_of_a_and_b
            if gcd_value_of_b == 1
                break
            quotient_b = quotient_b / gcd_value_of_b
        return b == 1
```
