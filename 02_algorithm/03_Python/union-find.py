def get_parent(parents, x):
    print(parents, x)
    if parents[x] == x: return x
    return get_parent(parents, parents[x])

def union_parent(parent, a, b):
    a = get_parent(parent, a)
    b = get_parent(parent, b)
    if a < b: parent[b] = a
    else: parent[a] = b

def find_parent(parent, a, b):
    a = get_parent(parent, a)
    b = get_parent(parent, b)
    if a==b: return 1
    else: return 0

def main():
    parents = [0]*11
    for i in range(1, 10):
        parents[i] = i
    print(parents)
    union_parent(parents, 1, 2)
    union_parent(parents, 2, 3)
    union_parent(parents, 3, 4)
    union_parent(parents, 5, 6)
    union_parent(parents, 6, 7)
    
    print('1과 5는 연결되어 있나요?')
    print(find_parent(parents, 1, 5))

main()