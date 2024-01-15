package components;

import pipe.Pipe;

import java.io.FileInputStream;
import java.io.IOException;

public class Input implements Runnable {
    FileInputStream stream;
    Pipe pipe;

    public Input(FileInputStream stream, Pipe pipe) {
        this.stream = stream;
        this.pipe = pipe;
    }
    public void run() {
        try {
            this.pipe.write(this.stream.readAllBytes());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
