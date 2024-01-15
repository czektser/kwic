package filter;

import pipe.Pipe;

public abstract class Filter implements Runnable {
    protected Pipe input;
    protected Pipe output;

    public void run() {

    }
}
