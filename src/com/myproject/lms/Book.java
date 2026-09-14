package com.myproject.lms;

import java.util.Date;

public class Book {
    private int bookId;
    private String name;
    private String author;
    private double price;
    private Date publishDate;

    public Book(int bookId, String name, String author, double price, Date publishDate) {
        super();
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Book() {
        super();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
