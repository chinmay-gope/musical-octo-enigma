package com.myproject.introduction.constructor;

class Book {
    int bookId;
    String title, author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public Book(Book book) {
        this.bookId = book.bookId;
        this.title = book.title;
        this.author = book.author;
    }

    public void printDetails() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }

    static void main() {
        Book book1 = new Book(1, "Book1", "Author1");

        Book copiedBook = new Book(book1);

        book1.printDetails();
        copiedBook.printDetails();
    }
}
