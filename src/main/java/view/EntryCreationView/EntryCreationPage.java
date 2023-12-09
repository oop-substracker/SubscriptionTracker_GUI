package view.EntryCreationView;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import model.DefaultEntries.Entry;
import model.Subscriptions.Billing;
import model.Subscriptions.constants.BillingPeriod;
import util.DropShadowCreatorForAllSides;
import util.RoundedComboBox;
import util.UICreator;
import util.DropShadowCreator;
import controller.Controller;
import model.Subscriptions.Subscription;

public class EntryCreationPage extends JPanel {

    private Entry entry;

    private JPanel container;
    private JPanel formPanel;
    private JTextField email;
    private JTextField password;
    private JComboBox<String> subscriptionPlan;
    private JTextField time;
    private JButton createBtn;
    private JButton cancelBtn;

    private JLabel image;

    public EntryCreationPage(Entry entry) {
        this.setLayout(new GridBagLayout());
        this.entry = entry;

        initContainer();

        UICreator.createComp(this, container, 0, 0, 1, 1, 2, 1,GridBagConstraints.CENTER, GridBagConstraints.NONE,0, 0,0,0, 0, 120);

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

        String[] plans = { "Weekly", "Monthly", "Yearly" };
        subscriptionPlan = new RoundedComboBox<>(plans);
        subscriptionPlan.setFont(UICreator.getRegularFont().deriveFont(Font.PLAIN,  13));

        time = UICreator.createTxtField("31 : 00 : 00 : 00");

        createBtn = new JButton("Create Entry");
        cancelBtn = new JButton("Cancel Entry");

        createBtn.addActionListener(new Controller.EntryCreationActionListeners(createBtn, new Subscription(email.getText(), entry.getPlatform(), time.getText(), new Billing(handleBillingPeriod((String) Objects.requireNonNull(subscriptionPlan.getSelectedItem())),2.25, 2.25, 39.00), "December 14, 2023")));
        cancelBtn.addActionListener(new Controller.EntryCreationActionListeners(cancelBtn, null));

        UICreator.createComp(formPanel, label, 0, 0, 4, 1, 1, 1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50,0,5, 0);
        UICreator.createComp(formPanel, email, 0, 1, 4, 1, 1, 1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 40, 50,0,5, 30);
        UICreator.createComp(formPanel, password, 0, 2, 4, 1, 1, 1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50,0,5, 30);
        UICreator.createComp(formPanel, subscriptionPlan, 0, 3, 4, 1, 1, 1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50,0,5, 30);
        UICreator.createComp(formPanel, time, 0, 4, 4, 1, 1, 1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 10, 50,0,5, 30);
        UICreator.createComp(formPanel, createBtn, 0, 5, 1, 1, 1, 1,GridBagConstraints.WEST, GridBagConstraints.BOTH, 10, 50,0,5, 30);
        UICreator.createComp(formPanel, cancelBtn, 2, 5, 1, 1, 1, 1,GridBagConstraints.EAST, GridBagConstraints.BOTH, 10, 50,0,5, 30);


    }

    private  BillingPeriod handleBillingPeriod(String plan) {
        var billingPeriod = BillingPeriod.WEEKLY;
        switch (plan) {
            case "Weekly":
                billingPeriod = BillingPeriod.WEEKLY;
                break;
            case "Monthly":
                billingPeriod = BillingPeriod.MONTHLY;
                break;
            case "Yearly":
                billingPeriod = BillingPeriod.YEARLY;
                break;
            default:
                // Handle the default case or throw an exception
                throw new IllegalArgumentException("Unexpected value: " + plan);
        }
        return billingPeriod;
    }


    private void initImage() {
        image = new JLabel(UICreator.createImage("/icons/poster/netflix.jpg", 390, 500));
    }
}
