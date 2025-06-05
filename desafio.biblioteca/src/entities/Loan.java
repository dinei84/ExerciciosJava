package entities;

import java.util.Date;

public class Loan {
    private int loanId;
    private int booksISBN;
    private int memberId;
    private Date loanDate;

    public Loan(int loanId, int booksISBN, int memberId, Date loanDate) {
        this.loanId = loanId;
        this.booksISBN = booksISBN;
        this.memberId = memberId;
        this.loanDate = loanDate;
    }

    public int getLoanId() {
        return loanId;
    }

    public int getBooksISBN() {
        return booksISBN;
    }

    public int getMemberId() {
        return memberId;
    }

    public Date getLoanDate() {
        return loanDate;
    }
}
