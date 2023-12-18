package view.OverviewPage;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import view.OverviewPage.sections.Header.Header;
import view.OverviewPage.sections.SubscriptionsView.SubsView;
import view.OverviewPage.sections.CreateEntryView.CreateEntryView;

/**
 * The {@code Overview} class represents the main panel for the overview page.
 * It includes the header, subscriptions view, and create entry view sections.
 */
public class Overview extends JPanel {
    private final Header header;
    private final SubsView subsView;
    private final CreateEntryView createEntryView;

    /**
     * Constructs an instance of the Overview class.
     * Initializes the header, subscriptions view, and create entry view.
     */
    public Overview() {
        header = new Header();
        subsView = new SubsView();
        createEntryView = new CreateEntryView();

        init();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0, 20, 20 , 25));

        this.add(header, BorderLayout.NORTH);
        this.add(subsView, BorderLayout.CENTER);
        this.add(createEntryView, BorderLayout.SOUTH);

    }

    public Header getHeader() {
        return header;
    }

    public SubsView getSubsView() {
        return subsView;
    }

    public CreateEntryView getCreateEntryView() {
        return createEntryView;
    }
}
