package com.box.android.capture;

import androidx.camera.core.CameraSelector;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraSession.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/capture/CameraSession;", "", "<init>", "()V", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "getCameraSelector", "()Landroidx/camera/core/CameraSelector;", "setCameraSelector", "(Landroidx/camera/core/CameraSelector;)V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CameraSession {
    public static final int $stable = 8;
    private CameraSelector cameraSelector;

    @Inject
    public CameraSession() {
        CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
        this.cameraSelector = DEFAULT_BACK_CAMERA;
    }

    public final CameraSelector getCameraSelector() {
        return this.cameraSelector;
    }

    public final void setCameraSelector(CameraSelector cameraSelector) {
        Intrinsics.checkNotNullParameter(cameraSelector, "<set-?>");
        this.cameraSelector = cameraSelector;
    }
}
