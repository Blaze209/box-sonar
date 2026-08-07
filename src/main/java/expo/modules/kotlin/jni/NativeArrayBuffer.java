package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.exception.Exceptions;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeArrayBuffer.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0011\b\u0013\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0082 J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0010H\u0096 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0096 J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0010H\u0096 J\u0011\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0096 J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0010H\u0096 J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0010H\u0096 J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0010H\u0096 J\t\u0010\u001d\u001a\u00020\bH\u0096 J\b\u0010\u001e\u001a\u00020\u001fH\u0004J\b\u0010 \u001a\u00020\u0004H\u0016R\u0010\u0010\n\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "Lexpo/modules/kotlin/jni/Destructible;", "Lexpo/modules/kotlin/jni/ArrayBuffer;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "mHybridData", "initHybrid", "buffer", "isValid", "", "size", "", "readByte", "", ViewProps.POSITION, "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "toDirectBuffer", "finalize", "", "getHybridDataForJNIDeallocator", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeArrayBuffer implements Destructible, ArrayBuffer {
    private final HybridData mHybridData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    private final native HybridData initHybrid(ByteBuffer buffer);

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native short read2Byte(int position);

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native int read4Byte(int position);

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native long read8Byte(int position);

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native byte readByte(int position);

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native double readDouble(int position);

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native float readFloat(int position);

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native int size();

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public native ByteBuffer toDirectBuffer();

    @Override // expo.modules.kotlin.jni.ArrayBuffer
    public NativeArrayBuffer copy() {
        return ArrayBuffer.DefaultImpls.copy(this);
    }

    private NativeArrayBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeArrayBuffer(ByteBuffer byteBuffer) throws Exceptions.IllegalArgument {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        if (!byteBuffer.isDirect()) {
            throw new Exceptions.IllegalArgument("ArrayBuffers can only be created from direct ByteBuffers", null, 2, 0 == true ? 1 : 0);
        }
        this.mHybridData = initHybrid(byteBuffer);
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }

    /* JADX INFO: compiled from: NativeArrayBuffer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/jni/NativeArrayBuffer$Companion;", "", "<init>", "()V", "allocate", "Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "size", "", "wrap", "byteBuffer", "Ljava/nio/ByteBuffer;", "copyOf", "other", "Lexpo/modules/kotlin/jni/ArrayBuffer;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NativeArrayBuffer allocate(int size) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size);
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new NativeArrayBuffer(byteBufferAllocateDirect);
        }

        public final NativeArrayBuffer wrap(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            return new NativeArrayBuffer(byteBuffer);
        }

        public final NativeArrayBuffer copyOf(ArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return copyOf(other.toDirectBuffer());
        }

        public final NativeArrayBuffer copyOf(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
            byteBufferAllocateDirect.put(byteBuffer);
            byteBufferAllocateDirect.rewind();
            byteBuffer.rewind();
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new NativeArrayBuffer(byteBufferAllocateDirect);
        }
    }
}
