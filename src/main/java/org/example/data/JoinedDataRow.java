package org.example.data;

public class JoinedDataRow<K extends Comparable<K>, V1, V2> {
    private K key;
    private V1 value1;
    private V2 value2;

    public JoinedDataRow(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V1 getValue1() {
        return value1;
    }

    public void setValue1(V1 value1) {
        this.value1 = value1;
    }

    public V2 getValue2() {
        return value2;
    }

    public void setValue2(V2 value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "JoinedDataRow{"
                + "key=" + key
                + ", value1=" + value1
                + ", value2=" + value2
                + '}';
    }
}
