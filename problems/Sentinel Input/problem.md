# Sentinel Input

Read input from standard input until `<end>` is found. Print the input to standard output. The string `<end>` is guaranteed to be the last line in the input. All characters in are valid ascii characters.

**Input Format**

string

string

**Constraints**

Last line ends with `<end>`

**Output Format**

The input lines, but without the `<end>` line

**Sample Input 0**

```
Hello
There
<end>
```

**Sample Output 0**

```
Hello
There
```

**Explanation 0**

Output lines until `<end>` is seen.

**Sample Input 1**

```
This is a full line.
Put an entire line as a line.
A line can contain <end> in it.
<end>
```

**Sample Output 1**

```
This is a full line.
Put an entire line as a line.
A line can contain <end> in it.
```

**Explanation 1**
Lines can contain multiple words.