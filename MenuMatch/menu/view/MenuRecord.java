package menu.view;

import menu.controller.AllDeleteRecord;
import menu.controller.DeleteRecord;
import menu.controller.RecordFoodList;
import menu.dto.AllDeleteRecordDTO;
import menu.dto.DeleteRecordDTO;
import menu.dto.FoodRecordDTO;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.*;

public class MenuRecord extends JFrame {

    static FoodRecordDTO foodRecordDTO = new FoodRecordDTO();
    private JPanel menuRecordPanel = new JPanel(new BorderLayout());
    private JPanel menuXPnael = new JPanel(null);

    private JScrollPane scrollPane;
    private JButton deleteButton;
    private List<String> userFoodRecords;
    private Map<Image, String> imageToMenuName = new HashMap<>();
    JButton menuRecordXBtn = new JButton("");
    ImageIcon menuXBtn_img = new ImageIcon("imgs/x.png");
    ImageIcon menuXBtnClick_img = new ImageIcon("imgs/x_clicked.png");

    public MenuRecord() {
        initializeFrame();
        initializeComponents();
        MenuRecordXBtn(); // X 버튼을 먼저 추가
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
        menuXPnael.setBounds(679,31,37,37);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(deleteButton, "이 메뉴를 삭제하시겠습니까?", "메뉴 삭제 확인", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    // 사용자가 "예"를 선택한 경우, 메뉴 삭제
                    AllDeleteRecordDTO allDeleteRecordDTO = new AllDeleteRecordDTO();
                    allDeleteRecordDTO.setUserId("rei050r"); // 현재 사용자의 ID를 설정

                    AllDeleteRecord allDeleteRecord = new AllDeleteRecord();
                    boolean deleteResult = allDeleteRecord.deleteFoodRecord(allDeleteRecordDTO);

                    if (deleteResult) {
                        // 삭제 성공 메시지 표시
                        JOptionPane.showMessageDialog(deleteButton, "메뉴가 삭제되었습니다.", "삭제 완료", JOptionPane.INFORMATION_MESSAGE);
                        // 다시 UI 업데이트 또는 리프레시 작업을 수행할 수 있음
                    } else {
                        // 삭제 실패 메시지 표시
                        JOptionPane.showMessageDialog(deleteButton, "메뉴 삭제에 실패했습니다.", "삭제 실패", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }



    private JPanel createRecordTextPanel() {
        JPanel menuRecordTextPanel = new JPanel(null);

        int y = 40;
        int i = 1;

        for (String menuName : userFoodRecords) {
            ImageIcon imageIcon = new ImageIcon("imgs/record_label.png");
            Image image = imageIcon.getImage();

            // 텍스트를 JLabel로 설정
            JLabel textLabel = new JLabel(menuName);
            textLabel.setFont(new Font("Gowun Batang", Font.PLAIN, 24));
            textLabel.setBounds(135, y+30, 200, 30); // 텍스트 크기를 조절
            menuRecordTextPanel.add(textLabel);

            JLabel numberLabel = new JLabel(String.valueOf(i));
            numberLabel.setBounds(85, y+30, 50, 30); // 숫자 텍스트 크기를 조절
            menuRecordTextPanel.add(numberLabel);

            // 이미지를 JLabel로 설정
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(45, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            menuRecordTextPanel.add(imageLabel);

            // 이미지와 menuName을 연결
            imageToMenuName.put(image, menuName);

            y += 110;
            i++;
        }

        // 이미지 클릭 이벤트 처리
        menuRecordTextPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component component = menuRecordTextPanel.getComponentAt(e.getPoint());
                if (component instanceof JLabel) {
                    Image clickedImage = ((ImageIcon) ((JLabel) component).getIcon()).getImage();
                    String menuName = imageToMenuName.get(clickedImage);

                    if (menuName != null) {
                        onImageClick(menuName);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 패널의 크기를 설정
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

            System.out.println(menuName);
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
        topPanel.add(menuRecordXBtn);
        // X 버튼을 상단 패널에 추가
        topPanel.add(menuXPnael, BorderLayout.SOUTH);

        menuRecordPanel.add(topPanel, BorderLayout.NORTH);
        menuRecordPanel.add(scrollPane, BorderLayout.CENTER);
        menuRecordPanel.add(deleteButton, BorderLayout.SOUTH);
    }


    public void MenuRecordXBtn() { // 메뉴 설명 X 버튼 (닫기 버튼과 같음)
        menuRecordXBtn.setBounds(700, 31, 37, 37);
        menuRecordXBtn.setBorderPainted(false);
        menuRecordXBtn.setRolloverIcon(menuXBtnClick_img);
        menuRecordXBtn.setIcon(menuXBtn_img);
        menuRecordXBtn.setContentAreaFilled(false);

        menuXPnael.add(menuRecordXBtn); // X 버튼을 menuXPnael 패널에 추가

        menuRecordXBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose(); // 현재의 JFrame을 닫습니다.
            }
        });
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
            menuRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
