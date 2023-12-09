package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import model.DefaultEntries.Entry;
import model.Subscriptions.Subscription;
import model.Subscriptions.SubscriptionList;
import model.UserAccount.User;
import model.DefaultEntries.EntryList;

import view.AccountsPage.components.VaultModal;
import view.AuthPage.Login;
import view.AuthPage.Register;
import view.MainFrame;
import view.SideBar2.SideBar;
import view.OverviewPage.Overview;
import view.OverviewPage.sections.SubscriptionsView.SubsView;
import view.OverviewPage.sections.CreateEntryView.CreateEntryView;
import view.EntryCreationView.EntryCreationPage;
import view.OverviewPage.sections.SubscriptionsView.SubscriptionVault;
import view.OverviewPage.sections.CreateEntryView.EntryItemView;
import view.AccountsPage.AccountsPage;
import view.PaymentsHistoryPage.PaymentsHistoryPage;
import view.BillingPage.BillingPage;

import controller.AuthRequestHandler.Authentication;
import controller.AuthRequestHandler.AuthenticationService;
import controller.SubscriptionsRequestHandler.SubscriptionHandler;
import controller.SubscriptionsRequestHandler.SubscriptionService;


public class Controller  {

    private static MainFrame frame;
    private static Register register;
    private static Login login;
    private static SideBar sideBar;

    /* === Auth Handler ( auth service dependency injection ) === */
    private static Authentication authentication;
    private AuthenticationService authenticationService;

    /* === Subscription Handler ( subs service dependency injection ) === */
    private static SubscriptionHandler subscriptionHandler;
    private SubscriptionService subscriptionService;


    // models
    private static SubscriptionList subscriptionList;


    private static EntryCreationPage entryCreationPage;

    /* ========== */
    private static Overview overview;
    private static SubsView subsView;
    private static CreateEntryView createEntryView;
    private static AccountsPage accountsPage;
    private static PaymentsHistoryPage paymentsHistoryPage;
    private static BillingPage billingPage;
    private static VaultModal vaultModal;

    private static EntryList entryList;
    private static EntryItemView entryItemView;

    private static User user;

    private SubscriptionVault subscriptionVault;


    public Controller(MainFrame frame) {
        Controller.frame = frame;
        register = frame.getRegister();
        login = frame.getLogin();
        sideBar = frame.getSideBar();
        entryList = new     EntryList();
        overview = frame.getOverview();
        subsView = overview.getSubsView();
        accountsPage = frame.getAccountsPage();
        paymentsHistoryPage = frame.getPaymentsHistoryPage();
        billingPage = frame.getBillingPage();
        vaultModal = accountsPage.getVaultModal();

        subscriptionVault = subsView.getSubscriptionVault();

        createEntryView = overview.getCreateEntryView();
        entryItemView = createEntryView.getEntryItemView();


        //
        subscriptionList = new SubscriptionList();

        onLoad();

        attachListeners();

        user = new User();

        authenticationService = new AuthenticationService();
        authentication = new Authentication(authenticationService);

        subscriptionService = new SubscriptionService();
        subscriptionHandler = new SubscriptionHandler(subscriptionService);

    }



    private static void onLoad() {
        createEntryView.getEntryItemView().updateEntriesView(entryList.getEntryList());
        subsView.getSubscriptionVault().updateSubscriptionVaults(SubscriptionList.getSubscriptionList());
        accountsPage.getAccountsVault().updateAccountsView(SubscriptionList.getSubscriptionList());
        billingPage.updateTabbedPaneData(SubscriptionList.getSubscriptionList());
    }

    /* ================================================================== */

    private void attachListeners() {
        sideBar.overviewBtnNavigateListener(new NavigateListener("overview"));
        sideBar.accountsBtnNavigateListener(new NavigateListener("accountsPage"));
        sideBar.paymentsBtnNavigateListener(new NavigateListener("paymentsPage"));
        sideBar.billingBtnNavigateListener(new NavigateListener("billingPage"));
        frame.setWindowsListener(new MyWindowStateListener());
    }

    /* ================================================================== */

    /**
     * Loads data from the backend during the application initialization.
     * Invokes {@link } and updates UI components with the parsed data.
     * Prints error messages to the console if fetching or parsing fails.
     */


    /* ================================================================== */
     public static class AuthLoginListener implements ActionListener {
         private JButton button;


        public AuthLoginListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                switch (button.getText()) {
                    case "Create Account":
                        register.setUser(Controller.user);
                        authentication.registerUser(user);
                        break;
                    case "Sign In":
                        login.setUser(Controller.user);
                        showUiOnCreate();
                        authentication.loginUser(user);

                        if (authentication.getResponseCode() == 200) {
                            User authenticatedUser = authentication.getUser();
                            subscriptionHandler.getSubscriptions(authenticatedUser.getId());
                            showUIOnLogin();

                        } else  {
                            login.getErrorLabel().setVisible(true);
                            login.getErrorLabel().setText(authentication.getError());
                            System.out.println("Error mate");
                        }
                        break;
                }
            }

        }

        private void showUIOnLogin() {
            login.setVisible(false);
            frame.setSize(new Dimension(1450,  760));
            frame.setLocationRelativeTo(null);
            frame.add(sideBar, BorderLayout.WEST);
            frame.add(overview, BorderLayout.CENTER);

            addCardPanel();
            frame.add(frame.getCardPanel(), BorderLayout.CENTER);

            frame.revalidate();
            frame.repaint();
        }

        private void showUiOnCreate() {
            register.setVisible(false);
            login.setVisible(true);
            frame.add(login, BorderLayout.CENTER);
        }


        public User getUser() {
            return user;
        }
    }

    private static void addCardPanel() {
        frame.addToCardPanel(overview, "overview");
        frame.addToCardPanel(accountsPage, "accountsPage");
        frame.addToCardPanel(paymentsHistoryPage, "paymentsPage");
        frame.addToCardPanel(billingPage, "billingPage");
    }

    private class NavigateListener implements ActionListener {
        private final String pageName;

        NavigateListener(String pageName) {
            this.pageName = pageName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (pageName) {
                case "overview":
                    frame.getCardLayout().show(frame.getCardPanel(), "overview");
                    break;
                case "accountsPage":
                    frame.getCardLayout().show(frame.getCardPanel(), "accountsPage");
                    break;
                case "paymentsPage":
                    frame.getCardLayout().show(frame.getCardPanel(), "paymentsPage");
                    break;
                case "billingPage":
                    frame.getCardLayout().show(frame.getCardPanel(), "billingPage");
                    break;
            }

            frame.revalidate();
            frame.repaint();
        }
    }

    private class MyWindowStateListener implements WindowStateListener {
        @Override
        public void windowStateChanged(WindowEvent e) {
            if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                SwingUtilities.invokeLater(() -> {
                    subsView.setBorder(BorderFactory.createEmptyBorder(30, 0, 0 , 0));
                    createEntryView.setPreferredSize(new Dimension(createEntryView.getWidth(), 300));
                });
            } else  {
                SwingUtilities.invokeLater(() -> {
                    subsView.setBorder(BorderFactory.createEmptyBorder(20, 0, 0 , 0));
                    createEntryView.setPreferredSize(new Dimension(createEntryView.getWidth(), 200));
                });
            }
        }
    }

    public static class CreateEntryListener implements ActionListener {

        Entry entry;

        public CreateEntryListener(Entry entry) {
            this.entry = entry;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            entryCreationPage = new EntryCreationPage(entry);
            frame.addToCardPanel(entryCreationPage, "entryCreationPage");
            frame.getCardLayout().show(frame.getCardPanel(), "entryCreationPage");

        }
    }

    public static class EntryCreationActionListeners implements ActionListener {

        private JButton button;
        private Subscription subscription;

        public EntryCreationActionListeners(JButton button, Subscription subscription) {
            this.button = button;
            this.subscription = subscription;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                switch (button.getText()) {
                    case "Create Entry":
                        /* Add the entry in subscription list */
                        entryCreationPage.setVisible(false);
                        overview.setVisible(true);
                        subscriptionList.addSubscription(subscription);

                        SwingUtilities.invokeLater(Controller::onLoad);
                        break;
                    case "Cancel Entry":
                        /*  */
                        SwingUtilities.invokeLater(() -> {
                            entryCreationPage.setVisible(false);
                            overview.setVisible(true);
                        });
                        break;
                }
            }
        }
    }

    public static class CustomMouseListener extends MouseAdapter {

        Component comp;
        Subscription subs;

        public CustomMouseListener(Component comp, Subscription subs) {
            this.subs = subs;
            this.comp = comp;
        }

        public void mouseClicked(MouseEvent e) {

            if (comp instanceof JLabel) {
                register.setVisible(false);
                login.setVisible(true);
                frame.add(login, BorderLayout.CENTER);
            } else {
                vaultModal = new VaultModal(SwingUtilities.getWindowAncestor(accountsPage), subs);
                vaultModal.setVisible(true);
            }

        }
    }

}
