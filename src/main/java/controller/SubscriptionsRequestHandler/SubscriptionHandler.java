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
}
