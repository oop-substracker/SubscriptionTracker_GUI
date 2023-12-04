package controller;

import model.DefaultEntries.Entry;
import model.Subscriptions.Subscription;
import model.Subscriptions.SubscriptionList;
import view.AuthPage.Login;
import view.AuthPage.Register;
import view.MainFrame;
import view.SideBar.SideBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import controller.RequestHandler.GetRequestHandler;

/* ========== */
import view.OverviewPage.Overview;
import view.OverviewPage.sections.SubscriptionsView.SubsView;
import view.OverviewPage.sections.CreateEntryView.CreateEntryView;
import view.EntryCreationView.EntryCreationPage;
import view.OverviewPage.sections.SubscriptionsView.SubscriptionVault;
import view.OverviewPage.sections.CreateEntryView.EntryItemView;

import model.DefaultEntries.EntryList;

public class Controller  {

    private static MainFrame frame;
    private static Register register;
    private static Login login;
    private static SideBar sideBar;

    //
    private GetRequestHandler getRequestHandler;

    // models
    private static SubscriptionList subscriptionList;


    private static EntryCreationPage entryCreationPage;

    /* ========== */
    private static Overview overview;
    private static SubsView subsView;
    private static CreateEntryView createEntryView;

    private static EntryList entryList;
    private static EntryItemView entryItemView;

    private SubscriptionVault subscriptionVault;


    public Controller(MainFrame frame) {
        Controller.frame = frame;
        frame.addWindowsStateListener(new MyWindowStateListener());
        register = frame.getRegister();
        login = frame.getLogin();
        sideBar = frame.getSideBar();
        entryList = new EntryList();
        overview = frame.getOverview();
        subsView = overview.getSubsView();


        subscriptionVault = subsView.getSubscriptionVault();

        createEntryView = overview.getCreateEntryView();
        entryItemView = createEntryView.getEntryItemView();


        //
        subscriptionList = new SubscriptionList();

        onLoad();

    }

    private static void onLoad() {
        createEntryView.getEntryItemView().updateEntriesView(entryList.getEntryList());
        subsView.getSubscriptionVault().updateSubscriptionVaults(SubscriptionList.getSubscriptionList());
    }

    /* ================================================================== */

//    private void attachListeners() {
//        register.addRegisterButtonListener(new RegisterClickListener());
//        login.addSignButtonListener(new LoginClickListener());
//
//        sideBar.homeBtnNavigateListener(new NavigateListener("homePage"));
//        sideBar.accountsBtnNavigateListener(new NavigateListener("accountsPage"));
//        sideBar.paymentsBtnNavigateListener(new NavigateListener("paymentsPage"));
//        frame.setWindowsListener((WindowStateListener) new MyWindowStateListener());
//    }

    /* ================================================================== */

    /**
     * Loads data from the backend during the application initialization.
     * Invokes {@link GetRequestHandler#fetchData(String)} and updates UI components with the parsed data.
     * Prints error messages to the console if fetching or parsing fails.
     */
//    private void onLoad() {
//        String responseData = getRequestHandler.fetchData("http://localhost:8080/api/subscriptions");
//
//        if (responseData != null) {
//            // Parse the JSON data into a list of Subscription objects
//            List<Subscription> responseBody = getRequestHandler.parseJsonToSubscriptionList(responseData);
//            populateSubscriptionModel(responseBody);
//
//            // Update the UI components with the parsed data
////            updateView();
//        } else {
//            // Handle error or notify the user
//            System.out.println("Failed to fetch data from the backend.");
//        }
//    }
//
//    private void populateSubscriptionModel(List<Subscription> response) {
//        SubscriptionList.setSubscriptionList(response);
//    }

//    private void updateView() {
//        homeView.getSubsView().updateSubscriptionVaults(SubscriptionList.getSubscriptionList());
//        accountsView.updateAccountsView(SubscriptionList.getSubscriptionList());
//        paymentsHistoryView.getVaultsView().updateSubVaults(SubscriptionList.getSubscriptionList());
//        homeView.getTableInfoView().updateTableData(SubscriptionList.getSubscriptionList());
//    }


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
                        register.setVisible(false);
                        login.setVisible(true);
                        frame.add(login, BorderLayout.CENTER);
                        break;
                    case "Sign In":
                        login.setVisible(false);
                        frame.setSize(new Dimension(1450, 760));
                        frame.setLocationRelativeTo(null);
                        frame.add(sideBar, BorderLayout.WEST);
                        frame.add(overview, BorderLayout.CENTER);
                        break;
                }
            }
        }
    }

//    private void addCardPanel() {
//        frame.addToCardPanel(homeView, "homePage");
//        frame.addToCardPanel(accountsView, "accountsPage");
//        frame.addToCardPanel(paymentsHistoryView, "paymentsPage");
//    }

//    private class RegisterClickListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            register.setVisible(false);
//            login.setVisible(true);
//            frame.add(login, BorderLayout.CENTER);
//        }
//    }
//
//    private class LoginClickListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            login.setVisible(false);
//            addCardPanel();
//
//            sideBar.setVisible(true);
//            frame.add(sideBar, BorderLayout.WEST);
//            frame.add(frame.getCardPanel(), BorderLayout.CENTER);
//            frame.setResizable(true);
//
//            onLoad();
//
//            if (homeView.isVisible()) {
////                     com.formdev.flatlaf.themes.FlatMacLightLaf.setup();
//            } else {
//                com.formdev.flatlaf.themes.FlatMacLightLaf.setup();
//            }
//
//            SwingUtilities.updateComponentTreeUI(frame);
//        }
//    }
//
//    private class NavigateListener implements ActionListener {
//        private final String pageName;
//
//        NavigateListener(String pageName) {
//            this.pageName = pageName;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            switch (pageName) {
//                case "homePage":
//                    frame.getCardLayout().show(frame.getCardPanel(), "homePage");
//                    break;
//                case "accountsPage":
//                    frame.getCardLayout().show(frame.getCardPanel(), "accountsPage");
//                    break;
//                case "paymentsPage":
//                    frame.getCardLayout().show(frame.getCardPanel(), "paymentsPage");
//                    break;
//            }
//        }
//    }

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
            SwingUtilities.invokeLater(() -> {
                overview.setVisible(false);
                entryCreationPage = new EntryCreationPage(entry);
                frame.add(entryCreationPage, BorderLayout.CENTER);
                entryCreationPage.setVisible(true);
            });
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

//    public static class CustomMouseListener extends MouseAdapter {
//
//        Subscription subs;
//
//        public CustomMouseListener(Subscription subs) {
//            this.subs = subs;
//        }
//
//        public void mouseClicked(MouseEvent e) {
//            vaultModal = new VaultModal(SwingUtilities.getWindowAncestor(accountsView), subs);
//            vaultModal.setVisible(true);
//
//        }
//    }

}
