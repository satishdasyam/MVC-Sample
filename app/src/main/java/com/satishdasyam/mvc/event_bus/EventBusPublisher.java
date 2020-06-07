package com.satishdasyam.mvc.event_bus;

import org.greenrobot.eventbus.EventBus;

/**This class is used to post  event bus events, maintained separate class
 * for subscribing and posting events so that we are clear in dependencies
 * which class are subscribing and which are posting*/
public class EventBusPublisher {

    private final EventBus mEventBus;
    public EventBusPublisher(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public void post(Object event) {
        mEventBus.post(event);
    }
}
