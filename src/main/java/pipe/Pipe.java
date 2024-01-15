package pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ArrayList;

public class Pipe {
    private PipedReader reader;
    private PipedWriter writer;

    public Pipe() throws IOException {
        this.reader = new PipedReader();
        this.writer = new PipedWriter();
        this.writer.connect(this.reader);


    }


    public ArrayList<String> Read() throws IOException {
        ArrayList<String> al = new ArrayList<>();
        int c = 0;
        ArrayList<Character> temp = new ArrayList<>();
        do {
            c = this.reader.read();
            if (c > 0) {
                temp.add(Character.valueOf((char) c));
            } else if (temp.size() > 0) {
                al.add(temp.toString());
                temp = new ArrayList<>();
            }
        } while (c >= 0);
        return al;
    }

    public void write(String w) throws IOException {
        this.writer.write(w);
    }

    public void write(ArrayList<String> w) throws IOException {
        for (int i = 0; i < w.size(); i++) {
            this.writer.write(w.get(i));
        }
    }

    public void write(byte[] b) throws IOException {
        for (int i = 0; i < b.length; i++) {
            this.writer.write(b[i]);
        }
    }

    public void print() throws IOException {
        int i = 0;
        do {
            System.out.write(this.reader.read());
        } while (i >= 0);
    }

}
