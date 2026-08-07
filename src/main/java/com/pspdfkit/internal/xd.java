package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeDocumentMetadata;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class xd {
    public final boolean a;
    public final NativeDocumentMetadata b;
    public final HashMap c;
    public boolean d;

    public xd(lm lmVar, boolean z) {
        this.a = z;
        NativeDocumentMetadata nativeDocumentMetadataCreate = NativeDocumentMetadata.create(lmVar.y);
        nativeDocumentMetadataCreate.getClass();
        this.b = nativeDocumentMetadataCreate;
        HashMap<String, String> metadata = lmVar.y.getMetadata();
        metadata.getClass();
        this.c = metadata;
    }

    public final void a() {
        synchronized (this) {
            this.d = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean hasUnsavedChanges() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }
}
