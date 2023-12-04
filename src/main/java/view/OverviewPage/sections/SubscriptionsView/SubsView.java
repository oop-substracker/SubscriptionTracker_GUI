package view.OverviewPage.sections.SubscriptionsView;

import javax.swing.*;
import java.awt.*;
import util.UICreator;
import java.util.List;
import java.util.ArrayList;

import model.Subscriptions.SubscriptionList;
import model.Subscriptions.Subscription;
import util.DropShadowCreator;

import view.OverviewPage.sections.SubscriptionsView.SubscriptionVault;

public class SubsView extends JPanel {

    private JPanel topPanel;
    private JButton filterBtn;
    private JButton addAcctBtn;
    private SubscriptionVault subscriptionVault;

    /*==============*/
//    SubscriptionList subscriptionLists = new SubscriptionList();
//    List<Subscription> subscriptionList = SubscriptionList.getSubscriptionList();
    /*==============*/

    public SubsView() {
        this.setLayout(new BorderLayout());
        initTop();
        subscriptionVault = new SubscriptionVault();

        JScrollPane scrollPane = new JScrollPane(subscriptionVault);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        this.setBorder(BorderFactory.createEmptyBorder(20, 0, 0 , 0));
    }

    private void initTop() {
        topPanel = new JPanel(new BorderLayout());

        var topLabel = UICreator.createLabel("Active Subscriptions", 20, Font.BOLD);

        var btnsPanel = new JPanel(new FlowLayout());
        filterBtn = UICreator.createButton("Filter", UICreator.createImage("/icons/assets/filter.png", 15, 15));
        addAcctBtn = UICreator.createButton("Add Account", UICreator.createImage("/icons/assets/create.png", 15, 15));
        btnsPanel.add(filterBtn);
        btnsPanel.add(addAcctBtn);

        topPanel.add(topLabel, BorderLayout.WEST);
        topPanel.add(btnsPanel, BorderLayout.EAST);
    }

//
//    private void initSubscriptionVaults() {
//        vaultsPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
//
//        for(Subscription vault: subscriptionList) {
//            var vaultContainer = new DropShadowCreator(5,5,5,5);
//            vaultContainer.setLayout(new BorderLayout());
//            var vaultContent = new JPanel(new BorderLayout());
//
//            /* 1st vault */
//            var topContainer = new JPanel(new BorderLayout());
//            vaultContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 0 , 10));
//
//            var leftTop = new JPanel(new BorderLayout());
//            var remainingTimeLabel = UICreator.createLabel("Time Remaining", 13, Font.PLAIN);
//            var remainingTime = UICreator.createLabel(vault.getTimeRemaining(), 13, Font.BOLD);
//            Box boxLayout = Box.createVerticalBox();
//            boxLayout.add(remainingTimeLabel);
//            boxLayout.add(remainingTime);
//            leftTop.add(boxLayout, BorderLayout.CENTER);
//
//            var ellipses = UICreator.createLabel("⋮", 23, Font.BOLD);
//            ellipses.setBorder(BorderFactory.createEmptyBorder(-18, 0, 0 , 0));
//
//            topContainer.add(leftTop, BorderLayout.WEST);
//            topContainer.add(ellipses, BorderLayout.EAST);
//
//            // END OF TOP
//            var imagePanel = new JPanel(new BorderLayout());
//            imagePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
//            var image = new JLabel(UICreator.createImage("/icons/assets/growth-1.png", 250, 160));
//            imagePanel.add(image, BorderLayout.CENTER);
//
//            // END OF CENTER
//            var bottomPanel = new JPanel(new BorderLayout());
//            bottomPanel.setPreferredSize(new Dimension(getWidth(), 60));
//
//            String platform = "<html><div style='font-size:15px; font-weight:bold;'>"+ vault.getPlatform() +"</html>";
//            var bottomLeftBtn = UICreator.createButton(platform, UICreator.createImage("/icons/assets/spotify.png", 40, 40));
//            bottomLeftBtn.setMargin(new Insets(0, -1, 0, 0 ));
//            bottomLeftBtn.setBorderPainted(false);
//            bottomLeftBtn.setBackground(new Color(0, 0, 0, 0));
//            bottomLeftBtn.setBorder(null);
//
//            String text = "<html><div style='text-align:center; font-size: 9px; font-weight:bold;'>Cancel<br>Subscription</div></html>";
//            var bottomRightBtn = UICreator.createButton(text, null);
//            bottomRightBtn.setBorderPainted(false);
//            bottomRightBtn.setBorder(null);
//            bottomRightBtn.setBackground(new Color(0, 0, 0, 0));
//
//            bottomPanel.add(bottomLeftBtn, BorderLayout.WEST);
//            bottomPanel.add(bottomRightBtn, BorderLayout.EAST);
//
//            vaultContent.add(topContainer, BorderLayout.NORTH);
//            vaultContent.add(image, BorderLayout.CENTER);
//            vaultContent.add(bottomPanel, BorderLayout.SOUTH);
//
//            vaultContainer.add(vaultContent, BorderLayout.CENTER);
//            vaultsPanel.add(vaultContainer);
//        }
//    }

//    public void updateSubscriptionVaults(List<Subscription> subscriptionList) {
//        JPanel vaultsPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
//
//        for (Subscription vault : subscriptionList) {
//            var vaultContainer = new DropShadowCreator(5, 5, 5, 5);
////            vaultContainer.setPreferredSize(new Dimension(300, getHeight()));
//            vaultContainer.setLayout(new BorderLayout());
//            var vaultContent = new JPanel(new BorderLayout());
//
//            var topContainer = new JPanel(new BorderLayout());
//            vaultContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
//
//            var leftTop = new JPanel(new BorderLayout());
//            var remainingTimeLabel = UICreator.createLabel("Time Remaining", 13, Font.PLAIN);
//            var remainingTime = UICreator.createLabel(vault.getTimeRemaining(), 13, Font.BOLD);
//            Box boxLayout = Box.createVerticalBox();
//            boxLayout.add(remainingTimeLabel);
//            boxLayout.add(remainingTime);
//            leftTop.add(boxLayout, BorderLayout.CENTER);
//
//            var ellipses = UICreator.createLabel("⋮", 23, Font.BOLD);
//            ellipses.setBorder(BorderFactory.createEmptyBorder(-18, 0, 0, 0));
//
//            topContainer.add(leftTop, BorderLayout.WEST);
//            topContainer.add(ellipses, BorderLayout.EAST);
//
//            // END OF TOP
//            var imagePanel = new JPanel(new BorderLayout());
//            imagePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
//            var image = new JLabel(UICreator.createImage("/icons/assets/growth-1.png", 250, 160));
//            imagePanel.add(image, BorderLayout.CENTER);
//
//            // END OF CENTER
//            var bottomPanel = new JPanel(new BorderLayout());
//            bottomPanel.setPreferredSize(new Dimension(getWidth(), 60));
//
//            String platform = "<html><div style='font-size:15px; font-weight:bold;'>" + vault.getPlatform() + "</html>";
//            var bottomLeftBtn = UICreator.createButton(platform, UICreator.createImage("/icons/assets/spotify.png", 40, 40));
//            bottomLeftBtn.setMargin(new Insets(0, -1, 0, 0));
//            bottomLeftBtn.setBorderPainted(false);
//            bottomLeftBtn.setBackground(new Color(0, 0, 0, 0));
//            bottomLeftBtn.setBorder(null);
//
//            String text = "<html><div style='text-align:center; font-size: 9px; font-weight:bold;'>Cancel<br>Subscription</div></html>";
//            var bottomRightBtn = UICreator.createButton(text, null);
//            bottomRightBtn.setBorderPainted(false);
//            bottomRightBtn.setBorder(null);
//            bottomRightBtn.setBackground(new Color(0, 0, 0, 0));
//
//            bottomPanel.add(bottomLeftBtn, BorderLayout.WEST);
//            bottomPanel.add(bottomRightBtn, BorderLayout.EAST);
//
//            vaultContent.add(topContainer, BorderLayout.NORTH);
//            vaultContent.add(image, BorderLayout.CENTER);
//            vaultContent.add(bottomPanel, BorderLayout.SOUTH);
//
//            vaultContainer.add(vaultContent, BorderLayout.CENTER);
//            vaultsPanel.add(vaultContainer);
//        }
//
//        JScrollPane scrollPane = new JScrollPane(vaultsPanel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setBorder(null);
//        this.add(scrollPane, BorderLayout.CENTER);
//
//
//        this.revalidate();
//        this.repaint();
//    }


    public SubscriptionVault getSubscriptionVault() {
        return subscriptionVault;
    }
}
