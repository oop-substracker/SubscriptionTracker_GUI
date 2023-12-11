package view.SideBar2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.*;

public class SideBar extends JPanel {

    private JButton overviewBtn;
    private JButton accountsBtn;
    private JButton paymentsBtn;
    private JButton billingBtn;
    private JButton lightBtn;
    private JButton darkBtn;

    private JButton foldBtn;

    private JPanel topPanel;
    private JPanel center;
    private JPanel bottomPanel;


    boolean fold = false;

    JPanel container;

    public SideBar() {
//        UIManager.put("Panel.background", Color.decode("#FFFFFF"));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(230, 100)); // 230

        var container = new DropShadowCreator(0, 0, 0, 10);
        container.setLayout(new BorderLayout());
        container.setBackground(Color.GREEN);

        initTop();
        initBottom();

        this.add(container, BorderLayout.CENTER);
        container.add(topPanel, BorderLayout.NORTH);
        center = new JPanel();
        center.setBackground(Color.decode("#FFFFFF"));
        container.add(center, BorderLayout.CENTER);
        container.add(bottomPanel, BorderLayout.SOUTH);

//        UIManager.put("Panel.background", null);
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
//        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#808080")));
        button.setMaximumSize(new Dimension(10, getHeight()));

        return panel;
    }

    private void adjustPadding() {
        overviewBtn.setBorder(BorderFactory.createEmptyBorder(0,30, 0,0));
        accountsBtn.setBorder(BorderFactory.createEmptyBorder(0,30, 0,0));
        paymentsBtn.setBorder(BorderFactory.createEmptyBorder(0,30, 0,0));
        billingBtn.setBorder(BorderFactory.createEmptyBorder(0,30, 0,0));
    }

    private void initTop() {
            topPanel = new JPanel();
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
            topPanel.setBackground(Color.WHITE);

            UIManager.put("Button.background", Color.WHITE);


            /* ================================== */

            JPanel logoPanel = new JPanel(new BorderLayout());
            logoPanel.setBackground(Color.WHITE);
            logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 5));
            JLabel label = UICreator.createLabelWithImage("ST", 20, Font.BOLD, "/icons/assets/logo.png", 60, 60);
            foldBtn = UICreator.createButton(false,"", 0, 0, UICreator.createImage("/icons/assets/left-arrow.png", 30,30), 0, 0);
            foldBtn.setMargin(new Insets(0, 0 , 0,0));
            foldBtn.setBorderPainted(false);
            foldBtn.setFocusable(false);

            logoPanel.add(label, BorderLayout.WEST);
            logoPanel.add(foldBtn, BorderLayout.EAST);

            //

            JPanel profilePanel = new RoundedPanel(15, true);
            profilePanel.setBackground(Color.WHITE);
            profilePanel.setBorder(null);
            profilePanel.setLayout(new BorderLayout());
            profilePanel.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 5));
            profilePanel.setMaximumSize(new Dimension(185, 70));


            String text = "<html><div style='text-align:center;'><span style='color:#969eab; font-size:9px;'>Manage</span><br>" + "Harvie" +"</div></html>";
            JLabel profLabel = UICreator.createLabelWithImage(text, 14, Font.BOLD, "/icons/assets/background-check.png", 47,47);
            JButton drop = new JButton(UICreator.createImage("/icons/assets/caret-down.png", 8, 8));
            drop.setMargin(new Insets(0, 0 , 0,0));
            drop.setBorderPainted(false);

            profilePanel.add(profLabel,  BorderLayout.WEST);
            profilePanel.add(drop, BorderLayout.EAST);

            /* ================================= */

            overviewBtn = UICreator.createButton(false,"Overview", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/homeblack.png", 28, 28), 0,0);
            UICreator.configureTransparentButton(overviewBtn);
            configureButton(overviewBtn);
            accountsBtn = UICreator.createButton(false,"Accounts", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/accounts.png", 28, 28), 0, 0);
            UICreator.configureTransparentButton(accountsBtn);
            configureButton(accountsBtn);
            paymentsBtn = UICreator.createButton(false,"Payments History", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/history.png", 28, 28), 0 ,0);
            UICreator.configureTransparentButton(paymentsBtn);
            configureButton(paymentsBtn);
            billingBtn = UICreator.createButton(false, "Billing Tracker", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/bill_track.png", 28, 28),0, 0);
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

            UIManager.put("Button.background", null);



            /* */
            foldBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    fold  =!fold;
                    if (fold) {
                        SideBar.this.setPreferredSize(new Dimension(100, 100)); // 230
                        logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, -5));
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

                        darkBtn.setVisible(false);
                        lightBtn.setPreferredSize(new Dimension(35, 35));
                        lightBtn.setText("");
                        container.setPreferredSize(new Dimension(35, 20));
                        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));

                    } else {
                        SideBar.this.setPreferredSize(new Dimension(230, 100)); // 230
                        logoPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 5));
                        overviewBtn.setText("Overview");
                        accountsBtn.setText("Accounts");
                        paymentsBtn.setText("Payments History ");
                        billingBtn.setText("Billing Tracker");
                        UICreator.iconChanger(foldBtn, "/icons/assets/left-arrow.png",30, 30);
                        label.setText("ST");
                        profLabel.setText(text);
                        drop.setVisible(true);
                        profilePanel.setMaximumSize(new Dimension(185, 70));

                        darkBtn.setVisible(true);
                        lightBtn.setPreferredSize(new Dimension(83, 55));
                        lightBtn.setText("Light");
                        container.setPreferredSize(new Dimension(60, 20));
                        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

                    }
                }
            });

    }



    private void initBottom() {
        bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 80));
        bottomPanel.setBackground(Color.WHITE);

        container = new RoundedPanel(new BorderLayout(), 40, Color.BLACK, false);
        container.setBackground(Color.WHITE);
        container.setPreferredSize(new Dimension(60, 20));
        container.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lightBtn = new RoundedButton(UICreator.createImage("/icons/sidebar/light.png", 15, 15), "Light", 30, 30);
        lightBtn.setPreferredSize(new Dimension(83, 35));
        lightBtn.setBackground(Color.WHITE);
        lightBtn.setFocusable(false);
        lightBtn.setBorderPainted(false);
        lightBtn.setBorder(null);
        lightBtn.setContentAreaFilled(false);

        darkBtn = new RoundedButton(UICreator.createImage("/icons/sidebar/dark.png", 30, 30), "Dark", 30 ,30);
        darkBtn.setPreferredSize(new Dimension(83, 35));
        darkBtn.setForeground(Color.BLACK);
        darkBtn.setBackground(Color.BLACK);

        darkBtn.setFocusable(false);
        darkBtn.setBorderPainted(false);
        darkBtn.setBorder(null);
        darkBtn.setContentAreaFilled(false);
        darkBtn.setFocusPainted(false);

        darkBtn.setLayout(new BorderLayout());


        var panelInside = new JPanel(new BorderLayout());
        panelInside.setPreferredSize(new Dimension(30, 30));
        JLabel label = UICreator.createLabelWithImage("Dark", 13, Font.PLAIN, "/icons/sidebar/dark.png", 30, 30);
        label.setForeground(Color.WHITE);
        panelInside.add(label, BorderLayout.CENTER);
        panelInside.setBackground(Color.BLACK);
        darkBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        darkBtn.add(panelInside, BorderLayout.CENTER);

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

}
