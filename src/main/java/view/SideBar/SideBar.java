package view.SideBar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.SwingConstants;
import controller.Controller;
import util.DropShadowCreator;
import util.UICreator;
import util.RoundedPanel;
import util.RoundedButtonWithBorder;
import javax.swing.BoxLayout;

public class SideBar extends JPanel {

    private JButton overviewBtn;
    private JButton accountsBtn;
    private JButton paymentsBtn;
    private JButton billingBtn;
    private JButton lightBtn;
    private JButton  darkBtn;
    private JLabel profLabel;
    private JButton foldBtn;

    private JPanel topPanel;
    private JPanel center;
    private JPanel bottomPanel;
    boolean fold = false;
    JPanel container;

    public SideBar() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(230, 100)); // 230

        var container = new DropShadowCreator(0, 0, 0, 10);
        container.setLayout(new BorderLayout());

        initTop();
        initBottom();

        this.add(container, BorderLayout.CENTER);
        container.add(topPanel, BorderLayout.NORTH);
        center = new JPanel();
        container.add(center, BorderLayout.CENTER);
        container.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void overviewBtnNavigateListener(ActionListener listener) {
        overviewBtn.addActionListener(listener);
    }

    public void accountsBtnNavigateListener(ActionListener listener) {
        accountsBtn.addActionListener(listener);
    }

    public void paymentsBtnNavigateListener(ActionListener listener) {
        paymentsBtn.addActionListener(listener);
    }

    public void billingBtnNavigateListener(ActionListener listener) {
        billingBtn.addActionListener(listener);
    }

    private JPanel wrapButtonWithPadding(Component button) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(getWidth(), 45));
        panel.add(button, BorderLayout.CENTER);
        button.setMaximumSize(new Dimension(10, getHeight()));

        return panel;
    }

    private void adjustPadding() {
        overviewBtn.setHorizontalAlignment(SwingConstants.CENTER);
        overviewBtn.setMargin(new Insets(0, 0, 0, 1));
        overviewBtn.setVerticalAlignment(SwingConstants.CENTER);
        accountsBtn.setMargin(new Insets(0, 0, 0, 1));
        accountsBtn.setHorizontalAlignment(SwingConstants.CENTER);
        accountsBtn.setVerticalAlignment(SwingConstants.CENTER);
        paymentsBtn.setMargin(new Insets(0, 0, 0, 1));
        paymentsBtn.setHorizontalAlignment(SwingConstants.CENTER);
        paymentsBtn.setVerticalAlignment(SwingConstants.CENTER);
        billingBtn.setMargin(new Insets(0, 0, 0, 1));
        billingBtn.setHorizontalAlignment(SwingConstants.CENTER);
        billingBtn.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void reset() {
        overviewBtn.setHorizontalAlignment(SwingConstants.LEFT);
        overviewBtn.setMargin(new Insets(10, 20, 10, 10));
        overviewBtn.setVerticalTextPosition(SwingConstants.CENTER);
        accountsBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accountsBtn.setMargin(new Insets(10, 20, 10, 10));
        accountsBtn.setVerticalTextPosition(SwingConstants.CENTER);
        paymentsBtn.setHorizontalAlignment(SwingConstants.LEFT);
        paymentsBtn.setMargin(new Insets(10, 20, 10, 10));
        paymentsBtn.setVerticalTextPosition(SwingConstants.CENTER);
        billingBtn.setHorizontalAlignment(SwingConstants.LEFT);
        billingBtn.setMargin(new Insets(10, 20, 10, 10));
        billingBtn.setVerticalTextPosition(SwingConstants.CENTER);
    }

    private void initTop() {
            topPanel = new JPanel();
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
            topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            /* ================================== */

            JPanel logoPanel = new JPanel(new BorderLayout());
            logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            JLabel label = UICreator.createLabelWithImage("ST", 20, Font.BOLD, "/icons/assets/logo-2.png", 60, 60);
            label.setFont(UICreator.getLogoFont().deriveFont(40f));
            foldBtn = UICreator.createButton(false,"", 0, 0, UICreator.createImage("/icons/assets/left-arrow.png", 30,30), 0, 0);
            foldBtn.setMargin(new Insets(0, 0 , 0,0));
            foldBtn.setBorderPainted(false);
            foldBtn.setFocusable(false);

            logoPanel.add(label, BorderLayout.WEST);
            logoPanel.add(foldBtn, BorderLayout.EAST);


            JPanel profilePanel = new RoundedPanel(15, true);
            profilePanel.setBorder(null);
            profilePanel.setLayout(new BorderLayout());
            profilePanel.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 5));
            profilePanel.setMaximumSize(new Dimension(185, 70));

            profLabel = UICreator.createLabelWithImage("", 14, Font.BOLD, "/icons/assets/background-check.png", 47,47);
            JButton drop = new JButton(UICreator.createImage("/icons/assets/caret-down.png", 8, 8));
            drop.setMargin(new Insets(0, 0 , 0,0));
            drop.setBorderPainted(false);

            profilePanel.add(profLabel,  BorderLayout.WEST);
            profilePanel.add(drop, BorderLayout.EAST);

            /* ================================= */


            overviewBtn = UICreator.createButton(false,"Overview", 11, Font.PLAIN, UICreator.createImage("/icons/sidebar/Overview1.png", 30, 30), 20,20);
            UICreator.configureTransparentButton(overviewBtn);
            configureButton(overviewBtn);
            accountsBtn = UICreator.createButton(false,"Accounts", 11, Font.PLAIN, UICreator.createImage("/icons/sidebar/Accounts1.png", 30, 30), 20, 20);
            UICreator.configureTransparentButton(accountsBtn);
            configureButton(accountsBtn);
            paymentsBtn = UICreator.createButton(false,"Payment History", 11, Font.PLAIN, UICreator.createImage("/icons/sidebar/PayHistory1.png", 30, 30), 20 ,20);
            UICreator.configureTransparentButton(paymentsBtn);
            configureButton(paymentsBtn);
            billingBtn = UICreator.createButton(false, "Billing Tracker", 11, Font.PLAIN, UICreator.createImage("/icons/sidebar/Billing1.png", 30, 30),20, 20);
            UICreator.configureTransparentButton(billingBtn);
            configureButton(billingBtn);


            topPanel.add(logoPanel);
            topPanel.add(Box.createVerticalStrut(20));
            topPanel.add(profilePanel);
            topPanel.add(Box.createVerticalStrut(10));
            topPanel.add(wrapButtonWithPadding(overviewBtn));
            topPanel.add(wrapButtonWithPadding(accountsBtn));
            topPanel.add(wrapButtonWithPadding(paymentsBtn));
            topPanel.add(wrapButtonWithPadding(billingBtn));


            /* */
            foldBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    fold  =!fold;
                    if (fold) {
                        SideBar.this.setPreferredSize(new Dimension(100, 100)); // 230
                        logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, -5));
                        overviewBtn.setText("");
                        accountsBtn.setText("");
                        paymentsBtn.setText("");
                        billingBtn.setText("");
                        adjustPadding();
                        UICreator.iconChanger(foldBtn, "/icons/assets/right-arrow.png",30, 30);
                        label.setText("");
                        profLabel.setText("");
                        drop.setVisible(false);
                        profilePanel.setMaximumSize(new Dimension(60, 70));
                        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 13));
//
                        foldBtn.setVisible(false);

                        darkBtn.setVisible(false);
                        lightBtn.setPreferredSize(new Dimension(35, 35));
                        lightBtn.setText("");
                        lightBtn.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 0));
                        container.setPreferredSize(new Dimension(35, 20));
                        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));

                    } else {
                        SideBar.this.setPreferredSize(new Dimension(230, 100)); // 230
                        logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 5));
                        overviewBtn.setText("Overview");
                        accountsBtn.setText("Accounts");
                        paymentsBtn.setText("Payments History ");
                        billingBtn.setText("Billing Tracker");
                        UICreator.iconChanger(foldBtn, "/icons/assets/left-arrow.png",30, 30);
                        label.setText("ST");
                        profLabel.setText(profLabel.getText());
                        drop.setVisible(true);
                        profilePanel.setMaximumSize(new Dimension(185, 70));

                        darkBtn.setVisible(true);
                        lightBtn.setPreferredSize(new Dimension(83, 55));
                        lightBtn.setText("Light");
                        container.setPreferredSize(new Dimension(60, 20));
                        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                        reset();

                        foldBtn.setVisible(true);

                    }
                }
            });

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (fold) {
                    SideBar.this.setPreferredSize(new Dimension(230, 100)); // 230
//                    logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
                    overviewBtn.setText("Overview");
                    accountsBtn.setText("Accounts");
                    paymentsBtn.setText("Payments History ");
                    billingBtn.setText("Billing Tracker");
                    UICreator.iconChanger(foldBtn, "/icons/assets/left-arrow.png", 30, 30);
                    label.setText("ST");

                    String[] userName = Controller.getUser().getEmail().split("@");
                    profLabel.setText("<html><div style='text-align:left;'><span font-size:9px;'>User</span><br>" + "@" + userName[0] + "</div></html>");

                    drop.setVisible(true);
                    profilePanel.setMaximumSize(new Dimension(185, 70));

                    darkBtn.setVisible(true);
                    lightBtn.setPreferredSize(new Dimension(83, 55));
                    lightBtn.setText("Light");
                    container.setPreferredSize(new Dimension(60, 20));
                    bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                    topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 10));
                    reset();

                    foldBtn.setVisible(true);
                    SideBar.this.setPreferredSize(new Dimension(230, 100)); // 230
                    logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    overviewBtn.setText("Overview");
                    accountsBtn.setText("Accounts");
                    paymentsBtn.setText("Payments History ");
                    billingBtn.setText("Billing Tracker");
                    UICreator.iconChanger(foldBtn, "/icons/assets/left-arrow.png", 30, 30);
                    label.setText("ST");
                    profLabel.setText(profLabel.getText());
                    drop.setVisible(true);
                    profilePanel.setMaximumSize(new Dimension(185, 70));

                    darkBtn.setVisible(true);
                    lightBtn.setPreferredSize(new Dimension(83, 55));
                    lightBtn.setText("Light");
                    container.setPreferredSize(new Dimension(60, 20));
                    bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                    topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    reset();

                    foldBtn.setVisible(true);
                    fold = !fold;
                }

            }
        });

    }

    private void initBottom() {
        bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 80));

        container = new RoundedPanel(new BorderLayout(), 40, Color.decode("#1e1e1e"), false);  //#172030 // #1e1e1e
        container.setPreferredSize(new Dimension(60, 20));
        container.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lightBtn = new RoundedButtonWithBorder(UICreator.createImage("/icons/sidebar/brightness.png", 20, 20), "Light", 30, 30);
        lightBtn.setPreferredSize(new Dimension(83, 35));
        lightBtn.setHorizontalAlignment(SwingConstants.CENTER);
        lightBtn.setVerticalAlignment(SwingConstants.CENTER);
        lightBtn.addMouseListener(new Controller.ThemeManager());
        lightBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
//        lightBtn.setBackground(Color.decode("#074855"));
       lightBtn.setBackground(Color.decode("#565656"));
        lightBtn.setForeground(Color.WHITE);


        darkBtn = new RoundedButtonWithBorder(UICreator.createImage("/icons/sidebar/dark.png", 35, 35), "Dark", 30 ,30);
        darkBtn.setPreferredSize(new Dimension(83, 35));
        darkBtn.addMouseListener(new Controller.ThemeManager());
        darkBtn.setForeground(Color.WHITE);
        darkBtn.setHorizontalAlignment(SwingConstants.CENTER);
        darkBtn.setVerticalAlignment(SwingConstants.CENTER);
//        darkBtn.setBackground(Color.decode("#172030"));
        darkBtn.setBackground(Color.decode("#1e1e1e"));

        darkBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
//        darkBtn.setBackground(Color.BLACK);
//        darkBtn.setForeground(Color.WHITE);

        container.add(lightBtn, BorderLayout.WEST);
        container.add(darkBtn, BorderLayout.EAST);

        UICreator.createComp(bottomPanel, container, 0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 20, 0, 20, 20);
    }

    private void configureButton(JButton button) {
        button.setBorderPainted(false);
        button.setIconTextGap(10);
        button.setMargin(new Insets(10, 20, 10, 10));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setVerticalTextPosition(SwingConstants.CENTER);

    }

    public JButton getLightBtn() {
        return lightBtn;
    }

    public JButton getDarkBtn() {
        return darkBtn;
    }

    public JLabel getProfLabel() {
        return profLabel;
    }
}
