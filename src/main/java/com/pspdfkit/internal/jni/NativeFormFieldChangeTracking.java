package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormFieldChangeTracking {
    final ArrayList<NativeFormField> mCreated;
    final int mGenerationId;
    final int mLastChangeId;
    final HashMap<Integer, Integer> mRemoved;
    final ArrayList<NativeFormField> mUpdated;

    public NativeFormFieldChangeTracking(HashMap<Integer, Integer> map, ArrayList<NativeFormField> arrayList, ArrayList<NativeFormField> arrayList2, int i, int i2) {
        this.mRemoved = map;
        this.mUpdated = arrayList;
        this.mCreated = arrayList2;
        this.mGenerationId = i;
        this.mLastChangeId = i2;
    }

    public ArrayList<NativeFormField> getCreated() {
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

    public ArrayList<NativeFormField> getUpdated() {
        return this.mUpdated;
    }

    public String toString() {
        return "NativeFormFieldChangeTracking{mRemoved=" + this.mRemoved + ",mUpdated=" + this.mUpdated + ",mCreated=" + this.mCreated + ",mGenerationId=" + this.mGenerationId + ",mLastChangeId=" + this.mLastChangeId + "}";
    }
}
