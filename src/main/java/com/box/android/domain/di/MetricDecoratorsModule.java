package com.box.android.domain.di;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppInfoService;
import com.box.android.domain.usecases.observability.DeviceMetricDecorator;
import com.box.android.domain.usecases.observability.MetricDecorator;
import com.box.android.domain.usecases.observability.UserMetricDecorator;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/di/MetricDecoratorsModule;", "", "<init>", "()V", "providesDeviceMetricDecorator", "Lcom/box/android/domain/usecases/observability/MetricDecorator;", "appInfoService", "Lcom/box/android/domain/services/IAppInfoService;", "providesUserMetricDecorator", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class MetricDecoratorsModule {
    public static final MetricDecoratorsModule INSTANCE = new MetricDecoratorsModule();

    private MetricDecoratorsModule() {
    }

    @Provides
    @IntoSet
    public final MetricDecorator providesDeviceMetricDecorator(IAppInfoService appInfoService) {
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        return new DeviceMetricDecorator(appInfoService);
    }

    @Provides
    @IntoSet
    public final MetricDecorator providesUserMetricDecorator(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return new UserMetricDecorator(userContextManager);
    }
}
