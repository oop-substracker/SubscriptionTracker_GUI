import controller.Controller;
import view.MainFrame;
import javax.swing.SwingUtilities;

/**
 * Application Overview:
 * The Subscription Tracker application serves as an essential tool for users to effectively manage and keep tabs on their
 * multitude of subscription services. The Subscription Tracker application helps users manage their subscriptions by providing a
 * user-friendly interface to track, analyze, and organize subscription services.
 *
 * Key Features:
 * - Subscription Management: Users can effortlessly add, edit, and remove subscriptions, ensuring an up-to-date and accurate record.
 * - Analytical Insights: The application provides analytical panels that offer insights into subscription trends, helping users make informed decisions.
 * - Billing and Payments: Users can conveniently monitor billing cycles, due payments, and access a comprehensive history of past transactions.
 * - User-Friendly Interface: The user interface is designed for simplicity and ease of use, making navigation and interaction intuitive for all users.
 *
 * Group Members:
 * - Harvie Purgatorio
 * - Niño Jay Dicdiquin
 * - Ethan Patrick Bandebas
 * - Clyde Puntanar
 * - Clint Joseph Ubanan
 * - John Earl Balabat
 * - Rowela Katelhyne Barredo
 * - Gabryle Antonie Pitogo
 *
 *
 * Group Responsibilities:
 * - The development team collaborates on implementing and enhancing the features of the Subscription Tracker application.
 * - Regular communication and coordination ensure that each team member's contributions align with the project goals.
 *
 * Developer Notes:
 * - Developers are encouraged to follow coding standards and contribute to maintaining a clean and efficient codebase.
 * - Continuous integration and testing practices are vital to ensure the stability and reliability of the application.
 * - Regular team meetings are scheduled to discuss progress, challenges, and future development plans.
 * - Documentation is a crucial aspect of the development process, providing insights for future enhancements or bug fixes.
 *
 * The Subscription Tracker application aims to simplify the subscription management process, providing users with a reliable
 * and feature-rich solution to organize and optimize their subscription-related activities.
 *
 *
 * JavaDoc template author: (GeeksForGeeks)
 */


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
