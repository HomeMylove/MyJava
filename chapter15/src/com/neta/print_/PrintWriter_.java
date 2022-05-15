package com.neta.print_;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("E:\\writer.txt"));
        printWriter.print("我是PrintWriter");
        printWriter.close();
    }
}
