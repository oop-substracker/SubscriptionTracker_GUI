package model.TabbedData;

public class TableData {

    private String paymentDate;
    private double cost;
    private String subsDue;


    public TableData(String paymentDate, double cost, String subsDue) {
        this.paymentDate = paymentDate;
        this.cost = cost;
        this.subsDue = subsDue;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSubsDue() {
        return subsDue;
    }

    public void setSubsDue(String subsDue) {
        this.subsDue = subsDue;
    }
}
