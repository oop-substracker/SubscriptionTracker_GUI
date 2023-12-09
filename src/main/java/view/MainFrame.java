package view;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.WindowStateListener;
import java.io.File;

import util.UICreator;
import view.AuthPage.Register;
import view.AuthPage.Login;
import view.OverviewPage.Overview;
import view.SideBar2.SideBar;
import view.AccountsPage.AccountsPage;
import view.PaymentsHistoryPage.PaymentsHistoryPage;
import view.BillingPage.BillingPage;

public class MainFrame extends JFrame  {

    private Register register;
    private Login login;
    private SideBar sideBar;
    private Overview overview;
    private AccountsPage accountsPage;
    private PaymentsHistoryPage paymentsHistoryPage;
    private BillingPage billingPage;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        initCustomFonts();
        register = new Register();
        login = new Login();
        sideBar = new SideBar();
        overview = new Overview();
        accountsPage = new AccountsPage();
        paymentsHistoryPage = new PaymentsHistoryPage();
        billingPage = new BillingPage();
        setSize(new Dimension(1024, 700));
        setMinimumSize(new Dimension(800, this.getHeight()));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());


        this.add(register, BorderLayout.CENTER);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
    }

    public void setWindowsListener(WindowStateListener listener) { this.addWindowStateListener((WindowStateListener) listener);}

    public void addToCardPanel(JPanel panel, String name) {
        this.cardPanel.add(panel, name);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public PaymentsHistoryPage getPaymentsHistoryPage() {
        return paymentsHistoryPage;
    }

    public BillingPage getBillingPage() {
        return billingPage;
    }

    public AccountsPage getAccountsPage() {
        return accountsPage;
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

    private void initCustomFonts() {
        try {
            Font jetBrainsMonoFontRegular = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Lenovo\\Desktop\\SubsciptionsTracker\\src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Regular.ttf"));
            Font jetBrainsMonoFontBold = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Lenovo\\Desktop\\SubsciptionsTracker\\src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Bold.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Lenovo\\Desktop\\SubsciptionsTracker\\src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Regular.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Lenovo\\Desktop\\SubsciptionsTracker\\src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Bold.ttf")));


            UICreator.setDefaultFont(jetBrainsMonoFontRegular, jetBrainsMonoFontBold);


            SwingUtilities.invokeLater(() -> {
                setUIFont(jetBrainsMonoFontRegular);;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void setUIFont(Font font) {
        UIDefaults defaults = UIManager.getDefaults();

        for (Object key : defaults.keySet()) {
            if (defaults.get(key) instanceof FontUIResource) {
                defaults.put(key, new FontUIResource(font));
            }
        }

        FontUIResource labelFont = new FontUIResource(font);
        FontUIResource textFieldFont = new FontUIResource(font);
        FontUIResource buttonFont = new FontUIResource(font.getFamily(), Font.PLAIN, 14);
        FontUIResource tabbedPaneFont = new FontUIResource(font);

        UIManager.put("Label.font", labelFont);
        UIManager.put("TextField.font", textFieldFont);
        UIManager.put("Button.font", buttonFont);
//        UIManager.put("TabbedPane.font", tabbedPaneFont);
//        UIManager.put("TabbedPane.font", new FontUIResource(font));

        UIManager.put("Button.focus", UIManager.getColor("Button.background"));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}