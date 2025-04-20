package entities;

public class Category {

    private Integer id;
    private String name;

    public Category() {
    }

    public Category(Integer id, String category) {
        this.id = id;
        this.name = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
