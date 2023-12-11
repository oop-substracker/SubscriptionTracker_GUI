package view.BillingPage;

import javax.swing.*;
import java.awt.*;

import model.Subscriptions.Subscription;
import java.util.List;
import util.MaterialTabbedPane;
import util.UICreator;
import util.RoundedPanel;

public class BillingPage extends JPanel {

    private JLabel title;
    private MaterialTabbedPane tabbedPane;

    JPanel container;

    public BillingPage() {
        init();
        initTabHeader();

        this.add(title, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
    }

    public void updateTabbedPaneData(List<Subscription> subscriptionList) {

        JPanel infoContainer = new JPanel();
        infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));
        infoContainer.add(Box.createVerticalStrut(10));

        for (Subscription subscription : subscriptionList) {
            /* platform shits */
            JPanel panel = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10,Color.WHITE, false);
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

            UIManager.put("Label.foreground", Color.BLACK);

            JLabel platform = UICreator.createLabel(subscription.getPlatform(), 14, Font.PLAIN);
            JLabel billing = UICreator.createLabel(subscription.getBilling().getBillingPeriod().toString(), 14, Font.PLAIN);
            JLabel amount = UICreator.createLabel("$" + subscription.getBilling().getCost(), 14, Font.PLAIN);
            JLabel timeRemaining = UICreator.createLabel(subscription.getTimeRemaining(), 14, Font.PLAIN);
            JLabel nextPayment = UICreator.createLabel("December 12, 3032", 14, Font.PLAIN);
            JLabel monthlyCost = UICreator.createLabel("$" + Double.toString(subscription.getBilling().getMonthlyCost()), 14, Font.PLAIN);
            JLabel yearlyCost = UICreator.createLabel("$" + Double.toString(subscription.getBilling().getYearlyCost()), 14, Font.PLAIN);
            JLabel status = UICreator.createLabel("Active", 14, Font.PLAIN);

            platform.setHorizontalAlignment(SwingConstants.CENTER);
            billing.setHorizontalAlignment(SwingConstants.CENTER);
            amount.setHorizontalAlignment(SwingConstants.CENTER);
            timeRemaining.setHorizontalAlignment(SwingConstants.CENTER);
            nextPayment.setHorizontalAlignment(SwingConstants.CENTER);
            monthlyCost.setHorizontalAlignment(SwingConstants.CENTER);
            yearlyCost.setHorizontalAlignment(SwingConstants.CENTER);
            status.setHorizontalAlignment(SwingConstants.CENTER);

            panel.add(platform);
            panel.add(billing);
            panel.add(amount);
            panel.add(timeRemaining);
            panel.add(nextPayment);
            panel.add(monthlyCost);
            panel.add(yearlyCost);
            panel.add(status);

            infoContainer.add(panel);
            infoContainer.add(Box.createVerticalStrut(10));

            container.add(infoContainer, BorderLayout.CENTER);

            UIManager.put("Label.foreground", null);

        }

        tabbedPane.add("Overall", container);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15, 22, 0, 22));
        title = UICreator.createLabel("Billing Tracker", 33, Font.BOLD);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        container = new JPanel(new BorderLayout());
        tabbedPane = new MaterialTabbedPane();
        tabbedPane.setFont(UICreator.getRegularFont().deriveFont(Font.PLAIN, 16));
        tabbedPane.setBackground(Color.RED);
    }

    private void initTabHeader() {

        JPanel header = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10, Color.BLACK, false);
        header.setPreferredSize(new Dimension(getWidth(), 40));

        UIManager.put("Label.foreground", Color.WHITE);

        JLabel platform = UICreator.createLabel("Name", 14, Font.PLAIN);
        JLabel billing = UICreator.createLabel("Billing", 14, Font.PLAIN);
        JLabel amount = UICreator.createLabel("Amount", 14, Font.PLAIN);
        JLabel timeRemaining = UICreator.createLabel("Time Remaining", 14, Font.PLAIN);
        JLabel nextPayment = UICreator.createLabel("Next Payment", 14, Font.PLAIN);
        JLabel monthlyCost = UICreator.createLabel("Monthly Cost", 14, Font.PLAIN);
        JLabel yearlyCost = UICreator.createLabel("Yearly Cost", 14, Font.PLAIN);
        JLabel status = UICreator.createLabel("Status", 14, Font.PLAIN);

        platform.setHorizontalAlignment(SwingConstants.CENTER);
        billing.setHorizontalAlignment(SwingConstants.CENTER);
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        timeRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        nextPayment.setHorizontalAlignment(SwingConstants.CENTER);
        monthlyCost.setHorizontalAlignment(SwingConstants.CENTER);
        yearlyCost.setHorizontalAlignment(SwingConstants.CENTER);
        status.setHorizontalAlignment(SwingConstants.CENTER);

        header.add(platform);
        header.add(billing);
        header.add(amount);
        header.add(timeRemaining);
        header.add(nextPayment);
        header.add(monthlyCost);
        header.add(yearlyCost);
        header.add(status);

        container.add(header, BorderLayout.NORTH);

        UIManager.put("Label.foreground", null);
    }


}
