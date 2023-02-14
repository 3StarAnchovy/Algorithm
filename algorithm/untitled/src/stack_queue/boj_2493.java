package stack_queue;

/* 문제 리뷰
n개의 높이가 서로 다른 탑 = 같은 높이의 탑은 없음.
// 각 탑들이 레이저를 왼쪽으로 쏠 때 레이저를 수신하는 탑의 번호를 출력하는 것
 */

/*
고려사항
N의 범위는 500,000
높이는 최대 1억, 근데 1억보다 커지는 연산 발생 안함 ㅇㅇ -> int
 */

/*
첫번째 접근
- 배열 만들어서 탑들의 높이 저장
- 현재 탑의 바로 이전 탑부터 탐색을 시작하여
    현재 탑보다 높은 탑을 발견하면 해당 탑 번호
    => 이 때 탑 높은거 없으면 0 출력해야함.
   최악의 경우 -> 모든 탑들이 자신보다 큰거를 만나지 못하는 경우 좃됨 (ex. 1,2,3,.....500,000)
   대충 1200억 연산해야됨 -> 터짐
 */

/* 두번째 접근
 탐색이 필요한 탑 정보만 따로 저장해놓으면 경우의수가 줄지 않을까?
 수신할 탑 탐색시, 현재 탑의 높이 > 수신 탑인 경우 수신 탑 정보를 삭제

 수신할 탑 탐색시 현재 탑 높이 < 수신 탑인 경우 현재 탑 정보를 저장하고 수신 탑 번호 출력
 -먼저 저장한것을 나중에 사용
 -마지막에 저장한것을 가장 먼저 사용 -> 스택에 저장
 */

public class boj_2493 {


    public static void main(String[] args)
    {

    }
}
