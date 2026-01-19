import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static String fileName = "sample.txt";

    // Method to write data into a file
    public static void writeFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is a sample text file.\n");
            writer.write("This file is created using Java File Handling.\n");
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing to file.");
        }
    }

    // Method to read data from a file
    public static void readFile() {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            System.out.println("\nReading file content:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // Method to modify (append) data into a file
    public static void modifyFile() {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("This line is added while modifying the file.\n");
            writer.close();
            System.out.println("\nFile modified successfully.");
        } catch (IOException e) {
            System.out.println("Error while modifying file.");
        }
    }

    public static void main(String[] args) {
        writeFile();
        readFile();
        modifyFile();
        readFile();
    }
}
