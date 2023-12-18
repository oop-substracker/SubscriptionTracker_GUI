package util;

import javax.swing.*;

public class RoundedComboBox<T> extends JComboBox<T> {

    public RoundedComboBox(T[] items) {
        super(items);
        setBorder(new RoundedCornerBorder());
    }
}
