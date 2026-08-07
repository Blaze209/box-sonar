package com.box.android.preview.previewtype.document.search;

import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes12.dex */
public final class TextSearchManager_Factory implements Factory<TextSearchManager> {
    private final Provider<CoroutineDispatcher> searchDispatcherProvider;
    private final Provider<SearchOptionsProvider> searchOptionsProvider;

    private TextSearchManager_Factory(Provider<CoroutineDispatcher> provider, Provider<SearchOptionsProvider> provider2) {
        this.searchDispatcherProvider = provider;
        this.searchOptionsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TextSearchManager get() {
        return newInstance(this.searchDispatcherProvider.get(), this.searchOptionsProvider.get());
    }

    public static TextSearchManager_Factory create(Provider<CoroutineDispatcher> provider, Provider<SearchOptionsProvider> provider2) {
        return new TextSearchManager_Factory(provider, provider2);
    }

    public static TextSearchManager newInstance(CoroutineDispatcher coroutineDispatcher, SearchOptionsProvider searchOptionsProvider) {
        return new TextSearchManager(coroutineDispatcher, searchOptionsProvider);
    }
}
