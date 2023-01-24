package study;

public class BookManager {
	//init
	final int MAX_SIZE = 100;
	Book books[] = new Book[MAX_SIZE];
	int size = 0;
	int m_size = 0;
	
	// 0. 인스턴스 하나만 만들고 싶음 (싱글톤) -> 하나의 객체만 생성하여 해당 객체를 반환해주는 방식
	// 1. 생성자 접근 막기 
	private BookManager(){}
	
	// 2. 객체 생성을 막았으니 클래스 멤버로 자신의 객체를 만들어 놓기
	private static BookManager bookManager = new BookManager();
	
	//3. Encapsulation 적용
	public static BookManager getInstance(){
		return bookManager;
	}
	
	//add 입력값 : 객체
	public void add(Book book)
	{
		books[size] = book;
		size ++;
		if(book instanceof Magazine)
			m_size ++;
	}
	
	//remove 입력값 : 책 넘버
	public void remove(String isbn)
	{
		//size까지 탐색하면서
		Book temp = new Book();
		int iTemp;
		for(int i = 0; i < size; i ++)
		{
			//책넘버 일치하는거 체킹
			if(books[i].isbn.equals(isbn))
			{
				iTemp = i;
				temp = books[iTemp];
				books[iTemp] = books[size - 1];
				books[size - 1] = null;
				size --;
				break;
			}
		}
		//가비지 컬렉터가 회수하게끔
		temp = null;
	}
	
	public Book[] getList()
	{
		return books;
	}

	public Magazine[] getMagazines()
	{
		Magazine[] result = new Magazine[m_size];
		int cnt = 0;

		for(int i = 0; i < size; i ++)
		{
			if(books[i] instanceof Magazine) {
				result[cnt] = (Magazine) books[i];
			}
		}

		return result;
	}

	public Book[] getBooks()
	{
		Book[] result = new Book[size - m_size];
		int cnt = 0;

		for(int i = 0; i < size; i ++)
		{
			if(!(books[i] instanceof Magazine)) {
				result[cnt] = books[i];
			}
		}
		return result;
	}
	
	public Book searchByIsbn(String isbn)
	{
		for(int i = 0; i < size; i ++)
		{
			//책넘버 일치하는거 체킹
			if(books[i].isbn.equals(isbn))
				return books[i];
		}
		return null;
	}

	public Book[] searchByTitle(String title)
	{
		Book[] result = new Book[MAX_SIZE];
		int cnt = 0;
		for(int i = 0; i < size; i ++)
		{
			if(books[i].title.contains(title))
			{
				result[cnt] = books[i];
				cnt ++;
			}
		}
		return result;
	}

	public int getTotalPrice()
	{
		int sum = 0;

		for(int i = 0; i < size; i ++)
			sum += books[i].price;

		return sum;

	}

	public double getPriceAvg()
	{
		return ((double)getTotalPrice() / (double) size);
	}
}
