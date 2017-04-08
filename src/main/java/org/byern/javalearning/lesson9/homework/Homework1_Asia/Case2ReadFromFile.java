package org.byern.javalearning.lesson9.homework.Homework1_Asia;


import java.io.*;

public class Case2ReadFromFile implements HelloWorldService {

    public static final String IN_FILE = "data/lesson9/inText.txt";

    @Override
    public void greetWorld() {
        readForFileAndPrint();
    }

    public void readForFileAndPrint() {
        FileInputStream inputByteStream = null;
        try {
            inputByteStream = new FileInputStream(IN_FILE);
            int nextByte;

            while ((nextByte = inputByteStream.read()) != -1) {
                System.out.print((char) nextByte);
            }

        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            if (inputByteStream != null) {
                try {
                    inputByteStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
