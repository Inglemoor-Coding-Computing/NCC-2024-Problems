var n = int.Parse(Console.ReadLine()!);

char[][,] faces = new char[6][,];

// initialize faces
for (var i = 0; i < 6; i++)
    faces[i] = new char[n, n];

// read faces
for (var i = 0; i < n; i++)
{
    var line = Console.ReadLine()!.Split(' ', StringSplitOptions.RemoveEmptyEntries);
    for (var j = 0; j < n; j++)
    {
        faces[0][i, j] = line[j][0];
    }
}

for (var i = 0; i < n; i++)
{
    var line = Console.ReadLine()!.Split(' ', StringSplitOptions.RemoveEmptyEntries);
    for (var j = 0; j < n; j++)
    {
        faces[1][i, j] = line[j][0];
        faces[2][i, j] = line[j + n][0];
        faces[3][i, j] = line[j + 2 * n][0];
        faces[4][i, j] = line[j + 3 * n][0];
    }
}


for (var i = 0; i < n; i++)
{
    var line = Console.ReadLine()!.Split(' ', StringSplitOptions.RemoveEmptyEntries);
    for (var j = 0; j < n; j++)
        faces[5][i, j] = line[j][0];
}


var rotations = Console.ReadLine()!.Split(' ', StringSplitOptions.RemoveEmptyEntries).Select(x => (int.Parse(x[0].ToString()), int.Parse(x[1].ToString())));

foreach (var (rotation, depth) in rotations)
{
    faces[rotation] = RotateMatrix(faces[rotation], n);
    var temp = new char[n];
    for (var d = 0; d < depth; d++)
    {
        switch (rotation)
        {
            case 0:
                for (var i = 0; i < n; i++) temp[i] = faces[1][d, i];
                for (var i = 0; i < n; i++) faces[1][d, i] = faces[2][d, i];
                for (var i = 0; i < n; i++) faces[2][d, i] = faces[3][d, i];
                for (var i = 0; i < n; i++) faces[3][d, i] = faces[4][d, i];
                for (var i = 0; i < n; i++) faces[4][d, i] = temp[i];
                break;
            case 1:
                faces[4] = RotateMatrix(faces[4], n);
                faces[4] = RotateMatrix(faces[4], n);
                for (var i = 0; i < n; i++) temp[i] = faces[4][i, d];
                for (var i = 0; i < n; i++) faces[4][i, d] = faces[5][i, d];
                for (var i = 0; i < n; i++) faces[5][i, d] = faces[2][i, d];
                for (var i = 0; i < n; i++) faces[2][i, d] = faces[0][i, d];
                for (var i = 0; i < n; i++) faces[0][i, d] = temp[i];
                faces[4] = RotateMatrix(faces[4], n);
                faces[4] = RotateMatrix(faces[4], n);
                break;
            case 2:
                for (var i = 0; i < n; i++) temp[i] = faces[0][n - 1 - d, i];
                for (var i = 0; i < n; i++) faces[0][n - 1 - d, i] = faces[1][n - 1 - i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[1][i, n - 1 - d] = faces[5][d, i];
                for (var i = 0; i < n; i++) faces[5][d, i] = faces[3][n - 1 - i, d];
                for (var i = 0; i < n; i++) faces[3][i, d] = temp[i];
                break;
            case 3:
                faces[4] = RotateMatrix(faces[4], n);
                faces[4] = RotateMatrix(faces[4], n);

                for (var i = 0; i < n; i++) temp[i] = faces[0][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[0][i, n - 1 - d] = faces[2][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[2][i, n - 1 - d] = faces[5][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[5][i, n - 1 - d] = faces[4][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[4][i, n - 1 - d] = temp[i];

                faces[4] = RotateMatrix(faces[4], n);
                faces[4] = RotateMatrix(faces[4], n);
                break;
            case 4:
                faces[0] = RotateMatrix(faces[0], n);
                faces[5] = RotateMatrix(faces[5], n);
                faces[5] = RotateMatrix(faces[5], n);
                faces[5] = RotateMatrix(faces[5], n);
                faces[1] = RotateMatrix(faces[1], n);
                faces[1] = RotateMatrix(faces[1], n);

                for (var i = 0; i < n; i++) temp[i] = faces[1][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[1][i, n - 1 - d] = faces[0][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[0][i, n - 1 - d] = faces[3][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[3][i, n - 1 - d] = faces[5][i, n - 1 - d];
                for (var i = 0; i < n; i++) faces[5][i, n - 1 - d] = temp[i];


                faces[0] = RotateMatrix(faces[0], n);
                faces[0] = RotateMatrix(faces[0], n);
                faces[0] = RotateMatrix(faces[0], n);
                faces[5] = RotateMatrix(faces[5], n);
                faces[1] = RotateMatrix(faces[1], n);
                faces[1] = RotateMatrix(faces[1], n);
                break;

            case 5:
                for (var i = 0; i < n; i++) temp[i] = faces[1][n - 1 - d, i];
                for (var i = 0; i < n; i++) faces[1][n - 1 - d, i] = faces[4][n - 1 - d, i];
                for (var i = 0; i < n; i++) faces[4][n - 1 - d, i] = faces[3][n - 1 - d, i];
                for (var i = 0; i < n; i++) faces[3][n - 1 - d, i] = faces[2][n - 1 - d, i];
                for (var i = 0; i < n; i++) faces[2][n - 1 - d, i] = temp[i];
                break;
        }
    }
}

// print it back

for (var i = 0; i < n; i++)
{
    for (var j = 0; j < n; j++) Console.Write("  ");
    for (var j = 0; j < n; j++) Console.Write(faces[0][i, j] + " ");
    Console.WriteLine();
}

for (var i = 0; i < n; i++)
{
    for (var j = 0; j < n; j++) Console.Write(faces[1][i, j] + " ");
    for (var j = 0; j < n; j++) Console.Write(faces[2][i, j] + " ");
    for (var j = 0; j < n; j++) Console.Write(faces[3][i, j] + " ");
    for (var j = 0; j < n; j++) Console.Write(faces[4][i, j] + " ");
    Console.WriteLine();
}

for (var i = 0; i < n; i++)
{
    for (var j = 0; j < n; j++)
        Console.Write("  ");
    for (var j = 0; j < n; j++)
        Console.Write(faces[5][i, j] + " ");
    Console.WriteLine();
}

static T[,] RotateMatrix<T>(T[,] matrix, int n)
{
    T[,] ret = new T[n, n];
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j)
            ret[i, j] = matrix[n - j - 1, i];
    return ret;
}