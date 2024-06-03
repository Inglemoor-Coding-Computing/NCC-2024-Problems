# For All the Odds

You'll get two numbers as your input. You'll output all the odd numbers from least to greatest that are strictly between the input numbers that meet a certain condition. The condition is that the odd number must contain some digit that is found in either of the input values. 

For example:

```
input: 3 15
output: 5 11 13
excluded odd numbers: 7 9 
explanation: the output must have one some digit that includes 1 3 5
```

Example #2:

```
input: 23 33
output: 25 27 29 31
excluded odd numbers: none
explanation: all the odd numbers include either 2 or 3 
```

**Input Format**

Two integers separated by a space. For example:

```
-2 59
```

**Constraints**

For each input number, n, `-10 ^ 10 <= n <= 10 ^ 10`

**Output Format**

Integers separated by spaces.

**Sample Input 0**

```
0 13
```

**Sample Output 0**

```
3 11
```

**Explanation 0**

The output must be odd, `1 < n < 13`, and contain either a 1 or 3.