package view.PaymentsHistoryPage;

import javax.swing.*;
import java.awt.*;
import util.UICreator;
import util.RoundedPanel;
import util.MaterialTabbedPane;

public class PaymentsHistoryPage extends JPanel {

    private JLabel title;
    private MaterialTabbedPane tabbedPane;

    String[] platforms = { "Spotify", "Netflix" };

    public PaymentsHistoryPage() {
        init();
        initTabbedPane();

        this.add(title, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
    }

    private void initTabbedPane() {
        tabbedPane = new MaterialTabbedPane();
        tabbedPane.setFont(UICreator.getRegularFont().deriveFont(Font.PLAIN, 16));

        for (String platform : platforms) {
            JPanel tabContent = new JPanel(new BorderLayout());

            // Header Panel
            JPanel headerPanel = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10, Color.BLACK);
            headerPanel.setPreferredSize(new Dimension(getWidth(), 40));

            UIManager.put("Label.foreground", Color.WHITE);

            JLabel paymentDate = UICreator.createLabel("Payment Date", 14, Font.PLAIN);
            JLabel paymentCost = UICreator.createLabel("Payment Cost", 14, Font.PLAIN);
            JLabel subsDue = UICreator.createLabel("Subscription Due", 14, Font.PLAIN);
            JLabel paymentStatus = UICreator.createLabel("Payment Status", 14, Font.PLAIN);

            paymentDate.setHorizontalAlignment(SwingConstants.CENTER);
            paymentCost.setHorizontalAlignment(SwingConstants.CENTER);
            subsDue.setHorizontalAlignment(SwingConstants.CENTER);
            paymentStatus.setHorizontalAlignment(SwingConstants.CENTER);

            headerPanel.add(paymentDate);
            headerPanel.add(paymentCost);
            headerPanel.add(subsDue);
            headerPanel.add(paymentStatus);

            UIManager.put("Label.foreground", null);

            tabContent.add(headerPanel, BorderLayout.NORTH);

            // Content Panel
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.add(Box.createVerticalStrut(10));

            for (int i = 1; i <= 5; i++) {
                JPanel panel = new RoundedPanel(new GridLayout(1, 4, 10, 0), 10, Color.WHITE);
                panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60)); // Set maximum height

                UIManager.put("Label.foreground", Color.BLACK);

                JLabel paymentDateValue = UICreator.createLabel("November 29, 2023", 14, Font.PLAIN);
                JLabel paymentCostValue = UICreator.createLabel("$3.25", 14, Font.PLAIN);
                JLabel subsDueValue = UICreator.createLabel("December 29, 2023", 14, Font.PLAIN);
                JLabel paymentStatusValue = UICreator.createLabel("Pending...", 14, Font.PLAIN);

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

            tabbedPane.add(platform, tabContent);
        }
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15, 22, 0, 22));
        title = UICreator.createLabel("Payment History", 33, Font.BOLD);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
    }
}
