package com.box.android.data.di;

import com.box.android.data.api.interceptors.AiRequestInterceptor;
import com.box.android.data.api.interceptors.DevpodInterceptor;
import com.box.android.data.api.interceptors.EmptyBodyInterceptor;
import com.box.android.data.api.interceptors.Gen204RequestInterceptor;
import com.box.android.data.api.interceptors.RetryRequestInterceptor;
import com.box.android.data.api.interceptors.auth.AuthInterceptor;
import com.box.android.data.api.interceptors.auth.RequestHeaderInterceptor;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.data.api.utils.HttpStreamLoggingInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.List;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideInterceptorsFactory implements Factory<List<Interceptor>> {
    private final Provider<AiRequestInterceptor> aiRequestInterceptorProvider;
    private final Provider<AuthInterceptor> authInterceptorProvider;
    private final Provider<DevpodInterceptor> devpodInterceptorProvider;
    private final Provider<EmptyBodyInterceptor> emptyBodyInterceptorProvider;
    private final Provider<Gen204RequestInterceptor> gen204RequestInterceptorProvider;
    private final Provider<HttpStreamLoggingInterceptor> httpLoggingInterceptorProvider;
    private final DataProvidesModule module;
    private final Provider<RequestHeaderInterceptor> requestHeaderInterceptorProvider;
    private final Provider<RetryRequestInterceptor> retryRequestInterceptorProvider;
    private final Provider<SharedLinkAuthInterceptor> sharedLinkAuthInterceptorProvider;

    private DataProvidesModule_ProvideInterceptorsFactory(DataProvidesModule module, Provider<AuthInterceptor> authInterceptorProvider, Provider<RequestHeaderInterceptor> requestHeaderInterceptorProvider, Provider<Gen204RequestInterceptor> gen204RequestInterceptorProvider, Provider<RetryRequestInterceptor> retryRequestInterceptorProvider, Provider<EmptyBodyInterceptor> emptyBodyInterceptorProvider, Provider<SharedLinkAuthInterceptor> sharedLinkAuthInterceptorProvider, Provider<DevpodInterceptor> devpodInterceptorProvider, Provider<AiRequestInterceptor> aiRequestInterceptorProvider, Provider<HttpStreamLoggingInterceptor> httpLoggingInterceptorProvider) {
        this.module = module;
        this.authInterceptorProvider = authInterceptorProvider;
        this.requestHeaderInterceptorProvider = requestHeaderInterceptorProvider;
        this.gen204RequestInterceptorProvider = gen204RequestInterceptorProvider;
        this.retryRequestInterceptorProvider = retryRequestInterceptorProvider;
        this.emptyBodyInterceptorProvider = emptyBodyInterceptorProvider;
        this.sharedLinkAuthInterceptorProvider = sharedLinkAuthInterceptorProvider;
        this.devpodInterceptorProvider = devpodInterceptorProvider;
        this.aiRequestInterceptorProvider = aiRequestInterceptorProvider;
        this.httpLoggingInterceptorProvider = httpLoggingInterceptorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public List<Interceptor> get() {
        return provideInterceptors(this.module, this.authInterceptorProvider.get(), this.requestHeaderInterceptorProvider.get(), this.gen204RequestInterceptorProvider.get(), this.retryRequestInterceptorProvider.get(), this.emptyBodyInterceptorProvider.get(), this.sharedLinkAuthInterceptorProvider.get(), this.devpodInterceptorProvider.get(), this.aiRequestInterceptorProvider.get(), this.httpLoggingInterceptorProvider.get());
    }

    public static DataProvidesModule_ProvideInterceptorsFactory create(DataProvidesModule module, Provider<AuthInterceptor> authInterceptorProvider, Provider<RequestHeaderInterceptor> requestHeaderInterceptorProvider, Provider<Gen204RequestInterceptor> gen204RequestInterceptorProvider, Provider<RetryRequestInterceptor> retryRequestInterceptorProvider, Provider<EmptyBodyInterceptor> emptyBodyInterceptorProvider, Provider<SharedLinkAuthInterceptor> sharedLinkAuthInterceptorProvider, Provider<DevpodInterceptor> devpodInterceptorProvider, Provider<AiRequestInterceptor> aiRequestInterceptorProvider, Provider<HttpStreamLoggingInterceptor> httpLoggingInterceptorProvider) {
        return new DataProvidesModule_ProvideInterceptorsFactory(module, authInterceptorProvider, requestHeaderInterceptorProvider, gen204RequestInterceptorProvider, retryRequestInterceptorProvider, emptyBodyInterceptorProvider, sharedLinkAuthInterceptorProvider, devpodInterceptorProvider, aiRequestInterceptorProvider, httpLoggingInterceptorProvider);
    }

    public static List<Interceptor> provideInterceptors(DataProvidesModule instance, AuthInterceptor authInterceptor, RequestHeaderInterceptor requestHeaderInterceptor, Gen204RequestInterceptor gen204RequestInterceptor, RetryRequestInterceptor retryRequestInterceptor, EmptyBodyInterceptor emptyBodyInterceptor, SharedLinkAuthInterceptor sharedLinkAuthInterceptor, DevpodInterceptor devpodInterceptor, AiRequestInterceptor aiRequestInterceptor, HttpStreamLoggingInterceptor httpLoggingInterceptor) {
        return (List) Preconditions.checkNotNullFromProvides(instance.provideInterceptors(authInterceptor, requestHeaderInterceptor, gen204RequestInterceptor, retryRequestInterceptor, emptyBodyInterceptor, sharedLinkAuthInterceptor, devpodInterceptor, aiRequestInterceptor, httpLoggingInterceptor));
    }
}
