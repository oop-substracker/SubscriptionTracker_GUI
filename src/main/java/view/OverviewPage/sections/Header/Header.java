    package view.OverviewPage.sections.Header;

    import javax.swing.JPanel;
    import java.awt.GridBagLayout;
    import java.awt.GridBagConstraints;
    import util.UICreator;
    import view.OverviewPage.sections.Header.components.NavPanel;
    import view.OverviewPage.sections.Header.components.AnalyticPanel;

    public class Header extends JPanel {

        private NavPanel navPanel;
        private AnalyticPanel analyticPanel;

        public Header() {
            navPanel = new NavPanel();
            analyticPanel = new AnalyticPanel();
            init();
        }

        public void init() {
            this.setLayout(new GridBagLayout());

            UICreator.createComp(this, navPanel, 0, 0, 4, 1, 1, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0, 0 );
            UICreator.createComp(this, analyticPanel, 0, 1, 4, 2, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 3, 0, 0, 0, 0 );
        }

        public AnalyticPanel getAnalyticPanel() {
            return analyticPanel;
        }

        public NavPanel getNavPanel() {
            return navPanel;
        }
    }
