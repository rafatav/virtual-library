package services;

import entities.Book;
import entities.BookLoan;
import entities.BookStatus;
import entities.User;
import repositories.BookLoanRepository;
import repositories.BookRepository;

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
    
}
