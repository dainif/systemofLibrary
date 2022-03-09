package entiy;

public class Book {
    private Integer id;
    private String bookname;
    private String press;
    private String author;
    private Integer num;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num +
                '}';
    }

    public Book( String bookname, String press, String author,Integer num) {
        this.bookname = bookname;
        this.press = press;
        this.author = author;
        this.num = num;
    }
    public Book(String bookname, String press, String author) {
        this.bookname = bookname;
        this.press = press;
        this.author = author;
    }

    public Integer getNum() {
        return num;
    }
    public Book(String bookname,Integer num) {
        this.bookname = bookname;
        this.num = num;
    }
    public Book(String bookname) {
        this.bookname = bookname;
    }
    public void setNum(Integer num) {
        this.num = num;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
