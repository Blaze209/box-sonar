package com.box.android.preview.annotations.managers;

import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes12.dex */
public final class CreateAnnotationsManager_Factory implements Factory<CreateAnnotationsManager> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private CreateAnnotationsManager_Factory(Provider<CoroutineDispatcher> provider) {
        this.ioDispatcherProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateAnnotationsManager get() {
        return newInstance(this.ioDispatcherProvider.get());
    }

    public static CreateAnnotationsManager_Factory create(Provider<CoroutineDispatcher> provider) {
        return new CreateAnnotationsManager_Factory(provider);
    }

    public static CreateAnnotationsManager newInstance(CoroutineDispatcher coroutineDispatcher) {
        return new CreateAnnotationsManager(coroutineDispatcher);
    }
}
