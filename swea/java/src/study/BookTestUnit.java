package study;

public class BookTestUnit {
	public static void main(String[] args) {
		//init
		//BookManager bookmanager = new BookManager();
		BookManager bookmanager = BookManager.getInstance();
		Book[] books = new Book[6];
		for (int i = 0; i < 6; i++)
			books[i] = new Book(Integer.toString(i), Integer.toString(i), Integer.toString(i), Integer.toString(i), i, Integer.toString(i));
		books[5] = new Magazine(Integer.toString(5), Integer.toString(5), Integer.toString(5), Integer.toString(5), 5, Integer.toString(5),5,5);


		//action
		//등록, 입력값 : isbn
		//숫자 체킹
		for (int i = 0; i < 6; i++)
			bookmanager.add(books[i]);

		//조회
		System.out.println("조회 ------");
		Book[] temp = new Book[5];
		temp = bookmanager.getList();
		for (int i = 0; i < 6; i++)
			System.out.println(temp[i].toString());

		System.out.println("---------삭제--------");
		//삭제, 입력값 : isbn
		bookmanager.remove("3"); // 넘버가 3인거 삭제
		temp = bookmanager.getList();
		for (int i = 0; i < 5; i++)
			System.out.println(temp[i].toString());

		System.out.println("---------조회--------");
		//삭제, 입력값 : isbn
		temp[0] = bookmanager.searchByIsbn("4"); // 넘버가 4인거 조회

		System.out.println(temp[0].toString());
		//삭제 됨?
		//배열 순차적으로 꽉참?
		//숫자 체킹해야됨

		System.out.println("---------이름 포함 검색 ---------");
		//이름 포함 검색
		temp = bookmanager.searchByTitle("1");
		int t = 0;
		while (temp[t] != null)
		{
			System.out.println(temp[t].toString());
			t ++;
		}
		
		
	}
}
