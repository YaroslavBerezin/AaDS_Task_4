package ru.vsu.cs.berezin_y_a;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    public List<SortState> sortArray(int[] array) {
        List<SortState> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];

                    array[j + 1] = array[j];
                    array[j] = temp;
                    int[] newArray = createNewArray(array);

                    list.add(new SortState(newArray, i, j));
                }
            }
        }

        return list;
    }

    public int[] createNewArray(int[] array) {
        int[] newArray = new int[array.length];

        System.arraycopy(array, 0, newArray, 0, newArray.length);

        return newArray;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i > 0 ? ", " : "") + array[i]);
        }

        System.out.println();
    }

}
