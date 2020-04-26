package com.satishdasyam.mvc.screens.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableViewMvc<ListenerType> extends BaseViewMvc
        implements IObservableViewMvc<ListenerType> {

    private Set<ListenerType> mListeners = new HashSet<>();

    @Override
    public void registerListener(ListenerType listenerType) {
        mListeners.add(listenerType);
    }

    @Override
    public void unregisterListener(ListenerType listenerType) {
        mListeners.remove(listenerType);
    }

    protected Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}
