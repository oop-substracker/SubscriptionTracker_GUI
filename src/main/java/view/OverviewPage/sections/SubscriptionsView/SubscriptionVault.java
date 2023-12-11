
package view.OverviewPage.sections.SubscriptionsView;

import model.Subscriptions.Subscription;
import util.DropShadowCreatorForAllSides;
import util.RoundedPanelWithShadow;
import util.UICreator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SubscriptionVault extends JPanel {

    public SubscriptionVault() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
    }

    public void updateSubscriptionVaults(List<Subscription> subscriptionList) {
        removeAll();

        for (Subscription vault : subscriptionList) {
            var vaultContainer = new JPanel();
            vaultContainer.setPreferredSize(new Dimension(275, 245));
            vaultContainer.setLayout(new BorderLayout());


            var vaultContent = new RoundedPanelWithShadow();
            vaultContent.setBackground(Color.decode("#FFFFFF"));
            vaultContent.setLayout(new BorderLayout());

            var topContainer = new JPanel(new BorderLayout());
            topContainer.setBackground(Color.decode("#FFFFFF"));
            vaultContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 6, 10));

            var leftTop = new JPanel(new BorderLayout());
            leftTop.setBackground(Color.decode("#FFFFFF"));
            var remainingTimeLabel = UICreator.createLabel("Time Remaining", 13, Font.PLAIN);
            var remainingTime = UICreator.createLabel(vault.getTimeRemaining(), 13, Font.BOLD);
            Box boxLayout = Box.createVerticalBox();
            boxLayout.add(remainingTimeLabel);
            boxLayout.add(remainingTime);
            leftTop.add(boxLayout, BorderLayout.CENTER);

            var ellipses = UICreator.createLabel("⋮", 23, Font.BOLD);
            ellipses.setBackground(Color.decode("#FFFFFF"));
            ellipses.setBorder(BorderFactory.createEmptyBorder(-18, 0, 0, 0));

            topContainer.add(leftTop, BorderLayout.WEST);
            topContainer.add(ellipses, BorderLayout.EAST);

            // END OF TOP
            var imagePanel = new JPanel(new BorderLayout());
            imagePanel.setBackground(Color.decode("#FFFFFF"));
            imagePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            var image = new JLabel(UICreator.createImage("/icons/assets/g-4.png", 280, 240));
            imagePanel.add(image, BorderLayout.CENTER);

            // END OF CENTER
            var bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.setBackground(Color.decode("#FFFFFF"));
            bottomPanel.setPreferredSize(new Dimension(getWidth(), 45));

            String platform = "<html><div style='font-size:15px; font-weight:bold;'>" + vault.getPlatform() + "</html>";
            var bottomLeftBtn = UICreator.createButton(false, platform, 13, Font.PLAIN, UICreator.createImage("/images/icons/spotify.png", 35, 35), 0, 0);
            configureTransparentButton(bottomLeftBtn);

            String text = "<html><div style='text-align:center; font-size: 9px; font-weight:bold;'>Cancel<br>Subscription</div></html>";
            var bottomRightBtn = UICreator.createButton(false, text, 13, Font.PLAIN, null, 0, 0);
            configureTransparentButton(bottomRightBtn);

            bottomPanel.add(bottomLeftBtn, BorderLayout.WEST);
            bottomPanel.add(bottomRightBtn, BorderLayout.EAST);

            vaultContent.add(topContainer, BorderLayout.NORTH);
            vaultContent.add(imagePanel, BorderLayout.CENTER);
            vaultContent.add(bottomPanel, BorderLayout.SOUTH);

            vaultContainer.add(vaultContent, BorderLayout.CENTER);
            this.add(vaultContainer);
            this.add(Box.createHorizontalStrut(0));
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
