package model.Subscriptions;

import java.time.Duration;
import java.time.Instant;

import view.AccountsPage.components.VaultModal;
import view.OverviewPage.sections.Header.components.NavPanel;

import static controller.Controller.overview;
import static controller.Controller.vaultModal;

public class Subscription {
    private String id;
    private String userId;
    private String email;
    private String platform;
    private long timeRemaining;
    private Billing billing;
    private String dueDate;
    private static NavPanel navPanel = new NavPanel();

    private long remainingTimeInMillis;
    private Instant windowCloseTime;

    public Subscription(String email, String platform, long timeRemaining, Billing billing, String dueDate) {
        this.email = email;
        this.platform = platform;
        this.timeRemaining = timeRemaining;
        this.billing = billing;
        this.dueDate = dueDate;
    }

    public Subscription(String userId, String email, String platform, long timeRemaining, Billing billing, String dueDate) {
        this.userId = userId;
        this.email = email;
        this.platform = platform;
        this.timeRemaining = timeRemaining;
        this.billing = billing;
        this.dueDate = dueDate;

    }

    public Subscription() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public long getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(long timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // Getters and setters for new fields
    public long getRemainingTimeInMillis() {
        return remainingTimeInMillis;
    }

    public void setRemainingTimeInMillis(long remainingTimeInMillis) {
        this.remainingTimeInMillis = remainingTimeInMillis;
    }

    public Instant getWindowCloseTime() {
        return windowCloseTime;
    }

    public void setWindowCloseTime(Instant windowCloseTime) {
        this.windowCloseTime = windowCloseTime;
    }

    /* ======== DATA LOGIC UTILITY METHODS ========*/

    public void updateElapsedTime(javax.swing.JLabel label) {
        if (timeRemaining > 0) {
            timeRemaining -= 1000;
            updateLabel(label);
        }

        if (timeRemaining <= 0) {
            controller.Controller.updateSubRemainingTime(id);
            vaultModal = new VaultModal(javax.swing.SwingUtilities.getWindowAncestor(overview), this);
            vaultModal.setVisible(true);
            model.Subscriptions.SubscriptionList.removeSubscription(id);

        }
    }



    private void updateLabel(javax.swing.JLabel label) {
        long days = timeRemaining / 86400000; // 1 day = 24 hours * 60 minutes * 60 seconds * 1000 milliseconds
        long hours = (timeRemaining % 86400000) / 3600000;
        long minutes = (timeRemaining % 3600000) / 60000;
        long seconds = (timeRemaining % 60000) / 1000;

        String formattedTime = String.format("%02d days %02d:%02d:%02d", days, hours, minutes, seconds);

//        System.out.println(formattedTime);

        javax.swing.SwingUtilities.invokeLater(() -> label.setText(formattedTime));
    }




    public void updateRemainingTime() {
        if (windowCloseTime != null) {
            Duration duration = Duration.between(windowCloseTime, Instant.now());
            long durationInMillis = duration.toMillis();
            timeRemaining = remainingTimeInMillis - durationInMillis;
        } else {
            timeRemaining = remainingTimeInMillis;
        }

    }


    /* ============================================*/

    @Override
    public String toString() {
        return "Subscription{" +
                "email='" + email + '\'' +
                ", platform='" + platform + '\'' +
                ", timeRemaining='" + timeRemaining + '\'' +
                ", billing=" + billing +
                ", dueDate='" + dueDate + '\'' +
                ", remainingTimeInMillis=" + remainingTimeInMillis +
                ", windowCloseTime=" + windowCloseTime +
                '}';
    }
}
