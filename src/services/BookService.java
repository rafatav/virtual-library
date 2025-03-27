package services;

import entities.Book;
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
}
