
import view.MainFrame;
import controller.Controller;

public class Main {
    public static void main(String[] args) {

        MainFrame frame = new MainFrame();

        Controller controller = new Controller(frame);

    }
}