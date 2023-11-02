package menu.view;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Swing 스레드에서 GUI 초기화 및 표시 작업을 지연시키기 위해 SwingUtilities.invokeLater 사용
        SwingUtilities.invokeLater(() -> {
            MenuStart menuStart = new MenuStart();
            // GUI 창을 표시
            menuStart.setVisible(true);
        });
    }
}

// TODO :
