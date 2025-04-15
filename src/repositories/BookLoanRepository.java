package repositories;

import entities.BookLoan;

import java.util.LinkedList;

public abstract class BookLoanRepository {

    private static LinkedList<BookLoan> list = new LinkedList<>();

    public static LinkedList<BookLoan> getList() {
        return list;
    }
}
