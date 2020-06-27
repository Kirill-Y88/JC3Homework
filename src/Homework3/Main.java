package Homework3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       IOClass ioClass = new IOClass("demo.txt");
        Scanner scanner = new Scanner(System.in);
        //ioClass.cleanFile();
        ioClass.outStream(scanner.nextLine() + "\n");
       ioClass.inStream();

    }
}
