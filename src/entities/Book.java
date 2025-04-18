package entities;

import java.util.*;

public class Book {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer year;
    private String publisher;
    private BookStatus status;
    private LinkedList<Category> categories = new LinkedList<>();

    private Queue<User> waitlist = new LinkedList<>();

    public Book() {
    }

    public Book(Long id, String title, String author, String isbn, Integer year, String publisher, BookStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.publisher = publisher;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public LinkedList<Category> getCategories() {
        return categories;
    }

    public Queue<User> getWaitlist() {
        return waitlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n        Título: ").append(title);
        sb.append("\n        Autor(a): ").append(author);
        sb.append("\n        Ano: ").append(year);
        sb.append("\n        Editora: ").append(publisher);
        sb.append("\n        ISBN: ").append(isbn);
        sb.append("\n        Categorias: ");
        int i = 0;
        for (Category category : categories) {
            sb.append(category.getName());
            if (i < categories.size() - 1) {
                sb.append(", ");
            }
            i++;
        }
        sb.append("\n        Disponibilidade: ");
        sb = (status.equals(BookStatus.AVAILABLE)) ? sb.append("Disponível") : sb.append("Indisponível");
        sb.append("\n\n        Usuários na lista de espera: ");
        if (!waitlist.isEmpty()) {
            for (User user : waitlist) {
                sb.append(user.getName());
            }
        } else {
            sb.append("Nenhum");
        }
        return sb.toString();
    }
}
