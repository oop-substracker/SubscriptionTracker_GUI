package view.AuthPage;

import javax.swing.*;
import java.awt.*;
import model.UserAccount.User;
import util.DropShadowCreatorForAllSides;
import util.UICreator;
import controller.Controller;

public class Login extends JPanel {

    private JPanel leftSec;
    private JPanel rightSec;
    private JButton signBtn;

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

        UIManager.put("Label.foreground", Color.decode("#b0bec3"));

        JPanel container = new DropShadowCreatorForAllSides(5, 5, 5, 5);
        container.setLayout(new GridBagLayout());
        container.setBounds(85, 60, 320, 540);

        ImageIcon icon = UICreator.createImage("/icons/assets/dash.png", 80, 80);
        var image = new JLabel(icon);
        UICreator.createComp(container, image, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 0, 0, 0);

        String text = "<html><div style='text-align:center; '>Subscription<br>Tracker</div></html>";
        JLabel label = UICreator.createLabel(text, 23, Font.BOLD);
        UICreator.createComp(container, label, 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10, 0, 0, 0, 0);

        String text1 = "<html><div style='text-align:center; '>Already have an account? <span style='text-decoration:underline;'>Sign In</span></div></html>";
        var leftDownLabel = UICreator.createLabel(text1, 13, Font.BOLD);
        UICreator.createComp(container, leftDownLabel, 0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10, 0, 0, 0, 0);

        leftSec.setBackground(Color.decode("#212121"));
        container.setBackground(Color.decode("#212121"));

        leftSec.add(container);

        UIManager.put("Label.foreground", null);
    }

    private void initRightSec() {
        rightSec = new JPanel();
        rightSec.setPreferredSize(new Dimension(800, 100));
        rightSec.setLayout(null);

        UIManager.put("TextField.placeholderForeground", Color.decode("#304D6D"));

        JPanel mainSection = new JPanel(new BorderLayout());
        mainSection.setBounds(-10, 60,530,540);
        mainSection.setBackground(Color.decode("#BDD4E7"));

        JPanel tempCont = new DropShadowCreatorForAllSides(5, 5, 5, 5);
        tempCont.setLayout(new GridBagLayout());
        tempCont.setPreferredSize(new Dimension(100, 100));

        JPanel container = new JPanel(new GridBagLayout());
        container.setPreferredSize(new Dimension(350, 300));

        JLabel signLabel = UICreator.createLabel("Login", 30, Font.BOLD);

        email = UICreator.createTxtField("Username");
        email.setBackground(Color.decode("#C5F2BD"));
        email.setMargin(new Insets(5, 20, 5, 5));

        password = UICreator.createTxtField("Password");
        password.setBackground(Color.decode("#C5F2BD"));
        password.setMargin(new Insets(5, 20, 5, 5));

        signBtn = UICreator.createButton(true, "Sign In", 13, Font.PLAIN, null, 50, 50);
        signBtn.setBorderPainted(false);

        signBtn.addActionListener(new Controller.AuthLoginListener(signBtn));

        String text = "<html><div style='text-align:center; '>Don't have and account?<br><span style='text-decoration:underline; color:#000000; '>Sign Up</span></div></html>";
        JLabel privacy = UICreator.createLabel(text, 13, Font.BOLD);

        /* error message */
        errorLabel = UICreator.createLabel("Incorrect password!", 13, Font.PLAIN);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        UICreator.createComp(container, errorLabel, 1, -10, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0,0 , 0, 0, 120);
        UICreator.createComp(container, signLabel, 0, 0, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0,0 , 0, 0, 120);
        UICreator.createComp(container, email, 0, 1, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0, 0, 130);
        UICreator.createComp(container, password, 0, 2, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0, 0, 130);
        UICreator.createComp(container, signBtn, 0, 3, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10,0 , 0, 0, 130, 200);
        UICreator.createComp(container, privacy, 0, 4, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 10, 80, 0, 0, 120);

        UICreator.createComp(tempCont, container, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 0);
        mainSection.add(tempCont, BorderLayout.CENTER);
        UICreator.createComp(rightSec, mainSection, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 0);

        UIManager.put("Label.foreground", null);
    }

    public void setUser(User user) {
        user.setEmail(email.getText());
        user.setPassword(password.getText());
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }
}
