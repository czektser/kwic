package com.components.pipe;

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
        StringBuffer sb = new StringBuffer();
        do {
            int c = this.reader.read();
            if (c != 13 && c != 10) { // everything except new line and carriage return
                sb.append((char) c);
            } else if (!sb.isEmpty()) {
                sb.append((char) c);
                al.add(sb.toString());
                sb.delete(0, sb.length());
            }
        } while (this.reader.ready());

        if (!sb.isEmpty()) {
            al.add(sb.toString());
        }
        return al;
    }

    public void write(String w) throws IOException {
        this.writer.write(w);
    }

    public void write(ArrayList<String> w) throws IOException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < w.size(); i++) {
            sb.append(w.get(i));
            if (i == w.size() - 1) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        this.write(sb.toString());
    }

    public void write(byte[] b) throws IOException {
        for (int i = 0; i < b.length; i++) {
            this.writer.write(b[i]);
        }
    }

    public void print() throws IOException {
        StringBuffer sb = new StringBuffer();
        do {

            int i = this.reader.read();
            if (i != 13 && i != 10) {
                sb.append((char) i);
            } else {
                System.out.println(sb.toString().trim());
                sb.delete(0, sb.length());
            }

        } while (this.reader.ready());
    }

}
