package repositories;

import entities.Book;

import java.util.LinkedList;

public abstract class BookRepository {

    private static LinkedList<Book> list = new LinkedList<>();

    public static LinkedList<Book> getList() {
        return list;
    }
}
