import java.time.LocalDate;

public class Loan {
    public Book book;
    public Reader reader;
    public LocalDate loanDate;
    public LocalDate returnDate;

    public Loan(Book book, Reader reader, LocalDate loanDate, LocalDate returnDate){
        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
    public Loan(Book book, Reader reader){
        this.book = book;
        this.reader = reader;
        this.loanDate = LocalDate.now();
        this.returnDate = null;
    }
    @Override
    public String toString() {
        return "loan{" +
        "Book"+ book.title +
        "Reader"+ reader.name +
        "Loan Date" + loanDate +
        "Return Date" + returnDate +
        ')';

    }
}
