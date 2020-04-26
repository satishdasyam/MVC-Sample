package com.satishdasyam.mvc.screens.common;

public interface IObservableViewMvc<ListenerType> extends IViewMvc {
    void registerListener(ListenerType listenerType);

    void unregisterListener(ListenerType listenerType);
}
