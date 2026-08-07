package com.box.android.domain.usecases.observability;

import android.os.Build;
import com.box.android.domain.models.observability.DeviceMetric;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.services.IAppInfoService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsDecorator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/usecases/observability/DeviceMetricDecorator;", "Lcom/box/android/domain/usecases/observability/MetricDecorator;", "appInfoService", "Lcom/box/android/domain/services/IAppInfoService;", "<init>", "(Lcom/box/android/domain/services/IAppInfoService;)V", "decorate", "Lcom/box/android/domain/models/observability/Gen204Event;", "event", "getDeviceMetric", "Lcom/box/android/domain/models/observability/DeviceMetric;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeviceMetricDecorator implements MetricDecorator {
    private final IAppInfoService appInfoService;

    @Inject
    public DeviceMetricDecorator(IAppInfoService appInfoService) {
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        this.appInfoService = appInfoService;
    }

    @Override // com.box.android.domain.usecases.observability.MetricDecorator
    public Gen204Event decorate(Gen204Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        DeviceMetric device = event.getDevice();
        if (device == null) {
            device = getDeviceMetric();
        }
        event.setDevice(device);
        return event;
    }

    private final DeviceMetric getDeviceMetric() {
        return new DeviceMetric(this.appInfoService.getAppVersionName(), this.appInfoService.getAppId(), Build.MODEL, Build.VERSION.RELEASE, "Android");
    }
}
