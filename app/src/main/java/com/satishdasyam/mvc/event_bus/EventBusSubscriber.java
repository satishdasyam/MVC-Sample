package com.satishdasyam.mvc.event_bus;

import org.greenrobot.eventbus.EventBus;

/**This class is used to subscribe event bus events, maintained separate class
 * for subscribing and posting events so that we are clear in dependencies
 * which class are subscribing and which are posting*/


public class EventBusSubscriber {

    private final EventBus mEventBus;
    public EventBusSubscriber(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public void register(Object subscriber) {
        mEventBus.register(subscriber);
    }

    public void unRegister(Object subscriber) {
        mEventBus.unregister(subscriber);
    }
}
