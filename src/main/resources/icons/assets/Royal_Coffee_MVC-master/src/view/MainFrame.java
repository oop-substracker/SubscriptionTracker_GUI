package view;

import view.components.Header;
import view.components.Menu;
import view.components.Sidebar;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    Header header;
    Menu menu;
    Sidebar sidebar;

    public MainFrame() {
        initMainFrame();

        header = new Header();
        menu = new Menu();
        sidebar = new Sidebar();

        this.add(header, BorderLayout.NORTH);
        this.add(menu, BorderLayout.CENTER);
        this.add(sidebar, BorderLayout.EAST);


    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public Header getHeader() {
        return header;
    }

    public Menu getMenu() {
        return menu;
    }

    private void initMainFrame() {
        this.setSize(1000, 700);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
