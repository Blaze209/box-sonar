package com.pspdfkit.internal;

import com.pspdfkit.bookmarks.BookmarkProvider;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.instant.annotations.InstantAnnotationProvider;
import com.pspdfkit.instant.client.InstantClient;
import com.pspdfkit.instant.client.InstantDocumentDescriptor;
import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.internal.jni.NativeLayerCapabilities;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import com.pspdfkit.internal.jni.NativeDocument;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import java.util.EnumSet;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx3.RxConvertKt;

/* JADX INFO: loaded from: classes3.dex */
public final class hm extends lm implements InstantPdfDocument {
    public static final /* synthetic */ int V = 0;
    public final InstantClient R;
    public final InstantDocumentDescriptor S;
    public final t4 T;
    public final EnumSet<NativeLayerCapabilities> U;

    public static final class a extends nc {
        public final /* synthetic */ InstantDocumentDescriptor a;
        public final /* synthetic */ il b;

        public a(InstantDocumentDescriptor instantDocumentDescriptor, il ilVar) {
            this.a = instantDocumentDescriptor;
            this.b = ilVar;
        }

        @Override // com.pspdfkit.internal.nc, com.pspdfkit.internal.qm
        public final o3 a(lm lmVar) {
            gm internal = this.a.getInternal();
            internal.getClass();
            return new wk(lmVar, internal, this.b);
        }

        @Override // com.pspdfkit.internal.nc, com.pspdfkit.internal.qm
        public final yd b(lm lmVar) {
            return new yd(lmVar, false);
        }

        @Override // com.pspdfkit.internal.nc, com.pspdfkit.internal.qm
        public final we c(lm lmVar) {
            return new we(lmVar, false);
        }
    }

    public hm(InstantClient instantClient, InstantDocumentDescriptor instantDocumentDescriptor, EnumSet enumSet, il ilVar, NativeDocument nativeDocument) {
        super(nativeDocument, false, new a(instantDocumentDescriptor, ilVar), null);
        this.R = instantClient;
        this.S = instantDocumentDescriptor;
        if (!enumSet.contains(NativeLayerCapabilities.WRITE)) {
            EnumSet enumSetClone = this.G.clone();
            enumSetClone.getClass();
            enumSetClone.remove(DocumentPermissions.ANNOTATIONS_AND_FORMS);
            this.G = enumSetClone;
        }
        EnumSet<NativeLayerCapabilities> enumSetClone2 = enumSet.clone();
        enumSetClone2.getClass();
        this.U = enumSetClone2;
        super.setAutomaticLinkGenerationEnabled(false);
        this.T = new t4(this);
    }

    @Override // com.pspdfkit.internal.lm
    public final boolean a() {
        if (this.U.contains(NativeLayerCapabilities.WRITE)) {
            return super.a();
        }
        return true;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final void addInstantDocumentListener(InstantDocumentListener instantDocumentListener) {
        instantDocumentListener.getClass();
        pl plVarA = this.S.getInternal().a();
        sl slVar = new sl(instantDocumentListener);
        plVarA.getClass();
        plVarA.b.a(slVar);
    }

    @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
    public final BookmarkProvider getBookmarkProvider() {
        throw new UnsupportedOperationException("Bookmarks are not supported in instant documents!");
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final long getDelayForSyncingLocalChanges() {
        return this.T.k;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final InstantDocumentState getDocumentState() {
        InstantDocumentState instantDocumentStateB = this.S.getInternal().b();
        instantDocumentStateB.getClass();
        return instantDocumentStateB;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final InstantClient getInstantClient() {
        return this.R;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final InstantDocumentDescriptor getInstantDocumentDescriptor() {
        return this.S;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final boolean isListeningToServerChanges() {
        return this.T.j;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final void notifyConnectivityChanged(boolean z) {
        il ilVar;
        t4 t4Var = this.T;
        if (t4Var.f != z) {
            t4Var.f = z;
            if (z) {
                t4Var.a(false);
            } else {
                t4Var.b();
            }
        }
        if (z) {
            gm internal = this.S.getInternal();
            synchronized (internal) {
                ilVar = internal.j;
                if (ilVar == null) {
                    throw new IllegalStateException("getAssetProvider() must be called only after InstantPdfDocument has been opened!");
                }
            }
            ilVar.a();
        }
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final void reauthenticateWithJwt(String str) {
        str.getClass();
        reauthenticateWithJwtAsync(str).blockingAwait();
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final Completable reauthenticateWithJwtAsync(String str) {
        str.getClass();
        gm internal = this.S.getInternal();
        internal.getClass();
        wl.a(str, internal.d, internal.e);
        internal.f = str;
        Completable completableA = internal.l.a(str);
        completableA.getClass();
        return completableA;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final void removeInstantDocumentListener(InstantDocumentListener instantDocumentListener) {
        instantDocumentListener.getClass();
        pl plVarA = this.S.getInternal().a();
        sl slVar = new sl(instantDocumentListener);
        plVarA.getClass();
        plVarA.b.b(slVar);
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final void removeLocalStorage() {
        this.S.removeLocalStorage();
    }

    @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
    public final void setAutomaticLinkGenerationEnabled(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Automatic link generation is not supported for instant documents!");
        }
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final void setDelayForSyncingLocalChanges(long j) {
        this.T.a(j);
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final void setListeningToServerChanges(boolean z) {
        t4 t4Var = this.T;
        synchronized (t4Var) {
            if (t4Var.j == z) {
                return;
            }
            t4Var.j = z;
            if (z) {
                t4Var.a(false);
            } else {
                t4Var.a();
            }
        }
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    public final Object syncAnnotations(Continuation<? super Unit> continuation) {
        t4 t4Var = this.T;
        t4Var.a();
        Object objCollect = FlowKt.collect(t4Var.a(true, false), continuation);
        if (objCollect != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objCollect = Unit.INSTANCE;
        }
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.instant.document.InstantPdfDocument
    @Deprecated(message = "Use syncAnnotations() from a coroutine context instead", replaceWith = @ReplaceWith(expression = "syncAnnotations()", imports = {}))
    public final Flowable<InstantProgress> syncAnnotationsAsync() {
        t4 t4Var = this.T;
        t4Var.a();
        return RxConvertKt.asFlowable$default(t4Var.a(true, false), null, 1, null);
    }

    @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
    public final boolean wasModified() {
        return false;
    }

    @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
    public final wk getAnnotationProvider() {
        o3 o3Var = this.e;
        if (o3Var instanceof InstantAnnotationProvider) {
            o3Var.getClass();
            return (wk) o3Var;
        }
        throw new IllegalStateException("Wrong type of annotation provider type. InstantAnnotationProvider was expected!");
    }
}
