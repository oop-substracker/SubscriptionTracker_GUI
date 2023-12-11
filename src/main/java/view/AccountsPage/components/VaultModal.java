package view.AccountsPage.components;

import java.awt.*;
import javax.swing.*;
import model.Subscriptions.Subscription;
import util.RoundedPanel;
import util.UICreator;

public class VaultModal extends JDialog {

    private JLabel image;
    private JLabel status;
    private JLabel email;
    private JLabel password;
    private JLabel remainingTime;
    private JLabel cost;
    private JButton closeBtn;
    private Subscription subscription;

    public VaultModal(Component parent, Subscription subscription) {
        super((Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent), "Vault Modal", true);
        this.setLayout(new BorderLayout());
        this.subscription = subscription;
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        setLayout(new BorderLayout());
        initDetails();
    }


    private void initDetails() {
        JPanel container = new RoundedPanel(new GridBagLayout(), 20, Color.WHITE, false);
        container.setPreferredSize(new Dimension(355, 360));

        closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());

        ImageIcon icon = UICreator.createImage("/icons/assets/sporitfypremium.png", 250, 150);
        image = new JLabel(icon);
        image.setBorder(BorderFactory.createEmptyBorder(-10, 0, 0, 0));
        image.setHorizontalAlignment(JLabel.CENTER);

        status = UICreator.createLabel("Active", 30, Font.BOLD);
        status.setHorizontalAlignment(JLabel.CENTER);

        email = UICreator.createLabel(subscription.getEmail(), 15, Font.PLAIN);
        email.setHorizontalAlignment(JLabel.CENTER);
        email.setSize(new Dimension(350, getHeight()));

        password = UICreator.createLabel("*********", 16, Font.PLAIN);
        password.setHorizontalAlignment(JLabel.CENTER);

        String text = "<html><div style='text-align:center; font-size:11px;' >Time remaining:<br style='font-weight:bold;  '><span style='font-size:13px;' >" + subscription.getDueDate() +"</span></div></html>";
        remainingTime = UICreator.createLabel(text, 13, Font.PLAIN);
        remainingTime.setHorizontalAlignment(JLabel.CENTER);

        String text1 =  "<html><div style='text-align:center; font-size:11px; ' >To Pay:<br><span style='font-size:13px;' >$" + subscription.getBilling().getCost() +"</span></div></html>";
        cost =  UICreator.createLabel(text1, 13, Font.PLAIN);
        cost.setHorizontalAlignment(JLabel.CENTER);

        UICreator.createComp(container, closeBtn, 0, 0, 1, 1, 1, 0.1, GridBagConstraints.EAST, GridBagConstraints.NONE, -70, 0, 0,10, 0);
        UICreator.createComp(container, image, 0, 0, 1, 1, 1, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 20, 0, -40,0, 0);
        UICreator.createComp(container, status, 0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 5, 0, -30,0, 0);
        UICreator.createComp(container, email, 0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 0, 0,0, 0);
        UICreator.createComp(container, password, 0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, -20, 0, 0,0, 0);
        UICreator.createComp(container, remainingTime, 0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 0,0, 0);
        UICreator.createComp(container, cost, 0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 0,0, 0);

        this.add(container,BorderLayout.CENTER);

    }
}
