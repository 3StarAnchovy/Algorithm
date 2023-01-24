numbers = [7,1,1,0]

def sumArray(numbers):
	result = []
	for i in range(len(numbers)):
		for j in range(len(numbers)):
			if(i != j):
				result.append(numbers[i] + numbers[j]);

	result = set(result);
	result = list(result)
	return (sorted(result))

def solution(numbers):
    print(sumArray(numbers))
    return sumArray(numbers)

solution(numbers);
