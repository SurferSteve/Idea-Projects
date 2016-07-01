package ex3.controller;

import ex3.view.LoginDialog;

import javax.swing.*;

/**
 * Created by Steve on 24.06.2016.
 */
public class LoginDialogController {
    private LoginDialog loginDialog;

    public LoginDialog getLoginDialog() {
        return loginDialog;
    }

    public void setLoginDialog(LoginDialog loginDialog) {
        this.loginDialog = loginDialog;
    }

    //    public boolean checkUserNameAndPassword(JTextField login, JPasswordField password) { // если можно так
    public boolean checkUserNameAndPassword(String login, String password) { // если можно так
        return false; // todo: доделать проверку синхронно
    }

}
