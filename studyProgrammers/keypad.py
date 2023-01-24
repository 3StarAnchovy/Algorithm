from turtle import right
from unittest import result
import math

left = [1, 4, 7]
right = [3, 6, 9]
numbers = [2, 5, 4, 5, 8, 2, 1, 4, 5, 9, 5]

#좌표 거리 계산


def isHand(left_position, right_position, num, hand):
	num_dict = {
		1: [0, 3], 2: [1, 3], 3: [2, 3],
		4: [0, 2], 5: [1, 2], 6: [2, 2],
		7: [0, 1], 8: [1, 1], 9: [2, 1],
		'*': [0, 0], 0: [1, 0], '#': [2, 0],
	}
	left_xy = num_dict[left_position]
	right_xy = num_dict[right_position]
	num_xy = num_dict[num]
	#left_distance = math.sqrt( pow((num_xy[1] - left_xy[1]),2) + pow((num_xy[0] - left_xy[0]),2) )
	#right_disdance = math.sqrt( pow((num_xy[1] - right_xy[1]),2) + pow((num_xy[0] - right_xy[0]),2) )
	if(left_distance > right_disdance):
		return ('R')
	elif(left_distance < right_disdance):
		return ('L')
	else:
		if(hand == 'right'):
			return ('R')
		elif(hand == 'left'):
			return ('L')


def solution(numbers, hand):
	result = []
	left_position = '*'
	right_position = '#'
	for i in numbers:
		if i in left:
			result.append('L')
			left_position = i
		elif i in right:
			result.append('R')
			right_position = i
		else:
			test = isHand(left_position, right_position, i, hand)
			if(test == 'R'):
				right_position = i
			elif(test == 'L'):
				left_position = i
			result.append(test)
	answer = ''
	for i in result:
		answer += i
	print(answer)
	return answer


#isHand(1,9,5);
solution(numbers, 'left')
