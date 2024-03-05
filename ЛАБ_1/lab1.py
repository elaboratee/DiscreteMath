def transpose(B):
    # Транспонирует матрицу
    transposed = [[0 for _ in range(len(B))] for _ in range(len(B[0]))]
    for i in range(len(B)):
        for j in range(len(B[0])):
            transposed[j][i] = B[i][j]
    return transposed


def incidence_to_adjacency(B):
    # Переводит матрицу инцидентности в матрицу смежности
    S = [[0 for _ in range(len(B))] for _ in range(len(B))]
    B = transpose(B)

    try:
        for i in range(len(B)):
            if sum(B[i]) == 0:
                index_j = B[i].index(-1)
                index_i = B[i].index(1)
                S[index_i][index_j] = 1
            elif sum(B[i]) == 2:
                index_j = B[i].index(1)
                index_i = B[i].index(1, index_j + 1)
                S[index_i][index_j] = 1
                S[index_j][index_i] = 1
            else:
                index_i = B[i].index(1)
                S[index_i][index_i] = 1
    except ValueError as e:
        print(f"Index = {i}. Error: {e}")
    return S
        

def adjacency_to_incidence(S):
    # Переводит матрицу смежности в матрицу инцидентности
    B = []
    for i in range(len(S)):
        for j in range(i + 1, len(S)):
            array = [0 for _ in range(len(S))]
            if S[i][j] == 1:
                if S[j][i] != 1:
                    array[i] = -1
                    array[j] = 1
                else:
                    array[i] = 1
                    array[j] = 1
                B.append(array)
    return B


if __name__ == "__main__":
    INC = [[1, 0, -1, 1],
           [1, 1, 0, 0],
           [0, -1, 1, -1]]
    
    INC1 = [[1, 0, 0, 0, 0],
           [-1, 1, -1, 0, 0],
           [0, -1, 1, 1, 0],
           [0, 0, 0, 1, 1]]
    
    print('Result for INC:', incidence_to_adjacency(INC))
    # print('Result for INC1:', incidence_to_adjacency(INC1))
    print()


    ADJ = [[0, 1, 1],
           [1, 0, 1],
           [1, 0, 0]]

    ADJ1 = [[0, 1, 0, 0],
           [0, 0, 1, 0],
           [0, 1, 0, 1],
           [0, 0, 1, 1]]
    
    print('Result for ADJ:', adjacency_to_incidence(ADJ))
    # print('Result for ADJ1:', adjacency_to_incidence(ADJ1))
    