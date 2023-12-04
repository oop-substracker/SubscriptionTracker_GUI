package view.OverviewPage.sections.CreateEntryView;

import javax.swing.*;
import java.awt.*;

import util.UICreator;

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
