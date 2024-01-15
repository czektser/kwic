package components;

import pipe.Pipe;

import java.io.IOException;

public class Output implements Runnable {
   private Pipe out;
    public Output(Pipe out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            this.out.print();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
