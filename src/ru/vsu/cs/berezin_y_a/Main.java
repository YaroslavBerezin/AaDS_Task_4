package ru.vsu.cs.berezin_y_a;

import ru.vsu.cs.berezin_y_a.util.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        EventQueue.invokeLater(() -> {
            try {
                JFrame frameMain = new FrameMain();
                frameMain.setVisible(true);
                frameMain.setExtendedState(MAXIMIZED_BOTH);
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
    }

}
