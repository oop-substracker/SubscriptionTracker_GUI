package view.AccountsPage;

import javax.swing.*;
import java.awt.*;
import util.UICreator;
import view.AccountsPage.components.AccountsVault;

public class AccountsPage extends JPanel {

    private JLabel title;
    private AccountsVault accountsVault;

    public AccountsPage() {
        this.setLayout(new BorderLayout());
        initTitle();
        accountsVault = new AccountsVault();

        this.add(title, BorderLayout.NORTH);
        this.add(accountsVault, BorderLayout.CENTER);
    }

    private void initTitle() {
        title = UICreator.createLabel("Accounts", 35, Font.BOLD);
        title.setBorder(BorderFactory.createEmptyBorder(15, 22, 0, 0));
//        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
    }


    public AccountsVault getAccountsVault() {
        return accountsVault;
    }
}
