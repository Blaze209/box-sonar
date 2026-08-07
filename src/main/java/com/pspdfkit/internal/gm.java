package com.pspdfkit.internal;

import com.pspdfkit.instant.client.InstantClient;
import com.pspdfkit.instant.client.InstantDocumentDescriptor;
import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeDocumentResult;
import com.pspdfkit.instant.internal.jni.NativeLayerCapabilities;
import com.pspdfkit.instant.internal.jni.NativeLayerDocumentContainer;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.EnumSet;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class gm {
    public final InstantDocumentDescriptor a;
    public final InstantClient b;
    public final NativeServerDocumentLayer c;
    public final String d;
    public final String e;
    public String f;
    public hm g;
    public pl h;
    public zk i;
    public il j;
    public Flowable<InstantProgress> k;
    public final kl l = new kl(this);

    public gm(InstantDocumentDescriptor instantDocumentDescriptor, InstantClient instantClient, NativeServerDocumentLayer nativeServerDocumentLayer) {
        this.a = instantDocumentDescriptor;
        this.b = instantClient;
        this.c = nativeServerDocumentLayer;
        this.d = nativeServerDocumentLayer.getDocumentIdentifier();
        this.e = nativeServerDocumentLayer.getLayerName();
    }

    public final synchronized Flowable<InstantProgress> a(String str) {
        uw.a(str, "jwt", null);
        wl.a(str, this.d, this.e);
        if (this.c.isDownloaded()) {
            return Flowable.fromArray(rl.d);
        }
        try {
            final wl wlVarA = wl.a(str);
            final rl rlVar = new rl(this.c);
            Flowable<InstantProgress> flowable = this.k;
            if (flowable == null) {
                this.k = rlVar.a(wlVarA).share();
            } else {
                this.k = flowable.onErrorResumeNext(new Function() { // from class: com.pspdfkit.internal.gm$$ExternalSyntheticLambda1
                    @Override // io.reactivex.rxjava3.functions.Function
                    public final Object apply(Object obj) {
                        return rlVar.a(wlVarA);
                    }
                }).share();
            }
            return this.k;
        } catch (InstantException e) {
            return Flowable.error(e);
        }
    }

    public final InstantPdfDocument b(String str) throws Exception {
        hm hmVar;
        synchronized (this) {
            if (this.g == null) {
                if (!this.c.isDownloaded()) {
                    throw new IllegalStateException("Document must be downloaded before opening!");
                }
                NativeDocumentResult document = this.c.getDocument();
                if (document.isError()) {
                    throw lr.a(document.error());
                }
                NativeLayerDocumentContainer nativeLayerDocumentContainerValue = document.value();
                NativeDocument document2 = nativeLayerDocumentContainerValue.getDocument();
                if (document2 == null) {
                    throw new IllegalStateException("Instant document could not be opened");
                }
                this.h = new pl(this);
                this.j = new il(this);
                InstantClient instantClient = this.b;
                InstantDocumentDescriptor instantDocumentDescriptor = this.a;
                EnumSet<NativeLayerCapabilities> layerCapabilities = nativeLayerDocumentContainerValue.getLayerCapabilities();
                il ilVar = this.j;
                int i = hm.V;
                instantClient.getClass();
                layerCapabilities.getClass();
                ilVar.getClass();
                this.g = new hm(instantClient, instantDocumentDescriptor, layerCapabilities, ilVar, document2);
                this.i = new zk(this.g);
            }
            hmVar = this.g;
        }
        if (str != null) {
            try {
                wl.a(str, this.d, this.e);
                this.f = str;
                this.l.a(str).blockingAwait();
                return hmVar;
            } catch (InstantException e) {
                PdfLog.d("Nutri.IntInstDocDescr", e, "Can't update authentication token", new Object[0]);
            }
        }
        return hmVar;
    }

    public final Single<InstantPdfDocument> c(final String str) {
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.gm$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.b(str);
            }
        });
    }

    public final synchronized pl a() {
        pl plVar;
        plVar = this.h;
        if (plVar == null) {
            throw new IllegalStateException("getDocumentDelegate must be called only after InstantPdfDocument has been opened!");
        }
        return plVar;
    }

    public final InstantDocumentState b() {
        switch (lr.a.b[this.c.getCurrentState().ordinal()]) {
            case 1:
            case 2:
                new IllegalArgumentException("Android neither needs nor supports content migrations - yet.");
                return InstantDocumentState.UNKNOWN;
            case 3:
                return InstantDocumentState.NEEDS_RESET_FOR_DATABASE_MIGRATION;
            case 4:
                return InstantDocumentState.RESETTING_FOR_DATABASE_MIGRATION;
            case 5:
                return InstantDocumentState.CLEAN;
            case 6:
                return InstantDocumentState.DIRTY;
            case 7:
                return InstantDocumentState.SENDING_CHANGES;
            case 8:
                return InstantDocumentState.RECEIVING_CHANGES;
            case 9:
                return InstantDocumentState.INVALID;
            default:
                return InstantDocumentState.UNKNOWN;
        }
    }
}
