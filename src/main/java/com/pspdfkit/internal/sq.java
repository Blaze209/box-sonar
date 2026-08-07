package com.pspdfkit.internal;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes3.dex */
public final class sq {
    public static final String a(ActivityManager.MemoryInfo memoryInfo) {
        return "Total memory: " + (memoryInfo.totalMem / 1048576.0f) + " MB, Available memory: " + (memoryInfo.availMem / 1048576.0f) + " MB, Low memory: " + memoryInfo.lowMemory;
    }
}
