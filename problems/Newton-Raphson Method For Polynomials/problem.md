# Newton-Raphson Method For Polynomials

Solve for all the real roots of any polynomial using the Newton-Raphson Method. You'll be given a series of integer values that represent the coefficients of a polynomial. You'll output all the real roots of the polynomial rounded to the nearest thousandths. 

Newton-Raphson Method is an iterative method that will calculate a better guess for a root value. The iteration should stop once a solution within a specific tolerance is found, or there is a division by zero, or the method is not converging. 

`x1 = x0 - (f(x0)/f'(x0))`

Note that f'(x) is the derivative of f(x).

The input will be the integer coefficients of a polynomial. For example: 

`1 0 -3`represents the polynomial `x^2 - 3`.

`1 4 2 -8 -2` represents the polynomial `x^4 + 4x^3 + 2x^2 - 8x - 2`.

The output will be all root solutions to within 0.0001 accuracy, rounded to the nearest thousandths. In the above examples, the output would be: 

```
-1.733
1.733
```

because when x = +-1.7325 then x^2 - 3 < 0.0001 or x^2 - 3 ~= 0.

And, we output roots in the order from smallest to largest.

The second input `1 4 2 -8 -2` will output:

```
-0.242
1.187
```

because for each of these x values `x^4 + 4x^3 + 2x^2 - 8x - 2` is ~= 0.

**Input Format**

A series of integer values on one line.

**Constraints**

The number of inputs will be less than 15 integers. Coefficients <= 200,000,000.

**Output Format**

Floating point numbers, rounded to the nearest 1-thousandths. Each number is on its own line.

**Sample Input 0**
    
```
1 0 -3
```

**Sample Output 0**

```
-1.732
1.732
```

**Explanation 0**

x^2 - 3 ~= 0 when x = +-1.73205. Rounded to the thousandth, we output `-1.732` and `1.732`.

We output smallest to greatest.

**Sample Input 1**
    
```
1 -2
```

**Sample Output 1**

```
2.000
```

**Explanation 1**

x - 2 = 0 when x = 2.0

**Sample Input 2**
    
```
1 0 -250000
```

**Sample Output 2**

```
-500.000
500.000
```

**Explanation 2**

The input says: x^2 - 250000 = 0. This means that x = +- sqrt(250000)

Answers are not always small integers. Note that (-500)^2 = 250000