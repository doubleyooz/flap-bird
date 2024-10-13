package utils;
import interfaces.Callable;

public class Timer {
    double time;
    double limit;
    Callable callback;
    boolean repeat;
    boolean end;
    
    public Timer(double limit, boolean repeat, Callable callback) {
        this.limit = limit;
        this.callback = callback;
        this.repeat = repeat;
    }

    public void tick(double dt) {
        if(end) return;
        time += dt;
        if(time <= limit) return;
   
        callback.run();
        if(repeat) {
            time -= limit;
        } else {
            end = true;
        }
    
    }
}