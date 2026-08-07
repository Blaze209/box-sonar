package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiComment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiCommentFactory implements Factory<BoxApiComment> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiCommentFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiComment get() {
        return provideBoxApiComment(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiCommentFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiCommentFactory(provider, provider2);
    }

    public static BoxApiComment provideBoxApiComment(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiComment) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiComment(iUserContextManager, context));
    }
}
