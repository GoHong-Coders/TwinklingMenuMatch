package menu.view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame{

    // 패널
    JPanel tapPn = new JPanel(null){
        @Override
        public void setBounds(int x, int y, int width, int height) {
            super.setBounds(0, 0, 1200, 140);
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/Tap_pn.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };

    // 버튼
    JButton homeBtn = new JButton("");
    JButton recordBtn = new JButton("");
    JButton morningBtn = new JButton("");
    JButton lunchBtn = new JButton("");
    JButton dinnerBtn = new JButton("");


    // 이미지 삽입
    ImageIcon homeBtn_img = new ImageIcon("imgs/Home.png");
    ImageIcon recordBtn_img = new ImageIcon("imgs/Record.png");
    ImageIcon morningBtn_img = new ImageIcon("imgs/morning_line.png");
    ImageIcon lunchBtn_img = new ImageIcon("imgs/lunch_line.png");
    ImageIcon dinnerBtn_img = new ImageIcon("imgs/dinner_line.png");
    ImageIcon morningBtnClick_img = new ImageIcon("imgs/morning.png");
    ImageIcon lunchBtnClick_img = new ImageIcon("imgs/lunch.png");
    ImageIcon dinnerBtnClick_img = new ImageIcon("imgs/dinner.png");



    MenuView() {
        setTitle("Menu"); // JFrame의 제목

        setBounds(0, 0, 1200, 700); //x, y 좌표 위치 / 너비 높이 길이 설정
        setLocationRelativeTo(null); // Frame의 위치를 화면 중앙으로 설정

        setResizable(false); // 화면 크기 고정하는 작업
        setDefaultCloseOperation(EXIT_ON_CLOSE); //무조건 있어야함 끝내는것
        setVisible(true); // JFrame을 화면에 표시

        // 패널 추가
        add(tapPn);

        // 버튼 추가
        HomeBtn();
        RecordBtn();
        MorningBtn();
        LunchBtn();
        DinnerBtn();
    }


    public void HomeBtn(){ // 홈 버튼
        homeBtn.setBounds(33, 36, 84, 84);
        homeBtn.setBorderPainted(false);
        homeBtn.setIcon(homeBtn_img);
        homeBtn.setContentAreaFilled(false);
        tapPn.add(homeBtn);
    }

    public void RecordBtn(){ // 기록 버튼
        recordBtn.setBounds(1097, 25, 91, 91);
        recordBtn.setBorderPainted(false);
        recordBtn.setIcon(recordBtn_img);
        recordBtn.setContentAreaFilled(false);
        tapPn.add(recordBtn);
    }

    public void MorningBtn(){ // 아침 버튼
        morningBtn.setBounds(390, 39, 140, 70);
        morningBtn.setBorderPainted(false);
        morningBtn.setRolloverIcon(morningBtnClick_img);
        morningBtn.setIcon(morningBtn_img);
        morningBtn.setContentAreaFilled(false);
        tapPn.add(morningBtn);
    }

    public void LunchBtn(){ // 점심 버튼
        lunchBtn.setBounds(528, 39, 140, 70);
        lunchBtn.setBorderPainted(false);
        lunchBtn.setRolloverIcon(lunchBtnClick_img);
        lunchBtn.setIcon(lunchBtn_img);
        lunchBtn.setContentAreaFilled(false);
        tapPn.add(lunchBtn);
    }

    public void DinnerBtn() { // 저녁 버튼
        dinnerBtn.setBounds(666, 39, 140, 70);
        dinnerBtn.setBorderPainted(false);
        dinnerBtn.setRolloverIcon(dinnerBtnClick_img);
        dinnerBtn.setIcon(dinnerBtn_img);
        dinnerBtn.setContentAreaFilled(false);
        tapPn.add(dinnerBtn);
    }

    public static void main(String[] args) {
        MenuView e = new MenuView();
    }

}
