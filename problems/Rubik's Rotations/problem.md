# Rubik's Rotations

You will be given a N x N grid representing the a face of a Rubik's cube. You will be given a series of next $m$ possible moves, at least one of which is achievable from the existing state by rotating the only face of the cube. You must output the first correct state. There may be missing information on the next moves. The next state will never the same as the current state.

**Input Format**

```
n m
c c c
c c c
c c c

d d d
d d d
d d d

e e e
e e e
e e e

f f f
f f f
f f f
...
z z z
z z z
z z z
```

Where c is the current state of the cube's face, and d, e, f, ..., z are the next `m` possible moves.

$m > 1$

The c...z are guaranteed to be square with uniform rows and columns `n`.

$n > 1$

Exactly one case from $d$ on will be the correct next state of the cube.

Each color is represented by a single alphanumeric ASCII character.

If a space is missing, it will instead be a `#` character.

**Output Format**

Output the grid of the first valid next move as it was given in the input, with missing portions filled in.

```
d d d
d d d
d d d
```


**Sample Input 0**

```
3 4
r r r
g b g
y y y

r r b
# b b
g g #

# b b
b # b
b b #

y g r
y # r
y # r

y # y
r b r
y g r
```

**Sample Output 0**

```
y g r
y b r
y g r
```

**Sample Explanation 0**

This is the only valid next move from the input. It is a rotation of the last face, with the missing # spaces filled in.

**Sample Input 1**
    
```
5 3
r r r r r
g g g g g
b b b b b
y y y y y
w w w w w

r r r r r
g g g # g
b b b # b
y y y # y
w w w w #

w w w # #
y y y y #
# b b # b
g g g g g
r r r r r

r r # # #
b b b g g
y y y y y
w w w w w
r r r r r
```

**Sample Output 1**

```
w w w w w
y y y y y
b b b b b
g g g g g
r r r r r
```

**Sample Explanation 1**

This is the only valid next move from the input. It is a rotation of the last face 180 degrees, with the missing # spaces filled in. The alternatives either do not rotate the face or would not be achievable from the current state with a rotation.


