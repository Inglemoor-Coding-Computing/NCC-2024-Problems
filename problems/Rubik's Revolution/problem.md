# Rubik's Revolution

You'll be given a 3 dimensional cube with 6 faces of N rows and N columns and a list of rotations. You'll output the final state of the cube after all the rotations have been applied.

**Input format**

The first line will contain an integer N, the dimension of the cube. The next 3 x N lines will contain the cube in the following format

`N < 10`

You'll receive the cube as 6 faces in the following arrangement

```
      0 0 0
      0 0 0
      0 0 0
1 1 1 2 2 2 3 3 3 4 4 4
1 1 1 2 2 2 3 3 3 4 4 4
1 1 1 2 2 2 3 3 3 4 4 4
      5 5 5
      5 5 5
      5 5 5
```

To decode moves, use the number of the face you want to rotate, and the depth of the rotation, this will rotate it 90 degrees clockwise. For example if you want to rotate face 1 at the first layer plus the second layer under it, 180 degrees, the input form would be `12 12`.

Shifting the face of a cube will affect the adjacent faces. For example, rotating face 1 will affect faces 0, 2, 4, and 5.

If shifting all the layers, make sure the opposite face is also rotated. For example, if you rotate face 1, you must also rotate face 3 to maintain geometric consistency.

Together, the encoded moves will be these integers in one line.

```
11 11 12 12 02 22 21 41 52
```

in the form

```
[face][depth] [face][depth] [face][depth] ...
```

where 0 < depth <= N

where 0 <= face <= 5

each 1 digit.

**Output format**

Output the final state of the cube in the same format as the input.
```
      0 0 0
      0 0 0
      0 0 0
1 1 1 2 2 2 3 3 3 4 4 4
1 1 1 2 2 2 3 3 3 4 4 4
1 1 1 2 2 2 3 3 3 4 4 4
      5 5 5
      5 5 5
      5 5 5
```

**Sample Input 0**
    
```
3
      r r r
      r r r
      r r r
g g g b b b w w w y y y
g g g b b b w w w y y y
g g g b b b w w w y y y
      o o o
      o o o
      o o o
21
```

**Sample Output 0**

```
      r r r
      r r r
      g g g
g g o b b b r w w y y y
g g o b b b r w w y y y
g g o b b b r w w y y y
      w w w
      o o o
      o o o
```

**Explanation 0**

The cube is rotated 90 degrees clockwise on face 2, affecting the adjacent faces. there is no additional depth to the rotation.

**Sample Input 1**
    
```
3
      r r r
      r r r
      r r r
g g g b b b w w w y y y
g g g b b b w w w y y y
g g g b b b w w w y y y
      o o o
      o o o
      o o o
52 52
```

**Sample Output 1**

```
      r r r
      r r r
      r r r
g g g b b b w w w y y y
w w w y y y g g g b b b
w w w y y y g g g b b b
      o o o
      o o o
      o o o
```

**Explanation 1**

The rotation of the bottom face moved the adjacent squares on the cube at a depth of 2, affecting 2 layers beyond the face.

**Sample Input 2**
```
2
    r r
    r r
g g b b o o w w
g g b b o o w w
    y y
    y y
01 31
```

**Sample Output 2**
```
    r o
    r b
b b o y o w r g
g g b y o w r w
    y w
    y g
```

**Explanation 2**
Multiple rotations were applied to the cube sequentially.

**Sample Input 3**
```
2
    r r
    r r
g g b b o o w w
g g b b o o w w
    y y
    y y
01 11 22 31 31 31 31 22 22 22 11 11 11 01 01 01

```

**Sample Output 3**
```
    r r
    r r
g g b b o o w w
g g b b o o w w
    y y
    y y
```

**Explanation 3**
by rotating the cube 90 degrees 4 times, the cube returns to its original state.