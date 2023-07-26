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
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(formatter);
        tTimeLb.setText(formattedTime);
    }

    // 시계 이미지를 추가하는 함수
    private void addClockImage() {
        tClockLb = new JLabel();
        ImageIcon tClockLb_Img = new ImageIcon("imgs/clock.png");
        tClockLb.setIcon(tClockLb_Img);
        tClockLb.setBounds(478, 46, 243, 122);
        timePl.add(tClockLb);
    }

    public static void main(String[] args){
        MenuTime e = new MenuTime();
    }

}