package view.BillingPage.sections;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.util.List;
import model.Subscriptions.Subscription;
import util.MaterialTabbedPane;
import util.RoundedPanel;
import util.UICreator;

/**
 * The TabbedList class extends MaterialTabbedPane and represents a tabbed list
 * for displaying subscription information, including platform, billing details, cost, next payment, and status.
 */
public class TabbedList extends MaterialTabbedPane {

    private JPanel container;

    /**
     * Constructs a new TabbedList with a custom font for tab headers.
     */
    public TabbedList() {
        this.setFont(UICreator.getRegularFont().deriveFont(Font.PLAIN, 16));
        initTabHeader();
    }

    /**
     * Initializes the tab header with column headers.
     */
    private void initTabHeader() {
        container = new JPanel(new BorderLayout());

        JPanel header = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10, Color.BLACK, false);
        header.setPreferredSize(new Dimension(getWidth(), 40));

        UIManager.put("Label.foreground", Color.WHITE);

        JLabel platform = UICreator.createLabel("Name", 14, Font.PLAIN);
        JLabel billing = UICreator.createLabel("Billing", 14, Font.PLAIN);
        JLabel amount = UICreator.createLabel("Amount", 14, Font.PLAIN);
        JLabel nextPayment = UICreator.createLabel("Next Payment", 14, Font.PLAIN);
        JLabel weeklyCost = UICreator.createLabel("Weekly Cost", 14, Font.PLAIN);
        JLabel monthlyCost = UICreator.createLabel("Monthly Cost", 14, Font.PLAIN);
        JLabel yearlyCost = UICreator.createLabel("Yearly Cost", 14, Font.PLAIN);
        JLabel status = UICreator.createLabel("Status", 14, Font.PLAIN);

        platform.setHorizontalAlignment(SwingConstants.CENTER);
        billing.setHorizontalAlignment(SwingConstants.CENTER);
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        weeklyCost.setHorizontalAlignment(SwingConstants.CENTER);
        nextPayment.setHorizontalAlignment(SwingConstants.CENTER);
        monthlyCost.setHorizontalAlignment(SwingConstants.CENTER);
        yearlyCost.setHorizontalAlignment(SwingConstants.CENTER);
        status.setHorizontalAlignment(SwingConstants.CENTER);

        header.add(platform);
        header.add(billing);
        header.add(amount);
        header.add(nextPayment);
        header.add(weeklyCost);
        header.add(monthlyCost);
        header.add(yearlyCost);
        header.add(status);

        container.add(header, BorderLayout.NORTH);

        UIManager.put("Label.foreground", null);
    }


    /**
     * Updates the tabbed pane with subscription data.
     *
     * @param subscriptionList The list of subscriptions to display.
     */
    public void updateTabbedPaneData(List<Subscription> subscriptionList) {
        JPanel infoContainer = new JPanel();
        this.removeAll();
        container.removeAll();
        initTabHeader();
        infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));
        infoContainer.add(Box.createVerticalStrut(10));

        for (Subscription subscription : subscriptionList) {
            JPanel panel = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10, false);
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

            JLabel platform = UICreator.createLabel(subscription.getPlatform(), 14, Font.PLAIN);
            JLabel billing = UICreator.createLabel(subscription.getBilling().getBillingPeriod().toString(), 14, Font.PLAIN);
            JLabel amount = UICreator.createLabel("₱" + subscription.getBilling().getCost(), 14, Font.PLAIN);
            JLabel nextPayment = UICreator.createLabel(subscription.getDueDate(), 14, Font.PLAIN);

            double weeklyCostValue = subscription.getBilling().getWeeklyCost();
            double monthlyCostValue = subscription.getBilling().getMonthlyCost();
            double yearlyCostValue = subscription.getBilling().getYearlyCost();

            String weeklyCostText = String.format("₱%.1f", weeklyCostValue);
            String monthlyCostText = String.format("₱%.1f", monthlyCostValue);
            String yearlyCostText = String.format("₱%.1f", yearlyCostValue);

            JLabel weeklyCost = UICreator.createLabel(weeklyCostText, 14, Font.PLAIN);
            JLabel monthlyCost = UICreator.createLabel(monthlyCostText, 14, Font.PLAIN);
            JLabel yearlyCost = UICreator.createLabel(yearlyCostText, 14, Font.PLAIN);
            JLabel status = UICreator.createLabel("Active", 14, Font.PLAIN);

            weeklyCost.setFont(new Font("Arial", Font.PLAIN, 14));
            monthlyCost.setFont(new Font("Arial", Font.PLAIN, 14));
            yearlyCost.setFont(new Font("Arial", Font.PLAIN, 14));
            amount.setFont(new Font("Arial", Font.PLAIN, 14));

            platform.setHorizontalAlignment(SwingConstants.CENTER);
            billing.setHorizontalAlignment(SwingConstants.CENTER);
            amount.setHorizontalAlignment(SwingConstants.CENTER);
            nextPayment.setHorizontalAlignment(SwingConstants.CENTER);
            weeklyCost.setHorizontalAlignment(SwingConstants.CENTER);
            monthlyCost.setHorizontalAlignment(SwingConstants.CENTER);
            yearlyCost.setHorizontalAlignment(SwingConstants.CENTER);
            status.setHorizontalAlignment(SwingConstants.CENTER);

            panel.add(platform);
            panel.add(billing);
            panel.add(amount);
            panel.add(nextPayment);
            panel.add(weeklyCost);
            panel.add(monthlyCost);
            panel.add(yearlyCost);
            panel.add(status);

            infoContainer.add(panel);
            infoContainer.add(Box.createVerticalStrut(10));

            container.add(infoContainer, BorderLayout.CENTER);
        }

        this.add("Overall", container);

        this.revalidate();
        this.repaint();
        container.revalidate();
        container.repaint();
    }
}
