import string, math

change_num = string.digits+string.ascii_lowercase
def convert_num(num, base) :
    q, r = divmod(num, base)
    if q == 0 :
        return change_num[r]
    else :
        return convert_num(q, base) + change_num[r]

def is_prime_number(x):
    for i in range(2, int(math.sqrt(x))+1):
        if x % i == 0:
            return False
    return True

def solution(n, k):
    answer = 0
    if k==10: num = n
    else: num = convert_num(n, k)

    num_s = str(num)

    num_s = num_s.split('0')
    for n in num_s:
        if not n : continue
        if int(n) < 2: continue
        if is_prime_number(int(n)):
            answer += 1

    return answer


solution(437674, 3)
solution(110011, 10)