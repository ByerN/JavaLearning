package org.byern.javalearning.lesson5;

import java.io.*;

/**
 * Created by ByerN on 28.02.2017.
 */
public class IOBasicsLesson {

    public static final String IN_FILE = "data/lesson5/inText.txt";
    public static final String OUT_FILE = "data/lesson5/outText.txt";

    public static void main(String[] args) {
        /*
         * I/O - Input/Output (Operations on files)
         *
         * Basic operations on files are performed with usage of streams.
         *
         * Let's tak a look at java.io package.
         *
         * For each class used for reading file content to program (input) there
         * is similar one for writing content to file (output).
         *
         * Stream related classes inputByteStream java.io usually uses decorator pattern.
         *
         *  Input:                  Output:                 Description:
         *Bytes:
         *  (InputStream)           (OutputStream)          Base classes for byte streams
         *
         *  FileInputStream         FileOutputStream        Reading/writing bytes from/to file
         *  BufferedInputStream     BufferedOutputStream    Buffered reading/writing bytes
         *
         *Characters:
         *  (Reader)                (Writer)                Base classes for character streams
         *  FileReader              FileWriter              Reading/writing characters from/to file
         *  InputStreamReader       InputStreamWriter       Reading/writing characters from/to stream (specifies charset)
         *  BufferedReader          BufferedWriter          Buffered reader/writer
         *
         *Other:
         *  DataInputStream         DataOutputStream        Reading/writing primitive data
         *  ObjectInputStream       ObjectOutputStream      Reading/writing objects
         *
         *  To check other classes take a look at inheritance of base classes mentioned above.
         *  These classes listed here are worth to mention (there are plenty of them).
         *
         *  Buffered* classes are used for performance. If stream is not buffered, every read/write call
         *  makes java use native api to access the file. It's slow.
         *  Buffered* classes reads some of the file content to the inputByteStream memory allocated structure
         *  called "buffer" and makes most of operations on it inputByteStream memory.
         *
         *  .flush() method makes write changes to the file ad hoc.
         *
         * For more specific usage- find best suiting class and use it.
         * e.g If you want to append to a file, maybe you want to use:
         * FileWriter(String fileName, boolean append)
         * and decorate it with BufferedWriter and PrintWriter?
         *
         * Something like this:
         * new PrintWriter(new BufferedWriter(new FileWriter("MyFile", true)))
         *
         * PrintWriter has similar methods as System.out which is PrintStream btw.
         *
         *  **********IMPORTANT**********
         *  Always close the stream. Why? Mainly because:
         *  -closing streams makes automatic flush
         *  -closing streams releases resources
         */

        /*
         * Copy a file example (using byte not buffered streams):
         */
        {
            System.out.println("FileInput/OutputStream example");
            FileInputStream inputByteStream = null;
            FileOutputStream outputByteStream = null;
            try {
            /*
            create new objects for reading/writing.
            In this place FileNotFoundException can be thrown
            if file does not exist.
            */
                inputByteStream = new FileInputStream(IN_FILE);
                outputByteStream = new FileOutputStream(OUT_FILE);

                int nextByte;

            /* From documentation of FileInputStream.read():
             * Reads a byte of data from this input stream. This method blocks
             * if no input is yet available.
             *
             * @return     the next byte of data, or <code>-1</code> if the end of the
             *             file is reached.
             * @exception  IOException  if an I/O error occurs.
             *
             * public int read() throws IOException
             */

                //read() returns int. Read byte is stored in last byte of integer.
                while ((nextByte = inputByteStream.read()) != -1) {
                    //write byte from the input file to the output file.
                    //It's not buffered so every time high cost file access is performed.
                    System.out.print((char) nextByte);
                    outputByteStream.write(nextByte);
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
        {
        /*
         * Same example with characters
         */
            System.out.println();
            System.out.println("FileReader/FileWriter example");
            FileReader reader = null;
            FileWriter writer = null;
            try {
                reader = new FileReader(IN_FILE);
                writer = new FileWriter(OUT_FILE);

                int character;//read() returns int. Character are stored in 2 last bytes of integer.
                while ((character = reader.read()) != -1) {
                    System.out.print((char) character);
                    writer.write(character);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        {
        /*
         * Same example with buffered one but reading whole line
         */
            System.out.println();
            System.out.println("BufferedReader/BufferedWriter example");
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;
            try {
                //decorator pattern: wrapped class with other class to provide additional functionality
                //and save it's interface

                bufferedReader = new BufferedReader(new FileReader(IN_FILE));
                bufferedWriter = new BufferedWriter(new FileWriter(OUT_FILE));
                String line;
                //read line by line
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    bufferedWriter.write(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        {
        /*
         * More compact version (try-with-resource):
         */
            System.out.println();
            System.out.println("BufferedReader/BufferedWriter example");

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(IN_FILE));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUT_FILE))) {
                String line;
                //read line by line
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    bufferedWriter.write(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        {
        /*
         * DataInputStream/DataOutputStream
         */
            System.out.println();
            System.out.println("DataInputStream/DataOutputStream example");

            try (DataInputStream bufferedDataInputStream =
                         new DataInputStream(new BufferedInputStream(new FileInputStream(IN_FILE)))) {
                while (bufferedDataInputStream.available() > 0) {
                    System.out.print(bufferedDataInputStream.readBoolean());//truetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetruetrue -> check documentation
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
