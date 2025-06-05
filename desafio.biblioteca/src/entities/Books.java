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


    public String getAuthor() {
        return author;
    }


    public Integer getISBN() {
        return ISBN;
    }


    public Integer getYear() {
        return year;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
