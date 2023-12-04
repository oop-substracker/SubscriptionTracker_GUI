package view.AuthPage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

import util.DropShadowCreator;
import util.UICreator;
import controller.Controller;

public class Login extends JPanel {

    private JPanel leftSec;
    private JPanel rightSec;
    private JButton signBtn;


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

        JPanel container = new DropShadowCreator(5, 5, 5, 0);
        container.setLayout(new GridBagLayout());
        container.setBounds(80, 60, 320, 540);

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
//        leftSec.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "leftSide");
//        container.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "leftSide");


        /* DROP SHADOW  */
        Color shadowColor = Color.decode("#1c1d21");
        Insets shadowInsets = new Insets(6, 6, 6, 0);
        float shadowOpacity = 1.5f;
//        Border shadowBorder = new com.formdev.flatlaf.ui.FlatDropShadowBorder(shadowColor, shadowInsets, shadowOpacity);
//        container.setBorder(shadowBorder);


        leftSec.add(container);

        UIManager.put("Label.foreground", null);
    }

    private void initRightSec() {
        rightSec = new JPanel();
        rightSec.setPreferredSize(new Dimension(800, 100));
        rightSec.setLayout(null);

//        rightSec.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "rightSide");
        UIManager.put("TextField.placeholderForeground", Color.decode("#304D6D"));

        JPanel mainSection = new JPanel(new BorderLayout());
        mainSection.setBounds(0, 60,530,540);
        mainSection.setBackground(Color.decode("#BDD4E7"));

        JPanel tempCont = new DropShadowCreator(5, 0, 5, 5);
        tempCont.setLayout(new GridBagLayout());
        tempCont.setPreferredSize(new Dimension(100, 100));

        /* DROP SHADOW  */
        Color shadowColor = Color.decode("#a1b4c5");
        Insets shadowInsets = new Insets(6, 0, 6, 6);
        float shadowOpacity = 1.5f;
//        Border shadowBorder = new com.formdev.flatlaf.ui.FlatDropShadowBorder(shadowColor, shadowInsets, shadowOpacity);
//        mainSection.setBorder(shadowBorder);

        JPanel container = new JPanel(new GridBagLayout());
        container.setPreferredSize(new Dimension(350, 300));

        JLabel signLabel = UICreator.createLabel("Login", 30, Font.BOLD);

        JTextField email = UICreator.createTxtField("Username");
        email.setBackground(Color.decode("#C5F2BD"));
//        email.putClientProperty(com.formdev.flatlaf.FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        email.setMargin(new Insets(5, 20, 5, 5));

        JTextField password = UICreator.createTxtField("Password");
        password.setBackground(Color.decode("#C5F2BD"));
//        password.putClientProperty(com.formdev.flatlaf.FlatClientProperties.PLACEHOLDER_TEXT, "Password");
        password.setMargin(new Insets(5, 20, 5, 5));

        signBtn = UICreator.createButton("Sign In", 13, Font.PLAIN, null);
//        signBtn.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "" +
//                "font: bold 13;" +
//                "[light]foreground: #BDD4E7;" +
//                "[light]background: #212227;");

        signBtn.addActionListener(new Controller.AuthLoginListener(signBtn));

        String text = "<html><div style='text-align:center; '>Don't have and account?<br><span style='text-decoration:underline; color:#000000; '>Sign Up</span></div></html>";
        JLabel privacy = UICreator.createLabel(text, 13, Font.BOLD);

        UICreator.createComp(container, signLabel, 1, 0, 1, 1, 0.0, 0.1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0,120 , 0, 0, 0);
        UICreator.createComp(container, email, 0, 1, 4, 2, 0.4, 0.2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 20, 0, 0, 0, 0);
        UICreator.createComp(container, password, 0, 3, 4, 2, 0.4, 0.2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0, 0, 0);
        UICreator.createComp(container, signBtn, 1, 5, 1, 2, 0.0, 0.2, GridBagConstraints.WEST, GridBagConstraints.BOTH, 10, 80, 0, 0, 0);
        UICreator.createComp(container, privacy, 1, 7, 1, 1, 0.0, 0.2, GridBagConstraints.WEST, GridBagConstraints.BOTH, 10, 100, 0, 0, 0);

        UICreator.createComp(tempCont, container, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 0);
        mainSection.add(tempCont, BorderLayout.CENTER);
        UICreator.createComp(rightSec, mainSection, 0, 0, 1, 1, 0.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE,0,0 , 0, 0, 0);

        UIManager.put("Label.foreground", null);
    }
}
