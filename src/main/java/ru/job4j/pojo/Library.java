package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book potter = new Book("Harry Potter", 456);
        Book schildt = new Book("Java", 1880);
        Book pushkin = new Book("Евгений Онегин", 350);
        Book code = new Book("Clean Code", 320);
        Book[] books = new Book[4];
        books[0] = potter;
        books[1] = schildt;
        books[2] = code;
        books[3] = pushkin;
        for (Book bk : books) {
            System.out.println(bk.getTitle() + ", " + bk.getPages() + " pages");
        }
        System.out.println("\nChanging array elements:");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getTitle() + ", " + bk.getPages() + " pages");
        }
        System.out.println("\nShowing Clean code:");
        for (Book bk : books) {
            if (bk.getTitle().equals("Clean Code")) {
                System.out.println(bk.getTitle() + ", " + bk.getPages() + " pages");
            }
        }
    }
}
