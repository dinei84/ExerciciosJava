package entities;

public class Books {
    private String title;
    private String author;
    private Integer ISBN;
    private Integer year;
    private Integer amount;

    public Books(String title, String author, Integer ISBN, Integer year, Integer amount) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void reduceAmount(){

    }
    public void  increaseAmount(){

    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN=" + ISBN +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }
}
