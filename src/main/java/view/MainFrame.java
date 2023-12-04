package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowStateListener;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import view.AuthPage.Register;
import view.AuthPage.Login;
import view.OverviewPage.Overview;
import view.SideBar.SideBar;
import controller.Controller;

public class MainFrame extends JFrame {

    private Register register;
    private Login login;
    private SideBar sideBar;
    private Overview overview;

    public MainFrame() {
        register = new Register();
        login = new Login();
        sideBar = new SideBar();
        overview = new Overview();
//        setSize(new Dimension(1450, 760));
        setSize(new Dimension(1024, 700));
        setMinimumSize(new Dimension(800, this.getHeight()));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(register, BorderLayout.CENTER);
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public Overview getOverview() {
        return overview;
    }

    public void addWindowsStateListener(WindowStateListener ls) {
        this.addWindowStateListener(ls);
    }

    public Register getRegister() {
        return register;
    }

    public Login getLogin() {
        return login;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            FlatLightLaf.registerCustomDefaultsSource("themes");
            FlatJetBrainsMonoFont.install();
            FlatLaf.setPreferredMonospacedFontFamily(FlatJetBrainsMonoFont.FAMILY);
            FlatMacLightLaf.setup();

            MainFrame frame = new MainFrame();
            frame.setVisible(true);

            Controller controller = new Controller(frame);
        });

    }


}
