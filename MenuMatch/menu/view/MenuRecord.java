package menu.view;

import menu.controller.DeleteRecord;
import menu.controller.RecordFoodList;
import menu.dto.DeleteRecordDTO;
import menu.dto.FoodRecordDTO;
import menu.dto.LoginDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

public class MenuRecord extends JFrame {

    static FoodRecordDTO foodRecordDTO = new FoodRecordDTO();
    private JPanel menuRecordPanel = new JPanel(new BorderLayout());
    private JScrollPane scrollPane;
    private JButton deleteButton;
    private List<String> userFoodRecords;

    public MenuRecord() {
        initializeFrame();
        initializeComponents();
        addComponentsToPanel();
        addPanelToFrame();
        displayFrame();
    }

    private void initializeFrame() {
        setTitle("Menu Record");
        setSize(754, 610);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        RecordFoodList recordFoodList = new RecordFoodList();
        userFoodRecords = recordFoodList.fetchFoodRecords("rei050r");
        deleteButton = createButton("imgs/delete.png", 47, 459, 640, 105);
        scrollPane = createScrollPane(createRecordTextPanel());
    }

    String CurmenuName = "";
    private JPanel createRecordTextPanel() {
        JPanel menuRecordTextPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int y = 60; // 메뉴 이름의 시작 y 좌표
                int i = 1;

                for (String menuName : userFoodRecords) {
                    ImageIcon imageIcon = new ImageIcon("imgs/record_label.png");
                    Image image = imageIcon.getImage();

                    // 이미지를 패널에 그림
                    g.drawImage(image, 45, y - 56, this);

                    g.setColor(Color.BLACK); // 텍스트 색상 설정
                    g.setFont(new Font("Gowun Batang", Font.PLAIN, 24));
                    g.drawString(menuName, 145, y); // 텍스트 그리기
                    g.drawString(String.valueOf(i), 83, y); // 텍스트 그리기
                    CurmenuName = menuName;
                    y += 110; // 다음 메뉴 이름을 그릴 y 좌표 조정
                    i++;


                }
            }
        };

        // 패널의 크기를 화면 크기보다 더 크게 설정
        menuRecordTextPanel.setPreferredSize(new Dimension(700, 700));
        return menuRecordTextPanel;
    }



    // 이미지를 클릭할 때 호출되는 메서드
    public void onImageClick(String menuName) {
        int result = JOptionPane.showConfirmDialog(this, "이 메뉴를 삭제하시겠습니까?", "메뉴 삭제 확인", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            // 사용자가 "예"를 선택한 경우, 메뉴 삭제
            DeleteRecordDTO deleteData = new DeleteRecordDTO();
            deleteData.setUserId("rei050r"); // 현재 사용자의 ID를 설정
            deleteData.setMenuName(menuName); // 클릭한 메뉴 이름을 설정

            DeleteRecord deleteRecord = new DeleteRecord();
            boolean deleteResult = deleteRecord.deleteFoodRecord(deleteData);

            if (deleteResult) {
                // 삭제 성공 메시지 표시
                JOptionPane.showMessageDialog(this, "메뉴가 삭제되었습니다.", "삭제 완료", JOptionPane.INFORMATION_MESSAGE);
                // 다시 UI 업데이트 또는 리프레시 작업을 수행할 수 있음
            } else {
                // 삭제 실패 메시지 표시
                JOptionPane.showMessageDialog(this, "메뉴 삭제에 실패했습니다.", "삭제 실패", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JButton createButton(String iconPath, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setIcon(new ImageIcon(iconPath));
        button.setContentAreaFilled(false);
        return button;
    }

    private JScrollPane createScrollPane(JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }


    private void addComponentsToPanel() {
        JLabel resultLabel = new JLabel("결과 불러오기");
        resultLabel.setFont(new Font("Gowun Batang", Font.PLAIN, 40));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(resultLabel);

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
