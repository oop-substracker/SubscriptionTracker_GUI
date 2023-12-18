package view.components;

import java.awt.*;
import javax.swing.*;
public class Header extends JPanel {

    public Header() {
        createHeaderPanel();
        createHeaderContent();
    }

    private void createHeaderPanel() {
        this.setPreferredSize(new Dimension(getWidth(), 60));
        this.setLayout(new BorderLayout());
    }

    private void createHeaderContent() {
        var logo = createLabel("Royal Cafe", 25);

        var timePanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        timePanel.setBackground(Color.WHITE);
        timePanel.setBorder(BorderFactory.createEmptyBorder(16, 0, 0, 0));
        var timeLabel = createLabel("10:52:22 PM", 15);
        var dateLabel =  createLabel("Thursday, 1-07-2023", 15);
        timePanel.add(timeLabel);
        timePanel.add(dateLabel);

        this.add(logo, BorderLayout.WEST);
        this.setBackground(Color.WHITE);
        this.add(timePanel, BorderLayout.EAST);
    }

    private JLabel createLabel(String title, int size) {
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, size));

        return label;
    }

}
