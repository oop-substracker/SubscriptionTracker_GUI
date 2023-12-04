package view.OverviewPage.sections.SubscriptionsView;

import model.Subscriptions.Subscription;
import util.DropShadowCreator;
import util.UICreator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SubscriptionVault  extends JPanel {


    public SubscriptionVault() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
    }


    public void updateSubscriptionVaults(List<Subscription> subscriptionList) {

        removeAll();

        for (Subscription vault : subscriptionList) {
            var vaultContainer = new DropShadowCreator(5, 5, 5, 5);
            vaultContainer.setPreferredSize(new Dimension(280, 260));
            vaultContainer.setLayout(new BorderLayout());
            var vaultContent = new JPanel(new BorderLayout());

            var topContainer = new JPanel(new BorderLayout());
            vaultContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

            var leftTop = new JPanel(new BorderLayout());
            var remainingTimeLabel = UICreator.createLabel("Time Remaining", 13, Font.PLAIN);
            var remainingTime = UICreator.createLabel(vault.getTimeRemaining(), 13, Font.BOLD);
            Box boxLayout = Box.createVerticalBox();
            boxLayout.add(remainingTimeLabel);
            boxLayout.add(remainingTime);
            leftTop.add(boxLayout, BorderLayout.CENTER);

            var ellipses = UICreator.createLabel("⋮", 23, Font.BOLD);
            ellipses.setBorder(BorderFactory.createEmptyBorder(-18, 0, 0, 0));

            topContainer.add(leftTop, BorderLayout.WEST);
            topContainer.add(ellipses, BorderLayout.EAST);

            // END OF TOP
            var imagePanel = new JPanel(new BorderLayout());
            imagePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            var image = new JLabel(UICreator.createImage("/icons/assets/growth-1.png", 250, 160));
            imagePanel.add(image, BorderLayout.CENTER);

            // END OF CENTER
            var bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.setPreferredSize(new Dimension(getWidth(), 60));

            String platform = "<html><div style='font-size:15px; font-weight:bold;'>" + vault.getPlatform() + "</html>";
            var bottomLeftBtn = UICreator.createButton(platform, UICreator.createImage("/icons/assets/spotify.png", 40, 40));
            bottomLeftBtn.setMargin(new Insets(0, -1, 0, 0));
            bottomLeftBtn.setBorderPainted(false);
            bottomLeftBtn.setBackground(new Color(0, 0, 0, 0));
            bottomLeftBtn.setBorder(null);

            String text = "<html><div style='text-align:center; font-size: 9px; font-weight:bold;'>Cancel<br>Subscription</div></html>";
            var bottomRightBtn = UICreator.createButton(text, null);
            bottomRightBtn.setBorderPainted(false);
            bottomRightBtn.setBorder(null);
            bottomRightBtn.setBackground(new Color(0, 0, 0, 0));

            bottomPanel.add(bottomLeftBtn, BorderLayout.WEST);
            bottomPanel.add(bottomRightBtn, BorderLayout.EAST);

            vaultContent.add(topContainer, BorderLayout.NORTH);
            vaultContent.add(image, BorderLayout.CENTER);
            vaultContent.add(bottomPanel, BorderLayout.SOUTH);

            vaultContainer.add(vaultContent, BorderLayout.CENTER);
//            vaultsPanel.add(vaultContainer);

            this.add(vaultContainer);
        }


        revalidate();
        repaint();
    }

}

