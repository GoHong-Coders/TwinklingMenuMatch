package menu.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuLogin extends JFrame {
    private JPanel panel = new JPanel(null);
    private JTextField usernameField;
    private JPasswordField passwordField;


    //버튼만들기
    JButton loginBtn = new JButton("");
    JButton joinBtn = new JButton("");
    MenuLogin(){


        //        <------------------------------------------------------> 아이디, 회원가입 필드
        // 아이디 입력 필드
        usernameField = new JTextField(15);
        usernameField.setText("아이디를 입력해주세요");
        usernameField.setForeground(Color.GRAY);
        usernameField.setBounds(192, 155, 312, 60); // 컴포넌트의 위치와 크기 설정
        panel.add(usernameField);

        // FocusListener를 사용하여 텍스트 필드의 힌트 텍스트 처리
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("아이디를 입력해주세요")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("아이디를 입력해주세요");
                    usernameField.setForeground(Color.GRAY);
                }
            }
        });

        // 비밀번호 입력 필드
        passwordField = new JPasswordField(15);
        passwordField.setEchoChar((char) 0);
        passwordField.setText("비밀번호를 입력해주세요");
        passwordField.setForeground(Color.GRAY);
        passwordField.setBounds(192, 236, 312, 60);
        panel.add(passwordField);

        // FocusListener를 사용하여 텍스트 필드의 힌트 텍스트 처리
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("비밀번호를 입력해주세요")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("비밀번호를 입력해주세요");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

//        <------------------------------------------------------> 로그인, 회원가입 버튼
        // 로그인 버튼 위치, 크기 설정
        ImageIcon loginBtnImg = new ImageIcon("imgs/loginBtn.png");
        ImageIcon loginBtnImg_enter = new ImageIcon("imgs/loginBtn_enter.png");
        loginBtn.setIcon(loginBtnImg);
        loginBtn.setBounds(76, 334, 190, 56); // 크기 위치 설정
        loginBtn.setBorderPainted(false); // 테두리 외곽선 없애기
        loginBtn.setFocusPainted(false); // focus되었을 때 생기는 테두리 없애기
        loginBtn.setContentAreaFilled(false); // 내용 영역 없애기

        // MouseListener를 이용하여 버튼의 Mouse 이벤트 처리
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 버튼 클릭 시 다른 클래스로 이동
//                new MenuTime();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                loginBtn.setIcon(loginBtnImg_enter); // 마우스가 버튼 안으로 들어오면 이미지 변경
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginBtn.setIcon(loginBtnImg); // 마우스가 버튼 밖으로 나가면 이미지 원래대로 복원
            }
        });

        panel.add(loginBtn);

        ImageIcon joinBtnImg = new ImageIcon("imgs/joinBtn.png");
        ImageIcon joinBtnImg_enter = new ImageIcon("imgs/joinBtn_enter.png");
        joinBtn.setIcon(joinBtnImg);
        joinBtn.setBounds(309, 334, 190, 56); // 크기 위치 설정
        joinBtn.setBorderPainted(false); // 테두리 외곽선 없애기
        joinBtn.setFocusPainted(false); // focus되었을 때 생기는 테두리 없애기
        joinBtn.setContentAreaFilled(false); // 내용 영역 없애기

        // MouseListener를 이용하여 버튼의 Mouse 이벤트 처리
        joinBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 버튼 클릭 시 다른 클래스로 이동
//                new MenuTime();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                joinBtn.setIcon(joinBtnImg_enter); // 마우스가 버튼 안으로 들어오면 이미지 변경
            }

            @Override
            public void mouseExited(MouseEvent e) {
                joinBtn.setIcon(joinBtnImg); // 마우스가 버튼 밖으로 나가면 이미지 원래대로 복원
            }
        });

        panel.add(joinBtn);



//        <------------------------------------------------------> 배경 사진 넣기

        JLabel backgroud_Label = new JLabel("");
        ImageIcon loginScreen_Img = new ImageIcon(this.getClass().getResource("/loginScreen.png"));
        backgroud_Label.setIcon(loginScreen_Img);
        backgroud_Label.setBounds(0, 0, 580, 465);
        panel.add(backgroud_Label);
        panel.setLayout(null);
        panel.setBounds(0, 0, 580, 465);

        add(panel);
        //        <------------------------------------------------------> JFrame
        setTitle("로그인 하기"); // JFrame의 제목

        setBounds(0, 0, 580, 465); //x, y 좌표 위치 / 너비 높이 길이 설정
        setLocationRelativeTo(null); // Frame의 위치를 화면 중앙으로 설정

        setResizable(false); // 화면 크기 고정하는 작업
        setDefaultCloseOperation(EXIT_ON_CLOSE); //무조건 있어야함 끝내는것

        setVisible(true); // JFrame을 화면에 표시


    }
    public static void main(String[] args){
        MenuLogin e = new MenuLogin();
    }

}