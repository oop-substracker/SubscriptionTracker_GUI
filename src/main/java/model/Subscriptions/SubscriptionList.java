package model.Subscriptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Subscriptions.constants.BillingPeriod;

public class SubscriptionList {
    private static List<Subscription> subscriptionList;

    public SubscriptionList() {
        subscriptionList = new ArrayList<>();
        initDefaultSubscriptions();
    }

    public SubscriptionList(List<Subscription> subscriptionList) {
        SubscriptionList.subscriptionList = subscriptionList;
        initDefaultSubscriptions();
    }

    public static List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public static void setSubscriptionList(List<Subscription> subscriptionList) {
        SubscriptionList.subscriptionList = subscriptionList;
    }

    public void addSubscription(Subscription subscription) {
        subscriptionList.add(subscription);
    }

    private void initDefaultSubscriptions() {
//        Subscription sub1 = new Subscription("dummyaccount@gmail.com","Spotify", "19 : 12 : 19: 03", new Billing(BillingPeriod.MONTHLY,2.25, 2.25, 39.00), "December 14, 2023");
//        Subscription sub2 = new Subscription("dummyaccount@gmail.com","Spotify", "19 : 12 : 19: 03", new Billing(BillingPeriod.WEEKLY,2.25, 2.25, 12.00, 20.22), "December 14, 2023");
//        Subscription sub3 = new Subscription("dummyaccount@gmail.com","Spotify", "19 : 12 : 19: 03", new Billing(BillingPeriod.WEEKLY,2.25, 2.25, 39.00, 20.22), "December 14, 2023");
//        Subscription sub4 = new Subscription("dummyaccount@gmail.com","Spotify", "19 : 12 : 19: 03", new Billing(BillingPeriod.WEEKLY,2.25, 2.25, 39.00, 20.22), "December 14, 2023");
//        Subscription sub5 = new Subscription("dummyaccount@gmail.com","Spotify", "19 : 12 : 19: 03", new Billing(BillingPeriod.WEEKLY,2.25, 2.25, 39.00, 20.22), "December 14, 2023");
//
//        subscriptionList.addAll(Arrays.asList(sub1, sub2, sub3, sub4));
    }



    @Override
    public String toString() {
        return "SubscriptionList{}";
    }
}
