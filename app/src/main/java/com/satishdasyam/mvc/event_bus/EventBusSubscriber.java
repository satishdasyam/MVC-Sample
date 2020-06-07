package com.satishdasyam.mvc.event_bus;

import org.greenrobot.eventbus.EventBus;

/**This class is used to subscribe to event bus events, maintained separate class
 * for subscribing and posting events so that we are clear in dependencies
 * which class are subscribing and which are posting*/


public class EventBusSubscriber {

    public void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public void unRegister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }
}
