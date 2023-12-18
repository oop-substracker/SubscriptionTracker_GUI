import controller.Controller;
import view.MainFrame;
import javax.swing.SwingUtilities;

public class Driver {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
            SwingUtilities.updateComponentTreeUI(frame);
            Controller controller = new Controller(frame);
        });
    }
}
