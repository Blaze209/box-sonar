package com.box.android.domain.di;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.usecases.observability.MetricDecorator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MetricDecoratorsModule_ProvidesUserMetricDecoratorFactory implements Factory<MetricDecorator> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private MetricDecoratorsModule_ProvidesUserMetricDecoratorFactory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricDecorator get() {
        return providesUserMetricDecorator(this.userContextManagerProvider.get());
    }

    public static MetricDecoratorsModule_ProvidesUserMetricDecoratorFactory create(Provider<IUserContextManager> provider) {
        return new MetricDecoratorsModule_ProvidesUserMetricDecoratorFactory(provider);
    }

    public static MetricDecorator providesUserMetricDecorator(IUserContextManager iUserContextManager) {
        return (MetricDecorator) Preconditions.checkNotNullFromProvides(MetricDecoratorsModule.INSTANCE.providesUserMetricDecorator(iUserContextManager));
    }
}
