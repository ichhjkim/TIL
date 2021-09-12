# 금지된 단어를 제외한 가장 흔하게 등장하는 단어를 출력하라, 대소문자 구분 않함, 마침표/쉼표 무시
import re, collections
def solution(parapgraph, banned):

    words = [word for word in re.sub('\w', '', parapgraph).lower().split() if word not in banned]
    counts = collections.Counter(words)
    return counts.most_common(1)[0][0]
