package view.OverviewPage.sections.CreateEntryView;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import util.UICreator;

/**
 * The {@code CreateEntryView} class represents a panel for creating entries in the overview page.
 * It includes a title panel and an {@link EntryItemView} for displaying and creating entry items.
 * The class provides methods to initialize its components and retrieve the entry item view.
 */
public class CreateEntryView extends JPanel {

    private JPanel titlePanel;
    private EntryItemView entryItemView;

    public CreateEntryView() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0 , 0));
        entryItemView = new EntryItemView();

        this.setPreferredSize(new Dimension(getWidth(), 200));

        initTitlePanel();

        JScrollPane entriesScrollPane = new JScrollPane(entryItemView);
        entriesScrollPane.setBorder(null);
        entriesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        entriesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(titlePanel,BorderLayout.NORTH);
        this.add(entriesScrollPane,BorderLayout.CENTER);
    }

    private void initTitlePanel() {
        titlePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        var label = UICreator.createLabel("Create Entries", 20, Font.BOLD);

        titlePanel.add(label);
    }

    public EntryItemView getEntryItemView() {
        return entryItemView;
    }
}