package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: compiled from: JavaScriptArrayBuffer.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\t\u0010\t\u001a\u00020\nH\u0096 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0096 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\nH\u0096 J\u0011\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0096 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\nH\u0096 J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\nH\u0096 J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\nH\u0096 J\t\u0010\u0017\u001a\u00020\u0018H\u0096 J\b\u0010\u0019\u001a\u00020\u001aH\u0004J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptArrayBuffer;", "Lexpo/modules/kotlin/jni/Destructible;", "Lexpo/modules/kotlin/jni/ArrayBuffer;", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "isValid", "", "size", "", "readByte", "", ViewProps.POSITION, "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "finalize", "", "getHybridDataForJNIDeallocator", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JavaScriptArrayBuffer implements Destructible, ArrayBuffer {
    public static final int $stable = 8;
    private final HybridData mHybridData;

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

    private JavaScriptArrayBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
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
}
