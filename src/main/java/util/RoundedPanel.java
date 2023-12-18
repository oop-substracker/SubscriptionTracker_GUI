package util;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private Color backgroundColor;
    private int cornerRadius = 20;
    private float borderWidth = 2.0f; // Set the desired border width
    private boolean  setStroke;

    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
        setBorder(null); // Set the border to be empty
    }

    public RoundedPanel(LayoutManager layout, int radius, Color bgColor, boolean setStroke) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
        this.setStroke =setStroke;
        setBorder(null); // Set the border to be empty
    }

    public RoundedPanel(int radius, boolean setStroke) {
        super();
        cornerRadius = radius;
        this.setStroke = setStroke;
        setBorder(null); // Set the border to be empty
    }

    public RoundedPanel(int radius, Color bgColor, boolean setStroke) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
        this.setStroke = setStroke;
        setBorder(null); // Set the border to be empty
    }

    public RoundedPanel(LayoutManager layout, int radius, boolean setStroke) {
        super(layout);
        cornerRadius = radius;
        this.setStroke =setStroke;
        setBorder(null); // Set the border to be empty
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }

        // Fill the rounded rectangle (including the border)
        graphics.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);

        if (setStroke) {
            // Set the color for the border to green
            graphics.setColor(Color.BLACK);

            // Set the stroke for the border (increase thickness)
            graphics.setStroke(new BasicStroke(borderWidth));
        } else {
            graphics.setColor(getForeground());
        }


        // Draw the rounded border
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }
}
