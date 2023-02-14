//package offline_coaching.day230209;
//
//import java.util.Scanner;
//
//class food{
//    int s;
//    int b;
//    public food(int s, int b) {
//        this.s = s;
//        this.b = b;
//    }
//
//    public int getS() {
//        return s;
//    }
//
//    public int getB() {
//        return b;
//    }
//}
//public class bj_2961 {
//    static int N;
//    static boolean[] isSelected;
//    static food[] foods;
//    static int min;
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        min = Integer.MAX_VALUE;
//        N = scanner.nextInt();
//        isSelected = new boolean[N];
//        foods = new food[N];
//        for(int i = 0; i < N; i ++)
//        {
//            int s = scanner.nextInt();
//            int b = scanner.nextInt();
//            foods[i] = new food(s,b);
//        }
//        if (N == 1)
//            System.out.println(Math.abs(foods[0].getS() - foods[0].getB()));
//        else {
//            getPowerSet(0, 1, 0);
//            System.out.println(min);
//        }
//
////        getPowerSet(0, 1, 0);
////        System.out.println(min);
//    }
//
//    private static void getPowerSet(int cnt, int gob, int sum) {
//        if(cnt == N)
//        {
//            // 공집합
//            if (gob == 1 && sum == 0) {
//                return;
//            }
//            if(min > Math.abs(gob-sum))
//                min = Math.abs(gob-sum);
//            return;
//        }
//
//        isSelected[cnt] = true;
//        getPowerSet(cnt + 1, gob * foods[cnt].getS(), sum + foods[cnt].getB());
//
//        isSelected[cnt] = false;
//        getPowerSet(cnt + 1, gob, sum);
//    }
//}
