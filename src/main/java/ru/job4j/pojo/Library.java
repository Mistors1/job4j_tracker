package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("HP", 125);
        Book book1 = new Book("Clean code", 15);
        Book book2 = new Book("Tom", 43);
        Book book3 = new Book("LotR", 500);
        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        for (int i = 0; i < books.length; i++) {
            Book allBooks = books[i];
            System.out.println(allBooks.getName() + " - " + allBooks.getPageCount());
        }
        System.out.println("Replace 1st book and 4th book");
        books[0] = book3;
        books[3] = book;
        for (int i = 0; i < books.length; i++) {
            Book allBooks = books[i];
            System.out.println(allBooks.getName() + " - " + allBooks.getPageCount());
        }
        System.out.println("Only \"Clean code\" books");
        for (int i = 0; i < books.length; i++) {
            Book allBooks = books[i];
            if (allBooks.getName().equals("Clean code")) {
            System.out.println(allBooks.getName() + " - " + allBooks.getPageCount());
        }
        }
    }
}
