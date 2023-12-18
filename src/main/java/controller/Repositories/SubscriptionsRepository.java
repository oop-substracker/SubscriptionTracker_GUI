package controller.Repositories;

import model.Subscriptions.Subscription;
import java.util.List;

public interface SubscriptionsRepository {
    public List<Subscription> getMySubscriptions(String userId);
    public Subscription createMySubscription(Subscription subscription);
    public void updateSubTimeStamps(String id, Subscription subscription);

    public void updateSubRemainingTime(String id);

    public void deleteSubscription(String id);
}
