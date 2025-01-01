package fenitride.chemicallaboratory.utils;

import java.util.Iterator;

public class Range implements Iterator<Integer>, Iterable<Integer> {

    int start;
    int end;
    int current;
    boolean isReversed;

    public Range(int start, int end, boolean isReversed) {
        this.start = start;
        this.end = end;
        this.isReversed = isReversed;
        if (isReversed) {
            this.current = end - 1;
        } else {
            this.current = start;
        }
    }

    public Range(int start, int end)  {
        this(start, end, false);
    }

    @Override
    public boolean hasNext() {
        if (this.isReversed) {
            return this.current >= this.start;
        } else {
            return this.current < this.end;
        }
    }

    @Override
    public Integer next() {
        return this.isReversed ? this.current-- : this.current++;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}
