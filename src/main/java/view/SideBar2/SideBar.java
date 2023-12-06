package view.SideBar2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import util.DropShadowCreator;
import util.RoundedPanel;
import util.UICreator;
import util.RoundedButton;

public class SideBar extends JPanel {

    private JButton overviewBtn;
    private JButton accountsBtn;
    private JButton paymentsBtn;
    private JButton billingBtn;
    private JButton lightBtn;
    private JButton darkBtn;

    private JPanel topPanel;
    private JPanel bottomPanel;

    public SideBar() {
        UIManager.put("Panel.background", Color.decode("#FFFFFF"));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(230, 100));

        JPanel container = new DropShadowCreator(0, 0, 0, 10);
        container.setLayout(new BorderLayout());
        container.setBackground(Color.GREEN);

        initTop();
        initBottom();

        this.add(container, BorderLayout.CENTER);
        container.add(topPanel, BorderLayout.NORTH);
        var center = new JPanel();
        center.setBackground(Color.decode("#FFFFFF"));
        container.add(center, BorderLayout.CENTER);
        container.add(bottomPanel, BorderLayout.SOUTH);

        UIManager.put("Panel.background", null);
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

    private JPanel wrapButtonWithPadding(JButton button) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#808080")));
        return panel;
    }

    private void initTop() {
        topPanel = new JPanel(new GridLayout(4, 1));

        overviewBtn = UICreator.createButton("Overview", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/homeblack.png", 28, 28));
        UICreator.configureTransparentButton(overviewBtn);
        configureButton(overviewBtn);
        accountsBtn = UICreator.createButton("Accounts", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/accounts.png", 28, 28));
        UICreator.configureTransparentButton(accountsBtn);
        configureButton(accountsBtn);
        paymentsBtn = UICreator.createButton("Payments History", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/history.png", 28, 28));
        UICreator.configureTransparentButton(paymentsBtn);
        configureButton(paymentsBtn);
        billingBtn = UICreator.createButton("Billing Tracker", 14, Font.BOLD, UICreator.createImage("/icons/sidebar/bill_track.png", 28, 28));
        UICreator.configureTransparentButton(billingBtn);
        configureButton(billingBtn);

        topPanel.add(wrapButtonWithPadding(overviewBtn));
        topPanel.add(wrapButtonWithPadding(accountsBtn));
        topPanel.add(wrapButtonWithPadding(paymentsBtn));
        topPanel.add(wrapButtonWithPadding(billingBtn));
    }

    private void initBottom() {
        bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 80));

        var container = new RoundedPanel(new BorderLayout(), 35, Color.BLACK);
        container.setPreferredSize(new Dimension(60, 20));
        container.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lightBtn = new RoundedButton(UICreator.createImage("/icons/sidebar/light.png", 15, 15), "Light");
        lightBtn.setPreferredSize(new Dimension(83, 35));
        lightBtn.setBackground(Color.WHITE);
        lightBtn.setFocusable(false);
        lightBtn.setBorderPainted(false);
        lightBtn.setBorder(null);
        lightBtn.setContentAreaFilled(false);

        darkBtn = new RoundedButton(UICreator.createImage("/icons/sidebar/dark.png", 30, 30), "Dark");
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
