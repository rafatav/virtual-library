package resources;

import entities.Book;
import entities.BookStatus;
import entities.Category;
import services.BookService;
import services.CategoryService;

public abstract class Seed {

    public static void data() {
        CategoryService.insert(new Category(1, "Literatura Brasileira"));
        CategoryService.insert(new Category(2, "Literatura Russa"));
        CategoryService.insert(new Category(3, "Clássicos"));
        CategoryService.insert(new Category(4, "Autoras Mulheres"));
        CategoryService.insert(new Category(5, "Calhamaço"));
        CategoryService.insert(new Category(6, "Literatura Europeia"));
        CategoryService.insert(new Category(7, "Literatura Norte-americana"));
        CategoryService.insert(new Category(8, "Drama"));
        CategoryService.insert(new Category(9, "Nobel de Literatura"));
        CategoryService.insert(new Category(10, "Literatura Latino-americana"));

        BookService.insert(new Book(1L, "Memórias do Subsolo", "Fiódor Dostoiévski",
                "978-8573261851", 1864, "Editora 34", BookStatus.AVAILABLE));
        BookService.findById(1L).getCategories().add(CategoryService.findById(2));
        BookService.findById(1L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(2L, "O Senhor das Moscas", "William Golding",
                "978-8520918432", 1954, "Editora Nova Fronteira", BookStatus.AVAILABLE));
        BookService.findById(2L).getCategories().add(CategoryService.findById(6));
        BookService.findById(2L).getCategories().add(CategoryService.findById(9));
        BookService.findById(2L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(3L, "Torto Arado", "Itamar Vieira Junior",
                "978-6580309313", 2019, "Editora Todavia", BookStatus.AVAILABLE));
        BookService.findById(3L).getCategories().add(CategoryService.findById(1));
        BookService.findById(3L).getCategories().add(CategoryService.findById(8));

        BookService.insert(new Book(4L, "O Acontecimento", "Annie Ernaux",
                "978-6589733553", 2000, "Fósforo Editora", BookStatus.AVAILABLE));
        BookService.findById(4L).getCategories().add(CategoryService.findById(6));
        BookService.findById(4L).getCategories().add(CategoryService.findById(4));
        BookService.findById(4L).getCategories().add(CategoryService.findById(9));

        BookService.insert(new Book(5L, "O Apanhador no Campo de Centeio", "J.D. Salinger",
                "978-6580309030", 1951, "Editora Todavia", BookStatus.AVAILABLE));
        BookService.findById(5L).getCategories().add(CategoryService.findById(7));
        BookService.findById(5L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(6L, "A Festa do Bode", "Mario Vargas Llosa",
                "978-8579620638", 2000, "Editora Alfaguara", BookStatus.AVAILABLE));
        BookService.findById(6L).getCategories().add(CategoryService.findById(10));
        BookService.findById(6L).getCategories().add(CategoryService.findById(9));

        BookService.insert(new Book(7L, "Crime e Castigo", "Fiódor Dostoiévski",
                "978-8525416476", 1866, "Editora L&PM", BookStatus.AVAILABLE));
        BookService.findById(7L).getCategories().add(CategoryService.findById(2));
        BookService.findById(7L).getCategories().add(CategoryService.findById(3));
        BookService.findById(7L).getCategories().add(CategoryService.findById(5));

        BookService.insert(new Book(8L, "A Morte de Ivan Ilitch", "Lev Tolstói",
                "978-8573263596", 1886, "Editora 34", BookStatus.AVAILABLE));
        BookService.findById(8L).getCategories().add(CategoryService.findById(2));
        BookService.findById(8L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(9L, "Tudo é Rio", "Carla Madeira",
                "978-6555871784", 2014, "Editora Record", BookStatus.UNAVAILABLE));
        BookService.findById(9L).getCategories().add(CategoryService.findById(1));
        BookService.findById(9L).getCategories().add(CategoryService.findById(4));
        BookService.findById(9L).getCategories().add(CategoryService.findById(8));

        BookService.insert(new Book(10L, "O Senhor do Lado Esquerdo", "Alberto Mussa",
                "978-8501101143", 2011, "Editora Record", BookStatus.AVAILABLE));
        BookService.findById(10L).getCategories().add(CategoryService.findById(1));
        BookService.findById(10L).getCategories().add(CategoryService.findById(8));

        BookService.insert(new Book(11L, "O Vampiro de Curitiba", "Dalton Trevisan",
                "978-8501013637", 1965, "Editora Record", BookStatus.AVAILABLE));
        BookService.findById(11L).getCategories().add(CategoryService.findById(1));
        BookService.findById(11L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(12L, "A Metamorfose", "Franz Kafka",
                "978-8571646858", 1915, "Companhia das Letras", BookStatus.AVAILABLE));
        BookService.findById(12L).getCategories().add(CategoryService.findById(6));
        BookService.findById(12L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(13L, "Vista Chinesa", "Tatiana Salém Levy",
                "978-6551140204", 2021, "Editora Todavia", BookStatus.AVAILABLE));
        BookService.findById(13L).getCategories().add(CategoryService.findById(1));
        BookService.findById(13L).getCategories().add(CategoryService.findById(4));
        BookService.findById(13L).getCategories().add(CategoryService.findById(8));

        BookService.insert(new Book(14L, "Olhos D'água", "Conceição Evaristo",
                "978-8534705257", 2014, "Fósforo Pallas", BookStatus.AVAILABLE));
        BookService.findById(14L).getCategories().add(CategoryService.findById(1));
        BookService.findById(14L).getCategories().add(CategoryService.findById(4));
        BookService.findById(14L).getCategories().add(CategoryService.findById(8));

        BookService.insert(new Book(15L, "A Pediatra", "Andréa del Fuego",
                "978-6559213481", 2021, "Companhia das Letras", BookStatus.AVAILABLE));
        BookService.findById(15L).getCategories().add(CategoryService.findById(1));
        BookService.findById(15L).getCategories().add(CategoryService.findById(4));
        BookService.findById(15L).getCategories().add(CategoryService.findById(8));

        BookService.insert(new Book(16L, "O Sol é Para Todos", "Harper Lee",
                "978-8503009492", 1960, "Editora José Olympio", BookStatus.AVAILABLE));
        BookService.findById(16L).getCategories().add(CategoryService.findById(7));
        BookService.findById(16L).getCategories().add(CategoryService.findById(4));
        BookService.findById(16L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(17L, "Uma Vida Pequena", "Hanya Yanagihara",
                "978-8501071545", 2015, "Editora Record", BookStatus.AVAILABLE));
        BookService.findById(17L).getCategories().add(CategoryService.findById(7));
        BookService.findById(17L).getCategories().add(CategoryService.findById(4));
        BookService.findById(17L).getCategories().add(CategoryService.findById(5));

        BookService.insert(new Book(18L, "Maurice", "E. M. Forster",
                "978-8525041197", 1971, "Editora Biblioteca Azul", BookStatus.AVAILABLE));
        BookService.findById(18L).getCategories().add(CategoryService.findById(6));
        BookService.findById(18L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(19L, "Meridiano de Sangue", "Cormac McCarthy",
                "978-8560281930", 1985, "Editora Alfaguara", BookStatus.UNAVAILABLE));
        BookService.findById(19L).getCategories().add(CategoryService.findById(7));
        BookService.findById(19L).getCategories().add(CategoryService.findById(3));

        BookService.insert(new Book(20L, "Ratos e Homens", "John Steinbeck",
                "978-8525427991", 1937, "Editora L&PM", BookStatus.AVAILABLE));
        BookService.findById(20L).getCategories().add(CategoryService.findById(7));
        BookService.findById(20L).getCategories().add(CategoryService.findById(3));
        BookService.findById(20L).getCategories().add(CategoryService.findById(9));
    }
}
