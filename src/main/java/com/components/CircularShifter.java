package com.components;

import com.components.pipe.Pipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CircularShifter implements Runnable {
    private Pipe in, out;

    public CircularShifter(Pipe in, Pipe out) throws IOException {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            ArrayList<String> r = in.Read();
            ArrayList<String> lines = new ArrayList<>();
            for (int i = 0; i < r.size(); i++) {
                String line = r.get(i);
                String[] words = line.split("\\s+");  //split on  space
                ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
                for (int j = 0; j < wordList.size(); j++) {
                    boolean shifted = wordList.add(wordList.remove(0));
                    if (!shifted) {
                        System.out.printf("There was an error shifting %s\n", wordList);
                    } else {
                        out.write(wordList);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
