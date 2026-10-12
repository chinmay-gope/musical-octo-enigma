package com.myproject.introduction.learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSiri {
    static void main() throws IOException, ClassNotFoundException {

        File f = new File("books.txt");

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Book book = (Book) ois.readObject();

        System.out.println(book);
    }
}
