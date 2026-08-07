package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentDescriptor {
    final String mBaseURL;
    final ArrayList<NativeDataDescriptor> mDataDescriptors;

    public NativeDocumentDescriptor(ArrayList<NativeDataDescriptor> arrayList, String str) {
        this.mDataDescriptors = arrayList;
        this.mBaseURL = str;
    }

    public String getBaseURL() {
        return this.mBaseURL;
    }

    public ArrayList<NativeDataDescriptor> getDataDescriptors() {
        return this.mDataDescriptors;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeDocumentDescriptor{mDataDescriptors=").append(this.mDataDescriptors).append(",mBaseURL="), this.mBaseURL, "}");
    }
}
