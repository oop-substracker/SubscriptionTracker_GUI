package util;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private static final int ARC_WIDTH = 28;
    private static final int ARC_HEIGHT = 28;

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    public RoundedButton(ImageIcon icon, String text) {
        super(icon);
        setText(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, ARC_WIDTH, ARC_HEIGHT);

        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        // Draw the border
        g2.setColor(getForeground());
        g2.draw(roundedRectangle);

        g2.dispose();

        super.paintComponent(g);
    }
}