var firstLine = Console.ReadLine()!.Split(' ');

var n = int.Parse(firstLine[0]);
var m = int.Parse(firstLine[1]);

var starting = new char[n, n];
var nextMoves = new char[3][,];
for (var i = 0; i < 3; i++)
    nextMoves[i] = new char[n,n];
var choices = new char[m][,];
for (var i = 0; i < m; i++)
{
    choices[i] = new char[n,n];
}

for (var i = 0; i < n; i++)
{
    var line = Console.ReadLine()!.Split(' ');
    for (var j = 0; j < n; j++)
        starting[i, j] = line[j][0];
}

for (var i = 0; i < m; i++)
{
    Console.ReadLine();
    for (var j = 0; j < n; j++)
    {
        var line = Console.ReadLine()!.Split(' ');
        for (var k = 0; k < n; k++)
            choices[i][j, k] = line[k][0];
    }
}

nextMoves[0] = RotateMatrix(starting, n);
nextMoves[1] = RotateMatrix(nextMoves[0], n);
nextMoves[2] = RotateMatrix(nextMoves[1], n);

foreach (var choice in choices)
{
    foreach (var nextMove in nextMoves)
    {
        if (IsMatch(n, choice, nextMove))
        {
            // print
            for (var i = 0; i < n; i++)
            {
                for (var j = 0; j < n; j++)
                    Console.Write(nextMove[i, j] + " ");
                Console.WriteLine();
            }
            return;
        }
    }
}

static T[,] RotateMatrix<T>(T[,] matrix, int n)
{
    T[,] ret = new T[n, n];
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j)
            ret[i, j] = matrix[n - j - 1, i];
    return ret;
}

static bool IsMatch(int n, char[,] choice, char[,] rotation)
{
    for (var i = 0; i < n; i++)
    {
        for (var j = 0; j < n; j++)
        {
            if (choice[i, j] == '#')
                continue;
            if (choice[i, j] != rotation[i, j])
                return false;
        }
    }
    return true;
}