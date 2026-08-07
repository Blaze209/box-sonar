package com.box.android.capture.documentscanning.logic;

import kotlin.Metadata;

/* JADX INFO: compiled from: EditScannedPageUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"getAngleForRotating90CCW", "", "currentAngle", "capture_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EditScannedPageUtilsKt {
    public static final int getAngleForRotating90CCW(int i) {
        return (i + 270) % 360;
    }
}
