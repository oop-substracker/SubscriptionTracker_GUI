package view.AccountsPage;

import javax.swing.*;
import java.awt.*;
import util.UICreator;
import view.AccountsPage.components.AccountsVault;
import view.AccountsPage.components.VaultModal;

public class AccountsPage extends JPanel {

    private JLabel title;
    private AccountsVault accountsVault;
    private VaultModal vaultModal;

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
        title.setVerticalAlignment(SwingConstants.CENTER);
    }

    public AccountsVault getAccountsVault() {
        return accountsVault;
    }

    public VaultModal getVaultModal() {
        return vaultModal;
    }
}
