# Fraction Approximation

Find a fraction that best approximates a real number where both the numerator and denominator are prime numbers below some upper bound.

For example, let's try to approximate `sqrt(2)` as a fraction using only prime numbers that are `<= 50`. We would find that `41/29 ~= 1.41793` which has an error of about 0.0004.

**Input Format**

U D

U is an upper-bound value for how large the prime numbers can get. 

D is a positive 64-bit floating point number.

**Constraints**

`2 < U <= 10^10`

`1 < D <= 10^6`

**Output Format**

Two integer values separated by a space, num den. For example, `41 29`.

**Sample Input 0**

```
50 1.4142135623730951
```

**Sample Output 0**

```
41 29
```

**Explanation 0**

With an upper bound of 50 on the size of our prime numbers, 41/29 is the best fraction to approximate sqrt(2) = 1.4142135623730951.

**Sample Input 1**

```
50 1.7320508075688772
```

**Sample Output 1**

```
19 11
```

**Explanation 1**

With an upper bound of 50 on the size of our prime numbers, 19/11 is the best fraction to approximate sqrt(3) = 1.7320508075688772.