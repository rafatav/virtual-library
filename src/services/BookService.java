package services;

import entities.Book;
import repositories.BookRepository;

import java.util.List;
import java.util.Objects;

public abstract class BookService {

    BookRepository repository;

    public List<Book> findAll() {
        return repository.getList();
    }

    public Book findById(Long id) {
        for (Book book : repository.getList()) {
            if (Objects.equals(book.getId(), id)) {
                return book;
            }
        }
        return null;
    }

    public void insert(Book book) {
        repository.getList().add(book);
    }

    public void remove(Book bookToRemove) {
        repository.getList().removeIf(book -> book.equals(bookToRemove));
    }
}
