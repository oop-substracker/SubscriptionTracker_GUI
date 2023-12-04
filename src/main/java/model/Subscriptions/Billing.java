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
    }

    public Billing(BillingPeriod billingPeriod, double cost, double weeklyCost, double monthlyCost, double yearlyCost) {
        this.billingPeriod = billingPeriod;
        this.cost = cost;
        this.weeklyCost = weeklyCost;
        this.monthlyCost = monthlyCost;
        this.yearlyCost = yearlyCost;
    }

    public Billing() { }

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
