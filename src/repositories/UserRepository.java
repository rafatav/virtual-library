package repositories;

import entities.User;

import java.util.LinkedList;

public abstract class UserRepository {

    private static LinkedList<User> list = new LinkedList<>();

    public static LinkedList<User> getList() {
        return list;
    }
}
