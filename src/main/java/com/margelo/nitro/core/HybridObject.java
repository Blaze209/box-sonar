package com.margelo.nitro.core;

import com.facebook.jni.HybridData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: HybridObject.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0017J\b\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0014R\u0014\u0010\u0004\u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/margelo/nitro/core/HybridObject;", "", "<init>", "()V", "memorySize", "", "getMemorySize", "()J", "dispose", "", "toString", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "updateNative", "hybridData", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HybridObject {
    private HybridData mHybridData;

    public void dispose() {
    }

    public long getMemorySize() {
        return 0L;
    }

    public String toString() {
        return "[HybridObject " + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "]";
    }

    protected void updateNative(HybridData hybridData) {
        Intrinsics.checkNotNullParameter(hybridData, "hybridData");
        this.mHybridData = hybridData;
    }
}
