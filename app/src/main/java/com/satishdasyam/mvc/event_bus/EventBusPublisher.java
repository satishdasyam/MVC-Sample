package com.satishdasyam.mvc.event_bus;

import org.greenrobot.eventbus.EventBus;

/**This class is used to post to event bus events, maintained separate class
 * for subscribing and posting events so that we are clear in dependencies
 * which class are subscribing and which are posting*/
public class EventBusPublisher {

    public void post(Object event) {
        EventBus.getDefault().post(event);
    }
}
