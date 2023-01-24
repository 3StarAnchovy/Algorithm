s = "one4seveneight"

def isWord(s):
	if 'one' in s:
		s = s.replace('one','1')
		return s
	if 'two' in s:
		s = s.replace('two','2')
		return s
	if 'three' in s:
		s = s.replace('three','3')
		return s
	if 'four' in s:
		s = s.replace('four','4')
		return s
	if 'five' in s:
		s = s.replace('five','5')
		return s
	if 'six' in s:
		s = s.replace('six','6')
		return s
	if 'seven' in s:
		s = s.replace('seven','7')
		return s
	if 'eight' in s:
		s = s.replace('eight','8');
		return s
	if 'nine' in s:
		s = s.replace('nine','9')
		return s
	if 'zero' in s:
		s = s.replace('zero','0')
		return s
	else :
		return 0;

def getNumber(s):
	while(isWord(s)):
		s = isWord(s)
	return s

def solution(s):
	answer = getNumber(s);
	return (int(answer))
	#return answer

solution(s)

