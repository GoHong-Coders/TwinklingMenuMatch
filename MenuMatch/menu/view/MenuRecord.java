package menu.view;

import menu.controller.RecordFoodList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MenuRecord extends JFrame {

    private JFrame menuRecordFrame = new JFrame("Menu Record");
    private JPanel menuRecordPanel = new JPanel(new BorderLayout());

    private JScrollPane scrollPane;
    private JButton deleteButton = new JButton();
    private JButton closeButton = new JButton();
    private JButton textCloseButton = new JButton();

    private ImageIcon deleteIcon = new ImageIcon("imgs/delete.png");
    private ImageIcon closeButtonIcon = new ImageIcon("imgs/x.png");
    private ImageIcon closeButtonClickedIcon = new ImageIcon("imgs/x_clicked.png");

    private List<String> userFoodRecords;

    public MenuRecord() {
        initializeFrame();
        initializeComponents();
        addComponentsToPanel();
        addPanelToFrame();
        displayFrame();
    }

    private void initializeFrame() {
        setTitle("Menu");
        setSize(754, 610);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        RecordFoodList recordFoodList = new RecordFoodList();
        userFoodRecords = recordFoodList.fetchFoodRecords("rei050r");

        scrollPane = new JScrollPane(createRecordTextPanel());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        initializeButton(deleteButton, deleteIcon, 47, 459, 640, 105);
    }

    private JPanel createRecordTextPanel() {
        JPanel panel = new JPanel(new GridLayout(userFoodRecords.size(), 1));
        for (int i = 0; i < userFoodRecords.size(); i++) {
            JPanel recordItemPanel = new JPanel(new BorderLayout());

            // 이미지와 버튼을 포함할 레이블 생성
            JLabel label = new JLabel();

            ImageIcon imageIcon = new ImageIcon("imgs/record_label.png");
            JLabel nameLabel = new JLabel(userFoodRecords.get(i));
            nameLabel.setFont(new Font("Gowun Batang", Font.PLAIN, 24));
            JLabel numberLabel = new JLabel(String.valueOf(i + 1));

            // 이미지 아이콘 설정
            label.setIcon(imageIcon);

            // 이미지 아이콘과 텍스트를 가운데 정렬
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);

            // 텍스트 라벨 추가
            label.setText("<html>" + userFoodRecords.get(i) + "<br>" + (i + 1) + "</html");

            // 버튼 추가
            deleteButton = new JButton();
            deleteButton.setIcon(closeButtonIcon);
            deleteButton.setBorderPainted(false); // 테두리 외곽선 없애기
            deleteButton.setFocusPainted(false); // focus되었을 때 생기는 테두리 없애기
            deleteButton.setContentAreaFilled(false); // 내용 영역 없애기add(startBtn);

            deleteButton.addActionListener(e -> {
                // 처리할 삭제 버튼 이벤트를 여기에 추가
            });


            recordItemPanel.add(label, BorderLayout.CENTER);
            recordItemPanel.add(deleteButton, BorderLayout.EAST);
            panel.add(recordItemPanel);
        }
        return panel;
    }



    private void initializeButton(JButton button, ImageIcon icon, int x, int y, int width, int height) {
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setIcon(icon);
        button.setContentAreaFilled(false);
    }

    private void addCloseButtonListener(JButton closeButton) {
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                menuRecordFrame.dispose();
            }
        });
    }

    private void addComponentsToPanel() {
        // "결과 불러오기" 라벨 생성
        JLabel resultLabel = new JLabel("결과 불러오기");
        resultLabel.setFont(new Font("Gowun Batang", Font.PLAIN, 40));

        // 상단 패널에 "결과 불러오기" 라벨 추가
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(resultLabel);

        // 나머지 구성요소 추가
        menuRecordPanel.add(topPanel, BorderLayout.NORTH);
        menuRecordPanel.add(scrollPane, BorderLayout.CENTER);
        menuRecordPanel.add(deleteButton, BorderLayout.SOUTH);

    }

    private void addPanelToFrame() {
        add(menuRecordPanel);
    }

    private void displayFrame() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuRecord menuRecord = new MenuRecord();
        });
    }
}
