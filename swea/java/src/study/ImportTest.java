package day0118;

// TODO: import 되는 패키지들을 살펴보자.
import java.awt.List;
//import java.util.List;
import static java.lang.Math.max;

// END:

public class ImportTest {
	List list;
	
	java.util.List list2;
	
	public static void main(String[] args)
	{
		System.out.println(Math.max(10,20)); //얘는 왜 인스턴스화 안함? -> 함수 까보니까 static으로 되있음
		System.out.println(max(10, 20)); //근데 println은 왜 인스턴스화 안함?, 이따 물어보자
	}
}
    // TODO: Object 타입의 객체를 선언해보자.
