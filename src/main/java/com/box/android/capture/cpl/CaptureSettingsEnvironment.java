package com.box.android.capture.cpl;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSettingsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;", "", "launchIntoCaptureUseCase", "Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureUseCase;", "capturePreferencesService", "Lcom/box/android/domain/services/ICapturePreferencesService;", "<init>", "(Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureUseCase;Lcom/box/android/domain/services/ICapturePreferencesService;)V", "getLaunchIntoCaptureUseCase", "()Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureUseCase;", "getCapturePreferencesService", "()Lcom/box/android/domain/services/ICapturePreferencesService;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CaptureSettingsEnvironment {
    public static final int $stable = 8;
    private final ICapturePreferencesService capturePreferencesService;
    private final LaunchIntoCaptureUseCase launchIntoCaptureUseCase;

    public static /* synthetic */ CaptureSettingsEnvironment copy$default(CaptureSettingsEnvironment captureSettingsEnvironment, LaunchIntoCaptureUseCase launchIntoCaptureUseCase, ICapturePreferencesService iCapturePreferencesService, int i, Object obj) {
        if ((i & 1) != 0) {
            launchIntoCaptureUseCase = captureSettingsEnvironment.launchIntoCaptureUseCase;
        }
        if ((i & 2) != 0) {
            iCapturePreferencesService = captureSettingsEnvironment.capturePreferencesService;
        }
        return captureSettingsEnvironment.copy(launchIntoCaptureUseCase, iCapturePreferencesService);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LaunchIntoCaptureUseCase getLaunchIntoCaptureUseCase() {
        return this.launchIntoCaptureUseCase;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ICapturePreferencesService getCapturePreferencesService() {
        return this.capturePreferencesService;
    }

    public final CaptureSettingsEnvironment copy(LaunchIntoCaptureUseCase launchIntoCaptureUseCase, ICapturePreferencesService capturePreferencesService) {
        Intrinsics.checkNotNullParameter(launchIntoCaptureUseCase, "launchIntoCaptureUseCase");
        Intrinsics.checkNotNullParameter(capturePreferencesService, "capturePreferencesService");
        return new CaptureSettingsEnvironment(launchIntoCaptureUseCase, capturePreferencesService);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureSettingsEnvironment)) {
            return false;
        }
        CaptureSettingsEnvironment captureSettingsEnvironment = (CaptureSettingsEnvironment) other;
        return Intrinsics.areEqual(this.launchIntoCaptureUseCase, captureSettingsEnvironment.launchIntoCaptureUseCase) && Intrinsics.areEqual(this.capturePreferencesService, captureSettingsEnvironment.capturePreferencesService);
    }

    public int hashCode() {
        return (this.launchIntoCaptureUseCase.hashCode() * 31) + this.capturePreferencesService.hashCode();
    }

    public String toString() {
        return "CaptureSettingsEnvironment(launchIntoCaptureUseCase=" + this.launchIntoCaptureUseCase + ", capturePreferencesService=" + this.capturePreferencesService + ")";
    }

    @Inject
    public CaptureSettingsEnvironment(LaunchIntoCaptureUseCase launchIntoCaptureUseCase, ICapturePreferencesService capturePreferencesService) {
        Intrinsics.checkNotNullParameter(launchIntoCaptureUseCase, "launchIntoCaptureUseCase");
        Intrinsics.checkNotNullParameter(capturePreferencesService, "capturePreferencesService");
        this.launchIntoCaptureUseCase = launchIntoCaptureUseCase;
        this.capturePreferencesService = capturePreferencesService;
    }

    public final LaunchIntoCaptureUseCase getLaunchIntoCaptureUseCase() {
        return this.launchIntoCaptureUseCase;
    }

    public final ICapturePreferencesService getCapturePreferencesService() {
        return this.capturePreferencesService;
    }
}
