package menu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuView extends JFrame{

    // 프레임
    JFrame menuF = new JFrame("Menu Description"); // 메뉴 설명
    JFrame menu_RandomF = new JFrame("Random Menu"); // 랜덤 메뉴

    // 패널
    JPanel tapPn = new JPanel(null){ // 탭바 패널
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/Tap_pn.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };
    JPanel menuPn = new JPanel(null); // 메뉴 버튼 패널
    JPanel menu_descriptionPn = new JPanel(null){ // 메뉴 설명 패널
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/Menu_Description.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };
    JPanel menu_WindowPn = new JPanel(null){ // 메뉴 설명창
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/white.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };
    JPanel menu_RandomPn = new JPanel(null){ // 랜던메뉴 선택창
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/white_2.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };

    // 버튼
    JButton homeBtn = new JButton("");
    JButton recordBtn = new JButton("");
    JButton randomBtn = new JButton("");
    JButton morningBtn = new JButton("");
    JButton lunchBtn = new JButton("");
    JButton dinnerBtn = new JButton("");
    JButton menuXBtn = new JButton("");
    JButton menuCloseBtn = new JButton("");
    JButton menuSelectBtn = new JButton("");
    JButton menuRandomSelectBtn = new JButton("");
    JButton[][] buttons = new JButton[4][4]; // 4행 4열의 버튼 배열 선언

    // 라벨
    JLabel randomtextLb = new JLabel("");

    // 텍스트 필드
    JTextField menurandomTF = new JTextField("");

    // 이미지 삽입
    ImageIcon homeBtn_img = new ImageIcon("imgs/Home.png");
    ImageIcon homeBtnClick_img = new ImageIcon("imgs/Home_clicked.png");
    ImageIcon recordBtn_img = new ImageIcon("imgs/Record.png");
    ImageIcon recordBtnClick_img = new ImageIcon("imgs/Record_clicked.png");
    ImageIcon randomBtn_img = new ImageIcon("imgs/Random.png");
    ImageIcon morningBtn_img = new ImageIcon("imgs/morning_line.png");
    ImageIcon lunchBtn_img = new ImageIcon("imgs/lunch_line.png");
    ImageIcon dinnerBtn_img = new ImageIcon("imgs/dinner_line.png");
    ImageIcon morningBtnClick_img = new ImageIcon("imgs/morning.png");
    ImageIcon lunchBtnClick_img = new ImageIcon("imgs/lunch.png");
    ImageIcon dinnerBtnClick_img = new ImageIcon("imgs/dinner.png");
    ImageIcon menuXBtn_img = new ImageIcon("imgs/x.png");
    ImageIcon menuXBtnClick_img = new ImageIcon("imgs/x_clicked.png");
    ImageIcon menuCloseBtn_img = new ImageIcon("imgs/close.png");
    ImageIcon menuCloseBtnClick_img = new ImageIcon("imgs/close_clicked.png");
    ImageIcon menuSelectBtn_img = new ImageIcon("imgs/select.png");
    ImageIcon menuSelectBtnClick_img = new ImageIcon("imgs/select_clicked.png");
    ImageIcon menu_img = new ImageIcon("imgs/menu.png");
    ImageIcon randomtext_img = new ImageIcon("imgs/random_text.png");
    ImageIcon menuRandomSelect_img = new ImageIcon("imgs/check.png");
    ImageIcon menurandomTF_img = new ImageIcon("imgs/text.png");

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

        // 메뉴 설명 버튼 추가
        MenuCloseBtn();
        MenuXBtn();
        MenuSelectBtn();
        MenuRandomTf();

        // 랜덤 메뉴 버튼 추가
        MenuRandomXBtn();
        MenuRandomSelectBtn();

        // 버튼 배열 추가
        addButtonsToPanel();

        // 스크롤 정책 설정
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 500)); // 스크롤 뷰포트의 크기 설정

        // 패널 크기 설정
        int tapPn_height = 120;
        int menuPn_height = tapPn_height * 8;

        tapPn.setPreferredSize(new Dimension(1200, tapPn_height));
        menuPn.setPreferredSize(new Dimension(1100, menuPn_height));

        // 패널 추가
        add(tapPn);
        add(scrollPane);

        setVisible(true); // JFrame을 화면에 표시
    }

    public void createButtons() { // 4행 4열 배열 버튼 생성
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setPreferredSize(new Dimension(100, 50)); // 버튼 크기 설정 (가로 100, 세로 50)
                buttons[row][col].setIcon(menu_img);
                buttons[row][col].setBorderPainted(false);
                buttons[row][col].setContentAreaFilled(false);
            }
        }
    }

    public void addButtonsToPanel() { // 4행 4열 버튼 패널에 추가
        menuPn.setLayout(new GridLayout(4, 4, -26, 0)); // 10픽셀의 간격으로 설정
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col].addMouseListener(new MouseAdapter() { // 마우스 이벤트
                    @Override public void mousePressed(MouseEvent e) { // 마우스 클릭했을때
                        menuF.setVisible(true);
                        menuF.setSize(670, 680);
                        menuF.setLayout(null);
                        menuF.setLocationRelativeTo(null);
                        menuF.setResizable(false);
                        menuF.add(menu_descriptionPn);

                        menu_descriptionPn.add(menu_WindowPn);
                        menu_descriptionPn.setBounds(0,0,670,680);
                        menu_WindowPn.setBounds(50, 80, 560, 400);

                        menuF.addWindowListener(new WindowAdapter() {
                            @Override public void windowClosing(WindowEvent e) { // X 누를 시 메뉴 설명 화면이 사라짐
                                menuF.dispose();
                            }
                        });
                    }
                });
                menuPn.add(buttons[row][col]);
            }
        }
    }

    public void HomeBtn(){ // 홈 버튼
        homeBtn.setBounds(23, 23, 70, 70);
        homeBtn.setBorderPainted(false);
        homeBtn.setRolloverIcon(homeBtnClick_img);
        homeBtn.setIcon(homeBtn_img);
        homeBtn.setContentAreaFilled(false);
        tapPn.add(homeBtn);
    }

    public void RecordBtn(){ // 기록 버튼
        recordBtn.setBounds(115, 23, 70, 70);
        recordBtn.setBorderPainted(false);
        recordBtn.setRolloverIcon(recordBtnClick_img);
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

        randomBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                menu_RandomF.setVisible(true);
                menu_RandomF.setSize(754, 493);
                menu_RandomF.setLayout(null);
                menu_RandomF.setLocationRelativeTo(null);
                menu_RandomF.setResizable(false);
                menu_RandomF.add(menu_RandomPn);

                menu_RandomPn.setBounds(0,0, 754, 493);
                menu_RandomPn.add(randomtextLb);
                randomtextLb.setIcon(randomtext_img);
                randomtextLb.setVisible(true);
                randomtextLb.setBounds(250, 20, 270, 50);

                menu_RandomF.addWindowListener(new WindowAdapter() {
                    @Override public void windowClosing(WindowEvent e) { // X 누를 시 메뉴 설명 화면이 사라짐
                        menu_RandomF.dispose();
                    }
                });
            }
        });
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

    public void MenuXBtn(){ // 메뉴 설명 X 버튼 (닫기 버튼과 같음)
        menuXBtn.setBounds(580, 20, 37, 37);
        menuXBtn.setBorderPainted(false);
        menuXBtn.setRolloverIcon(menuXBtnClick_img);
        menuXBtn.setIcon(menuXBtn_img);
        menuXBtn.setContentAreaFilled(false);
        menu_descriptionPn.add(menuXBtn);

        menuXBtn.addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                menuF.dispose();
            }
        });
    }

    public void MenuCloseBtn(){ // 메뉴 설명 닫기 버튼
        menuCloseBtn.setBounds(140, 520, 151, 69);
        menuCloseBtn.setBorderPainted(false);
        menuCloseBtn.setRolloverIcon(menuCloseBtnClick_img);
        menuCloseBtn.setIcon(menuCloseBtn_img);
        menuCloseBtn.setContentAreaFilled(false);
        menu_descriptionPn.add(menuCloseBtn);

        menuCloseBtn.addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                menuF.dispose();
            }
        });
    }

    public void MenuSelectBtn(){ // 메뉴 선택 버튼
        menuSelectBtn.setBounds(373, 520, 151, 69);
        menuSelectBtn.setBorderPainted(false);
        menuSelectBtn.setRolloverIcon(menuSelectBtnClick_img);
        menuSelectBtn.setIcon(menuSelectBtn_img);
        menuSelectBtn.setContentAreaFilled(false);
        menu_descriptionPn.add(menuSelectBtn);
    }

    public void MenuRandomXBtn(){ // 메뉴 설명 X 버튼 (닫기 버튼과 같음)
        menuXBtn.setBounds(681, 20, 37, 37);
        menuXBtn.setBorderPainted(false);
        menuXBtn.setRolloverIcon(menuXBtnClick_img);
        menuXBtn.setIcon(menuXBtn_img);
        menuXBtn.setContentAreaFilled(false);
        menu_RandomPn.add(menuXBtn);

        menuXBtn.addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                menu_RandomF.dispose();
            }
        });
    }

    public void MenuRandomSelectBtn(){
        menuRandomSelectBtn.setBounds(282, 350, 190, 80);
        menuRandomSelectBtn.setBorderPainted(false);
        menuRandomSelectBtn.setIcon(menuRandomSelect_img);
        menuRandomSelectBtn.setContentAreaFilled(false);
        menu_RandomPn.add(menuRandomSelectBtn);
    }

    public void MenuRandomTf(){
        menurandomTF.setBounds(52, 157, 650, 145);
        menu_RandomPn.add(menurandomTF);
    }

    public static void main(String[] args) {
        MenuView e = new MenuView();
    }

}
