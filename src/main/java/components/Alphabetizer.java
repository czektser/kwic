package components;

import pipe.Pipe;

import java.io.IOException;
import java.util.ArrayList;

public class Alphabetizer implements Runnable {
    private Pipe in, out;

    public Alphabetizer(Pipe in, Pipe out) throws IOException {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            ArrayList<String> words = in.Read();
            words.sort(String.CASE_INSENSITIVE_ORDER);
            out.write(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
