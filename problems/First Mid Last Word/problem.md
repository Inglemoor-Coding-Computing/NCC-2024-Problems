# First Mid Last Word

Read in a list of words until you reach the word `<end>` which is not included in the list. Sort the list and print out the first, middle, and last word. If there are an even number of words, the middle word will be the one closer to start (e.g. 2 of 4). It is possible that the list may be any length: `0 <= length`. If the length == 1, the same word will be printed 3 times. If the length is empty, nothing is printed.

Words will be sorted lexicographically (or alphabetically). Note that upper-case letters are sorted before lower-case letters. 

**Input Format**

word1

word2

word3

...

wordn

**Constraints**

Words will be of length, L, `1 <= L < 100000000`and may contain any ASCII character or digit, upper-case or lower-case. 

**Output Format**

first-word

mid-word

last-word 

**Sample Input 0**

```
tree
apple
carrot
snake
dog
<end>
```

**Sample Output 0**

```
apple
dog
tree
```

**Explanation 0**

The full set of words is sorted as follows:

apple carrot dog snake tree

The first word is "apple". The middle word is "dog". The last word is "tree".

**Sample Input 1**

```
apple
Carrot
dog
Zesty
<end>
```

**Sample Output 1**

```
Carrot
Zesty
dog
```

**Explanation 1**

The sorted list is: Carrot Zesty apply dog

Upper-case letters go first.

The length of the list is 4 so we take the 2nd word as the middle word.