package menu.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuStart extends JFrame {
    private JLabel startLb;
    private JButton startBtn;

    MenuStart() {
        startLb = new JLabel((new ImageIcon("imgs/startScreen.png")), JLabel.CENTER);
        startBtn = new JButton("");

        StartUI();
    }

    private void StartUI() {
        setTitle("별메추 시작하기");
        setBounds(0, 0, 1200, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // 시작 버튼 초기화
        StartButton();

        // 사진 넣기
        add(startLb, "Center");
    }

    private void StartButton() {
        // 로그인 버튼 위치, 크기 설정
        ImageIcon startBtnImg = new ImageIcon("imgs/startBtn.png");
        ImageIcon startBtnImg_enter = new ImageIcon("imgs/startBtn_enter.png");

        startBtn.setIcon(startBtnImg);
        startBtn.setBackground(new Color(255, 255, 255)); // 버튼 배경색을 흰색으로
        startBtn.setBounds(514, 508, 172, 56); // 크기 위치 설정
        startBtn.setBorderPainted(false); // 테두리 외곽선 없애기
        startBtn.setFocusPainted(false); // focus되었을 때 생기는 테두리 없애기
        startBtn.setContentAreaFilled(false); // 내용 영역 없애기

        // MouseListener를 이용하여 버튼의 Mouse 이벤트 처리
        startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 버튼 클릭 시 다른 클래스로 이동
//                new MenuTime();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                startBtn.setIcon(startBtnImg_enter); // 마우스가 버튼 안으로 들어오면 이미지 변경
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startBtn.setIcon(startBtnImg); // 마우스가 버튼 밖으로 나가면 이미지 원래대로 복원
            }
        });

        add(startBtn);
    }

    public static void main(String[] args){
        MenuStart e = new MenuStart();
    }

}