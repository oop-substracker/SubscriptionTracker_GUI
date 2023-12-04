package view.SideBar;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import util.DropShadowCreator;
import util.UICreator;

public class SideBar extends JPanel {

    private JButton homeBtn;
    private JButton accountsBtn;
    private JButton paymentsBtn;
    private JButton summaryBtn;
    private JButton settingsBtn;
    private JButton exitBtn;

    private JPanel topPanel;
    private JPanel bottomPanel;


    public SideBar() {
        this.setPreferredSize(new Dimension(230, 100));
        this.setLayout(new BorderLayout());
        Color color = UIManager.getColor("MainDisplay.SideBar.background");

        JPanel container = new DropShadowCreator(0, 0, 0, 10);
        container.setLayout(new BorderLayout());

        initTopLinks();
        initBottomLinks();

        container.add(topPanel, BorderLayout.NORTH);
        var tempPanel = new JPanel();
        tempPanel.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");
        container.add(tempPanel, BorderLayout.CENTER);
        container.add(bottomPanel, BorderLayout.SOUTH);

        this.add(container, BorderLayout.CENTER);

    }

    public void homeBtnNavigateListener(ActionListener listener) {
        homeBtn.addActionListener(listener);
    }

    public void accountsBtnNavigateListener(ActionListener listener) {
        accountsBtn.addActionListener(listener);
    }

    public void paymentsBtnNavigateListener(ActionListener listener) {
        paymentsBtn.addActionListener(listener);
    }

    private void initTopLinks() {
        topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 18, 0, 0));

        homeBtn = UICreator.createButton("", UICreator.createImage("/icons/assets/dash.png", 25, 25));
        homeBtn.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");
        accountsBtn = UICreator.createButton("", UICreator.createImage("/icons/assets/profilewhite.png", 25, 25));
        accountsBtn.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");
        paymentsBtn = UICreator.createButton("", UICreator.createImage("/icons/assets/transactionhistory.png", 25, 25));
        paymentsBtn.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");
        summaryBtn = UICreator.createButton("", UICreator.createImage("/icons/assets/summary.png", 25, 25));
        summaryBtn.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");

        Box boxLayout = Box.createVerticalBox();

        boxLayout.add(Box.createVerticalStrut(7));
        boxLayout.add(homeBtn);
        boxLayout.add(Box.createVerticalStrut(10));
        boxLayout.add(accountsBtn);
        boxLayout.add(Box.createVerticalStrut(10));
        boxLayout.add(paymentsBtn);
        boxLayout.add(Box.createVerticalStrut(10));
        boxLayout.add(summaryBtn);
        topPanel.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");

        topPanel.add(boxLayout, BorderLayout.CENTER);
    }

    private void initBottomLinks() {
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 19, 0, 0));

        settingsBtn = UICreator.createButton("", UICreator.createImage("/icons/assets/settings.png", 25, 25));
        settingsBtn.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");
        exitBtn = UICreator.createButton("", UICreator.createImage("/icons/assets/logout.png", 25, 25));
        exitBtn.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");

        Box boxLayout = Box.createVerticalBox();
        boxLayout.add(settingsBtn);
        boxLayout.add(Box.createVerticalStrut(10));
        boxLayout.add(exitBtn);
        boxLayout.add(Box.createVerticalStrut(10));
        bottomPanel.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "MyBackground");

        bottomPanel.add(boxLayout, BorderLayout.CENTER);
    }
}
