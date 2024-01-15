package components;

import pipe.Pipe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class KWIC {
    public void execute(String file) {
        Pipe inCS = new Pipe();
        Pipe csAl = new Pipe();
        Pipe alOut = new Pipe();

        try {
            FileInputStream in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
