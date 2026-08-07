package com.box.android.preview.previewtype.code;

import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes12.dex */
public final class CodeFileReader_Factory implements Factory<CodeFileReader> {
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;

    private CodeFileReader_Factory(Provider<CoroutineDispatcher> provider) {
        this.coroutineDispatcherProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CodeFileReader get() {
        return newInstance(this.coroutineDispatcherProvider.get());
    }

    public static CodeFileReader_Factory create(Provider<CoroutineDispatcher> provider) {
        return new CodeFileReader_Factory(provider);
    }

    public static CodeFileReader newInstance(CoroutineDispatcher coroutineDispatcher) {
        return new CodeFileReader(coroutineDispatcher);
    }
}
