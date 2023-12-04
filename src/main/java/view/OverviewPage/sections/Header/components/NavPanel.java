package view.OverviewPage.sections.Header.components;

import javax.swing.*;
import java.awt.*;
import util.UICreator;

public class NavPanel extends JPanel {

    private JButton profile;

    public NavPanel() {
        setLayout(new BorderLayout());
        init();
    }

    private void init() {
        var left = new JPanel(new BorderLayout());
        var title = UICreator.createLabel("Overview", 20, Font.BOLD);
        var desc = UICreator.createLabel("Lorem ipsum dolor amet ipsum dolor amet ipsum dolor", 12, Font.PLAIN);

        Box boxLayout = Box.createVerticalBox();
        boxLayout.add(title);
        boxLayout.add(desc);

        left.add(boxLayout, BorderLayout.CENTER);

        profile = UICreator.createButton("", UICreator.createImage("/icons/assets/profile.png", 35,35));
        profile.setBorder(null);
        profile.setBackground(new Color(0, 0, 0,0));
        profile.setBorderPainted(false);

        this.add(left, BorderLayout.WEST);
        this.add(profile, BorderLayout.EAST);
    }
}
