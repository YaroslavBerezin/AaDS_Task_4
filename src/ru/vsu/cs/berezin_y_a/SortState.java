package ru.vsu.cs.berezin_y_a;

public class SortState {

    public final int[] array;
    public final int i;
    public final int j;

    public SortState(int[] array, int i, int j) {
        this.array = array;
        this.i = i;
        this.j = j;
    }

}
