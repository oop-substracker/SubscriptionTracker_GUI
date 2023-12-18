    package view.OverviewPage.sections.Header.components;

    import util.RoundedPanelWithShadow;
    import util.UICreator;
    import javax.swing.BorderFactory;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import java.awt.BorderLayout;
    import java.awt.GridLayout;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.util.List;
    import model.Subscriptions.Subscription;
    import model.Subscriptions.constants.BillingPeriod;

    /**
     * The {@code AnalyticPanel} class represents a panel for displaying analytics related to subscriptions.
     * It includes methods to update the analytics view with subscription data, such as active subscriptions, weekly cost,
     * monthly cost, and yearly cost.
     */
    public class AnalyticPanel extends JPanel {

        private JLabel subsCount;
        private JLabel ads;
        private JLabel income;
        private JLabel rate;

        /**
         * Constructs a new {@code AnalyticPanel} with a grid layout.
         */
        public AnalyticPanel() {
            setLayout(new GridLayout(1, 4, 10, 5));
            this.setPreferredSize(new Dimension(getWidth(), 100));

        }
        /**
         * Updates the analytic panel with the given list of subscriptions.
         * Calculates and displays the number of active subscriptions and the cost breakdown for weekly, monthly, and yearly subscriptions.
         *
         * @param subscriptionList The list of subscriptions to be used for analytics.
         */
        public void updateSubscriptionsAnalytic(List<Subscription> subscriptionList) {
            removeAll();
            int  activeSubs  = 0;
            double  weekly = 0.0, monthly = 0.0, yearly = 0.0;

            for (Subscription sub: subscriptionList) {
                if (sub.getTimeRemaining() > 0) {
                    activeSubs +=  1;
                }

                if (sub.getBilling().getBillingPeriod() == BillingPeriod.WEEKLY) {
                    weekly += sub.getBilling().getWeeklyCost();
                } else if (sub.getBilling().getBillingPeriod() == BillingPeriod.MONTHLY) {
                    monthly += sub.getBilling().getMonthlyCost();
                }  else if (sub.getBilling().getBillingPeriod() == BillingPeriod.YEARLY) {
                    yearly += sub.getBilling().getYearlyCost();
                }
            }

            JPanel subsCountPanel =  new JPanel(new BorderLayout());
            var container1 = new RoundedPanelWithShadow();
            container1.setLayout(new BorderLayout());
            container1.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            subsCountPanel.setPreferredSize(new Dimension(400, 200));
            var subsText = UICreator.createLabel("Active Subscriptions", 14, Font.BOLD);
            subsCount = UICreator.createLabel(Integer.toString(activeSubs), 25, Font.BOLD);
            var subsImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
            container1.add(subsText, BorderLayout.NORTH);
            container1.add(subsCount, BorderLayout.WEST);
            container1.add(subsImage, BorderLayout.CENTER);
            subsCountPanel.add(container1, BorderLayout.CENTER);

            JPanel addsPanel = new JPanel(new BorderLayout());
            var container2 = new RoundedPanelWithShadow();
            container2.setLayout(new BorderLayout());
            container2.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            addsPanel.setPreferredSize(new Dimension(400, 200));
            var addsText = UICreator.createLabel("Weekly Expense", 14, Font.BOLD);
            ads = UICreator.createLabel("₱" + String.format("%.1f", weekly), 25, Font.BOLD);
            var adsImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
            container2.add(addsText, BorderLayout.NORTH);
            container2.add(ads, BorderLayout.WEST);
            container2.add(adsImage, BorderLayout.CENTER);
            addsPanel.add(container2, BorderLayout.CENTER);

            JPanel incomePanel =  new JPanel(new BorderLayout());
            var container3 = new RoundedPanelWithShadow();
            container3.setLayout(new BorderLayout());
            container3.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            incomePanel.setPreferredSize(new Dimension(400, 200));
            var incomeText = UICreator.createLabel("Monthly Expense", 14, Font.BOLD);
            income = UICreator.createLabel("₱" + String.format("%.1f", monthly), 25, Font.BOLD);
            var incomeImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
            container3.add(incomeText, BorderLayout.NORTH);
            container3.add(income, BorderLayout.WEST);
            container3.add(incomeImage, BorderLayout.CENTER);
            incomePanel.add(container3, BorderLayout.CENTER);

            JPanel ratePanel =  new JPanel(new BorderLayout());
            var container4 = new RoundedPanelWithShadow();
    //        container4.setBackground(Color.decode("#FFFFFF"));
            container4.setLayout(new BorderLayout());
            container4.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            ratePanel.setPreferredSize(new Dimension(400, 200));
            var rateText = UICreator.createLabel("Yearly Expense", 14, Font.BOLD);
            rate = UICreator.createLabel("₱" + String.format("%.1f", yearly), 25, Font.BOLD);
            var rateImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
            container4.add(rateText, BorderLayout.NORTH);
            container4.add(rate, BorderLayout.WEST);
            container4.add(rateImage, BorderLayout.CENTER);
            ratePanel.add(container4, BorderLayout.CENTER);

            ads.setFont(new Font("Arial", Font.BOLD, 25));
            income.setFont(new Font("Arial", Font.BOLD, 25));
            rate.setFont(new Font("Arial", Font.BOLD, 25));

            this.add(subsCountPanel);
            this.add(addsPanel);
            this.add(incomePanel);
            this.add(ratePanel);
        }

    }
