package com.box.android.base.presentation.watermarking;

import com.box.android.domain.metrics.Gen204WatermarkingEventLogger;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IWatermarkService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkingReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingEnvironment;", "", "watermarkService", "Lcom/box/android/domain/services/IWatermarkService;", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "watermarkingEventLogger", "Lcom/box/android/domain/metrics/Gen204WatermarkingEventLogger;", "<init>", "(Lcom/box/android/domain/services/IWatermarkService;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/metrics/Gen204WatermarkingEventLogger;)V", "getWatermarkService", "()Lcom/box/android/domain/services/IWatermarkService;", "getRemoteItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "getWatermarkingEventLogger", "()Lcom/box/android/domain/metrics/Gen204WatermarkingEventLogger;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WatermarkingEnvironment {
    public static final int $stable = 8;
    private final IRemoteItemService remoteItemService;
    private final IWatermarkService watermarkService;
    private final Gen204WatermarkingEventLogger watermarkingEventLogger;

    @Inject
    public WatermarkingEnvironment(IWatermarkService watermarkService, IRemoteItemService remoteItemService, Gen204WatermarkingEventLogger watermarkingEventLogger) {
        Intrinsics.checkNotNullParameter(watermarkService, "watermarkService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(watermarkingEventLogger, "watermarkingEventLogger");
        this.watermarkService = watermarkService;
        this.remoteItemService = remoteItemService;
        this.watermarkingEventLogger = watermarkingEventLogger;
    }

    public final IWatermarkService getWatermarkService() {
        return this.watermarkService;
    }

    public final IRemoteItemService getRemoteItemService() {
        return this.remoteItemService;
    }

    public final Gen204WatermarkingEventLogger getWatermarkingEventLogger() {
        return this.watermarkingEventLogger;
    }
}
