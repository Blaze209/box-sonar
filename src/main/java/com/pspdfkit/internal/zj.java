package com.pspdfkit.internal;

import android.os.Looper;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.ImageDocument;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.download.exceptions.DownloadException;
import com.pspdfkit.document.providers.WritableDataProvider;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeImageDocument;
import com.pspdfkit.internal.jni.NativeImageDocumentOpenResult;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class zj implements ImageDocument {
    public final DocumentSource a;
    public final NativeImageDocument b;
    public a c;

    public static class a extends lm {
        public final zj R;

        public a(zj zjVar, NativeDocument nativeDocument, nc ncVar, DocumentSource documentSource) {
            super(nativeDocument, true, ncVar, documentSource);
            this.R = zjVar;
        }

        @Override // com.pspdfkit.internal.lm
        public final boolean a(DocumentSaveOptions documentSaveOptions) throws IOException {
            throw new UnsupportedOperationException("This method is not supported for image document. Use saveIfModified() instead.");
        }

        @Override // com.pspdfkit.internal.lm
        public final Single<Boolean> b(DocumentSaveOptions documentSaveOptions) {
            throw new UnsupportedOperationException("This method is not supported for image document. Use saveIfModified() instead.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final void save(String str) throws IOException {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final Completable saveAsync(String str) {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final boolean saveIfModified() {
            return this.R.saveIfModified(true);
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final Single<Boolean> saveIfModifiedAsync() {
            return this.R.saveIfModifiedAsync(true);
        }

        @Override // com.pspdfkit.internal.lm
        public final void a(String str, DocumentSaveOptions documentSaveOptions) {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm
        public final boolean b(String str, DocumentSaveOptions documentSaveOptions) {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final void save(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final Completable saveAsync(String str, DocumentSaveOptions documentSaveOptions) {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final boolean saveIfModified(DocumentSaveOptions documentSaveOptions) {
            return this.R.saveIfModified(documentSaveOptions, true);
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final Single<Boolean> saveIfModifiedAsync(DocumentSaveOptions documentSaveOptions) {
            return this.R.saveIfModifiedAsync(documentSaveOptions, true);
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final boolean saveIfModified(String str) throws IOException {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final Single<Boolean> saveIfModifiedAsync(String str) {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final boolean saveIfModified(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }

        @Override // com.pspdfkit.internal.lm, com.pspdfkit.document.PdfDocument
        public final Single<Boolean> saveIfModifiedAsync(String str, DocumentSaveOptions documentSaveOptions) {
            throw new UnsupportedOperationException("Image documents does not support saving to path.");
        }
    }

    public zj(DocumentSource documentSource) throws IOException {
        h00 h00Var;
        if (!ar.b().a(NativeLicenseFeatures.IMAGE_DOCUMENT)) {
            throw new InvalidNutrientLicenseException("Your current license doesn't allow opening image documents.");
        }
        this.a = documentSource;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (ar.class) {
            if (ar.i == null) {
                ar.i = new h00();
            }
            h00Var = ar.i;
        }
        g00 g00VarA = h00Var.a(documentSource.getUid());
        g00VarA.readLock().lock();
        try {
            try {
                if (documentSource.isRemoteSource() && Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    throw new DownloadException.DownloadOnMainThreadException();
                }
                NativeImageDocumentOpenResult nativeImageDocumentOpenResultCreateImageDocument = NativeImageDocument.createImageDocument(documentSource.toDataDescriptor());
                NativeResult result = nativeImageDocumentOpenResultCreateImageDocument.getResult();
                if (result.getHasError()) {
                    throw new RuntimeException(result.getErrorString());
                }
                if (nativeImageDocumentOpenResultCreateImageDocument.getImageDocument() == null) {
                    throw new NullPointerException("Could not load image document");
                }
                NativeImageDocument imageDocument = nativeImageDocumentOpenResultCreateImageDocument.getImageDocument();
                g00VarA.readLock().unlock();
                this.b = imageDocument;
                PdfLog.d("Nutri.ImageDocumentImpl", "Image document open took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.", new Object[0]);
            } catch (RuntimeException e) {
                if (!e.getMessage().contains("A license for image documents and annotation editing is needed")) {
                    throw new IOException("Error while loading ImageDocument", e);
                }
                throw new InvalidNutrientLicenseException("A license for image documents and annotation editing is needed. Your PSPDFKit license can only be used with Pdf documents.");
            }
        } catch (Throwable th) {
            g00VarA.readLock().unlock();
            throw th;
        }
    }

    public final /* synthetic */ Boolean a(DocumentSaveOptions documentSaveOptions, boolean z) throws Exception {
        return Boolean.valueOf(saveIfModified(documentSaveOptions, z));
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final PdfDocument getDocument() {
        if (this.c == null) {
            if (this.b.getDocument() == null) {
                NativeResult nativeResultOpen = this.b.open();
                if (nativeResultOpen.getHasError()) {
                    PdfLog.e("Nutri.ImageDocumentImpl", "Image document couldn't be opened: %s", nativeResultOpen.getErrorString());
                    return null;
                }
            }
            this.c = new a(this, this.b.getDocument(), new nc(), this.a);
        }
        return this.c;
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final DocumentSource getImageDocumentSource() {
        return this.a;
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final boolean isValidForEditing() {
        return this.a.isFileSource() || (this.a.getDataProvider() instanceof WritableDataProvider);
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final boolean saveIfModified() {
        return saveIfModified(true);
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final Single<Boolean> saveIfModifiedAsync(final DocumentSaveOptions documentSaveOptions, final boolean z) {
        uw.a(documentSaveOptions, "saveOptions", null);
        if (getDocument() == null) {
            return Single.just(Boolean.FALSE);
        }
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.zj$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(documentSaveOptions, z);
            }
        });
        PdfDocument document = getDocument();
        return singleFromCallable.subscribeOn((document != null ? (a) document : null).b(10));
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final boolean saveIfModified(boolean z) {
        if (getDocument() == null) {
            return false;
        }
        return saveIfModified(((lm) getDocument()).a(true), z);
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final boolean saveIfModified(DocumentSaveOptions documentSaveOptions, boolean z) {
        h00 h00Var;
        uw.a(documentSaveOptions, "saveOptions", null);
        PdfDocument document = getDocument();
        a aVar = document != null ? (a) document : null;
        if (aVar == null) {
            return false;
        }
        if (!aVar.wasModified() && z) {
            PdfLog.d("Nutri.ImageDocumentImpl", "Image document not modified, not saving.", new Object[0]);
            return false;
        }
        synchronized (ar.class) {
            if (ar.i == null) {
                ar.i = new h00();
            }
            h00Var = ar.i;
        }
        g00 g00VarA = h00Var.a(this.a.getUid());
        g00VarA.writeLock().lock();
        try {
            try {
                NativeResult nativeResultSaveIfModified = this.b.saveIfModified(mr.a(documentSaveOptions, aVar, false), z);
                if (nativeResultSaveIfModified.getHasError()) {
                    throw new IOException("Image document could not be saved: " + nativeResultSaveIfModified.getErrorString());
                }
                g00VarA.writeLock().unlock();
                Iterator<lm.c> it = aVar.K.iterator();
                while (it.hasNext()) {
                    it.next().onInternalDocumentSaved(aVar);
                }
                return true;
            } catch (Exception e) {
                PdfLog.e("Nutri.ImageDocumentImpl", e, null, new Object[0]);
                Iterator<lm.c> it2 = aVar.K.iterator();
                while (it2.hasNext()) {
                    it2.next().onInternalDocumentSaveFailed(aVar, e);
                }
                g00VarA.writeLock().unlock();
                return false;
            }
        } catch (Throwable th) {
            g00VarA.writeLock().unlock();
            throw th;
        }
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final Single<Boolean> saveIfModifiedAsync() {
        return saveIfModifiedAsync(true);
    }

    @Override // com.pspdfkit.document.ImageDocument
    public final Single<Boolean> saveIfModifiedAsync(boolean z) {
        return getDocument() == null ? Single.just(Boolean.FALSE) : saveIfModifiedAsync(((lm) getDocument()).a(true), z);
    }
}
