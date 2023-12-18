package util;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        JTextField textField = new JTextField();
        textField.putClientProperty("JComponent.roundRect", true);
        textField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholder);
        textField.setFont(new Font(regularFont.getFamily(), Font.PLAIN, 13));
//        textField.setFocusable(false);


        return textField;
    }

    public static ImageIcon createImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(UICreator.class.getResource(path)));
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static ImageIcon resizedImage(ImageIcon image, int width, int height) {
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static JButton createButton(boolean rounded, String text, int fontSize, int weight, ImageIcon icon, int arcWidth, int arcHeight) {
        JButton button;

        if (rounded) {
            button =new RoundedButton(text, arcWidth, arcHeight);
            configureTransparentButton(button);
        } else {
            button = new JButton(text);
        }
        if (icon != null)
            button.setIcon(icon);
        button.setText(text);
        button.setFont(new Font(weight == 1 ? boldFont.getFamily() : regularFont.getFamily(), weight, fontSize));

        return button;
    }

    public static void iconChanger(JButton button, String path, int w, int h)  {
        ImageIcon image = createImage(path, w, h);
        button.setIcon(image);
    }

    public static Instant parseStringToInstant(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
                .withZone(ZoneId.systemDefault());

        LocalDate localDate = LocalDate.parse(dateString, formatter);

        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
    }

    public static String formatInstantToString(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
    }


    public static void configureTransparentButton(AbstractButton button) {
        button.setMargin(new Insets(0, -1, 0, 0));
//        button.setBorderPainted(false);
//        button.setContentAreaFilled(false);
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

    public static void createComp(JPanel panel, Component comp, int xPos, int yPos, int gridWidth, int gridHeight, double weightX, double weightY, int anchor, int fill, int top, int left, int bottom, int right, int ipady, int  ipadx) {
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = xPos;
        gc.gridy = yPos;
        gc.gridwidth = gridWidth;
        gc.gridheight = gridHeight;
        gc.weightx = weightX;
        gc.weighty = weightY;
        gc.ipady = ipady;
        gc.ipadx = 50;
        gc.anchor = anchor;
        gc.insets = new Insets(top, left, bottom, right);
        gc.fill = fill;


        panel.add(comp, gc);
    }

    public static JPasswordField createJPassword() {
        JPasswordField  jP = new JPasswordField();
        jP.putClientProperty("JComponent.roundRect", true);
        jP.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
        jP.setFont(new Font(regularFont.getFamily(), Font.PLAIN, 13));
        jP.putClientProperty("JPasswordField.showViewIcon", Boolean.FALSE);
        UIManager.put("PasswordField.showCapsLock", Boolean.FALSE);
        return jP;
    }

    public static Font getRegularFont() {
        return regularFont;
    }

    public static Font getBoldFont() {
        return boldFont;
    }
}
