package repositories;

import entities.Book;

import java.util.LinkedList;
import java.util.List;

public abstract class BookRepository {

    private List<Book> list = new LinkedList<>();

    public List<Book> getList() {
        return list;
    }
}
