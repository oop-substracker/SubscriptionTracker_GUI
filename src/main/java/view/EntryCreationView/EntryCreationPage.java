    package view.EntryCreationView;

    import javax.swing.JButton;
    import javax.swing.JComboBox;
    import javax.swing.UIManager;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JTextField;
    import java.awt.FlowLayout;
    import java.awt.GridBagConstraints;
    import java.awt.GridBagLayout;
    import java.awt.Font;
    import javax.swing.Box;
    import java.time.Instant;
    import model.DefaultEntries.Entry;
    import model.Subscriptions.Billing;
    import model.Subscriptions.constants.BillingPeriod;
    import util.DropShadowCreatorForAllSides;
    import util.RoundedComboBox;
    import util.UICreator;
    import controller.Controller;
    import model.Subscriptions.Subscription;

    /**
     * The {@code EntryCreationPage} class represents the panel for creating a new entry in the application.
     * It includes a form for entering details such as email, password, amount, subscription plan, and duration.
     * The class provides methods to initialize its components, handle billing periods, set subscription details,
     * and calculate time durations.
     *
     */

    public class EntryCreationPage extends JPanel {

        private Entry entry;

        private JPanel container;
        private JPanel formPanel;
        private JTextField email;
        private JTextField password;
        private JTextField amount;
        private JComboBox<String> subscriptionPlan;
        private JTextField time;
        private JButton createBtn;
        private JButton cancelBtn;
        private String defaultTime;

        private String[] plans = { "Weekly", "Monthly", "Yearly" };
        private BillingPeriod billingPeriod;


        private JLabel image;

        public EntryCreationPage(Entry entry) {
            this.setLayout(new GridBagLayout());
            this.entry = entry;

            initContainer();

            UICreator.createComp(this, container, 0, 0, 1, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 0, 0, 0, 120);

        }

        private void initContainer() {
            container = new DropShadowCreatorForAllSides(5, 5, 5, 5);
            container.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));

            initForm();
            initImage();

            container.add(image);
            container.add(Box.createHorizontalStrut(10));
            container.add(formPanel);
        }

        private void initForm() {

            formPanel = new JPanel(new GridBagLayout());

            String text = "<html><div style='text-align:center;'>Account Creation<br><span style='font-size:10px;'>We are glad to track your new subscription!</span></div></html>";
            var label = UICreator.createLabel(text, 20, Font.BOLD);

            email = UICreator.createTxtField("Email");

            password = UICreator.createTxtField("Password");

            amount = UICreator.createTxtField("Amount");

            subscriptionPlan = new RoundedComboBox<>(plans);
            subscriptionPlan.setFont(UICreator.getRegularFont().deriveFont(Font.PLAIN, 13));

            time = UICreator.createTxtField("31 : 00 : 00 : 00");

            UIManager.put( "Button.arc", 999 );
            createBtn = new JButton("Create Entry");
            cancelBtn = new JButton("Cancel Entry");

            createBtn.addActionListener(new Controller.EntryCreationActionListeners(createBtn));
            cancelBtn.addActionListener(new Controller.EntryCreationActionListeners(cancelBtn));

            UICreator.createComp(formPanel, label, 0, 0, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50, 0, 5, 0);
            UICreator.createComp(formPanel, email, 0, 1, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 40, 50, 0, 5, 30);
            UICreator.createComp(formPanel, password, 0, 2, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50, 0, 5, 30);
            UICreator.createComp(formPanel, amount, 0, 3, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50, 0, 5, 30);
            UICreator.createComp(formPanel, subscriptionPlan, 0, 4, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50, 0, 5, 30);
            UICreator.createComp(formPanel, time, 0, 5  , 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50, 0, 5, 30);
            UICreator.createComp(formPanel, createBtn, 0, 6, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH, 10, 50, 0, 5, 30);
            UICreator.createComp(formPanel, cancelBtn, 2, 6, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH, 10, 50, 0, 5, 30);
        }

        private BillingPeriod handleBillingPeriod(String plan) {
            billingPeriod = BillingPeriod.WEEKLY;

            switch (plan) {
                case "Weekly":
                    billingPeriod = BillingPeriod.WEEKLY;
                    defaultTime = "7";
                    break;
                case "Monthly":
                    billingPeriod = BillingPeriod.MONTHLY;
                    defaultTime = "30";
                    break;
                case "Yearly":
                    billingPeriod = BillingPeriod.YEARLY;
                    defaultTime = "365";
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + plan);
            }

            time.setText(defaultTime);
            return billingPeriod;
        }

        public void setSubscription(Subscription subscription) {
            subscription.setUserId(Controller.getUser().getId());
            subscription.setEmail(email.getText());
            subscription.setPlatform(entry.getPlatform());

            Billing billing = subscription.getBilling();
            if (billing == null) {
                billing = new Billing(); // Instantiate the Billing object if it is null
            }

            billing.setBillingPeriod(handleBillingPeriod((String) subscriptionPlan.getSelectedItem()));
            billing.setBillingPeriod(billingPeriod);

            double cost = Double.parseDouble(amount.getText());

            billing.setCost(cost);
            billing.calculateDerivedCosts();

            subscription.setTimeRemaining(calcTime(Integer.parseInt(time.getText())));

            // Calculate due date based on billing period
            int billingDays = Integer.parseInt(defaultTime); // Use the default time set in handleBillingPeriod
            Instant currentDate = Instant.now();
            Instant dueDateInstant = currentDate.plusMillis(calcTime(billingDays));

            // Format due date
            String formattedDueDate = UICreator.formatInstantToString(dueDateInstant);

            subscription.setDueDate(formattedDueDate);

            // Automatically update the timeRemaining in millis
            subscription.setRemainingTimeInMillis(subscription.getTimeRemaining());
            subscription.setWindowCloseTime(Instant.now());

            subscription.setBilling(billing);

            System.out.println("user id: " + Controller.getUser().getId());
        }


        private void initImage() {
            image = new JLabel(UICreator.createImage("/images/banners/" + entry.getPlatform() + ".png", 390, 500));
        }

        private long calcTime(int days) {
            return (long) days * 24 * 60 * 60 * 1000;
        }

    }
