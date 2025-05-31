package services;

import entities.Books;
import entities.Member;

import java.util.Date;

public class Loan {
    private Books book;
    private Member member;
    private Date date;

    public Loan(Books book, Member member, Date date) {
        this.book = book;
        this.member = member;
        this.date = date;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
