import java.util.*;

public class MonIterator implements Iterator<Integer> {
    int i = 0;
    int max;

    public boolean hasNext(){
        return i<max;
    }

    public Integer next(){
        i++;
        return new Integer(i-1);
    }

    public void remove(){};
}
