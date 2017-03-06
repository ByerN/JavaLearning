package org.byern.javalearning.lesson5.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework1_Asia {
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


    public static final String IN_FILE = "data/lesson5/inText.txt";
    public static final String OUT_FILE = "data/lesson5/outText.txt";
    public static final String OUT_FILE_AFTER_DECRYPT = "data/lesson5/outTextAfterDescription.txt";

    public static void main(String[] args) {

        encrypt(1, IN_FILE, OUT_FILE);
        decrypt(1, OUT_FILE, OUT_FILE_AFTER_DECRYPT);

    }


    public static void encrypt(int shift, String inFile, String outFile) {
        FileInputStream inputByteStream = null;
        FileOutputStream outputByteStream = null;

        try {
            inputByteStream = new FileInputStream(inFile);
            outputByteStream = new FileOutputStream(outFile);

            int nextByte;
            int ascii = 0;

            while ((nextByte = inputByteStream.read()) != -1) {

                for (int i = 0; i < nextByte; i++) {
                    ascii = nextByte + shift;
                }

                outputByteStream.write(ascii);
            }


        } catch (IOException e) {
            //catch potential IOExceptions (e.g. file not found) and solve it
            e.printStackTrace();
        } finally {
            //close the streams if it's created
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

    public static void decrypt(int shift, String inFile, String outFile) {
        FileInputStream inputByteStream = null;
        FileOutputStream outputByteStream = null;

        try {
            inputByteStream = new FileInputStream(inFile);
            outputByteStream = new FileOutputStream(outFile);

            int nextByte;
            int ascii = 0;

            while ((nextByte = inputByteStream.read()) != -1) {

                for (int i = 0; i < nextByte; i++) {
                    ascii = nextByte - shift;
                }

                outputByteStream.write(ascii);
            }


        } catch (IOException e) {
            //catch potential IOExceptions (e.g. file not found) and solve it
            e.printStackTrace();
        } finally {
            //close the streams if it's created
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