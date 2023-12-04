package model.Subscriptions;

import model.Subscriptions.constants.BillingPeriod;

public class Subscription {
    private String email;
    private String platform;
    private String timeRemaining;
    private Billing billing;

    private String dueDate;

    public Subscription(String email, String platform, String timeRemaining, Billing billing, String dueDate) {
        this.email = email;
        this.platform = platform;
        this.timeRemaining = timeRemaining;
        this.billing = billing;
        this.dueDate = dueDate;
    }

    public Subscription() { }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(String timeRemaining) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "email='" + email + '\'' +
                ", platform='" + platform + '\'' +
                ", timeRemaining='" + timeRemaining + '\'' +
                ", billing=" + billing +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}
