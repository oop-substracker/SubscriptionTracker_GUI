package view.OverviewPage.sections.Header.components;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.Controller;
import util.RoundedPanelWithShadow;
import util.UICreator;

/**
 * The {@code NavPanel} class represents a navigation panel containing buttons for profile and notifications.
 * It includes a profile drop-down with an option to log out.
 */
public class NavPanel extends JPanel {

    private JButton profile;
    private boolean showLogout = false;

    private JPanel profileDrop;
    private JPanel leftPanel;
    private  JPanel rightPanel;

    public NavPanel() {
        setLayout(new BorderLayout());
        init();
        initProfileDrop();


        this.add(rightPanel, BorderLayout.EAST);
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0,0));
    }

    private void init() {
        var left = new JPanel(new BorderLayout());
        var title = UICreator.createLabel("Overview", 25, Font.BOLD);
        var desc = UICreator.createLabel("Keep track of your subscriptions", 13, Font.PLAIN);

        Box boxLayout = Box.createVerticalBox();
        boxLayout.add(title);
        boxLayout.add(desc);

        left.add(boxLayout, BorderLayout.CENTER);

        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(100, 70));

        leftPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        profile = UICreator.createButton(false,"", 0, 0, UICreator.createImage("/icons/assets/profile1.png", 27,27), 0, 0);
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

        leftPanel.add(Box.createHorizontalStrut(3));
        leftPanel.add(profile);

        this.add(left, BorderLayout.WEST);
    }

    private void initProfileDrop() {
        profileDrop = new RoundedPanelWithShadow();
        profileDrop.setLayout(new BorderLayout());
        profileDrop.setPreferredSize(new Dimension(100, 20));
        profileDrop.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 10));
        profileDrop.setVisible(false);

        JLabel logout = UICreator.createLabel("Logout", 13,  Font.BOLD);
        logout.setHorizontalAlignment(SwingConstants.CENTER);
        logout.setVerticalAlignment(SwingConstants.CENTER);
        logout.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        profileDrop.add(logout, BorderLayout.CENTER);
        profileDrop.addMouseListener(new Controller.CustomMouseListener(profileDrop, null));

        rightPanel.add(leftPanel);
        rightPanel.add(profileDrop);

    }
    public JPanel getProfileDrop() {
        return profileDrop;
    }
}
