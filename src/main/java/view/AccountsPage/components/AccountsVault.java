package view.AccountsPage.components;

import controller.Controller;
import model.Subscriptions.Subscription;
import util.RoundedPanel;
import util.RoundedPanelWithShadow;
import util.UICreator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class AccountsVault extends JPanel {

    public AccountsVault() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 30,30));
        this.setBorder(BorderFactory.createEmptyBorder(15, 0, 35, 0));
    }

    public void updateAccountsView(List<Subscription> subscriptionList) {
        removeAll();

        for (Subscription account : subscriptionList) {
            JPanel vault = new RoundedPanelWithShadow();
            vault.setBackground(Color.decode("#FFFFFF"));
            vault.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
            vault.setLayout(new BorderLayout());
            vault.setPreferredSize(new Dimension(250, 130));
            JLabel image = new JLabel(UICreator.createImage("/icons/assets/sporitfypremium.png", 250, 150));

            JLabel email = UICreator.createLabel(account.getEmail(), 13, Font.BOLD);
            email.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#AAB9CF")));
            email.setHorizontalAlignment(JLabel.CENTER);
            email.setBorder(BorderFactory.createCompoundBorder(email.getBorder(), new EmptyBorder(5, 5, 5, 5)));
//            email.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "myButton");

//            vault.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE_CLASS, "myRoundPanel");
            vault.add(image, BorderLayout.CENTER);
            vault.add(email, BorderLayout.SOUTH);

//            vault.addMouseListener(new Controller.CustomMouseListener(account));

            this.add(vault);

        }

        revalidate();
        repaint();
    }
}
