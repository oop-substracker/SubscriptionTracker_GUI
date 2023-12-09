package util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DropShadowCreator extends JPanel {
    private static final long serialVersionUID = 1L;

    private int top, left, bottom, right;

    public DropShadowCreator(int top, int left, int bottom, int right) {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
        Border border = BorderFactory.createEmptyBorder(top, left, bottom, right);
        this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), border));
        this.setLayout(new BorderLayout());

    }

    @Override
    protected void paintComponent(Graphics g) {
        int shadowOpacity = 80;

        Graphics2D g2d = (Graphics2D) g.create();

        // Top shadow
        for (int i = 0; i < top; i++) {
            g2d.setColor(new Color(0, 0, 0, (shadowOpacity / top) * i));
            g2d.drawLine(0, i, getWidth() - 1, i);
        }

        // Left shadow
        for (int i = 0; i < left; i++) {
            g2d.setColor(new Color(0, 0, 0, (shadowOpacity / left) * i));
            g2d.drawLine(i, 0, i, getHeight() - 1);
        }

        // Bottom shadow
        for (int i = 0; i < bottom; i++) {
            g2d.setColor(new Color(0, 0, 0, (shadowOpacity / bottom) * i));
            g2d.drawLine(0, getHeight() - 1 - i, getWidth() - 1, getHeight() - 1 - i);
        }

        // Right shadow
        for (int i = 0; i < right; i++) {
            g2d.setColor(new Color(0, 0, 0, (shadowOpacity / right) * i));
            g2d.drawLine(getWidth() - 1 - i, 0, getWidth() - 1 - i, getHeight() - 1);
        }

        g2d.dispose();
    }


}