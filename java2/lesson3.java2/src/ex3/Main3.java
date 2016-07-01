package ex3;

import ex3.controller.LoginDialogController;
import ex3.view.LoginDialog;

/**
 * Created by Steve on 24.06.2016.
 */
public class Main3 {
    public static void main(String[] args) {
        LoginDialogController controller = new LoginDialogController();
        LoginDialog dialog = new LoginDialog();
        dialog.setLoginDialogController(controller);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0); // убрать, чтобы
    }
}
