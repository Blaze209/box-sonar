package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLibraryDocumentDescriptor {
    final ArrayList<NativeAnnotation> mAnnotations;
    final NativeDocumentDescriptor mDocumentDescriptor;
    final byte[] mMetadata;
    final String mUid;

    public NativeLibraryDocumentDescriptor(NativeDocumentDescriptor nativeDocumentDescriptor, byte[] bArr, ArrayList<NativeAnnotation> arrayList, String str) {
        this.mDocumentDescriptor = nativeDocumentDescriptor;
        this.mMetadata = bArr;
        this.mAnnotations = arrayList;
        this.mUid = str;
    }

    public ArrayList<NativeAnnotation> getAnnotations() {
        return this.mAnnotations;
    }

    public NativeDocumentDescriptor getDocumentDescriptor() {
        return this.mDocumentDescriptor;
    }

    public byte[] getMetadata() {
        return this.mMetadata;
    }

    public String getUid() {
        return this.mUid;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeLibraryDocumentDescriptor{mDocumentDescriptor=").append(this.mDocumentDescriptor).append(",mMetadata=").append(this.mMetadata).append(",mAnnotations=").append(this.mAnnotations).append(",mUid="), this.mUid, "}");
    }
}
