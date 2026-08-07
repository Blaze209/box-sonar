package com.fasterxml.jackson.core.util;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes13.dex */
public class BufferRecyclers {
    public static final String SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS = "com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers";
    private static final ThreadLocalBufferManager _bufferRecyclerTracker;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef;

    static {
        boolean zEquals;
        try {
            zEquals = TelemetryEventStrings.Value.TRUE.equals(System.getProperty(SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        _bufferRecyclerTracker = zEquals ? ThreadLocalBufferManager.instance() : null;
        _recyclerRef = new ThreadLocal<>();
    }

    public static BufferRecycler getBufferRecycler() {
        SoftReference<BufferRecycler> softReference;
        ThreadLocal<SoftReference<BufferRecycler>> threadLocal = _recyclerRef;
        SoftReference<BufferRecycler> softReference2 = threadLocal.get();
        BufferRecycler bufferRecycler = softReference2 == null ? null : softReference2.get();
        if (bufferRecycler == null) {
            bufferRecycler = new BufferRecycler();
            ThreadLocalBufferManager threadLocalBufferManager = _bufferRecyclerTracker;
            if (threadLocalBufferManager != null) {
                softReference = threadLocalBufferManager.wrapAndTrack(bufferRecycler);
            } else {
                softReference = new SoftReference<>(bufferRecycler);
            }
            threadLocal.set(softReference);
        }
        return bufferRecycler;
    }

    public static int releaseBuffers() {
        ThreadLocalBufferManager threadLocalBufferManager = _bufferRecyclerTracker;
        if (threadLocalBufferManager != null) {
            return threadLocalBufferManager.releaseBuffers();
        }
        return -1;
    }
}
