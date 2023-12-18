package model.Subscriptions;

import model.Subscriptions.constants.BillingPeriod;

public class Billing {
    private BillingPeriod billingPeriod;
    private double cost;
    private double monthlyCost;
    private double yearlyCost;
    private double weeklyCost;

    public Billing(BillingPeriod billingPeriod, double cost, double monthlyCost, double yearlyCost) {
        this.billingPeriod = billingPeriod;
        this.cost = cost;
        this.monthlyCost = monthlyCost;
        this.yearlyCost = yearlyCost;
        this.weeklyCost = cost; // Set weekly cost as the default cost
    }

    public Billing(BillingPeriod billingPeriod, double cost, double weeklyCost, double monthlyCost, double yearlyCost) {
        this.billingPeriod = billingPeriod;
        this.cost = cost;
        this.weeklyCost = weeklyCost;
        this.monthlyCost = monthlyCost;
        this.yearlyCost = yearlyCost;
    }

    public Billing() { }

    public void calculateDerivedCosts() {
        if (billingPeriod == BillingPeriod.WEEKLY) {
            monthlyCost = cost * 4; // Assuming 4 weeks in a month
            yearlyCost = cost * 52; // Assuming 52 weeks in a year
            weeklyCost = cost;
        } else if (billingPeriod == BillingPeriod.MONTHLY) {
            weeklyCost = cost / 4; // Assuming 4 weeks in a month
            yearlyCost = cost * 12; // Assuming 12 months in a year
            monthlyCost = cost;
        } else if (billingPeriod == BillingPeriod.YEARLY) {
            weeklyCost = cost / 52; // Assuming 52 weeks in a year
            monthlyCost = cost / 12; // Assuming 12 months in a year
            yearlyCost = cost;
        } else {
            throw new IllegalArgumentException("Unsupported billing period: " + billingPeriod);
        }
    }

    public double getWeeklyCost() {
        return weeklyCost;
    }

    public void setWeeklyCost(double weeklyCost) {
        this.weeklyCost = weeklyCost;
    }

    public BillingPeriod getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(BillingPeriod billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public double getYearlyCost() {
        return yearlyCost;
    }

    public void setYearlyCost(double yearlyCost) {
        this.yearlyCost = yearlyCost;
    }
}
