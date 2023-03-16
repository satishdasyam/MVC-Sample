package com.satishdasyam.mvvm.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.satishdasyam.mvvm.repository.SearchListRepo;

import javax.inject.Inject;

public class SearchViewModelFactory implements ViewModelProvider.Factory {

    private final SearchListRepo mSearchListRepo;

    @Inject
    public SearchViewModelFactory(SearchListRepo searchListRepo) {
        this.mSearchListRepo = searchListRepo;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(mSearchListRepo);
        }
        throw new IllegalArgumentException("Unknown class name");
    }

   /* @NonNull
    @Override
    public SearchViewModel create(@NonNull Class modelClass) {
        return new SearchViewModel(mSearchListRepo);
    }*/
}
