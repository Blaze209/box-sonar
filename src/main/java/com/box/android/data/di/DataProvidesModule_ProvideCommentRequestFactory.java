package com.box.android.data.di;

import com.box.android.data.api.requests.CommentRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.AppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideCommentRequestFactory implements Factory<CommentRequest> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideCommentRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentRequest get() {
        return provideCommentRequest(this.module, this.requestFactoryProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DataProvidesModule_ProvideCommentRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider) {
        return new DataProvidesModule_ProvideCommentRequestFactory(module, requestFactoryProvider, appRestrictionsManagerProvider);
    }

    public static CommentRequest provideCommentRequest(DataProvidesModule instance, RequestFactory requestFactory, AppRestrictionsManager appRestrictionsManager) {
        return (CommentRequest) Preconditions.checkNotNullFromProvides(instance.provideCommentRequest(requestFactory, appRestrictionsManager));
    }
}
