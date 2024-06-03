def is_consonant(c):
    return c.lower() not in ['a', 'e', 'i', 'o', 'u'] and c.lower() != ' '

def solve(userInput: str):
    data = userInput.split('\n')
    
    # Read in names
    N = int(data[0])
    names = []
    
    index = 1
    for i in range(N):
        names.append(data[index])
        index += 1

    # Read in queries
    Q = int(data[index])
    index += 1
    queries = []
    for i in range(Q):
        queries.append(int(data[index]))
        index += 1

    ret = []
    for query in queries:
        answer = 0
        # calculate answer for current query
        for name in names:
            number_of_consonants = sum(1 for c in name if is_consonant(c))
            if number_of_consonants >= query:
                answer += 1
        ret.append(answer)
    return ret

