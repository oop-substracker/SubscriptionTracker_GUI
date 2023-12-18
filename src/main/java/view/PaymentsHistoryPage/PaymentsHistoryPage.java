package view.PaymentsHistoryPage;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Subscriptions.Subscription;
import util.UICreator;
import util.RoundedPanel;
import util.MaterialTabbedPane;

public class PaymentsHistoryPage extends JPanel {

    private JLabel title;
    private MaterialTabbedPane tabbedPane;
    private Map<String, JPanel> subscriptionTabMap;

    public PaymentsHistoryPage() {
        init();
        this.add(title, BorderLayout.NORTH);
        this.subscriptionTabMap = new HashMap<>();
    }

    public void updateTabbedPane(List<Subscription> subscriptionList) {
        // Clear existing tabs and the map
        if (tabbedPane != null) {
            this.remove(tabbedPane);
            subscriptionTabMap.clear();
        }

        tabbedPane = new MaterialTabbedPane();
        tabbedPane.setFont(UICreator.getRegularFont().deriveFont(Font.PLAIN, 16));

        for (Subscription sub : subscriptionList) {
            JPanel tabContent;

            if (subscriptionTabMap.containsKey(sub.getPlatform())) {
                // If the tab for the subscription already exists, get it
                tabContent = subscriptionTabMap.get(sub.getPlatform());
            } else {
                // If the tab for the subscription does not exist, create a new one
                tabContent = new JPanel(new BorderLayout());
                updateTabContent(tabContent, sub, subscriptionList);

                tabbedPane.add(sub.getPlatform(), tabContent);
                subscriptionTabMap.put(sub.getPlatform(), tabContent);
            }
        }

        this.add(tabbedPane, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void updateTabContent(JPanel tabContent, Subscription sub, List<Subscription> subscriptionList) {
        // Header Panel
        UIManager.put("Label.foreground", Color.WHITE);
        JPanel headerPanel = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10, Color.BLACK, false);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 40));

        JLabel paymentDateLabel = UICreator.createLabel("Payment Date", 14, Font.PLAIN);

        JLabel paymentCostLabel = UICreator.createLabel("Payment Cost", 14, Font.PLAIN);
        JLabel subsDueLabel = UICreator.createLabel("Subscription Due", 14, Font.PLAIN);
        JLabel paymentStatusLabel = UICreator.createLabel("Payment Status", 14, Font.PLAIN);

        paymentDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        paymentCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subsDueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        paymentStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(paymentDateLabel);
        headerPanel.add(paymentCostLabel);
        headerPanel.add(subsDueLabel);
        headerPanel.add(paymentStatusLabel);

        tabContent.add(headerPanel, BorderLayout.NORTH);
        UIManager.put("Label.foreground", null);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(Box.createVerticalStrut(10));


        int numRows = countSubscriptionsForPlatform(sub.getPlatform(), subscriptionList);

        for (int i = 0; i < numRows; i++) {
            JPanel panel = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10 , false);
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

            // Calculate payment date based on due date and time remaining
            Instant dueDateInstant = UICreator.parseStringToInstant(sub.getDueDate());
            long timeRemainingInMillis = sub.getTimeRemaining();
            Instant paymentDateInstant = dueDateInstant.minusMillis(timeRemainingInMillis);
            String formattedPaymentDate = UICreator.formatInstantToString(paymentDateInstant);

            JLabel paymentDateValue = UICreator.createLabel(formattedPaymentDate, 14, Font.PLAIN);
            JLabel paymentCostValue = UICreator.createLabel(Double.toString(sub.getBilling().getCost()), 14, Font.PLAIN);
            JLabel subsDueValue = UICreator.createLabel(sub.getDueDate(), 14, Font.PLAIN);
            JLabel paymentStatusValue = UICreator.createLabel("Paid", 14, Font.PLAIN);

            paymentDateValue.setHorizontalAlignment(SwingConstants.CENTER);
            paymentCostValue.setHorizontalAlignment(SwingConstants.CENTER);
            subsDueValue.setHorizontalAlignment(SwingConstants.CENTER);
            paymentStatusValue.setHorizontalAlignment(SwingConstants.CENTER);

            panel.add(paymentDateValue);
            panel.add(paymentCostValue);
            panel.add(subsDueValue);
            panel.add(paymentStatusValue);

            contentPanel.add(panel);
            contentPanel.add(Box.createVerticalStrut(10));
        }

        tabContent.add(contentPanel, BorderLayout.CENTER);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15, 22, 0, 22));
        title = UICreator.createLabel("Payment History", 33, Font.BOLD);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
    }

    public int countSubscriptionsForPlatform(String platform, List<Subscription> subscriptionList) {
        int count = 0;

        for (Subscription subscription : subscriptionList) {
            if (subscription.getPlatform().equals(platform)) {
                count++;
            }
        }

        return count;
    }
}