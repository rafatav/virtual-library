package services;

import entities.Book;
import entities.BookStatus;
import entities.Category;
import repositories.BookRepository;

import java.util.*;

public abstract class BookService {

    public static HashMap<Book, Set<Book>> graph = bookRecommendationGraph();

    public static List<Book> findAll() {
        return BookRepository.getList();
    }

    public static Book findById(Long id) {
        for (Book book : BookRepository.getList()) {
            if (Objects.equals(book.getId(), id)) {
                return book;
            }
        }
        throw new NullPointerException();
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

    public static HashMap<Book, Set<Book>> bookRecommendationGraph() {
        HashMap<Book, Set<Book>> graph = new HashMap<>();
        for (Book book : findAll()) {
            graph.put(book, new HashSet<>());
        }
        for (Book book_1 : graph.keySet()) {
            for (Book book_2 : graph.keySet()) {
                if (!book_1.equals(book_2)) {
                    for (Category cat : book_1.getCategories()) {
                        if (book_2.getCategories().contains(cat)) {
                            graph.get(book_1).add(book_2);
                        }
                    }
                }
            }
        }
        return graph;
    }

    public static Set<Book> getGraph(Book book) {
         for (Book b : bookRecommendationGraph().keySet()) {
             if (b.equals(book)) {
                 return bookRecommendationGraph().get(b);
             }
         }
        return null;
    }

    public static Map<Book, Integer> djikstraAlgorithm(HashMap<Book, Set<Book>> graph, Book source) {
        Map<Book, Integer> distances = new HashMap<>();
        Queue<Book> queue = new LinkedList<>();
        distances.put(source, 0);
        queue.add(source);
        while (!queue.isEmpty()) {
            Book current = queue.poll();

            int currentDistance = distances.get(current);

            for (Book neighbor : graph.getOrDefault(current, new HashSet<>())) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, currentDistance + 1);
                    queue.add(neighbor);
                }
            }
        }
        return distances;
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
