package view.AccountsPage.components;

import controller.Controller;
import model.Subscriptions.Subscription;
import util.RoundedPanelWithShadow;
import util.UICreator;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
/**
 * This class is responsible for displaying the accounts associated with a specific subscription.
 */
public class AccountsVault extends JPanel {

    /**
     * Constructs an instance of the AccountsVault class.
     * Sets the layout, border, and other properties for the panel.
     */
    public AccountsVault() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));
        this.setBorder(BorderFactory.createEmptyBorder(15, 0, 35, 0));
    }

    /**
     * Updates the view to display the accounts associated with the provided subscription list.
     *
     * @param subscriptionList The list of subscriptions containing the accounts to be displayed.
     */
    public void updateAccountsView(List<Subscription> subscriptionList) {
        removeAll();

        for (Subscription account : subscriptionList) {
            JPanel vault = new RoundedPanelWithShadow();

            vault.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
            vault.setLayout(new BorderLayout());
            vault.setPreferredSize(new Dimension(250, 130));
            JLabel image = new JLabel(UICreator.createImage("/images/posters/" + account.getPlatform() + ".png", 150, 150));

            JLabel email = UICreator.createLabel(account.getEmail(), 13, Font.BOLD);
            email.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#AAB9CF")));
            email.setHorizontalAlignment(JLabel.CENTER);
            email.setBorder(BorderFactory.createCompoundBorder(email.getBorder(), new EmptyBorder(5, 5, 5, 5)));

            vault.add(image, BorderLayout.CENTER);
            vault.add(email, BorderLayout.SOUTH);

            vault.addMouseListener(new Controller.CustomMouseListener(this, account));

            vault.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "" +
                    "arc:20;" +
                    "[light]background:#FFFFFF;" +
                    "[dark]background:#565656;");

            this.add(vault);
        }

        revalidate();
        repaint();
    }
}
