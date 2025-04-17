package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookLoan {

    private Long id;
    private LocalDate borrowedAt;
    private LocalDate dueDate;
    private LocalDate returnedAt;

    private User user;
    private Book book;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public BookLoan() {
    }

    public BookLoan(Long id, LocalDate borrowedAt, LocalDate dueDate, User user, Book book) {
        this.id = id;
        this.borrowedAt = borrowedAt;
        this.dueDate = dueDate;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(LocalDate borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDate returnedAt) {
        this.returnedAt = returnedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        StringBuilder sc = new StringBuilder();
        sc.append("\n    Código do empréstimo: ").append(id);
        sc.append("\n    Usuário: ").append(user.getName());
        sc.append("\n    Livro emprestado: ").append(book.getTitle());
        sc.append("\n    Data do empréstimo: ").append(fmt.format(borrowedAt));
        sc.append("\n    Data de devolução: ").append(fmt.format(dueDate));

        return sc.toString();
    }
}
