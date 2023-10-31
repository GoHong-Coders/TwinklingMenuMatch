package menu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuStart extends JFrame {
    private JLabel startLb;
    private JButton startBtn;

    public MenuStart() {
        startLb = new JLabel(new ImageIcon("imgs/startScreen.png"), JLabel.CENTER);
        startBtn = new JButton();

        startUI();
    }

    private void startUI() {
        setTitle("별메추 시작하기");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 시작 버튼 초기화
        startButton();

        // 이미지 레이블 추가
        add(startLb, BorderLayout.CENTER);
    }

    private void startButton() {
        // 로그인 버튼 위치, 크기 설정
        ImageIcon startBtnImg = new ImageIcon("imgs/startBtn.png");
        ImageIcon startBtnImgEnter = new ImageIcon("imgs/startBtn_enter.png");

        startBtn.setIcon(startBtnImg);
        startBtn.setBackground(Color.WHITE);
        startBtn.setBounds(514, 508, 172, 56);
        startBtn.setBorderPainted(false);
        startBtn.setFocusPainted(false);
        startBtn.setContentAreaFilled(false);

        // MouseListener를 이용하여 버튼의 Mouse 이벤트 처리
        startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // "시작" 버튼을 클릭할 때 할 작업
                new MenuLogin();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                startBtn.setIcon(startBtnImgEnter);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startBtn.setIcon(startBtnImg);
            }
        });

        add(startBtn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuStart menuStart = new MenuStart();
            menuStart.setVisible(true);
        });
    }
}
