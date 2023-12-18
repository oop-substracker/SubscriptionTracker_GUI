package controller.SubscriptionsRequestHandler;

import controller.Repositories.SubscriptionsRepository;
import model.Subscriptions.Subscription;

import java.util.List;

public class SubscriptionHandler {

    private final SubscriptionsRepository subscriptionsRepository;

    public SubscriptionHandler(SubscriptionsRepository subscriptionsRepository) {
        this.subscriptionsRepository= subscriptionsRepository;
    }

    public List<Subscription> getSubscriptions(String userId) {
        return subscriptionsRepository.getMySubscriptions(userId);
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionsRepository.createMySubscription(subscription);
    }

    public void updateSubTimeStamps(String id, Subscription subscription) {
        subscriptionsRepository.updateSubTimeStamps(id, subscription);
    }

    public void updateSubRemainingTime(String id) {
        subscriptionsRepository.updateSubRemainingTime(id);
    }

    public void deleteSubscription(String id) {
        subscriptionsRepository.deleteSubscription(id);
    }
}
