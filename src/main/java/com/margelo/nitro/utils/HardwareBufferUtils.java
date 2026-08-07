package com.margelo.nitro.utils;

import android.hardware.HardwareBuffer;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HardwareBufferUtils.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/margelo/nitro/utils/HardwareBufferUtils;", "", "<init>", "()V", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HardwareBufferUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Object copyHardwareBuffer(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyHardwareBuffer(Object obj, Object obj2);

    /* JADX INFO: compiled from: HardwareBufferUtils.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00060\u0001j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0005H\u0083 J!\u0010\u0004\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u00052\n\u0010\b\u001a\u00060\u0001j\u0002`\u0005H\u0083 J\u0010\u0010\u0004\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007¨\u0006\r"}, d2 = {"Lcom/margelo/nitro/utils/HardwareBufferUtils$Companion;", "", "<init>", "()V", "copyHardwareBuffer", "Lcom/margelo/nitro/utils/BoxedHardwareBuffer;", "sourceHardwareBuffer", "", "destinationHardwareBuffer", "Landroid/hardware/HardwareBuffer;", "hardwareBuffer", "source", FirebaseAnalytics.Param.DESTINATION, "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final Object copyHardwareBuffer(Object sourceHardwareBuffer) {
            return HardwareBufferUtils.copyHardwareBuffer(sourceHardwareBuffer);
        }

        @JvmStatic
        private final void copyHardwareBuffer(Object sourceHardwareBuffer, Object destinationHardwareBuffer) {
            HardwareBufferUtils.copyHardwareBuffer(sourceHardwareBuffer, destinationHardwareBuffer);
        }

        private Companion() {
        }

        public final HardwareBuffer copyHardwareBuffer(HardwareBuffer hardwareBuffer) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            Object objCopyHardwareBuffer = copyHardwareBuffer((Object) hardwareBuffer);
            Intrinsics.checkNotNull(objCopyHardwareBuffer, "null cannot be cast to non-null type android.hardware.HardwareBuffer");
            return (HardwareBuffer) objCopyHardwareBuffer;
        }

        public final void copyHardwareBuffer(HardwareBuffer source, HardwareBuffer destination) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(destination, "destination");
            copyHardwareBuffer((Object) source, (Object) destination);
        }
    }
}
