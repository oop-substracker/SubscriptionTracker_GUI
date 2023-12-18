package view.OverviewPage.sections.SubscriptionsView;

import javax.swing.*;
import java.awt.*;

import controller.Controller;
import util.UICreator;

public class SubsView extends JPanel {

    private JPanel topPanel;
    private JButton refreshBtn;
    private SubscriptionVault subscriptionVault;

    public SubsView() {
        this.setLayout(new BorderLayout());
        initTop();
        subscriptionVault = new SubscriptionVault();

        JScrollPane scrollPane = new JScrollPane(subscriptionVault);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.WHITE);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        this.setBorder(BorderFactory.createEmptyBorder(20, 0, 0 , 0));
    }

    private void initTop() {
        topPanel = new JPanel(new BorderLayout());

        var topLabel = UICreator.createLabel("Active Subscriptions", 20, Font.BOLD);

        var btnsPanel = new JPanel(new FlowLayout());
        refreshBtn = UICreator.createButton(false,"Refresh", 13, Font.PLAIN, UICreator.createImage("/icons/assets/create.png", 15, 15), 0, 0);
        refreshBtn.addActionListener(new Controller.AuthLoginListener(refreshBtn));
        btnsPanel.add(refreshBtn);

        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(btnsPanel, BorderLayout.EAST);
    }


    public SubscriptionVault getSubscriptionVault() {
        return subscriptionVault;
    }
}
