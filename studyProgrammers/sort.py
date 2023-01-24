#array = [1, 5, 2, 6, 3, 7, 4]
#commands = [[2,5,3],[4,4,1],[1,7,3]]


def getArray(array, commands):
	sortedArray = [];
	resultArray = [];
	for i in range(len(commands)):
		sortedArray.append(array[commands[i][0]-1 : commands[i][1]])
		sortedArray[i].sort()
		resultArray.append(sortedArray[i][commands[i][2]-1])
	return(resultArray)


def solution(array, commands):
	return (getArray(array,commands));

#solution(array,commands)
