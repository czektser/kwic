package components;

import pipe.Pipe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KWIC {
    public void execute(String file) {
        try {
            Pipe inCS = new Pipe();
            Pipe csAl = new Pipe();
            Pipe alOut = new Pipe();

            FileInputStream in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
