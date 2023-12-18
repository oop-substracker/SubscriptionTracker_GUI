package model.Subscriptions.constants;

public enum BillingPeriod {
    WEEKLY(7),
    MONTHLY(30),
    YEARLY(365);

    private final int daysInPeriod;

    BillingPeriod(int daysInPeriod) {
        this.daysInPeriod = daysInPeriod;
    }

    public int getDaysInPeriod() {
        return daysInPeriod;
    }
}
