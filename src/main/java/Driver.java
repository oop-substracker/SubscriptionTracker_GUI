import controller.Controller;
import view.MainFrame;

import javax.swing.*;

public class Driver {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
                Controller controller = new Controller(frame);
            }
        });
    }


}
