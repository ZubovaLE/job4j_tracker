package ru.job4j.ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book javaTutorial = new Book("Java tutorial for dummies", 1056);
        Book javaDescription = new Book("Java description", 543);
        Book aboutC = new Book("C++ for dummies", 666);
        Book cleanCode = new Book("Clean code", 356);
        Book[] books = new Book[4];
        books[0] = javaTutorial;
        books[1] = javaDescription;
        books[2] = aboutC;
        books[3] = cleanCode;
        for (Book value : books) {
            System.out.println("\"" + value.getName() + "\"" + " has " + value.getPages() + " pages");
        }
        System.out.println("Replace 0 with 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("After changing");
        for (Book value : books) {
            System.out.println(value.getName() + " has " + value.getPages() + " pages");
        }

        System.out.println("Shown only Clean code books");
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}

