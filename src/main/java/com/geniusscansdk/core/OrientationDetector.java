package com.geniusscansdk.core;

import android.content.Context;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public class OrientationDetector {
    private ByteBuffer modelBuffer;
    private long nativeHandle;

    private static native long createDetector(ByteBuffer byteBuffer);

    private static native void deleteDetector(long j);

    OrientationDetector(Context context) throws IOException {
        MappedByteBuffer mappedByteBufferLoad = ModelLoader.load(context, "mobilenetV2_orientation_quant_opti.png");
        this.modelBuffer = mappedByteBufferLoad;
        this.nativeHandle = createDetector(mappedByteBufferLoad);
    }

    protected void finalize() {
        this.nativeHandle = 0L;
        deleteDetector(0L);
        this.modelBuffer = null;
    }

    long getNativeHandle() {
        return this.nativeHandle;
    }

    static {
        System.loadLibrary("gssdk-core");
    }
}
