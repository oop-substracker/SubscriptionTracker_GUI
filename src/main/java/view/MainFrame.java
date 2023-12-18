package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowStateListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import util.UICreator;
import view.AccountsPage.AccountsPage;
import view.AuthPage.Login;
import view.AuthPage.Register;
import view.BillingPage.BillingPage;
import view.OverviewPage.Overview;
import view.PaymentsHistoryPage.PaymentsHistoryPage;
import view.SideBar.SideBar;

/**
 * The {@code MainFrame} class represents the main frame of the application,
 * serving as the primary container for various views and components.
 * It manages the initialization of key UI elements, such as the registration,
 * login, side bar, overview, accounts page, payments history page, and billing page.
 * The frame employs a card layout to dynamically switch between different views.
 * Custom fonts, including JetBrains Mono in regular and bold styles, are applied
 * to maintain a consistent and visually appealing appearance across the application.
 * The frame adheres to the FlatMacLightLaf look and feel for a clean and modern user interface.
 * It also provides methods for accessing and manipulating specific pages and components.
 * Additionally, window state listeners can be added to the frame for handling state changes.
 */
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

    /**
     * Constructs a new instance of the MainFrame.
     */
    public MainFrame() {
        initDefaults();
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

    public  MainFrame getMainFrame() { return this; }

    private void initCustomFonts() {
        try {
            Font jetBrainsMonoFontRegular = Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Regular.ttf"));
            Font jetBrainsMonoFontBold = Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Bold.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Regular.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\resources\\custom_fonts\\fonts\\ttf\\JetBrainsMono-Bold.ttf")));


            UICreator.setDefaultFont(jetBrainsMonoFontRegular, jetBrainsMonoFontBold);

            Font kristiFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\resources\\custom_fonts\\rimiba\\King-Rimba-400.ttf"));
            GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge1.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\main\\resources\\custom_fonts\\rimiba\\King-Rimba-400.ttf")));

            UICreator.setLogoFont(kristiFont);

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
        UIManager.put("ScrollPane.border", Boolean.FALSE);
        UIManager.put("Button.focus", UIManager.getColor("Button.background"));
    }

    private void initDefaults() {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.themes.FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
            System.err.println("Failed to initialize LaF");
        }
    }

}
