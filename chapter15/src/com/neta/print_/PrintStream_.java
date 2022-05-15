package com.neta.print_;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = System.out;
        printStream.println("正常打印");
        System.setOut(new PrintStream("E:\\print.txt"));
        printStream = new PrintStream("E:\\print2.txt");
        printStream.println("猜猜打印到哪里去了^_^");
        System.out.println("猜猜打印到哪里去了");
        printStream.close();
    }
}
