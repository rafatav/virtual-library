package services;

import entities.Book;
import entities.BookStatus;
import repositories.BookRepository;

import java.util.List;
import java.util.Objects;

public abstract class BookService {

    public static List<Book> findAll() {
        return BookRepository.getList();
    }

    public static Book findById(Long id) {
        for (Book book : BookRepository.getList()) {
            if (Objects.equals(book.getId(), id)) {
                return book;
            }
        }
        return null;
    }

    public static void insert(Book book) {
        BookRepository.getList().add(book);
    }

    public static void remove(Book bookToRemove) {
        BookRepository.getList().removeIf(book -> book.equals(bookToRemove));
    }

    public static void addToWaitlist(Book book) {
        book.getWaitlist().add(UserService.findById(1L));
    }

    public static void changeStatus(Book book) {
        Book b = BookRepository.getList().get((int) (book.getId() - 1));
        if ((b.getStatus() == BookStatus.AVAILABLE)) {
            b.setStatus(BookStatus.UNAVAILABLE);
        } else {
            b.setStatus(BookStatus.AVAILABLE);
        }
    }
}
