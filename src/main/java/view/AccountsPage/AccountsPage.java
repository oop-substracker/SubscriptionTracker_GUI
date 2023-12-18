package view.AccountsPage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import util.UICreator;
import view.AccountsPage.components.AccountsVault;
import view.AccountsPage.components.VaultModal;

/**
 * The {@code AccountsPage} class represents the main panel for displaying accounts information.
 * It includes an AccountsVault to display account entries and a VaultModal for detailed
 * information on a specific account.
 */
public class AccountsPage extends JPanel {

    private JLabel title;
    private AccountsVault accountsVault;
    private VaultModal vaultModal;

    /**
     * Constructs an instance of the AccountsPage class.
     * Initializes the layout, title, and components.
     */
    public AccountsPage() {
        this.setLayout(new BorderLayout());
        initTitle();
        accountsVault = new AccountsVault();

        this.add(title, BorderLayout.NORTH);
        this.add(accountsVault, BorderLayout.CENTER);
    }

    /**
     * Initializes the title label for the AccountsPage.
     */
    private void initTitle() {
        title = UICreator.createLabel("Accounts", 35, Font.BOLD);
        title.setBorder(BorderFactory.createEmptyBorder(15, 22, 0, 0));
        title.setVerticalAlignment(SwingConstants.CENTER);
    }

    /**
     * Gets the AccountsVault component.
     *
     * @return The AccountsVault component.
     */
    public AccountsVault getAccountsVault() {
        return accountsVault;
    }

    /**
     * Gets the VaultModal component.
     *
     * @return The VaultModal component.
     */
    public VaultModal getVaultModal() {
        return vaultModal;
    }
}
