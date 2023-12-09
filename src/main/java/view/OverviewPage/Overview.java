package view.OverviewPage;

import javax.swing.*;
import java.awt.*;

import view.OverviewPage.sections.Header.Header;
import view.OverviewPage.sections.SubscriptionsView.SubsView;
import view.OverviewPage.sections.CreateEntryView.CreateEntryView;

public class Overview extends JPanel {

    private final Header header;
    private final SubsView subsView;
    private final CreateEntryView createEntryView;

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

    public SubsView getSubsView() {
        return subsView;
    }

    public CreateEntryView getCreateEntryView() {
        return createEntryView;
    }
}
