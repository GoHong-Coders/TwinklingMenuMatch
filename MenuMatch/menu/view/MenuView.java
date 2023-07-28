package menu.view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MenuView extends JFrame{

    // 패널
    JPanel tapPn = new JPanel(null){
//        @Override
//        public void setBounds(int x, int y, int width, int height) {
//            super.setBounds(0, 0, 1200, 120);
//        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/Tap_pn.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };
    JPanel menuPn = new JPanel(null){
//        @Override
//        public void setBounds(int x, int y, int width, int height) {
//            super.setBounds(24, 197, 1140, 803);
//        }

    };

    // 버튼
    JButton homeBtn = new JButton("");
    JButton recordBtn = new JButton("");
    JButton randomBtn = new JButton("");
    JButton morningBtn = new JButton("");
    JButton lunchBtn = new JButton("");
    JButton dinnerBtn = new JButton("");
    JButton[][] buttons = new JButton[4][4]; // 4행 4열의 버튼 배열 선언

    // 이미지 삽입
    ImageIcon homeBtn_img = new ImageIcon("imgs/Home.png");
    ImageIcon recordBtn_img = new ImageIcon("imgs/Record.png");
    ImageIcon randomBtn_img = new ImageIcon("imgs/Random.png");
    ImageIcon morningBtn_img = new ImageIcon("imgs/morning_line.png");
    ImageIcon lunchBtn_img = new ImageIcon("imgs/lunch_line.png");
    ImageIcon dinnerBtn_img = new ImageIcon("imgs/dinner_line.png");
    ImageIcon morningBtnClick_img = new ImageIcon("imgs/morning.png");
    ImageIcon lunchBtnClick_img = new ImageIcon("imgs/lunch.png");
    ImageIcon dinnerBtnClick_img = new ImageIcon("imgs/dinner.png");

    JScrollPane scrollPane = new JScrollPane(menuPn);

    MenuView() {
        setTitle("Menu"); // JFrame의 제목
        // setLayout(new GridLayout(2,1)); // 프레임 하나에 동시에 두 패널 띄움
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setBounds(0, 0, 1200, 700); //x, y 좌표 위치 / 너비 높이 길이 설정
        setLocationRelativeTo(null); // Frame의 위치를 화면 중앙으로 설정
        setResizable(false); // 화면 크기 고정하는 작업
        setDefaultCloseOperation(EXIT_ON_CLOSE); //무조건 있어야함 끝내는것

        // 버튼 배열 초기화
        createButtons();

        // 버튼 추가
        HomeBtn();
        RecordBtn();
        RandomBtn();
        MorningBtn();
        LunchBtn();
        DinnerBtn();

        // 버튼 배열 추가
        addButtonsToPanel();

        // 스크롤 정책 설정
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 500)); // 스크롤 뷰포트의 크기 설정

        // 패널 크기 설정
        int tapPn_heigth = 120;
        int menuPn_height = tapPn_heigth * 5;

        tapPn.setPreferredSize(new Dimension(500, tapPn_heigth));
        menuPn.setPreferredSize(new Dimension(500, menuPn_height));

        // 패널 추가
        add(tapPn);
        add(scrollPane);

        setVisible(true); // JFrame을 화면에 표시
    }

    public void createButtons() { // 4행 4열 배열 버튼 생성
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new JButton("" + (row * 4 + col + 1));
                buttons[row][col].setPreferredSize(new Dimension(100, 50)); // 버튼 크기 설정 (가로 100, 세로 50)

            }
        }
    }

    public void addButtonsToPanel() { // 4행 4열 버튼 패널에 추가
        menuPn.setLayout(new GridLayout(4, 10, 58, 82)); // 10픽셀의 간격으로 설정
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                menuPn.add(buttons[row][col]);
            }
        }
    }

    public void HomeBtn(){ // 홈 버튼
        homeBtn.setBounds(23, 23, 70, 70);
        homeBtn.setBorderPainted(false);
        homeBtn.setIcon(homeBtn_img);
        homeBtn.setContentAreaFilled(false);
        tapPn.add(homeBtn);
    }

    public void RecordBtn(){ // 기록 버튼
        recordBtn.setBounds(115, 23, 70, 70);
        recordBtn.setBorderPainted(false);
        recordBtn.setIcon(recordBtn_img);
        recordBtn.setContentAreaFilled(false);
        tapPn.add(recordBtn);
    }

    public void RandomBtn(){ // 랜덤 메뉴 버튼
        randomBtn.setBounds(1080, 20, 87, 87);
        randomBtn.setBorderPainted(false);
        randomBtn.setIcon(randomBtn_img);
        randomBtn.setContentAreaFilled(false);
        tapPn.add(randomBtn);
    }

    public void MorningBtn(){ // 아침 버튼
        morningBtn.setBounds(391, 26, 140, 70);
        morningBtn.setBorderPainted(false);
        morningBtn.setRolloverIcon(morningBtnClick_img);
        morningBtn.setIcon(morningBtn_img);
        morningBtn.setContentAreaFilled(false);
        tapPn.add(morningBtn);
    }

    public void LunchBtn(){ // 점심 버튼
        lunchBtn.setBounds(529, 26, 140, 70);
        lunchBtn.setBorderPainted(false);
        lunchBtn.setRolloverIcon(lunchBtnClick_img);
        lunchBtn.setIcon(lunchBtn_img);
        lunchBtn.setContentAreaFilled(false);
        tapPn.add(lunchBtn);
    }

    public void DinnerBtn() { // 저녁 버튼
        dinnerBtn.setBounds(666, 26, 140, 70);
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
