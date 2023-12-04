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
        int shadowSize = Math.max(Math.max(top, left), Math.max(bottom, right));
        int topOpacity = 80;

        for (int i = 0; i < shadowSize; i++) {
            if (i < top && i < getHeight() - bottom) {
                int alpha = (int) ((topOpacity / (double) top) * i);
                g.setColor(new Color(0, 0, 0, alpha));
                g.drawLine(0, i, getWidth() - right - 1, i);
            }

            if (i < left && i < getWidth() - right) {
                int alpha = (int) ((topOpacity / (double) left) * i);
                g.setColor(new Color(0, 0, 0, alpha));
                g.drawLine(i, 0, i, getHeight() - bottom - 1);
            }

            if (i < bottom && i < getHeight() - top) {
                int alpha = (int) ((topOpacity / (double) bottom) * i);
                g.setColor(new Color(0, 0, 0, alpha));
                g.drawLine(0, getHeight() - i - 1, getWidth() - right - 1, getHeight() - i - 1);
            }

            if (i < right && i < getWidth() - left) {
                int alpha = (int) ((topOpacity / (double) right) * i);
                g.setColor(new Color(0, 0, 0, alpha));
                g.drawLine(getWidth() - i - 1, 0, getWidth() - i - 1, getHeight() - top - 1);
            }
        }

        //
        }
    }
