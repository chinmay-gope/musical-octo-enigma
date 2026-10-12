package com.myproject.introduction.learning;

import java.io.*;

class Book implements Serializable {

    transient int bookId;
    String title;
    String author;
    double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

public class SiriDemo {

    static void main() throws IOException {

        Book book = new Book(101, "Java FS", "Chinmay", 499.00);

        File f = new File("books.txt");
        FileOutputStream fos = new FileOutputStream(f);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(book);
    }
}
