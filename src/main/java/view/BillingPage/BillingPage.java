package view.BillingPage;

import javax.swing.*;
import java.awt.*;
import view.BillingPage.sections.TabbedList;
import util.UICreator;


public class BillingPage extends JPanel {

    private JLabel title;
    private TabbedList tabbedPane;

    private JPanel container;

    public BillingPage() {
        init();

        this.add(title, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
    }


    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(15, 22, 0, 22));
        title = UICreator.createLabel("Billing Tracker", 33, Font.BOLD);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        container = new JPanel(new BorderLayout());
        tabbedPane = new TabbedList();
    }


    public TabbedList getTabbedPane() {
        return tabbedPane;
    }
}
