package study;

public class Magazine extends Book{
    int year;
    int month;

    public Magazine()
    {

    }

    public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
        super(isbn, title, author, publisher, price, desc);
        this.year = year;
        this.month = month;
    }

    @Override
    public String toString()
    {
        return (super.toString() + " : " + year + " : " + month);
    }
}
