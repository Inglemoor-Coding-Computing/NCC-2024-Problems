# Rubik's Revolution

You'll be given a 3 dimensional cube with faces of N dimension and a series of rotations. You'll output the final state of the cube after all the rotations have been applied.

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

To encode moves, use the number of the face you want to rotate, and the depth of the rotation, this will rotate it 90 degrees clockwise. For example if you want to rotate face 1 at the first layer plus the second layer under it, 180 degrees, the encoded form would be `12 12`.

Shifting the face of a cube will affect the adjacent faces. For example, rotating face 1 will affect faces 0, 2, 4, and 5.

Together, the encoded moves will be these integers in one line.

```
11 11 12 12 02 22 21 41 52
```

in the form

```
facedepth facedepth facedepth ...
```

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
      g g g
g g o b b b r w w y y y
g g o b b b r w w y y y
g g o b b b r w w y y y
      w w w
      o o o
      o o o
51 51
```

**Sample Output 1**

```
      r r r
      r r r
      g g g
g g o b b b r w w y y y
g g o b b b r w w y y y
r w w y y y g g o b b b
      o o o
      o o o
      w w w
```

**Explanation 1**

The rotation of the bottom face moved the adjacent squares on the cube.

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

3
      a b c
      d e f
      g h i
j k l m n o p q r s t u
v w x y z A B C D E F G
H I J K L M N O P Q R S
      T U V
      W X Y
      Z + =
02 31 01 13 22 11 02 42 22 51 33 01 33 41 52 31 31 02 01 12 53 13 22 52 43 22 42 13 53 22 52
      N v j
      h C t
      c E T
l y Q g W o p D J m G H
b F n U e Y B z + O X A
i L a K q S Z d s V I r
      M R P
      x w f
      = k u

5
          r r r r r
          r r r r r
          r r r r r
          r r r r r
          r r r r r
g g g g g b b b b b o o o o o w w w w w
g g g g g b b b b b o o o o o w w w w w
g g g g g b b b b b o o o o o w w w w w
g g g g g b b b b b o o o o o w w w w w
g g g g g b b b b b o o o o o w w w w w
          y y y y y
          y y y y y
          y y y y y
          y y y y y
          y y y y y
21 52 43 31 43 13 21 42 22 23 02 32 23 23 03 52 41 52 43 33 52 31 21 01 03 23 01 31 01 22 11
          g b o w r
          g b o b o
          r y y r y
          w y o w r
          r o y b o
b b b y o w y g o y w b w b b o g r y y
b b o y o w o y g y w r r w g b y g o r
b g w b y o g o w r g r b w b o y g y g
w r b o o w w b w w r r w g r o b o r g
w r w r g y r y o y b g w g g r b o r g
          w g b y o
          o g b y y
          g r r g r
          w o w g y
          r g w y b