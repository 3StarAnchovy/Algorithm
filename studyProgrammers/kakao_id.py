from curses.ascii import isalpha, isdigit


new_id = '=.='

#1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
def step1(new_id):
	new_id = new_id.lower();
	return new_id

#2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
def step2(new_id):
	answer = []
	for i in new_id :
		if(i.isalpha() or i.isdigit() or i == '-' or i == '_' or i == '.'):
			answer.append(i);
	answer = "".join(answer);
	return answer

#3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
def step3(new_id):
	while '..' in new_id :
		new_id = new_id.replace('..','.');
	return (new_id);

#4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
#-1까지인데..? 왜 끝문자제거임 시발?
#빈문자열은 인덱스 못찍음
def step4(new_id):
	if (len(new_id) > 0 and new_id[0] == '.' ):
		new_id = new_id[1:]
	if (len(new_id) > 0 and new_id[-1] == '.' ) :
		new_id = new_id[:-1]
		#복사본에서 -1
	return (new_id);


#5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
def step5(new_id):
	if (new_id == ''):
		new_id = new_id + 'a'
	return new_id

#6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
#만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
def step6(new_id):
	while(len(new_id) >= 16):
		new_id = new_id[:-1]
	if (len(new_id) > 0 and new_id[-1] == '.' ) :
		new_id = new_id[:-1]
	return new_id

#7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
def step7(new_id):
	while(len(new_id) <= 2):
		new_id += new_id[-1]
	return new_id


def solution(new_id):
	answer = step1(new_id);
	answer = step2(answer);
	answer = step3(answer);
	answer = step4(answer);
	answer = step5(answer);
	answer = step6(answer);
	answer = step7(answer);
	return answer

print(solution(new_id));
