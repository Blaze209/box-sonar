package com.box.android.domain.analytics;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class WopiPropertyBuilder_Factory implements Factory<WopiPropertyBuilder> {
    private final Provider<BoxAmplitudeAnalytics.EventPropertyBuilder> eventPropertyBuilderProvider;

    private WopiPropertyBuilder_Factory(Provider<BoxAmplitudeAnalytics.EventPropertyBuilder> provider) {
        this.eventPropertyBuilderProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WopiPropertyBuilder get() {
        return newInstance(this.eventPropertyBuilderProvider.get());
    }

    public static WopiPropertyBuilder_Factory create(Provider<BoxAmplitudeAnalytics.EventPropertyBuilder> provider) {
        return new WopiPropertyBuilder_Factory(provider);
    }

    public static WopiPropertyBuilder newInstance(BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilder) {
        return new WopiPropertyBuilder(eventPropertyBuilder);
    }
}
