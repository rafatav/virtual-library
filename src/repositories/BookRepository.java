package repositories;

import entities.Book;

import java.util.LinkedList;
import java.util.List;

public class BookRepository {

    private static List<Book> list = new LinkedList<>();

    public static List<Book> getList() {
        return list;
    }
}
