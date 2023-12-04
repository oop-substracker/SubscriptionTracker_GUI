package util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DropShadowCreatorForAllSides extends JPanel {
    private static final long serialVersionUID = 1L;

    private int top, left, bottom, right;

    public DropShadowCreatorForAllSides(int top, int left, int bottom, int right) {
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
        int shade = 0;
        int topOpacity = 80;
        for (int i = 0; i < right; i++) {
            g.setColor(new Color(shade, shade, shade, ((topOpacity / right) * i)));
            g.drawRect(i, i, this.getWidth() - ((i * 2) + 1), this.getHeight() - ((i * 2) + 1));
        }
    }
}