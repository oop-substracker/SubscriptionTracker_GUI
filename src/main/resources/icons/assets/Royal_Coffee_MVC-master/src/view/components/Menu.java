package view.components;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.DefaultProducts.ProductList;
import model.DefaultProducts.ProductItem;
import model.CartDetails.CartItem;

public class Menu extends JPanel  {

    ProductList productList;
    JPanel menuList;

    private static List<ProductItem> defaultProducts;
    private static final List<ActionListener> radioListeners = new ArrayList<>();


    // btns panel
    JPanel buttonsPanel;
    JButton total, receipt, reset, exit;

    public Menu() {
        this.setLayout(new BorderLayout());
        productList = new ProductList();
        defaultProducts = ProductList.getProductList();
        initDefaultProducts();
        initButtonsPanel();

        this.add(menuList, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void initDefaultProducts() {
        JLabel menuLabel = createLabel("Menu Items", 20);
        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuLabel.setVerticalAlignment(SwingConstants.CENTER);

        menuList = new JPanel(new GridLayout(3, 5, 10, 10));
        final int[] quantity = new int[1];
        for (ProductItem item: defaultProducts) {

            JPanel menuItem = new JPanel(new GridBagLayout());
            menuItem.setBackground(Color.WHITE);
//            menuItem.setBorder(new LineBorder(Color.GRAY, 1));

            Image image = item.getImagePath();
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setOpaque(true);
            createComp(menuItem, imageLabel, 0 ,0, 3, 5, 0.3, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

            JLabel itemName = createLabel(item.getProductName(), 17);
            itemName.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            itemName.setBackground(Color.WHITE);
            itemName.setOpaque(true);
            createComp(menuItem, itemName, 0 ,5, 3, 1, 0.3, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

            JPanel infoPanel = new JPanel(new GridLayout(3, 2, 3, 3));
            infoPanel.setBackground(Color.WHITE);
            JLabel priceLabel = createLabel("Price", 15);
            infoPanel.add(priceLabel);

            JLabel price = createLabel("$" + item.getPrice(), 15);
            infoPanel.add(price);

            JLabel qtyLabel = createLabel("Quantity", 15);
            infoPanel.add(qtyLabel);

            JPanel spinnerPanel = new JPanel();
            JRadioButton radio = new JRadioButton();
            spinnerPanel.setBackground(Color.WHITE);
            spinnerPanel.setLayout(null);
            SpinnerModel value =
                    new SpinnerNumberModel(0, //initial value
                            0, //minimum value
                            10, //maximum value
                            1); //step
            JSpinner spinner = new JSpinner(value);
            spinner.addChangeListener(e -> {
                quantity[0] = (int) spinner.getValue();
                if (quantity[0] != 0) {
                    radio.setEnabled(true);
                    radio.repaint();
                }
            });

            spinner.setBackground(Color.WHITE);
            // Get the editor from the spinner
            JComponent editor = ((JSpinner.DefaultEditor) spinner.getEditor());

            // Get the text field from the editor
            JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();

            // Set the vertical alignment on the text field
            tf.setHorizontalAlignment(JTextField.CENTER);
            spinner.setBounds(-5, 0, 50, 18);
            spinner.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

            spinnerPanel.add(spinner);

            infoPanel.add(spinnerPanel);

            JLabel purchaseLabel = createLabel("Purchase", 15);
            infoPanel.add(purchaseLabel);

            radio.setBackground(Color.WHITE);
            radio.addActionListener(e -> {
                if (quantity[0] != 0) {
                    fireSelectedProductChanged(item, quantity[0]);
                    quantity[0] = 0;
                    radio.setSelected(true);
                } else {
                    SwingUtilities.invokeLater(() -> {
                        radio.setEnabled(false);
                        radio.setSelected(false);
                        radio.repaint();
                    });
                }
            });

            infoPanel.add(radio);

            createComp(menuItem, infoPanel, 0 ,10, 1, 1, 0.1, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
            menuList.setBackground(Color.WHITE);
            menuList.add(menuItem);
        }
    }


    // Method to add ActionListener to the radio button
    public void addRadioListener(ActionListener listener) {
        radioListeners.add(listener);
    }

    // Notify all listeners about the selected product change and it typically includes information about the event
    private void fireSelectedProductChanged(ProductItem selectedItem, int quantity) {
        for (ActionListener listener : radioListeners) {
            listener.actionPerformed(new ActionEvent(selectedItem, ActionEvent.ACTION_PERFORMED, String.valueOf(quantity)));
        }
    }


    private void createComp(JPanel panel, JComponent comp, int xPos, int yPos, int gW, int gH, double wX, double wY, int anchor, int fill) {
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = xPos;
        gc.gridy = yPos;
        gc.gridwidth = gW;
        gc.gridheight = gH;
        gc.weightx = wX;
        gc.weighty = wY;
        // gc.insets = new Insets(5, 0, 5, 0);
        gc.anchor = anchor;
        gc.fill = fill;

        panel.add(comp, gc);
    }

    private JLabel createLabel(String title, int size) {
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, size));

        return label;
    }

    private void initButtonsPanel() {
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10,0));
        buttonsPanel.setPreferredSize(new Dimension(100, 50));

        total = createButton("Total", "rgb(191,139,255)");
        receipt = createButton("Receipt", "rgb(204,163,255)");
        reset = createButton("Reset",   "rgb(218,188,255)");
        exit = createButton("Exit", "rgb(229,208,255)");

        buttonsPanel.add(total);
        buttonsPanel.add(receipt);
        buttonsPanel.add(reset);
        buttonsPanel.add(exit);
    }

    private JButton createButton(String label, String color) {
        JButton btn = new JButton("<html><div style='padding: 2px 10px;'>" + label + "</div></html>");
        btn.setForeground(Color.WHITE);

        String[] colorValues = color.substring(4, color.length() - 1).split(",");
        int r = Integer.parseInt(colorValues[0].trim());
        int g = Integer.parseInt(colorValues[1].trim());
        int b = Integer.parseInt(colorValues[2].trim());

        btn.setBackground(new Color(r,g,b));
        btn.setFont(new Font("Arial", Font.BOLD, 15));
        return btn;
    }


}
