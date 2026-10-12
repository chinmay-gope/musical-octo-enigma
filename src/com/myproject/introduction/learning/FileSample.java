package com.myproject.introduction.learning;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSample {
    static void main() throws IOException {
        File file = new File("final_bill.txt");

        final FileReader fr = new FileReader(file);
        int i;

        try (fr) {
            i = fr.read();
            while (i != -1) {
                System.out.print((char) i);
                i = fr.read();
            }
        } catch (IOException e) {
            System.out.println("Error reading file :" + e.getMessage());
        }
    }
}
