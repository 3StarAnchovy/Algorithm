rank = [6,6,5,4,3,2,1]

def solution(lottos, win_nums):
	result = 0
	result2 = 0
	for i in lottos :
		if(i == 0):
			result2 += 1
		for j in win_nums :
			if (i == j):
				result += 1
	answer = [rank[(result2 + result)], rank[result]]
	return answer
