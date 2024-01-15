package com.components;

import com.components.pipe.Pipe;

import java.io.IOException;
import java.util.ArrayList;

public class CircularShifter implements Runnable {
    private Pipe in, out;

    public CircularShifter(Pipe in, Pipe out) throws IOException {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            ArrayList<String> r = in.Read();
            //for (int i = 0; i < r.size(); i++) {
           //     r.add(r.remove(i)); // circular shift happens here
           // }
            out.write(r);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
