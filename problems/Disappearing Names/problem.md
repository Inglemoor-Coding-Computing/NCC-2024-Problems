# Disappearing Names

You'll be given an integer $N$ and a list of N names. However, every time you grab a name from either the front or back, the list of names magically flips itself after.
You are given a task - grabbing all the names from the list in the initial order they appeared in, finding out which index each name is grabbed at, and adding the indices.

## **Note that this problem uses 1-indexed arrays!**

Example:

```
Input:
4
Priyanka
Jonas
Viola
Orsino
Output:
```

**Input Format**

An integer $N$, followed by $N$ lines, each with a name.

$N$  
$name_1$  
$name_2$  
...  
$name_N$

**Constraints**

`1 <= N <= 1,000`

All names will be one word - no space, and contain only letters a-z (either uppercase or lowercase).

**Output Format**

A box of characters.

**Sample Input 0**

```
4
Priyanka
Jonas
Viola
Orsino
```

**Sample Output 0**

```
6
```

**Explanation 0**

Initially, our list is `[Priyanka, Jonas, Viola, Orsino]`.
Then, we take Priyanka at index $1$.
The list then flips into `[Orsino, Viola, Jonas]`. We need to grab names in the order they
appeared in the input, so we grab Jonas at index $3$. Then, the list flips into [Viola, Orsino]. We grab Viola at index $1$, then grab the remaining Orsino at index $1$. Our total sum is $1 + 3 + 1 + 1 = 6$, which gives us our answer.
