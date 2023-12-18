package view.OverviewPage.sections.CreateEntryView;

import controller.Controller;
import model.DefaultEntries.Entry;
import util.RoundedPanel;
import util.UICreator;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

/**
 * The {@code EntryItemView} class represents a panel for displaying entry items in the create entry view.
 * It includes methods to update the view with a list of entries and configure transparent buttons for each entry.
 */
public class EntryItemView extends JPanel {

    public EntryItemView() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }


    /**
     * Updates the entry item view with the given list of entries.
     * Each entry is displayed with a platform label and a "Create Entry" button.
     *
     * @param entryList The list of entries to be displayed.
     */
    public void updateEntriesView(List<Entry> entryList) {
        for (Entry entry: entryList) {
            var panel = new RoundedPanel(new BorderLayout(), 10, false);
            panel.setPreferredSize(new Dimension(getWidth(), 50));
            var platform = UICreator.createLabelWithImage(entry.getPlatform(), 13, Font.BOLD, entry.getImage(), 30, 30);
            var createBtn = UICreator.createButton(false,"Create Entry", 13, Font.PLAIN, UICreator.createImage("/icons/assets/create.png", 16, 16), 0, 0);
            configureTransparentButton(createBtn);

            panel.add(platform, BorderLayout.WEST);
            panel.add(createBtn, BorderLayout.EAST);
            Border matteBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY);
            Border emptyBorder = BorderFactory.createEmptyBorder(0, 20, 0, 10);
            Border compoundBorder = BorderFactory.createCompoundBorder(matteBorder, emptyBorder);
            panel.setBorder(compoundBorder);


            createBtn.addActionListener(new Controller.CreateEntryListener(entry));

            this.add(panel);
            this.add(Box.createVerticalStrut(10));
        }
        revalidate();
        repaint();
    }

    private void configureTransparentButton(AbstractButton button) {
        button.setMargin(new Insets(0, -1, 0, 0));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
    }
}
