# Crawl Map

You'll be given the contents of a map as two lines of input, each line is a series of strings separated by spaces. The first line is to be used as the keys to a map or dictionary. The second line is the set of values that map to those keys.

Find the smallest value (since this is a string, the first alphabetically). This will be your first key to use.

If the key is in the set of keys provided, find the value it is associated with. The value becomes your next key. Continue until the value is not a key, or until a cycle is encountered.

Output the last key that is found in the map. If a cycle is encountered, output the last key before the cycle is started.

If the first value is not in the set of keys, output `<none>`.

**Input Format**

key1 key2 key3...keyn
val1 val2 val3...valn

**Constraints**

Keys will be unique ascii strings. Values will be unique ascii strings.

The length of each string, L, `1 <= L <= 50`

The number of keys, N, `1 <= N <= 10^5`

**Output Format**

string

**Sample Input 0**

```
a b c
r a b
```

**Sample Output 0**

```
a
```

**Explanation 0**

The first value is `a`. This is a key that exists and it has the value `r`. But, `r` is not a key, so the output is `a`.

**Sample Input 1**

```
a b c d
z w x y
```

**Sample Output 1**

```
<none>
```

**Explanation 1**

The first value is `w` but that is not found in the set of keys. Output `<none>`.

**Sample Input 2**

```
d
```

**Explanation 2**

`a` is the first value to use. a -> b, b -> c, c -> d, d -> a. But, `a` is the start of cycle. So, we output the last valid key we visited before entering the cycle, `d`.