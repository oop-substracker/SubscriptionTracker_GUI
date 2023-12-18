package view.OverviewPage.sections.SubscriptionsView;

import controller.Controller;
import model.Subscriptions.Subscription;
import util.RoundedPanelWithShadow;
import util.UICreator;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SubscriptionVault extends JPanel {

    public SubscriptionVault() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
    }

    public void updateSubscriptionVaults(List<Subscription> subscriptionList) {
        removeAll();

        for (Subscription vault : subscriptionList) {
            if (vault.getTimeRemaining() > 0) {
                createSubscriptionPanel(vault);
            }
        }

        SwingUtilities.invokeLater(() -> {
            SwingUtilities.updateComponentTreeUI(this);
            revalidate();
            repaint();
        });
    }

    private void createSubscriptionPanel(Subscription vault) {
        var vaultContainer = new JPanel();
        vaultContainer.setPreferredSize(new Dimension(275, 245));
        vaultContainer.setLayout(new BorderLayout());

        var vaultContent = new RoundedPanelWithShadow();
        vaultContent.setLayout(new BorderLayout());
        vaultContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 6, 10));

        createTopContainer(vault, vaultContent);

        var imagePanel = createImagePanel(vault);
        var bottomPanel = createBottomPanel(vault);

        vaultContent.add(imagePanel, BorderLayout.CENTER);
        vaultContent.add(bottomPanel, BorderLayout.SOUTH);

        vaultContainer.add(vaultContent, BorderLayout.CENTER);
        this.add(vaultContainer);
        this.add(Box.createHorizontalStrut(0));
    }

    private void createTopContainer(Subscription vault, JPanel vaultContent) {
        var topContainer = new JPanel(new BorderLayout());
        var leftTop = new JPanel(new BorderLayout());

        var remainingTimeLabel = UICreator.createLabel("Time Remaining", 14, Font.PLAIN);
        var remainingTime = UICreator.createLabel("", 14, Font.BOLD);

        vault.updateRemainingTime();
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            vault.updateElapsedTime(remainingTime);
            SwingUtilities.invokeLater(() -> remainingTime.repaint()); // Ensure thread safety
        }, 0, 1000, TimeUnit.MILLISECONDS);

        Box boxLayout = Box.createVerticalBox();
        boxLayout.add(remainingTimeLabel);
        boxLayout.add(remainingTime);
        leftTop.add(boxLayout, BorderLayout.CENTER);

        String el = "<html><div style='line-height: 10px;'>⋮</div></html>";
        var ellipses = UICreator.createLabel(el, 23, Font.BOLD);
        ellipses.setBorder(BorderFactory.createEmptyBorder(-18, 0, 0, 0));

        topContainer.add(leftTop, BorderLayout.WEST);
        topContainer.add(ellipses, BorderLayout.EAST);

        vaultContent.add(topContainer, BorderLayout.NORTH);
    }

    private JPanel createImagePanel(Subscription vault) {
        var imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        var image = new JLabel(UICreator.createImage("/icons/assets/subs-logo-4.png", 250, 145));
        imagePanel.add(image, BorderLayout.CENTER);
        return imagePanel;
    }

    private JPanel createBottomPanel(Subscription vault) {
        var bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 45));

        String platform = "<html><div style='font-size:15px; font-weight:bold;'>" + vault.getPlatform() + "</html>";
        var bottomLeftBtn = UICreator.createButton(false, platform, 14, Font.PLAIN, UICreator.createImage("/images/icons/" + vault.getPlatform() + ".png", 35, 35), 0, 0);
        configureTransparentButton(bottomLeftBtn);

        String text = "<html><div style='text-align:center; font-size: 9px; font-weight:bold;'>Cancel<br>Subscription</div></html>";
        var bottomRightBtn = UICreator.createButton(false, text, 14, Font.PLAIN, null, 0, 0);
        configureTransparentButton(bottomRightBtn);
        bottomRightBtn.addActionListener(e  -> {
            Controller.deleteSubscription(vault.getId());
        });

        bottomPanel.add(bottomLeftBtn, BorderLayout.WEST);
        bottomPanel.add(bottomRightBtn, BorderLayout.EAST);

        return bottomPanel;
    }

    private void configureTransparentButton(AbstractButton button) {
        button.setMargin(new Insets(0, -1, 0, 0));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
    }
}
