package view.AuthPage;

import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import util.DropShadowCreatorForAllSides;
import util.UICreator;
import controller.Controller;
import model.UserAccount.User;

/**
 * The Login class represents the login panel for user authentication.
 * Users can enter their username and password to sign in.
 * The class provides functionality for user login.
 */
public class Login extends JPanel {

    private JPanel leftSec;
    private JPanel rightSec;
    private JPanel container;
    private JPanel mainSection;
    private JButton signBtn;
    private JLabel gotoSignup;

    private JTextField email;
    private JTextField password;

    private JLabel errorLabel;

    public Login() {

        initLogin();
        initLeftSec();
        initRightSec();

        this.add(leftSec, BorderLayout.WEST);
        this.add(rightSec, BorderLayout.CENTER);

    }

    private void initLogin() {
        this.setSize(new Dimension(800, 700));
        this.setLayout(new BorderLayout());
    }

    private void initLeftSec() {
        leftSec = new JPanel();
        leftSec.setLayout(null);
        leftSec.setPreferredSize(new Dimension(400, 100));


        container = new DropShadowCreatorForAllSides(5, 5, 5, 5);
        container.setLayout(new GridBagLayout());
        container.setBounds(85, 60, 320, 540);

        ImageIcon icon = UICreator.createImage("/icons/assets/dash.png", 80, 80);
        var image = new JLabel(icon);
        UICreator.createComp(container, image, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 0, 0, 0);

        String text = "<html><div style='text-align:center; '>Subscription<br>Tracker</div></html>";
        JLabel label = UICreator.createLabel(text, 23, Font.BOLD);
        label.setForeground(Color.decode("#b0bec3"));
        UICreator.createComp(container, label, 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10, 0, 0, 0, 0);

        leftSec.setBackground(Color.decode("#212121"));
        container.setBackground(Color.decode("#212121"));

        leftSec.add(container);

    }

    private void initRightSec() {
        rightSec = new JPanel();
        rightSec.setPreferredSize(new Dimension(800, 100));
        rightSec.setBackground(Color.WHITE);
        rightSec.setLayout(null);

//        UIManager.put("TextField.placeholderForeground", Color.decode("#212121"));
        UIManager.put("TextField.foreground", Color.decode("#212121"));
        UIManager.put("PasswordField.foreground", Color.decode("#212121"));
        UIManager.put("Label.foreground", Color.decode("#212121"));

        mainSection = new JPanel(new BorderLayout());
        mainSection.setBounds(-10, 60,530,540);

        JPanel tempCont = new DropShadowCreatorForAllSides(5, 5, 5, 5);
        tempCont.setLayout(new GridBagLayout());
        tempCont.setPreferredSize(new Dimension(100, 100));

        JPanel container = new JPanel(new GridBagLayout());
        container.setPreferredSize(new Dimension(350, 300));
        container.setBackground(Color.WHITE);

        JLabel signLabel = UICreator.createLabel("Login", 30, Font.BOLD);
        signLabel.setForeground(Color.BLACK);

        email = UICreator.createTxtField("Username");
        email.setBackground(Color.decode("#C5F2BD"));
        email.setMargin(new Insets(5, 20, 5, 5));

        password = UICreator.createJPassword();
        password.setBackground(Color.decode("#C5F2BD"));
        password.setMargin(new Insets(5, 20, 5, 5));

        signBtn = UICreator.createButton(true, "Sign In", 13, Font.PLAIN, null, 50, 50);
        signBtn.setBorderPainted(false);

        signBtn.addActionListener(new Controller.AuthLoginListener(signBtn));
        signBtn.setBackground(Color.WHITE);
        signBtn.setForeground(Color.decode("#212121"));

        String text = "<html><div style='text-align:center; '>Don't have an account?<br><span style='text-decoration:underline; color:#000000; '>Sign Up</span></div></html>";
        gotoSignup = UICreator.createLabel(text, 13, Font.BOLD);
        gotoSignup.addMouseListener(new Controller.CustomMouseListener(gotoSignup, null));

        /* error message */
        errorLabel = UICreator.createLabel("Incorrect password!", 13, Font.PLAIN);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        UICreator.createComp(container, errorLabel, 1, -10, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0,0 , 0, 0, 120);
        UICreator.createComp(container, signLabel, 0, 0, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0,0 , 0, 0, 120);
        UICreator.createComp(container, email, 0, 1, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0, 0, 130);
        UICreator.createComp(container, password, 0, 2, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0, 0, 130);
        UICreator.createComp(container, signBtn, 0, 3, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10,0 , 0, 0, 130, 200);
        UICreator.createComp(container, gotoSignup, 0, 4, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 10, 80, 0, 0, 120);

        UICreator.createComp(tempCont, container, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 0);
        mainSection.add(tempCont, BorderLayout.CENTER);
        UICreator.createComp(rightSec, mainSection, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 0);

        UIManager.put("Label.foreground", null);
        UIManager.put("TextField.placeholderForeground", null);
        UIManager.put("PasswordField.foreground", null);
        UIManager.put("TextField.foreground", null);
    }

    public void clearFields() {
        email.setText("");
        password.setText("");
        errorLabel.setText("");
    }

    public JLabel getGotoSignup() {
        return gotoSignup;
    }

    public void setUser(User user) {
        user.setEmail(email.getText());
        user.setPassword(password.getText());
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }
}
