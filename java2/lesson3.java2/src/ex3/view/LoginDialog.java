package ex3.view;

import ex3.controller.LoginDialogController;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class LoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfLogin;
    private JPasswordField pfPassword;
    private JLabel labError;
    private JLabel labRegister;
    private LoginDialogController loginDialogController;

    public LoginDialogController getLoginDialogController() {
        return loginDialogController;
    }

    public void setLoginDialogController(LoginDialogController loginDialogController) {
        this.loginDialogController = loginDialogController;
    }

    public LoginDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        labError.setVisible(false);
        labRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Registration...");
                String urlText = "http://www.tehnoslon.com.ua";
                try {
                    java.awt.Desktop.getDesktop().browse(URI.create(urlText));
                } catch (IOException e1) {
                    System.out.println("Не открывается сайт.");
                }
            }
        });
    }

    private void onOK() {
// add your code here
        System.out.println("OK is pressed.");
        // Проверка в контроллер // todo: DZ
//        loginDialogController.checkUserNameAndPassword(tfLogin,pfPassword); // можно так? хз
//        loginDialogController.checkUserNameAndPassword(tfLogin.getText(),pfPassword.getText());
        labError.setVisible(true);
        System.out.println(tfLogin.getText() + " " + pfPassword.getPassword()); // ! password будет скрыт
//        dispose();
        // if correct -> обратиться к контроллеру и попросить его переключать окна
    }

    private void onCancel() {
// add your code here if necessary
        System.out.println("Cancel is pressed");
        dispose();
    }

    public static void main(String[] args) {
        LoginDialog dialog = new LoginDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0); // убрать, чтобы
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
