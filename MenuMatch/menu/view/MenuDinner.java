package menu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import menu.controller.AddRecord;
import menu.dto.DinnerDTO;
import menu.dto.FoodRecordDTO;
import menu.controller.DinnerInfo;
import menu.dto.UserDTO;

public class MenuDinner extends JFrame {

    // import
    UserDTO vo = new UserDTO();
    static DinnerDTO dto = new DinnerDTO();
    DinnerInfo dinnerInfo = new DinnerInfo();
    static FoodRecordDTO foodRecordDTO = new FoodRecordDTO();

    int menu_id;
    String description;
    String name;

    // 프레임
    JFrame menuF = new JFrame("Menu Description"); // 메뉴 설명
    JFrame menu_RandomF = new JFrame("Random Menu"); // 랜덤 메뉴
    JFrame menu_RecordF = new JFrame("Menu Record"); // 메뉴 불러오기

    // 패널
    JPanel tapPn = new JPanel(null) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/Tap_pn.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };
    JPanel menuPn = new JPanel(null);
    JPanel menu_descriptionPn = new JPanel(null) { // 메뉴 설명 패널
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/Menu_Description.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);

            dinnerInfo.DinnerInfo(dto);
            name = dto.getMenuName(); // 데이터베이스에서 가져온 값으로 대체


            g.setColor(Color.WHITE); // 텍스트 색상 설정
            g.setFont(new Font("Gowun Batang", Font.PLAIN, 35));
            g.drawString(name, 250, 60); // 텍스트 그리기

        }
    };
    JPanel menu_WindowPn = new JPanel(null) { // 메뉴 설명창
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/white.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);



            dinnerInfo.DinnerInfo(dto);
            description = dto.getDescription(); // 데이터베이스에서 가져온 값으로 대체

            g.setColor(Color.BLACK); // 텍스트 색상 설정
            g.setFont(new Font("Gowun Batang", Font.PLAIN, 20)); // 한글을 지원하는 폰트 사용 예시
            g.drawString(description, 10, 78); // 텍스트 그리기

        }
    };
    JPanel menu_RandomPn = new JPanel(null) { // 랜덤메뉴 선택 패널
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("imgs/white_2.png");
            Image image = imageIcon.getImage();

            // 이미지를 패널에 그림
            g.drawImage(image, 0, 0, this);
        }
    };
    JPanel menu_RecordPn = new JPanel(null) { // 메뉴 불러오기 패널
        @Override
        protected void paintComponent(Graphics g) {
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
    JButton menuRandomXBtn = new JButton("");
    JButton menuRecordXBtn = new JButton("");
    JButton menuCloseBtn = new JButton("");
    JButton menuSelectBtn = new JButton("");
    JButton menuRandomSelectBtn = new JButton("");
    JButton menuRecordDeleteBtn = new JButton("");
    JButton[][] buttons = new JButton[4][4]; // 4행 4열의 버튼 배열 선언

    // 라벨
    JLabel randomtextLb = new JLabel("");
    JLabel recordtextLb = new JLabel("");

    // 텍스트 필드
    JTextField menurandomTF = new JTextField();

    // private (랜덤 기능)
    private final String[] Menu = {"삼겹살", "치킨", "피자", "볶음밥", "스테이크", "김치찌개",
            "된장찌개", "김치볶음밥", "카레", "만둣국", "보쌈", "짜장면", "짬뽕", "냉면", "훈제 오리", "마라탕"};
    private boolean spinning;

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
    ImageIcon recordtext_img = new ImageIcon("imgs/record_text.png");
    ImageIcon menuRandomSelect_img = new ImageIcon("imgs/check.png");
    ImageIcon menuRecordDelete_img = new ImageIcon("imgs/delete.png");
    ImageIcon menurandomTF_img = new ImageIcon("imgs/text.png");

    JScrollPane scrollPane = new JScrollPane(menuPn);

    MenuDinner() {
        setTitle("Menu Dinner"); // JFrame의 제목
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

        // 랜덤 메뉴 버튼 추가
        MenuRandomXBtn();
        MenuRandomSelectBtn();
        MenuRandomTf();

        // 버튼 배열 추가
        addButtonsToPanel();

        // 스크롤 정책 설정
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 500)); // 스크롤 뷰포트의 크기 설정

        // 패널 크기 설정
        int tapPn_height = 120;
        int menuPn_height = tapPn_height * 8;

        tapPn.setPreferredSize(new Dimension(500, tapPn_height));
        menuPn.setPreferredSize(new Dimension(500, menuPn_height));

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
        int row, col = 0;
        for (row = 0; row < 4; row++) {
            for (col = 0; col < 4; col++) {
                int finalRow = row;
                int finalCol = col;
                buttons[row][col].addMouseListener(new MouseAdapter() { // 마우스 이벤트
                    @Override
                    public void mousePressed(MouseEvent e) { // 마우스 클릭했을때
                        menuF.setVisible(true);
                        menuF.setSize(670, 680);
                        menuF.setLayout(null);
                        menuF.setLocationRelativeTo(null);
                        menuF.setResizable(false);
                        menuF.add(menu_descriptionPn);
                        menu_descriptionPn.add(menu_WindowPn);
                        menu_descriptionPn.setBounds(0, 0, 670, 680);
                        menu_WindowPn.setBounds(50, 80, 560, 400);

                        // 2차원 배열을 숫자로 바꾸기 : finalRow*4 + finalCol +1
                        System.out.println(finalRow*4 + finalCol + 1);
                        menu_id = finalRow*4 + finalCol + 1;
                        dto.setMenuID(menu_id);
                        menuF.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) { // X 누를 시 메뉴 설명 화면이 사라짐

                                menuF.dispose();
                            }
                        });
                    }
                });
                menuPn.add(buttons[row][col]);

            }
        }
    }

    public void HomeBtn() { // 홈 버튼
        homeBtn.setBounds(23, 23, 70, 70);
        homeBtn.setBorderPainted(false);
        homeBtn.setRolloverIcon(homeBtnClick_img);
        homeBtn.setIcon(homeBtn_img);
        homeBtn.setContentAreaFilled(false);
        tapPn.add(homeBtn);
    }

    public void RecordBtn() { // 기록 버튼
        recordBtn.setBounds(115, 23, 70, 70);
        recordBtn.setBorderPainted(false);
        recordBtn.setRolloverIcon(recordBtnClick_img);
        recordBtn.setIcon(recordBtn_img);
        recordBtn.setContentAreaFilled(false);
        tapPn.add(recordBtn);

        recordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼이 선택되었을 때 실행할 코드
                System.out.println("1");
            }
        });

    }


    public void RandomBtn() { // 랜덤 메뉴 버튼
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

                menu_RandomPn.setBounds(0, 0, 754, 493);
                menu_RandomPn.add(randomtextLb);
                randomtextLb.setIcon(randomtext_img);
                randomtextLb.setVisible(true);
                randomtextLb.setBounds(250, 20, 270, 50);

                menu_RandomF.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) { // X 누를 시 메뉴 설명 화면이 사라짐
                        menu_RandomF.dispose();
                    }
                });
            }
        });
    }

    public void MorningBtn() { // 아침 버튼
        morningBtn.setBounds(391, 26, 140, 70);
        morningBtn.setBorderPainted(false);
        morningBtn.setRolloverIcon(morningBtnClick_img);
        morningBtn.setIcon(morningBtn_img);
        morningBtn.setContentAreaFilled(false);
        tapPn.add(morningBtn);

        morningBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lunchBtn.setIcon(lunchBtn_img);
                dinnerBtn.setIcon(dinnerBtn_img);

                new MenuMorning();
                dispose();
            }
        });
    }

    public void LunchBtn() { // 점심 버튼
        lunchBtn.setBounds(529, 26, 140, 70);
        lunchBtn.setBorderPainted(false);
        lunchBtn.setRolloverIcon(lunchBtnClick_img);
        lunchBtn.setIcon(lunchBtn_img);
        lunchBtn.setContentAreaFilled(false);
        tapPn.add(lunchBtn);

        lunchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                morningBtn.setIcon(morningBtn_img);
                dinnerBtn.setIcon(dinnerBtn_img);

                new MenuLunch();
                dispose();
            }
        });
    }

    public void DinnerBtn() { // 저녁 버튼
        dinnerBtn.setBounds(666, 26, 140, 70);
        dinnerBtn.setBorderPainted(false);
        dinnerBtn.setRolloverIcon(dinnerBtnClick_img);
        dinnerBtn.setIcon(dinnerBtn_img);
        dinnerBtn.setContentAreaFilled(false);
        tapPn.add(dinnerBtn);

        dinnerBtn.setIcon(dinnerBtnClick_img);
        morningBtn.setIcon(morningBtn_img);
        lunchBtn.setIcon(lunchBtn_img);

        // 버튼 이미지 생성
        ImageIcon[] Dinner_menu_Images = new ImageIcon[16];
        ImageIcon[] Dinner_menu_dark_Images = new ImageIcon[16];
        for (int i = 1; i <= 16; i++) {
            String imagePath_1 = "imgs/Dinner_menu/dinner_menu" + i + ".png";
            String imagePath_2 = "imgs/Dinner_menu/dinner_menu_dark_" + i + ".png";
            ImageIcon icon_1 = new ImageIcon(imagePath_1);
            ImageIcon icon_2 = new ImageIcon(imagePath_2);
            Dinner_menu_Images[i - 1] = icon_1;
            Dinner_menu_dark_Images[i - 1] = icon_2;
        }

        // 버튼에 이미지 삽입
        int index = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col].setIcon(Dinner_menu_Images[index]);
                buttons[row][col].setRolloverIcon(Dinner_menu_dark_Images[index]);
                index++;
                buttons[row][col].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                });
                menuPn.add(buttons[row][col]);
            }
        }
    }

    public void MenuXBtn() { // 메뉴 설명 X 버튼 (닫기 버튼과 같음)
        menuXBtn.setBounds(580, 20, 37, 37);
        menuXBtn.setBorderPainted(false);
        menuXBtn.setIcon(menuXBtn_img);
        menuXBtn.setContentAreaFilled(false);
        menu_descriptionPn.add(menuXBtn);

        menuXBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                menuF.dispose();
            }
        });
    }

    public void MenuCloseBtn() { // 메뉴 설명 닫기 버튼
        menuCloseBtn.setBounds(140, 520, 151, 69);
        menuCloseBtn.setBorderPainted(false);
        menuCloseBtn.setRolloverIcon(menuCloseBtnClick_img);
        menuCloseBtn.setIcon(menuCloseBtn_img);
        menuCloseBtn.setContentAreaFilled(false);
        menu_descriptionPn.add(menuCloseBtn);

        menuCloseBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                menuF.dispose();
            }
        });
    }

    public void MenuSelectBtn() { // 메뉴 선택 버튼
        menuSelectBtn.setBounds(373, 520, 151, 69);
        menuSelectBtn.setBorderPainted(false);
        menuSelectBtn.setRolloverIcon(menuSelectBtnClick_img);
        menuSelectBtn.setIcon(menuSelectBtn_img);
        menuSelectBtn.setContentAreaFilled(false);
        menu_descriptionPn.add(menuSelectBtn);

        menuSelectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRecord addFood = new AddRecord();
                foodRecordDTO.setMenuName(dto.getMenuName());
                System.out.println(foodRecordDTO.getMenuName() + " " + foodRecordDTO.getUserID() );
                addFood.FoodRecordDTO(foodRecordDTO);
                if(addFood.record_chek()) {
                    JOptionPane.showMessageDialog(null, foodRecordDTO.getMenuName() + " 메뉴가 선택되었습니다!", "메뉴 선택 여부", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, foodRecordDTO.getMenuName() + " 메뉴가 선택되지 않았습니다!", "메뉴 선택 여부", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public void MenuRandomXBtn() { // 메뉴 설명 X 버튼 (닫기 버튼과 같음)
        menuRandomXBtn.setBounds(681, 20, 37, 37);
        menuRandomXBtn.setBorderPainted(false);
        menuRandomXBtn.setRolloverIcon(menuXBtnClick_img);
        menuRandomXBtn.setIcon(menuXBtn_img);
        menuRandomXBtn.setContentAreaFilled(false);
        menu_RandomPn.add(menuRandomXBtn);

        menuRandomXBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                menu_RandomF.dispose();
            }
        });
    }

    public void MenuRandomSelectBtn() { // 메뉴 랜덤 선택 버튼
        menuRandomSelectBtn.setBounds(282, 350, 190, 80);
        menuRandomSelectBtn.setBorderPainted(false);
        menuRandomSelectBtn.setIcon(menuRandomSelect_img);
        menuRandomSelectBtn.setContentAreaFilled(false);
        menu_RandomPn.add(menuRandomSelectBtn);
    }

    public void MenuRandomTf(){ // 메뉴 랜덤 텍스트필드
        Thread rouletteThread = new Thread(new RouletteTask());
        rouletteThread.start();

        menurandomTF.setFont(new Font("SansSerif", Font.BOLD, 20));
        menurandomTF.setHorizontalAlignment(JTextField.CENTER);
        menurandomTF.setEditable(false);
        menurandomTF.setBounds(52, 157, 650, 145);
        menu_RandomPn.add(menurandomTF);
    }
    private class RouletteTask implements Runnable {
        @Override
        public void run() {
            spinning = true;
            Random random = new Random();
            int duration = 5000 + random.nextInt(5000); // 스핀 지속 시간 (5-10초)
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() - startTime < duration) {
                int randomIndex = random.nextInt(Menu.length);
                menurandomTF.setText(Menu[randomIndex]);
                try {
                    Thread.sleep(100); // 업데이트 간격 (0.1초)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            spinning = false;
            stopRoulette();
        }
    }
    private void stopRoulette() {
        Random random = new Random();
        int randomIndex = random.nextInt(Menu.length);
        menurandomTF.setText(Menu[randomIndex]);
    }

    public static void main(String[] args) {
        MenuDinner e = new MenuDinner();
    }
}