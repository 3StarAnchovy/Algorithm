package floyd;

public class sample {
}

/*
모든 정점 쌍 사이 최단 거리를 구하는 알고리즘
음수인 사이클이 생기면 문제 생김

step1
 - 테이블 짜기. 다른
ste 2
 - 다른 정점을 거치지 않았거나 1번 정점을 거쳤을 때로 수정
 s에서 t로 가는 최단거리
 (d[s][t] = Math.min(d[s][1] + d[1][t], d[s][t])
step 3 정점 수 만큼 반복
최악의 경우의 수 v * v를 v번 탐색하기 때문에 v3
*/