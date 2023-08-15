package menu.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class MenuTime extends JFrame {
    private JPanel timePl; // 패널
    private JLabel tTimeLb; // 현재 시각을 나타내는 라벨
    private JLabel tClockLb; // 시계 이미지를 넣을 라벨
    private JButton tMorning_btn; // 아침 선택 버튼
    private JButton tLunch_btn; // 점심 선택 버튼
    private JButton tDinner_btn; // 저녁 선택 버튼

    MenuTime() {
        setTitle("시간대별로 아침, 점심, 저녁 고르기");
        setBounds(0, 0, 1200, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timePl = new JPanel(null);
        timePl.setBackground(new Color(255, 255, 255));

        // 현재 시간 표시 라벨 추가
        addTimeLabel();

        // 시계 이미지 추가
        addClockImage();

        // 아침, 점심, 저녁 버튼 추가
        addMealButtons();

        this.add(timePl);
        this.setVisible(true);
    }

    // 현재 시간 표시하는 함수
    private void addTimeLabel() {
        tTimeLb = new JLabel();
        tTimeLb.setFont(new Font("Arial", Font.PLAIN, 45));
        tTimeLb.setBounds(540, 82, 150, 58);
        updateTimeLabel();

        // 1초마다 현재 시간 업데이트
        int delay = 1000;
        Timer timer = new Timer(delay, e -> updateTimeLabel());
        timer.start();

        timePl.add(tTimeLb);
    }

    // 현재 시각을 나타내는 함수
    private void updateTimeLabel() {
        Font font = new Font("digital-7", Font.PLAIN, 55);//디지털 font 설정
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(formatter);
        tTimeLb.setText(formattedTime);
        tTimeLb.setFont(font); //
    }

    // 시계 이미지를 추가하는 함수
    private void addClockImage() {
        tClockLb = new JLabel();
        ImageIcon tClockLb_Img = new ImageIcon("imgs/tClock.png");
        tClockLb.setIcon(tClockLb_Img);
        tClockLb.setBounds(478, 46, 243, 122);
        timePl.add(tClockLb);
    }

    // 아침, 점심, 저녁 버튼을 선택하는 함수
    private void addMealButtons() {
        tMorning_btn = new JButton("");
        tLunch_btn = new JButton("");
        tDinner_btn = new JButton("");

        tMorning_btn.setBounds(110, 293, 224, 226);
        tLunch_btn.setBounds(488, 293, 224, 226);
        tDinner_btn.setBounds(865, 293, 224, 226);

        addImageButton(tMorning_btn, "imgs/tMorning_btn.png", "imgs/tMorning_btn_enter.png", "Morning");
        addImageButton(tLunch_btn, "imgs/tLunch_btn.png", "imgs/tLunch_btn_enter.png", "Lunch");
        addImageButton(tDinner_btn, "imgs/tDinner_btn.png", "imgs/tDinner_btn_enter.png", "Dinner");

        timePl.add(tMorning_btn);
        timePl.add(tLunch_btn);
        timePl.add(tDinner_btn);
    }

    // 마우스 이벤트 함수
    private void addImageButton(JButton button, String normalImage, String enterImage, String className) {
        ImageIcon normalIcon = new ImageIcon(normalImage);
        ImageIcon enterIcon = new ImageIcon(enterImage);

        button.setIcon(normalIcon);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 버튼 클릭 시 해당 클래스로 이동
                if ("Morning".equals(className)) {
//                    new MenuMorning(); // 아침 메뉴 화면으로 이동
                } else if ("Lunch".equals(className)) {
//                    new MenuLunch(); // 아침 메뉴 화면으로  이동
                } else if ("Dinner".equals(className)) {
//                    new MenuDinner(); // 저녁 메뉴 화면으로 이동
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(enterIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(normalIcon);
            }
        });
    }
    public static void main(String[] args){
        MenuTime e = new MenuTime();
    }

}