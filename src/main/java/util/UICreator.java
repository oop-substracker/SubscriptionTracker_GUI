package util;

import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UICreator {
    public static JLabel createLabel(String text, int size, int weight) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(FlatJetBrainsMonoFont.FAMILY, weight, size));

        return label;
    }

    public static JLabel createLabelWithImage(String text, int size, int weight, String path, int imageWidth, int imageHeight) {
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(UICreator.class.getResource(path)));
        ImageIcon res = new ImageIcon(icon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(res);
        label.setText(text);
        label.setFont(new Font(FlatJetBrainsMonoFont.FAMILY, weight, size));

        return label;
    }

    public static JLabel createLabelWithImage(String text, int size, int weight, ImageIcon image, int imageWidth, int imageHeight) {
        ImageIcon res = new ImageIcon(image.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(res);
        label.setText(text);
        label.setFont(new Font(FlatJetBrainsMonoFont.FAMILY, weight, size));

        return label;
    }

    public static JTextField createTxtField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font(FlatJetBrainsMonoFont.FAMILY, Font.PLAIN, 13));

        return textField;
    }

    public static ImageIcon createImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(UICreator.class.getResource(path)));
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static ImageIcon resizedImage(ImageIcon image, int width, int height) {
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static JButton createButton(String text, ImageIcon icon) {
        JButton button = new JButton();
        if (icon != null)
            button.setIcon(icon);
        button.setText(text);
        button.setFont(new Font(FlatJetBrainsMonoFont.FAMILY, Font.PLAIN, 13));

        return button;
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
