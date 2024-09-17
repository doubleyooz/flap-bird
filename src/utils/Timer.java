package utils;
import interfaces.Action;

public class Timer {
    double time;
    double limit;
    Action acao;
    boolean repeat;
    boolean end;
    
    public Timer(double limit, boolean repeat, Action acao) {
        this.limit = limit;
        this.acao = acao;
        this.repeat = repeat;
    }

    public void tick(double dt) {
        if(end) return;
        time += dt;
        if(time <= limit) return;
   
        acao.run();
        if(repeat) {
            time -= limit;
        } else {
            end = true;
        }
    
    }
}