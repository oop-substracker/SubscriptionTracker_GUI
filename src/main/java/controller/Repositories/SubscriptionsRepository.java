package controller.Repositories;

import model.Subscriptions.Subscription;
import java.util.List;

public interface SubscriptionsRepository {
    public List<Subscription> getMySubscriptions(String userId);
    public Subscription createMySubscription(Subscription subscription);
}
