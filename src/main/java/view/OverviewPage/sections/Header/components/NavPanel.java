package view.OverviewPage.sections.Header.components;

import javax.swing.*;
import java.awt.*;
import util.UICreator;

public class NavPanel extends JPanel {

    private JButton profile;
    private JButton notif;

    public NavPanel() {
        setLayout(new BorderLayout());
        init();
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0,0));
    }

    private void init() {
        var left = new JPanel(new BorderLayout());
        var title = UICreator.createLabel("Overview", 20, Font.BOLD);
        var desc = UICreator.createLabel("Lorem ipsum dolor amet ipsum dolor amet ipsum dolor", 12, Font.PLAIN);

        Box boxLayout = Box.createVerticalBox();
        boxLayout.add(title);
        boxLayout.add(desc);

        left.add(boxLayout, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        notif = UICreator.createButton("", 0, 0, UICreator.createImage("/icons/sidebar/notif_icon.png", 25,25));
        notif.setBorder(null);
        notif.setBackground(new Color(0, 0, 0,0));
        notif.setBorderPainted(false);
        UICreator.configureTransparentButton(notif);

        profile = UICreator.createButton("", 0, 0, UICreator.createImage("/icons/assets/profile.png", 27,27));
        profile.setBorder(null);
        profile.setBackground(new Color(0, 0, 0,0));
        profile.setBorderPainted(false);
        UICreator.configureTransparentButton(profile);

        leftPanel.add(notif);
        leftPanel.add(Box.createHorizontalStrut(3));
        leftPanel.add(profile);

        this.add(left, BorderLayout.WEST);
        this.add(leftPanel, BorderLayout.EAST);
    }
}
