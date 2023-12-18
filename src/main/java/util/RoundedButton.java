package util;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private  int ARC_WIDTH;
    private  int ARC_HEIGHT;

    public RoundedButton(String text,  int width, int height) {
        super(text);
        setContentAreaFilled(false);
        ARC_WIDTH = width;
        ARC_HEIGHT = height;
    }

    public RoundedButton(ImageIcon icon, String text, int width, int height) {
        super(icon);
        setText(text);
        setContentAreaFilled(false);
        ARC_WIDTH = width;
        ARC_HEIGHT = height;

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