package day0118;

public class Test {
	String name = "A"; //String 어케쓴거? -> 기본으로 java.lang이 import 되어있음
						//
	{
		name = "B";
		System.out.println("초기화 블록 실행");
	}
	
	//해당 클래스가 메모리에 로드 될 때 한번만 실행
	static {
		System.out.println("스태틱 블록 실행");
	}
	
	public Test()
	{
		this.name="C";
	}
	
	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(t.name);
		Test t2 = new Test();
		
		final int a = 30;
		final int[] arr = new int[10];
		arr[3] = 30; //얘 값 바뀜 ㅋ -> 레퍼런스타입임 -> 주소값이 고정되는거임. 참조되는 것은 바꿀 수 있음.
		
		//arr = new int[20]; 얘는 값 안바뀜 ->final 걸려있음
	}
}
