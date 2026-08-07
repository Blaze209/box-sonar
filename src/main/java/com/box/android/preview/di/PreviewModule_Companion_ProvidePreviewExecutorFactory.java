package com.box.android.preview.di;

import android.content.Context;
import com.box.android.domain.identity.PreviewExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewModule_Companion_ProvidePreviewExecutorFactory implements Factory<PreviewExecutor> {
    private final Provider<Context> contextProvider;

    private PreviewModule_Companion_ProvidePreviewExecutorFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewExecutor get() {
        return providePreviewExecutor(this.contextProvider.get());
    }

    public static PreviewModule_Companion_ProvidePreviewExecutorFactory create(Provider<Context> provider) {
        return new PreviewModule_Companion_ProvidePreviewExecutorFactory(provider);
    }

    public static PreviewExecutor providePreviewExecutor(Context context) {
        return (PreviewExecutor) Preconditions.checkNotNullFromProvides(PreviewModule.INSTANCE.providePreviewExecutor(context));
    }
}
