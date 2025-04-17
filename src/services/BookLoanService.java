package services;

import entities.Book;
import entities.BookLoan;

import entities.User;
import repositories.BookLoanRepository;

import java.time.LocalDateTime;
import java.util.List;

public abstract class BookLoanService {

    public static List<BookLoan> findAll() {
        return BookLoanRepository.getList();
    }

    public static BookLoan findById(int id) {
        for (BookLoan bookLoan : BookLoanRepository.getList()) {
            if (bookLoan.getId() == id) {
                return bookLoan;
            }
        }
        return null;
    }

    public static void insert(BookLoan bookLoan) {
        BookLoanRepository.getList().add(bookLoan);
    }

    public static void remove(BookLoan bookLoanToRemove) {
        BookLoanRepository.getList().removeIf(bookLoan -> bookLoan.equals(bookLoanToRemove));
    }

    public static BookLoan loan(Book book) {
        User user = UserService.findById(1L);
        BookLoan bookLoan = new BookLoan(1, LocalDateTime.now(), LocalDateTime.now().plusDays(30), user, book);
        BookLoanRepository.getList().add(bookLoan);
        user.getLoans().add(bookLoan);
        return bookLoan;
    }
}
