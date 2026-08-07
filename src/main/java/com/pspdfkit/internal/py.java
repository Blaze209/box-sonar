package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class py {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof py) && Float.compare(2.0f, 2.0f) == 0 && Float.compare(0.15f, 0.15f) == 0;
    }

    public final int hashCode() {
        return Long.hashCode(100L) + kv.a(0.15f, Float.hashCode(2.0f) * 31, 31);
    }

    public final String toString() {
        return "RenderConfig(paddingFactor=2.0, reRenderThreshold=0.15, zoomDebounceMs=100)";
    }
}
