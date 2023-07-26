package menu.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class MenuStart extends JFrame {

    JLabel startLb = new JLabel((new ImageIcon("imgs/startScreen.png")), JLabel.CENTER);//가운데로 수평정렬
    //버튼만들기
    JButton startBtn = new JButton("");
    MenuStart(){

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
                new MenuView();
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

        //사진 넣기
        add(startLb, "Center");

        setTitle("별메추 시작하기"); // JFrame의 제목

        setBounds(0, 0, 1200, 700); //x, y 좌표 위치 / 너비 높이 길이 설정
        setLocationRelativeTo(null); // Frame의 위치를 화면 중앙으로 설정

        setResizable(false); // 화면 크기 고정하는 작업
        setDefaultCloseOperation(EXIT_ON_CLOSE); //무조건 있어야함 끝내는것

        setVisible(true); // JFrame을 화면에 표시

    }
    public static void main(String[] args){
        MenuStart e = new MenuStart();
    }

}