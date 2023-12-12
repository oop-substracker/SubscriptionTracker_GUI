package view.OverviewPage.sections.Header.components;

import javax.swing.*;
import java.awt.*;

import controller.Controller;
import util.RoundedPanelWithShadow;
import util.UICreator;

public class NavPanel extends JPanel {

    private JButton profile;
    private JButton notif;
    private boolean showLogout = false;

    private JPanel profileDrop;

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

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(100, 70));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        notif = UICreator.createButton(false,"", 0, 0, UICreator.createImage("/icons/assets/bell-d.png", 22,22), 0, 0);
        notif.setBorder(null);
        notif.setBackground(new Color(0, 0, 0,0));
        notif.setBorderPainted(false);
        notif.setContentAreaFilled(false);
        UICreator.configureTransparentButton(notif);

        profile = UICreator.createButton(false,"", 0, 0, UICreator.createImage("/icons/assets/profile.png", 27,27), 0, 0);
        profile.setBorder(null);
        profile.setBackground(new Color(0, 0, 0,0));
        profile.setBorderPainted(false);
        profile.setContentAreaFilled(false);
        UICreator.configureTransparentButton(profile);
        profile.addActionListener(e -> {
            showLogout = !showLogout;
            if (showLogout) {
                profileDrop.setVisible(true);
            } else {
                profileDrop.setVisible(false);
            }

        });

        leftPanel.add(notif);
        leftPanel.add(Box.createHorizontalStrut(3));
        leftPanel.add(profile);

        profileDrop = new RoundedPanelWithShadow();
        profileDrop.setLayout(new BorderLayout());
        profileDrop.setBackground(Color.WHITE);
        profileDrop.setPreferredSize(new Dimension(100, 30));
        profileDrop.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 10));
        profileDrop.setVisible(false);

        JLabel logout = UICreator.createLabel("Logout", 12,  Font.BOLD);
        logout.setHorizontalAlignment(SwingConstants.CENTER);
        logout.setVerticalAlignment(SwingConstants.CENTER);
        logout.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        profileDrop.add(logout, BorderLayout.CENTER);
        profileDrop.addMouseListener(new Controller.CustomMouseListener(profileDrop, null));

        rightPanel.add(leftPanel);
        rightPanel.add(profileDrop);

        this.add(left, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
    }

    public JPanel getProfileDrop() {
        return profileDrop;
    }
}
