package menu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;

public class MenuJoin extends JFrame {
    // 패널 만들기
    private JPanel panel;


    // 텍스트 필드 만들기
    private JTextField Join_Id_tf;
    private JTextField Join_name_tf;
    private JPasswordField Join_pass_tf;
    private JPasswordField Join_retry_tf;

    //버튼만들기
    private JButton joinBtn;
    private JButton cancelBtn;

    private Font font = new Font("Gowun Batang", Font.PLAIN, 14); // 폰트 설정

    MenuJoin() {
        panel = new JPanel(null);

        Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
        Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
        Border Border = BorderFactory.createCompoundBorder(raisedBevelBorder,loweredBevelBorder);

        //        <------------------------------------------------------> 아이디, 회원가입 필드


        // 이름 입력 필드
        Join_name_tf = new JTextField(15);
        Join_name_tf.setText("이름을 입력해주세요");
        Join_name_tf.setForeground(new Color(168, 168, 168));
        Join_name_tf.setBounds(234, 137, 312, 60); // 컴포넌트의 위치와 크기 설정
        Join_name_tf.setBorder(Border);
        Join_name_tf.setFont(font); // 폰트 설정
        panel.add(Join_name_tf);

        Join_name_tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Join_name_tf.getText().equals("이름을 입력해주세요")) {
                    Join_name_tf.setText("");
                    Join_name_tf.setForeground(new Color(44, 44, 44));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Join_name_tf.getText().isEmpty()) {
                    Join_name_tf.setText("이름을 입력해주세요");
                    Join_name_tf.setForeground(new Color(168, 168, 168));
                }
            }
        });



        // 아이디 입력 필드
        Join_Id_tf = new JTextField(15);
        Join_Id_tf.setText("아이디를 입력해주세요");
        Join_Id_tf.setForeground(new Color(168, 168, 168));
        Join_Id_tf.setBounds(234, 234, 312, 60); // 컴포넌트의 위치와 크기 설정
        Join_Id_tf.setBorder(Border);
        Join_Id_tf.setFont(font); // 폰트 설정
        panel.add(Join_Id_tf);

        Join_Id_tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Join_Id_tf.getText().equals("아이디를 입력해주세요")) {
                    Join_Id_tf.setText("");
                    Join_Id_tf.setForeground(new Color(44, 44, 44));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Join_Id_tf.getText().isEmpty()) {
                    Join_Id_tf.setText("아이디를 입력해주세요");
                    Join_Id_tf.setForeground(new Color(168, 168, 168));
                }
            }
        });


        // 비밀번호 입력 필드
        Join_pass_tf = new JPasswordField(15);
        Join_pass_tf.setEchoChar((char) 0);
        Join_pass_tf.setText("비밀번호를 입력해주세요");
        Join_pass_tf.setBounds(234, 331, 312, 60);
        Join_pass_tf.setForeground(new Color(168, 168, 168));
        Join_pass_tf.setBorder(Border);
        Join_pass_tf.setFont(font); // 폰트 설정
        panel.add(Join_pass_tf);

        // 비밀번호 입력 필드에 입력하면 *로 입력하게 만들어주는 함수
        Join_pass_tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // 입력 필드에 포커스를 받으면 힌트 텍스트가 비워짐
                String input = new String(Join_pass_tf.getPassword());
                if (input.equals("비밀번호를 입력해주세요")) {
                    Join_pass_tf.setText("");
                    Join_pass_tf.setForeground(new Color(44, 44, 44));
                    Join_pass_tf.setEchoChar('*'); // '*'로 마스킹 설정
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // 입력 필드에서 포커스를 잃으면 힌트 텍스트가 나타남
                String input = new String(Join_pass_tf.getPassword());
                if (input.isEmpty()) {
                    Join_pass_tf.setText("비밀번호를 입력해주세요");
                    Join_pass_tf.setForeground(new Color(168, 168, 168));
                    Join_pass_tf.setEchoChar((char) 0); // 마스킹 없음
                }
            }
        });

        // 비밀번호 확인 입력 필드
        Join_retry_tf = new JPasswordField(15);
        Join_retry_tf.setEchoChar((char) 0);
        Join_retry_tf.setText("비밀번호를 확인해주세요");
        Join_retry_tf.setBounds(234, 428, 312, 60);
        Join_retry_tf.setForeground(new Color(168, 168, 168));
        Join_retry_tf.setBorder(Border);
        Join_retry_tf.setFont(font); // 폰트 설정
        panel.add(Join_retry_tf);

        // 비밀번호 입력 필드에 입력하면 *로 입력하게 만들어주는 함수
        Join_retry_tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // 입력 필드에 포커스를 받으면 힌트 텍스트가 비워짐
                String input = new String(Join_retry_tf.getPassword());
                if (input.equals("비밀번호를 확인해주세요")) {
                    Join_retry_tf.setText("");
                    Join_retry_tf.setForeground(new Color(44, 44, 44));
                    Join_retry_tf.setEchoChar('*'); // '*'로 마스킹 설정
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // 입력 필드에서 포커스를 잃으면 힌트 텍스트가 나타남
                String input = new String(Join_retry_tf.getPassword());
                if (input.isEmpty()) {
                    Join_retry_tf.setText("비밀번호를 확인해주세요");
                    Join_retry_tf.setForeground(new Color(168, 168, 168));
                    Join_retry_tf.setEchoChar((char) 0); // 마스킹 없음
                }
            }
        });


        // 로그인 버튼
        joinBtn = createButton("imgs/join_joinBtn.png", "imgs/join_joinBtn_enter.png", 93, 542, 170, 60);
        // 취소 버튼
        cancelBtn = createButton("imgs/join_cancelBtn.png", "imgs/join_cancelBtn_enter.png", 318, 542, 170, 60);

        // 배경 사진 넣기
        JLabel backgroud_Label = new JLabel("");
        ImageIcon JoinScreen_Img = new ImageIcon(this.getClass().getResource("/joinScreen.png"));
        backgroud_Label.setIcon(JoinScreen_Img);
        backgroud_Label.setBounds(0, 0, 580, 640);
        panel.add(backgroud_Label);
        panel.setLayout(null);
        panel.setBounds(0, 0, 580, 670);

        add(panel);


        // JFrame 설정
        setTitle("회원가입 하기");
        setBounds(0, 0, 580, 670);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //        <------------------------------------------------------> JFrame
        setTitle("회원가입 하기"); // JFrame의 제목

        setBounds(0, 0, 580, 670); //x, y 좌표 위치 / 너비 높이 길이 설정
        setLocationRelativeTo(null); // Frame의 위치를 화면 중앙으로 설정

        setResizable(false); // 화면 크기 고정하는 작업
        setDefaultCloseOperation(EXIT_ON_CLOSE); //무조건 있어야함 끝내는것

        setVisible(true); // JFrame을 화면에 표시


    }

    private JButton createButton(String imgPath, String imgPathEnter, int x, int y, int width, int height) {
        JButton button = new JButton("");
        ImageIcon btnImg = new ImageIcon(imgPath);
        ImageIcon btnImgEnter = new ImageIcon(imgPathEnter);
        button.setIcon(btnImg);
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 버튼 클릭 시 동작 코드 작성
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(btnImgEnter);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(btnImg);
            }
        });

        panel.add(button);
        return button;
    }

    public static void main(String[] args) {
        MenuJoin e = new MenuJoin();
    }

}