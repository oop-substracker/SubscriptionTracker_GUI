package view.AuthPage;

import javax.swing.*;
import java.awt.*;
import util.DropShadowCreatorForAllSides;
import util.UICreator;
import controller.Controller;
import model.UserAccount.User;


public class Register extends JPanel {

    private JPanel leftSec;
    private JPanel rightSec;

    // input fields
    private JTextField fName;
    private JTextField lName;
    private JTextField email;
    private JTextField password;

    private JButton registerBtn;

    public Register() {

        initLogin();
        initRightSec();
        initLeftSec();

        this.add(leftSec, BorderLayout.CENTER);
        this.add(rightSec, BorderLayout.WEST);

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
        container.setBounds(-2, 60, 320, 540);

        ImageIcon icon = UICreator.createImage("/icons/assets/dash.png", 80, 80);
        var image = new JLabel(icon);
        UICreator.createComp(container, image, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 0, 0, 0);

        String text = "<html><div style='text-align:center; '>Subscription<br>Tracker</div></html>";
        JLabel label = UICreator.createLabel(text, 23, Font.BOLD);
//        label.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "leftSide");
        UICreator.createComp(container, label, 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10, 0, 0, 0, 0);

        String text1 = "<html><div style='text-align:center; '>Already have an account? <span style='text-decoration:underline;'>Sign In</span></div></html>";
        var leftDownLabel = UICreator.createLabel(text1, 13, Font.BOLD);
//        leftDownLabel.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "leftSide");
        UICreator.createComp(container, leftDownLabel, 0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10, 0, 0, 0, 0);

        leftSec.setBackground(Color.decode("#212121"));
        container.setBackground(Color.decode("#212121"));
        container.setForeground(Color.decode("#b0bec3"));
//        leftSec.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "leftSide");
//        container.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "leftSide");


        /* DROP SHADOW  */
        Color shadowColor = Color.decode("#1c1d21");
        Insets shadowInsets = new Insets(6, 0, 6, 6);
        float shadowOpacity = 1.5f;
//        Border shadowBorder = new com.formdev.flatlaf.ui.FlatDropShadowBorder(shadowColor, shadowInsets, shadowOpacity);
//        container.setBorder(shadowBorder);


        leftSec.add(container);

        UIManager.put("Label.foreground", null);
    }

    private void initRightSec() {
        rightSec = new JPanel();
        rightSec.setPreferredSize(new Dimension(600, 100));
        rightSec.setLayout(null);

        UIManager.put("TextField.placeholderForeground", Color.decode("#304D6D"));

        JPanel mainSection = new JPanel(new BorderLayout());
        mainSection.setBounds(90, 60,530,540);

        JPanel tempCont = new DropShadowCreatorForAllSides(5, 5, 5, 5);
        tempCont.setLayout(new GridBagLayout());
        tempCont.setPreferredSize(new Dimension(100, 100));

        JPanel container = new JPanel(new GridBagLayout());
        container.setPreferredSize(new Dimension(350, 300));

        JLabel signLabel = UICreator.createLabel("Create Account", 30, Font.BOLD);

        fName = UICreator.createTxtField("First Name");
        fName.setBackground(Color.decode("#C5F2BD"));
        fName.setMargin(new Insets(5, 20, 5, 5));

        lName = UICreator.createTxtField("Last Name");
        lName.setBackground(Color.decode("#C5F2BD"));
        lName.setMargin(new Insets(5, 20, 5, 5));

        email = UICreator.createTxtField("Email");
        email.setBackground(Color.decode("#C5F2BD"));
        email.setMargin(new Insets(5, 20, 5, 5));

        password = UICreator.createTxtField("Password");
        password.setBackground(Color.decode("#C5F2BD"));

        password.setMargin(new Insets(5, 20, 5, 5));

        registerBtn = UICreator.createButton(true,"Create Account", 13, Font.PLAIN, null, 50, 50);
        registerBtn.setMargin(new Insets(1, 8, 1, 8));
        registerBtn.setBorderPainted(false);

        String text = "<html><div style='text-align:center; '>Already have an account?<br><span style='text-decoration:underline; color:#000000; '>Sign In</span></div></html>";
        JLabel privacy = UICreator.createLabel(text, 13, Font.BOLD);
        privacy.addMouseListener(new Controller.CustomMouseListener(privacy, null));

        UICreator.createComp(container, signLabel, 1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0,0 , 0, 0, 120);
        UICreator.createComp(container, fName, 0, 1, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10,0 , 0, 0, 120);
        UICreator.createComp(container, lName, 0, 2, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10,0 , 0, 0, 120);
        UICreator.createComp(container, email, 0, 3, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0, 0, 120);
        UICreator.createComp(container, password, 0, 4, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0, 0, 120);
        UICreator.createComp(container, registerBtn, 1, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 10, 0, 0, 0, 120);
        UICreator.createComp(container, privacy, 1, 6, 2, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 10,75, 0, 0, 120);

        UICreator.createComp(tempCont, container, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 120);
        mainSection.add(tempCont, BorderLayout.CENTER);
        UICreator.createComp(rightSec, mainSection, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 120);

        UIManager.put("Label.foreground", null);

        /* REGISTER  */
        registerBtn.addActionListener(new Controller.AuthLoginListener(registerBtn));
    }

    public void setUser(User user) {
        user.setEmail(email.getText());
        user.setPassword(password.getText());
    }

}
