package com.pspdfkit.instant.internal.jni;

import java.util.EnumSet;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeServerChangeApplicatorChanges {
    final EnumSet<NativeLayerCapabilities> mCapabilities;
    final HashSet<Integer> mInvalidatedPages;

    public NativeServerChangeApplicatorChanges(HashSet<Integer> hashSet, EnumSet<NativeLayerCapabilities> enumSet) {
        this.mInvalidatedPages = hashSet;
        this.mCapabilities = enumSet;
    }

    public EnumSet<NativeLayerCapabilities> getCapabilities() {
        return this.mCapabilities;
    }

    public HashSet<Integer> getInvalidatedPages() {
        return this.mInvalidatedPages;
    }

    public String toString() {
        return "NativeServerChangeApplicatorChanges{mInvalidatedPages=" + this.mInvalidatedPages + ",mCapabilities=" + this.mCapabilities + "}";
    }
}
