package view.OverviewPage.sections.CreateEntryView;

import controller.Controller;
import model.DefaultEntries.Entry;
import util.UICreator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class EntryItemView extends JPanel {

    public EntryItemView() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void updateEntriesView(List<Entry> entryList) {
        UIManager.put("Panel.background", Color.decode("#FFFFFF"));

        for (Entry entry: entryList) {
            /* 1st entry */
            var panel = new JPanel(new BorderLayout());
            panel.setPreferredSize(new Dimension(getWidth(), 50));
            var platform = UICreator.createLabelWithImage(entry.getPlatform(), 13, Font.BOLD, entry.getImage(), 30, 30);
            var createBtn = UICreator.createButton(false,"Create Entry", 13, Font.PLAIN, UICreator.createImage("/icons/assets/create.png", 16, 16), 0, 0);
            configureTransparentButton(createBtn);

            panel.add(platform, BorderLayout.WEST);
            panel.add(createBtn, BorderLayout.EAST);
            Border matteBorder = BorderFactory.createMatteBorder(1, 1, 0, 0, Color.LIGHT_GRAY);
            Border emptyBorder = BorderFactory.createEmptyBorder(0, 20, 0, 10);
            Border compoundBorder = BorderFactory.createCompoundBorder(matteBorder, emptyBorder);
            panel.setBorder(compoundBorder);


            createBtn.addActionListener(new Controller.CreateEntryListener(entry));

            this.add(panel);
        }
        UIManager.put("Panel.background", null);
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