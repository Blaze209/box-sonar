package com.box.android.capture;

import com.box.android.domain.models.capture.CaptureMode;
import kotlin.Metadata;

/* JADX INFO: compiled from: IPermissionHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/IPermissionHandler;", "", "areAllPermissionsGranted", "", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "onPermissionsGranted", "", "requiredPermissions", "", "", "(Lcom/box/android/domain/models/capture/CaptureMode;)[Ljava/lang/String;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPermissionHandler {
    boolean areAllPermissionsGranted(CaptureMode captureMode);

    void onPermissionsGranted(CaptureMode captureMode);

    String[] requiredPermissions(CaptureMode captureMode);
}
