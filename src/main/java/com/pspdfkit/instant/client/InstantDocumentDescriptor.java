package com.pspdfkit.instant.client;

import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import com.pspdfkit.internal.gm;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wl;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

/* JADX INFO: loaded from: classes3.dex */
public final class InstantDocumentDescriptor {
    private final gm internal;

    public InstantDocumentDescriptor(InstantClient instantClient, NativeServerDocumentLayer nativeServerDocumentLayer) {
        this.internal = new gm(this, instantClient, nativeServerDocumentLayer);
    }

    public synchronized Flowable<InstantProgress> downloadDocumentAsync(String str) {
        return this.internal.a(str);
    }

    public String getCreatorName() {
        return getInternal().c.getCreatorName();
    }

    public String getDocumentId() {
        return this.internal.d;
    }

    public gm getInternal() {
        return this.internal;
    }

    public String getJwt() {
        return this.internal.f;
    }

    public String getLayerName() {
        return this.internal.e;
    }

    public String getSourcePdfSha() {
        gm gmVar = this.internal;
        if (gmVar.c.getSourcePdfSha().isError()) {
            return null;
        }
        return gmVar.c.getSourcePdfSha().value();
    }

    public String getUserId() {
        return this.internal.c.getUserId();
    }

    public boolean isDownloaded() {
        return this.internal.c.isDownloaded();
    }

    public InstantPdfDocument openDocument(String str) {
        return openDocumentAsync(str).blockingGet();
    }

    public Single<InstantPdfDocument> openDocumentAsync(String str) {
        gm gmVar = this.internal;
        gmVar.getClass();
        uw.a(str, "jwt", null);
        wl.a(str, gmVar.d, gmVar.e);
        return gmVar.c.isDownloaded() ? gmVar.c(str) : gmVar.a(str).ignoreElements().andThen(gmVar.c(str));
    }

    public void removeLocalStorage() {
        gm gmVar = this.internal;
        gmVar.c.invalidate();
        gmVar.c.removeLayerStorage();
    }
}
