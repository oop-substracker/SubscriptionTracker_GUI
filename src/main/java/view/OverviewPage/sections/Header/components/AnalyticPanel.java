package view.OverviewPage.sections.Header.components;

import javax.swing.*;
import java.awt.*;

import util.DropShadowCreatorForAllSides;
import util.RoundedPanelWithShadow;
import util.UICreator;

public class AnalyticPanel extends JPanel {

    private JLabel subsCount;
    private JLabel ads;
    private JLabel income;
    private JLabel rate;

    public AnalyticPanel() {
        setLayout(new GridLayout(1, 4, 10, 5));
        this.setPreferredSize(new Dimension(getWidth(), 100));

        init();
    }

    public void init() {

        JPanel subsCountPanel =  new JPanel(new BorderLayout());
        var container1 = new RoundedPanelWithShadow();
        container1.setBackground(Color.decode("#FFFFFF"));
        container1.setLayout(new BorderLayout());
        container1.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        subsCountPanel.setPreferredSize(new Dimension(400, 200));
        var subsText = UICreator.createLabel("Subscription count", 13, Font.BOLD);
        subsCount = UICreator.createLabel("6", 25, Font.BOLD);
        var subsImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
        container1.add(subsText, BorderLayout.NORTH);
        container1.add(subsCount, BorderLayout.WEST);
        container1.add(subsImage, BorderLayout.CENTER);
        subsCountPanel.add(container1, BorderLayout.CENTER);

        JPanel addsPanel = new JPanel(new BorderLayout());
        var container2 = new RoundedPanelWithShadow();
        container2.setLayout(new BorderLayout());
        container2.setBackground(Color.decode("#FFFFFF"));
        container2.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        addsPanel.setPreferredSize(new Dimension(400, 200));
        var addsText = UICreator.createLabel("Overall ads", 13, Font.BOLD);
        ads = UICreator.createLabel("35", 25, Font.BOLD);
        var adsImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
        container2.add(addsText, BorderLayout.NORTH);
        container2.add(ads, BorderLayout.WEST);
        container2.add(adsImage, BorderLayout.CENTER);
        addsPanel.add(container2, BorderLayout.CENTER);

        JPanel incomePanel =  new JPanel(new BorderLayout());
        var container3 = new RoundedPanelWithShadow();
        container3.setBackground(Color.decode("#FFFFFF"));
        container3.setLayout(new BorderLayout());
        container3.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        incomePanel.setPreferredSize(new Dimension(400, 200));
        var incomeText = UICreator.createLabel("Income status", 13, Font.BOLD);
        income = UICreator.createLabel("24", 25, Font.BOLD);
        var incomeImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
        container3.add(incomeText, BorderLayout.NORTH);
        container3.add(income, BorderLayout.WEST);
        container3.add(incomeImage, BorderLayout.CENTER);
        incomePanel.add(container3, BorderLayout.CENTER);

        JPanel ratePanel =  new JPanel(new BorderLayout());
        var container4 = new RoundedPanelWithShadow();
        container4.setBackground(Color.decode("#FFFFFF"));
        container4.setLayout(new BorderLayout());
        container4.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        ratePanel.setPreferredSize(new Dimension(400, 200));
        var rateText = UICreator.createLabel("Conversion rate", 13, Font.BOLD);
        rate = UICreator.createLabel("345k", 25, Font.BOLD);
        var rateImage = new JLabel(UICreator.createImage("/icons/assets/pulse-1.png", 100, 50));
        container4.add(rateText, BorderLayout.NORTH);
        container4.add(rate, BorderLayout.WEST);
        container4.add(rateImage, BorderLayout.CENTER);
        ratePanel.add(container4, BorderLayout.CENTER);

        this.add(subsCountPanel);
        this.add(addsPanel);
        this.add(incomePanel);
        this.add(ratePanel);

        UIManager.put("Panel.background", null);
    }
}
