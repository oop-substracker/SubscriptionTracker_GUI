package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class UICreator {

    private static Font regularFont;
    private static Font boldFont;

    public static void setDefaultFont(Font regularFont, Font boldFont) {
        UICreator.regularFont = regularFont;
        UICreator.boldFont = boldFont;
    }

    public static JLabel createLabel(String text, int size, int weight) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(weight == 1 ? boldFont.getFamily() : regularFont.getFamily(), weight, size));

        return label;
    }

    public static JLabel createLabelWithImage(String text, int size, int weight, String path, int imageWidth, int imageHeight) {
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(UICreator.class.getResource(path)));
        ImageIcon res = new ImageIcon(icon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(res);
        label.setText(text);
        label.setFont(new Font(weight == 1 ? boldFont.getFamily() : regularFont.getFamily(), weight, size));

        return label;
    }

    public static JLabel createLabelWithImage(String text, int size, int weight, ImageIcon image, int imageWidth, int imageHeight) {
        ImageIcon res = new ImageIcon(image.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(res);
        label.setText(text);
        label.setFont(new Font(weight == 1 ? boldFont.getFamily() : regularFont.getFamily(), weight, size));

        return label;
    }

    public static JTextField createTxtField(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.setFont(new Font(regularFont.getFamily(), Font.PLAIN, 13));

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        // Add mouse click listener to clear the placeholder when clicked
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
        });

        return textField;
    }

    public static ImageIcon createImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(UICreator.class.getResource(path)));
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static ImageIcon resizedImage(ImageIcon image, int width, int height) {
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static JButton createButton(String text, int fontSize, int weight, ImageIcon icon) {
        JButton button = new JButton();
        if (icon != null)
            button.setIcon(icon);
        button.setText(text);
        button.setFont(new Font(weight == 1 ? boldFont.getFamily() : regularFont.getFamily(), weight, fontSize));

        return button;
    }

    public static void configureTransparentButton(AbstractButton button) {
        button.setMargin(new Insets(0, -1, 0, 0));
//        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
    }

    public static void createComp(JPanel panel, Component comp, int xPos, int yPos, int gridWidth, int gridHeight, double weightX, double weightY, int anchor, int fill, int top, int left, int bottom, int right, int ipady) {
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = xPos;
        gc.gridy = yPos;
        gc.gridwidth = gridWidth;
        gc.gridheight = gridHeight;
        gc.weightx = weightX;
        gc.weighty = weightY;
        gc.ipady = ipady;
//        gc.ipadx = 50;
        gc.anchor = anchor;
        gc.insets = new Insets(top, left, bottom, right);
        gc.fill = fill;


        panel.add(comp, gc);
    }
}
