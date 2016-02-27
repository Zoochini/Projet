import java.util.*;

public class ConfSimple implements Configuration {

    int val;

    public ConfSimple(int val) {
        this.val;
    }

    @Override
    public String toString(){
        return " "+val;
    }
    public int ident(){
        return val;
    }
}
