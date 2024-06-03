# Smallest subset is Target

Output the smallest subset (fewest count) of positive integers in a list whose sum is a given target. The numbers may not repeat. 

* The output should be sorted from smallest to largest. 

* If there is a tie, output the list whose product is the smallest. 

* If no set exists, output `<none>`. 

The input will be a series of positive integers separated by spaces, starting with the target value. The list of positive integers can be in any order. 

Example #1: Input: 

```
4 3 2 1
```

Output: 

```
1 3
```

**Input Format**

T N1 N2 N3 ... Nn

T = Target number
Ni = A positive integer value in the list

**Constraints**

`0 < T <= 10^5`

`0 < Ni <= 10^3`

`1 < n < 21`

`Ni are all unique`

**Output Format**

A series of integers, from smallest to largest, from the original list, separated by spaces. 

`M1 < M2 < ... < Mj where Mi in N`

`j <= n where n is the count of numbers in the input`

`T = Sum i=0 -> j where j is the count of numbers in the output.`

**or**

If there is no solution, output `none`

**Sample Input 0**

```
4 3 2 1
```

**Sample Output 0** 

```
1 3
```

**Explanation 0**

1 + 3 = 4. 1 and 3 are in the original input.

**Sample Input 1**

```
7 4 2 3 6 5
```

**Sample Output 1**

```
2 5
```

**Explanation 1**

2 + 5 = 7. But, also 3 + 4 = 7. However, 2 x 5 < 3 x 4

**Sample Input 2**
```
12 1 2 3
```

**Sample Output 2**
```
<none>
```

**Explanation 2**

There is no combination of 1,2,3 that add up to 12.