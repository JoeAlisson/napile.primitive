package io.github.joealisson.primitive;

public class LongKeyLongValue implements LongLongMap.Entry {

    private long value;
    private final long key;

    public LongKeyLongValue(int k, int v) {
        this.key = k;
        this.value= v;
    }

    @Override
    public long getKey() {
        return key;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public long setValue(long value) {
        long oldvalue = this.value;
        this.value = value;
        return oldvalue;
    }
}
