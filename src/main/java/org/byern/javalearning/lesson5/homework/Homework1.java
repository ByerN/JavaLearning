package org.byern.javalearning.lesson5.homework;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ByerN on 02.03.2017.
 */
public class Homework1 {

    private static int OFFSET;

    public static void main(String[] args) throws IOException {
        /*
         * Ceaser cipher.
         *
         * Implement Ceaser cipher for files.
         *
         * Program should:
         * -read source filename
         * -read destination filename
         * -read shift value
         * -encrypt source file content and write it into destination file
         *
         * *There is no need of creating new file on the fly (only existing files, otherwise exception).
         * *It should work for byte value for making it simpler. Not only characters. Simple shift.
         *
         * Properly made program should be able to recover encrypted file with
         * encrypting it again with reversed shift.
         */
        OFFSET = -1;

        FileReader file_in = null;
        FileWriter file_out = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Plik we (np.: test.txt)");
            String nazwa_in = scanner.nextLine();
            System.out.println("Plik wy (np.: test_out.txt)");
            String nazwa_out = scanner.nextLine();
        try {


            file_in = new FileReader(nazwa_in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            file_out = new FileWriter(nazwa_out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int char_int;
        while ( (char_int = file_in.read())  != -1) {
            try {
                char ch = (char) ((char) char_int+OFFSET);
                file_out.write(ch);

                //file_out.write(((char) file_in.read())+OFFSET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            file_in.close();
            file_out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
