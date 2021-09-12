import math
def timeReturn(time):
    play_time = time.split(':')
    return int(play_time[0])*60 + int(play_time[1])

def solution(fees, records):
    answer = []
    park = {}
    car_t = {}
    records = [r.split() for r in records]
    for record in records:
        t = timeReturn(record[0])
        way = record[2]
        if way == 'IN':
            park[record[1]] = t
        else:
            if car_t.get(record[1]): car_t[record[1]] += t - park[record[1]]
            else: car_t[record[1]] = t - park[record[1]]
            park.pop(record[1])


    for key in park.keys():
        t = timeReturn('23:59')
        if car_t.get(key):
            car_t[key] += t - park[key]
        else:
            car_t[key] = t - park[key]
    for car in sorted(car_t.keys()):

        car_fee = fees[1]
        if car_t[car]-fees[0] > 0:
            car_fee += math.ceil((car_t[car]-fees[0])/fees[2]) * fees[3]
        answer.append(car_fee)
    return answer



solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"])