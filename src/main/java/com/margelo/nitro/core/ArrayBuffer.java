package com.margelo.nitro.core;

import android.hardware.HardwareBuffer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.jni.HybridData;
import com.margelo.nitro.utils.HardwareBufferUtils;
import dalvik.annotation.optimization.FastNative;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayBuffer.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0013\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eJ\b\u0010\u0018\u001a\u00020\u0007H\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0000J\u0011\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0003H\u0082 J\u0015\u0010\u001e\u001a\u00020\n2\n\u0010\u001f\u001a\u00060\u0001j\u0002` H\u0083 J\u0011\u0010!\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0082 J\r\u0010\"\u001a\u00060\u0001j\u0002` H\u0082 J\t\u0010#\u001a\u00020\u000eH\u0083 J\t\u0010$\u001a\u00020\u000eH\u0083 J\t\u0010%\u001a\u00020\u000eH\u0083 J\t\u0010&\u001a\u00020\u0013H\u0083 R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/margelo/nitro/core/ArrayBuffer;", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "<init>", "(Ljava/nio/ByteBuffer;)V", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "(Landroid/hardware/HardwareBuffer;)V", "hybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "isOwner", "", "()Z", "isByteBuffer", "isHardwareBuffer", "size", "", "getSize", "()I", "getBuffer", "copyIfNeeded", "getHardwareBuffer", "toByteArray", "", "asOwning", "initHybrid", "buffer", "initHybridBoxedHardwareBuffer", "hardwareBufferBoxed", "Lcom/margelo/nitro/core/BoxedHardwareBuffer;", "getByteBuffer", "getHardwareBufferBoxed", "getIsOwner", "getIsByteBuffer", "getIsHardwareBuffer", "getBufferSize", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArrayBuffer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HybridData mHybridData;

    @FastNative
    private final native int getBufferSize();

    private final native ByteBuffer getByteBuffer(boolean copyIfNeeded);

    private final native Object getHardwareBufferBoxed();

    @FastNative
    private final native boolean getIsByteBuffer();

    @FastNative
    private final native boolean getIsHardwareBuffer();

    @FastNative
    private final native boolean getIsOwner();

    private final native HybridData initHybrid(ByteBuffer buffer);

    private final native HybridData initHybridBoxedHardwareBuffer(Object hardwareBufferBoxed);

    public final boolean isOwner() {
        return getIsOwner();
    }

    public final boolean isByteBuffer() {
        return getIsByteBuffer();
    }

    public final boolean isHardwareBuffer() {
        return getIsHardwareBuffer();
    }

    public final int getSize() {
        return getBufferSize();
    }

    public final ByteBuffer getBuffer(boolean copyIfNeeded) {
        return getByteBuffer(copyIfNeeded);
    }

    public final HardwareBuffer getHardwareBuffer() {
        Object hardwareBufferBoxed = getHardwareBufferBoxed();
        Intrinsics.checkNotNull(hardwareBufferBoxed, "null cannot be cast to non-null type android.hardware.HardwareBuffer");
        return (HardwareBuffer) hardwareBufferBoxed;
    }

    public final byte[] toByteArray() {
        ByteBuffer buffer = getBuffer(false);
        if (buffer.hasArray()) {
            byte[] bArrArray = buffer.array();
            if (bArrArray.length == getSize()) {
                Intrinsics.checkNotNull(bArrArray);
                return bArrArray;
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(buffer.capacity());
        byteBufferAllocate.put(buffer);
        byte[] bArrArray2 = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray2, "array(...)");
        return bArrArray2;
    }

    public final ArrayBuffer asOwning() {
        return !isOwner() ? INSTANCE.copy(this) : this;
    }

    public ArrayBuffer(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        if (!byteBuffer.isDirect()) {
            throw new Error("ArrayBuffers can only be created from direct ByteBuffers, and the given ByteBuffer is not direct!");
        }
        this.mHybridData = initHybrid(byteBuffer);
    }

    public ArrayBuffer(HardwareBuffer hardwareBuffer) {
        Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
        if (hardwareBuffer.isClosed()) {
            throw new Error("Cannot create ArrayBuffer from an already-closed HardwareBuffer!");
        }
        this.mHybridData = initHybridBoxedHardwareBuffer(hardwareBuffer);
    }

    private ArrayBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    /* JADX INFO: compiled from: ArrayBuffer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0011"}, d2 = {"Lcom/margelo/nitro/core/ArrayBuffer$Companion;", "", "<init>", "()V", "allocate", "Lcom/margelo/nitro/core/ArrayBuffer;", "size", "", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "other", "byteBuffer", "Ljava/nio/ByteBuffer;", "byteArray", "", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "wrap", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArrayBuffer allocate(int size) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size);
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new ArrayBuffer(byteBufferAllocateDirect);
        }

        public final ArrayBuffer copy(ArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other.isHardwareBuffer()) {
                return copy(other.getHardwareBuffer());
            }
            return copy(other.getBuffer(false));
        }

        public final ArrayBuffer copy(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
            byteBufferAllocateDirect.put(byteBuffer);
            byteBufferAllocateDirect.rewind();
            byteBuffer.rewind();
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new ArrayBuffer(byteBufferAllocateDirect);
        }

        public final ArrayBuffer copy(byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteArray.length);
            byteBufferAllocateDirect.put(byteArray);
            Companion companion = ArrayBuffer.INSTANCE;
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return companion.wrap(byteBufferAllocateDirect);
        }

        public final ArrayBuffer copy(HardwareBuffer hardwareBuffer) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            return new ArrayBuffer(HardwareBufferUtils.INSTANCE.copyHardwareBuffer(hardwareBuffer));
        }

        public final ArrayBuffer wrap(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            return new ArrayBuffer(byteBuffer);
        }

        public final ArrayBuffer wrap(HardwareBuffer hardwareBuffer) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            return new ArrayBuffer(hardwareBuffer);
        }
    }
}
