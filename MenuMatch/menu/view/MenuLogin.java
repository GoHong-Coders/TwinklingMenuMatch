package menu.view;

import menu.controller.UserLogin;
import menu.dto.FoodRecordDTO;
import menu.dto.LoginDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class MenuLogin extends JFrame {
    static LoginDTO vo = new LoginDTO();
    static FoodRecordDTO foodRecordDTO = new FoodRecordDTO();

    private JPanel panel;
    private JTextField Login_Id_tf;
    private JPasswordField Login_pass_tf;
    private JButton loginBtn;
    private JButton joinBtn;

    private String login_id;
    private String login_pass;

    private Font font = new Font("Gowun Batang", Font.PLAIN, 14); // 폰트 설정


    public MenuLogin() {
        LoginUI();
    }

    private void LoginUI() {
        // 패널 레이아웃 null로 설정
        panel = new JPanel(null);


        // 아이디 입력 필드
        Login_Id_tf = new JTextField(10);
        // createCompoundBorder(Border outsideBorder, Border insideBorder): 두 개의 Border를 조합하여 새로운 Border를 생성
        // createRaisedBevelBorder(): 볼록한 스타일의 테두리를 생성.
        //createLoweredBevelBorder(): 오목한 스타일의 테두리를 생성.
        Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
        Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
        Border Border = BorderFactory.createCompoundBorder(raisedBevelBorder, loweredBevelBorder);

        Login_Id_tf.setText("아이디를 입력해주세요");
        Login_Id_tf.setBounds(192, 155, 312, 60);
        Login_Id_tf.setForeground(new Color(168, 168, 168));
        Login_Id_tf.setBorder(Border);
        Login_Id_tf.setFont(font); // 폰트 설정

        Login_Id_tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Login_Id_tf.getText().equals("아이디를 입력해주세요")) {
                    Login_Id_tf.setText("");
                    Login_Id_tf.setForeground(new Color(44, 44, 44));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Login_Id_tf.getText().isEmpty()) {
                    Login_Id_tf.setText("아이디를 입력해주세요");
                    Login_Id_tf.setForeground(new Color(168, 168, 168));
                }
            }
        });

        panel.add(Login_Id_tf);

        // 비밀번호 입력 필드
        Login_pass_tf = new JPasswordField(15);
        Login_pass_tf.setEchoChar((char) 0);
        Login_pass_tf.setText("비밀번호를 입력해주세요");
        Login_pass_tf.setBounds(192, 236, 312, 60);
        Login_pass_tf.setForeground(new Color(168, 168, 168));
        Login_pass_tf.setBorder(Border);
        Login_pass_tf.setFont(font); // 폰트 설정
        panel.add(Login_pass_tf);

        // 비밀번호 입력 필드에 입력하면 *로 입력하게 만들어주는 함수
        Login_pass_tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // 입력 필드에 포커스를 받으면 힌트 텍스트가 비워짐
                String input = new String(Login_pass_tf.getPassword());
                if (input.equals("비밀번호를 입력해주세요")) {
                    Login_pass_tf.setText("");
                    Login_pass_tf.setForeground(new Color(44, 44, 44));
                    Login_pass_tf.setEchoChar('*'); // '*'로 마스킹 설정
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // 입력 필드에서 포커스를 잃으면 힌트 텍스트가 나타남
                String input = new String(Login_pass_tf.getPassword());
                if (input.isEmpty()) {
                    Login_pass_tf.setText("비밀번호를 입력해주세요");
                    Login_pass_tf.setForeground(new Color(168, 168, 168));
                    Login_pass_tf.setEchoChar((char) 0); // 마스킹 없음
                }
            }
        });


        // 로그인 버튼
        loginBtn = new JButton("");
        setButton(loginBtn, "imgs/loginBtn.png", "imgs/loginBtn_enter.png");
        loginBtn.setBounds(76, 334, 190, 56);
        panel.add(loginBtn);

        // 회원가입 버튼
        joinBtn = new JButton("");
        setButton(joinBtn, "imgs/joinBtn.png", "imgs/joinBtn_enter.png");
        joinBtn.setBounds(309, 334, 190, 56);
        panel.add(joinBtn);

        // 배경 사진 넣기
        JLabel backgroundLabel = new JLabel("");
        ImageIcon loginScreenImg = new ImageIcon(this.getClass().getResource("/loginScreen.png"));
        backgroundLabel.setIcon(loginScreenImg);
        backgroundLabel.setBounds(0, 0, 580, 465);
        panel.add(backgroundLabel);

        panel.setLayout(null);
        panel.setBounds(0, 0, 580, 465);
        add(panel);

        setTitle("로그인 하기");
        setBounds(0, 0, 580, 465);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // 마우스 리스너를 클릭하면 동작 또는 버튼위에 마우스가 올라가면 이미지가 변경되는 함수
    private void setButton(JButton button, String imgPath, String imgPathEnter) {
        ImageIcon btnImg = new ImageIcon(imgPath);
        ImageIcon btnImgEnter = new ImageIcon(imgPathEnter);
        button.setIcon(btnImg);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // JTextField에서 입력된 값을 변수에 할당
                login_id = Login_Id_tf.getText();
                login_pass = Login_pass_tf.getText();

                // 이후 변수(user_id)를 활용하여 처리 가능
                System.out.println("User ID: " + login_id);
                System.out.println("User PASS: " + login_pass);

                if (button == loginBtn) {
                    vo = new LoginDTO(login_id, login_pass);

                    UserLogin login = new UserLogin();
                    login.Login(vo);
                    if (login.Login_check()) {
                        JOptionPane.showMessageDialog(null, "로그인이 되었습니다!", "로그인 확인 여부", JOptionPane.INFORMATION_MESSAGE);
                        vo.setLoginId(login_id);
                        foodRecordDTO.setUserID(login_id);
                        new MenuTime();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "로그인이 되지 않았습니다.", "로그인 확인 여부", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (button == joinBtn) {
                    new MenuJoin();
                    dispose();
                }
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
    }

    public static void main(String[] args) {
        MenuLogin e = new MenuLogin();
    }
}
