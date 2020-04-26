package com.satishdasyam.mvc.screens.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableViewMvc<ListenerType> extends BaseViewMvc {

    private Set<ListenerType> mListeners = new HashSet<>();


    public void registerListener(ListenerType listenerType) {
        mListeners.add(listenerType);
    }

    public void unregisterListener(ListenerType listenerType) {
        mListeners.remove(listenerType);
    }

    protected Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}
