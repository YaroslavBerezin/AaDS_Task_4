package ru.vsu.cs.berezin_y_a;

import ru.vsu.cs.berezin_y_a.util.ArrayUtils;
import ru.vsu.cs.berezin_y_a.util.JTableUtils;
import ru.vsu.cs.berezin_y_a.util.SwingUtils;

import javax.swing.*;
import java.util.List;

public class FrameMain extends JFrame {

    Logic logic = new Logic();
    public int countOfSteps = 0;

    private JTable inputTable;
    private JTable outputTable;
    private JButton sortButton;
    private JButton oneStepButton;
    private JPanel panelMain;
    private JButton clearButton;
    private JButton fillRandomNumbersButton;

    public FrameMain() {
        this.setTitle("Bubble Sort");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(inputTable, 60, false, true,
                false, true);
        inputTable.setRowHeight(30);

        JTableUtils.writeArrayToJTable(inputTable, new int[]{4, 3, 2, 6, 44, 7});

        JTableUtils.initJTableForArray(outputTable, 60, false, true,
                false, false);
        outputTable.setRowHeight(30);

        sortButton.addActionListener(actionEvent -> sort());
        oneStepButton.addActionListener(actionEvent -> oneStepSort());
        clearButton.addActionListener(actionEvent -> clearTables());
        fillRandomNumbersButton.addActionListener(actionEvent -> fillRandomNumbers());
    }

    private void sort() {
        try {
            int[] array = JTableUtils.readIntArrayFromJTable(inputTable);
            assert array != null;

            logic.sortArray(array);
            countOfSteps = 0;

            JTableUtils.writeArrayToJTable(outputTable, array);
        } catch (Exception ex) {
            SwingUtils.showErrorMessageBox(ex);
        }
    }

    private void oneStepSort() {
        try {
            int[] array = JTableUtils.readIntArrayFromJTable(inputTable);
            assert array != null;

            List<SortState> list = logic.sortArray(array);

            if (countOfSteps == 0) {
                logic.sortArray(array);
            }

            if (countOfSteps < list.size()) {
                JTableUtils.writeArrayToJTable(outputTable, list.get(countOfSteps).array);
                countOfSteps++;
            }
        } catch (Exception ex) {
            SwingUtils.showErrorMessageBox(ex);
        }
    }

    private void clearTables() {
        JTableUtils.writeArrayToJTable(inputTable, new int[]{});
        JTableUtils.writeArrayToJTable(outputTable, new int[]{});
        countOfSteps = 0;
    }

    private void fillRandomNumbers() {
        int[] arr = ArrayUtils.createRandomIntArray(10, 100);
        clearTables();
        JTableUtils.writeArrayToJTable(inputTable, arr);
        countOfSteps = 0;
    }

}
