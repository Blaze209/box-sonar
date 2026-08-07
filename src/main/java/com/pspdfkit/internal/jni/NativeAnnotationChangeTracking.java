package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnnotationChangeTracking {
    final ArrayList<NativeAnnotation> mCreated;
    final int mGenerationId;
    final int mLastChangeId;
    final HashMap<Integer, Integer> mRemoved;
    final ArrayList<NativeAnnotation> mUpdated;

    public NativeAnnotationChangeTracking(HashMap<Integer, Integer> map, ArrayList<NativeAnnotation> arrayList, ArrayList<NativeAnnotation> arrayList2, int i, int i2) {
        this.mRemoved = map;
        this.mUpdated = arrayList;
        this.mCreated = arrayList2;
        this.mGenerationId = i;
        this.mLastChangeId = i2;
    }

    public ArrayList<NativeAnnotation> getCreated() {
        return this.mCreated;
    }

    public int getGenerationId() {
        return this.mGenerationId;
    }

    public int getLastChangeId() {
        return this.mLastChangeId;
    }

    public HashMap<Integer, Integer> getRemoved() {
        return this.mRemoved;
    }

    public ArrayList<NativeAnnotation> getUpdated() {
        return this.mUpdated;
    }

    public String toString() {
        return "NativeAnnotationChangeTracking{mRemoved=" + this.mRemoved + ",mUpdated=" + this.mUpdated + ",mCreated=" + this.mCreated + ",mGenerationId=" + this.mGenerationId + ",mLastChangeId=" + this.mLastChangeId + "}";
    }
}
