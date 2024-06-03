# Consonantal Names

You are given an integer $N$ and a list of $N$ names, each on their own line. You are then given an integer $Q$ and a list of
$Q$ queries, with each query simply being an integer $q$ on its own line. Your task is to, for each query, output the number of names containing at least $q$ consonants.

Example:

Input:

```
4
Nitsuj
iHsiR
LeInad
TREBLA
2
4
3
```

Output:

```
2
4
```

**Input Format**

An integer $N$, then $N$ names on their own line, then an integer $Q$, then $Q$ integers on their own line.

$N$  
$name_1$  
$name_2$  
...  
$name_N$  
$Q$  
$query_1$  
$query_...$  
$query_Q$

**Constraints**

$1 <= N <= 2000$

Each character in a name is either an alphabetic lowercase or uppercase character (ascii 65-90, 97-122, both inclusive) or a space character (ascii value of 32).

$1 <= max\_word\_length <= 10$  
$1 <= Q <= 100$  
$1 <= query_i <= 10$

**Output Format**

$Q$ lines of integers, with the $ith$ line representing the answer to the $ith$ query.

**Sample Input 0**

```

4
Nitsuj
iHsiR
LeInad
TREBLA
2
4
3
```

**Sample Output 0**

```

2
4

```

**Explanation 0**

There are 2 names with at least 4 consonants - `Nitsuj` and `TREBLA`.
It can be shown for the second query that all four names have at least 3 consonants.

```

```
