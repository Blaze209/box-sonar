package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiBookmark;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiBookmarkFactory implements Factory<BoxApiBookmark> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiBookmarkFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiBookmark get() {
        return provideBoxApiBookmark(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiBookmarkFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiBookmarkFactory(provider, provider2);
    }

    public static BoxApiBookmark provideBoxApiBookmark(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiBookmark) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiBookmark(iUserContextManager, context));
    }
}
