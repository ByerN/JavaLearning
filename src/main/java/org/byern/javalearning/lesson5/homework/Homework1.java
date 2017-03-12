package org.byern.javalearning.lesson5.homework;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by ByerN on 02.03.2017.
 */
public class Homework1 {

    public static final String IN_FILE = "data/lesson5/inText.txt";
    public static final String OUT_FILE = "data/lesson5/outText.txt";
    public static final String ENCODED_FILE = "data/lesson5/encodedText.txt";
    public static final Character DATA_LINK_ESCAPE = '\u0010';

    public static void main(String[] args) {
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

        int shift = getShift();

        System.out.println("Original file:");
        displayFileByByte(IN_FILE);

        encodeFile(IN_FILE, ENCODED_FILE, shift);
        System.out.println("Encoded file:");
        displayFileByByte(ENCODED_FILE);

        decodeFile(ENCODED_FILE, OUT_FILE, shift);
        System.out.println("Decoded file:");
        displayFileByByte(OUT_FILE);
    }

    private static int getShift() {
        Scanner scanner = new Scanner(System.in);
        int shift = 0;
        System.out.print("Enter shift value to decode the file: ");

        try {
            shift = scanner.nextInt();
            System.out.println();

        } catch (InputMismatchException e) {
            System.out.println("Error: The shift must be an integer. The program will be terminated.");
            System.exit(0);
        }
        return shift;

    }

    private static void displayFileByByte(String inFile) {
        FileInputStream inputByteStream = null;

        try {

            inputByteStream = new FileInputStream(inFile);
            int nextByte;

            while ((nextByte = inputByteStream.read()) != -1) {
                System.out.print((char) nextByte);
                if (nextByte == DATA_LINK_ESCAPE) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println();

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

    private static void encodeFile(String inFile, String outFile, int shift) {

        FileInputStream inputByteStream = null;
        FileOutputStream outputByteStream = null;

        try {

            inputByteStream = new FileInputStream(inFile);
            outputByteStream = new FileOutputStream(outFile);

            int nextByte;

            while ((nextByte = inputByteStream.read()) != -1) {
                nextByte += shift;
                outputByteStream.write(nextByte);
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
            if (outputByteStream != null) {
                try {
                    outputByteStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void decodeFile(String inFile, String outFile, int shift) {

        FileInputStream inputByteStream = null;
        FileOutputStream outputByteStream = null;

        try {

            inputByteStream = new FileInputStream(inFile);
            outputByteStream = new FileOutputStream(outFile);

            int nextByte;

            while ((nextByte = inputByteStream.read()) != -1) {
                nextByte -= shift;
                outputByteStream.write(nextByte);
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
            if (outputByteStream != null) {
                try {
                    outputByteStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
