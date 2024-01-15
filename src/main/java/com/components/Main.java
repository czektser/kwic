package com.components;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify a file");
        } else {
            KWIC.execute(args[0]);
        }
    }
}
