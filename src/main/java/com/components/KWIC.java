package com.components;

import com.components.pipe.Pipe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KWIC {
    public static void execute(String file) {
        try {
            Pipe inCS = new Pipe();
            Pipe csAl = new Pipe();
            Pipe alOut = new Pipe();

            FileInputStream in = new FileInputStream(file);
            Input input = new Input(in, inCS);
            CircularShifter shifter = new CircularShifter(inCS, csAl);
            Alphabetizer alpha = new Alphabetizer(inCS, alOut);
            Output output = new Output(alOut);

            input.run();
      //      shifter.run();
            alpha.run();
            output.run();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
