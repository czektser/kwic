package com.components;

import com.components.pipe.Pipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


public class Alphabetizer implements Runnable {
    private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };
    private Pipe in, out;

    public Alphabetizer(Pipe in, Pipe out) throws IOException {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            ArrayList<String> words = in.Read();
            words.sort(ALPHABETICAL_ORDER);
            out.write(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
