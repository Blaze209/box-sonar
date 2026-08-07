package com.box.android.domain.di;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DomainProvidesModule_ProvideEventPropertyBuilderFactory implements Factory<BoxAmplitudeAnalytics.EventPropertyBuilder> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAmplitudeAnalytics.EventPropertyBuilder get() {
        return provideEventPropertyBuilder();
    }

    public static DomainProvidesModule_ProvideEventPropertyBuilderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxAmplitudeAnalytics.EventPropertyBuilder provideEventPropertyBuilder() {
        return (BoxAmplitudeAnalytics.EventPropertyBuilder) Preconditions.checkNotNullFromProvides(DomainProvidesModule.INSTANCE.provideEventPropertyBuilder());
    }

    private static final class InstanceHolder {
        static final DomainProvidesModule_ProvideEventPropertyBuilderFactory INSTANCE = new DomainProvidesModule_ProvideEventPropertyBuilderFactory();

        private InstanceHolder() {
        }
    }
}
