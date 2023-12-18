package view.BillingPage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import view.BillingPage.sections.TabbedList;
import util.UICreator;

/**
 * The {@code BillingPage} class represents the main panel for the billing page in the application.
 * It includes a title label and a {@link view.BillingPage.sections.TabbedList} for displaying subscription information.
 * The class provides methods to initialize its components and retrieve the tabbed list.
 */
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
