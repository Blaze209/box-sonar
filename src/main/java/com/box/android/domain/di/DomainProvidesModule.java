package com.box.android.domain.di;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: DomainModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/di/DomainProvidesModule;", "", "<init>", "()V", "provideEventPropertyBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$EventPropertyBuilder;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class DomainProvidesModule {
    public static final DomainProvidesModule INSTANCE = new DomainProvidesModule();

    private DomainProvidesModule() {
    }

    @Provides
    @Singleton
    public final BoxAmplitudeAnalytics.EventPropertyBuilder provideEventPropertyBuilder() {
        return new BoxAmplitudeAnalytics.EventPropertyBuilder();
    }
}
