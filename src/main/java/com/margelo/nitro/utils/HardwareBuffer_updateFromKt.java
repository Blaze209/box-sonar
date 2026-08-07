package com.margelo.nitro.utils;

import android.hardware.HardwareBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HardwareBuffer+updateFrom.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"updateFrom", "", "Landroid/hardware/HardwareBuffer;", "hardwareBuffer", "react-native-nitro-modules_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HardwareBuffer_updateFromKt {
    public static final void updateFrom(HardwareBuffer hardwareBuffer, HardwareBuffer hardwareBuffer2) {
        Intrinsics.checkNotNullParameter(hardwareBuffer, "<this>");
        Intrinsics.checkNotNullParameter(hardwareBuffer2, "hardwareBuffer");
        HardwareBufferUtils.INSTANCE.copyHardwareBuffer(hardwareBuffer2, hardwareBuffer);
    }
}
