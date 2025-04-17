package application;

import entities.User;
import resources.Seed;
import services.BookService;
import services.UserService;
import view.Interface;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Seed.data();

        System.out.print("Digite o seu nome: ");
        String name = sc.nextLine();

        UserService.insert(new User(1L, name, name.toLowerCase().replaceAll("\\s", "") +
                "@gmail.com", "123456"));

        User user = UserService.findById(1L);

        user.getBrowsingHistory().add(BookService.findById(1L));

        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| BIBLIOTECA VIRTUAL DALTON TREVISAN |||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

        System.out.println("    Olá, " + user.getName() + ". Bem-vindo à Biblioteca Virtual Dalton Trevisan.");

        Interface.mainMenu();
    }
}

