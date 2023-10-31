package menu.view;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuStart menuStart = new MenuStart();
            menuStart.setVisible(true);
        });
    }
}
