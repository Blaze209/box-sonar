package com.pspdfkit.internal;

import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeFileResourceInformation;
import com.pspdfkit.internal.jni.NativeResourceManager;
import com.pspdfkit.internal.jni.NativeResult;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class wf implements EmbeddedFile {
    public final lm a;
    public final FileAnnotation b;
    public final String c;
    public boolean d = false;
    public String e = "";
    public long f = -1;
    public String g;
    public Date h;

    public wf(FileAnnotation fileAnnotation, String str) {
        uw.a(fileAnnotation, "annotation", null);
        uw.a(str, "resourceId", null);
        this.b = fileAnnotation;
        this.c = str;
        a();
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final FileAnnotation getAnnotation() {
        return this.b;
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final byte[] getFileData() throws IOException {
        long j = this.f;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(j != -1 ? (int) j : 1024);
        a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final String getFileDescription() {
        return this.g;
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final String getFileName() {
        String str = this.e;
        return str == null ? "" : str;
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final long getFileSize() {
        return this.f;
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final String getId() {
        return this.c;
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final Date getModificationDate() {
        return this.h;
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    /* JADX INFO: renamed from: writeToStream, reason: merged with bridge method [inline-methods] */
    public final void a(OutputStream outputStream) throws IOException {
        uw.a(outputStream, "outputStream", null);
        lm internalDocument = this.a;
        if (internalDocument == null) {
            FileAnnotation fileAnnotation = this.b;
            internalDocument = fileAnnotation != null ? fileAnnotation.getInternal().getInternalDocument() : null;
        }
        if (internalDocument == null) {
            throw new IllegalStateException("Document must not be null.");
        }
        pt ptVar = new pt(outputStream);
        NativeResourceManager nativeResourceManager = internalDocument.getAnnotationProvider().a.q;
        NativeDocument nativeDocument = internalDocument.y;
        FileAnnotation fileAnnotation2 = this.b;
        NativeResult resource = nativeResourceManager.getResource(nativeDocument, fileAnnotation2 != null ? fileAnnotation2.getInternal().getNativeAnnotation() : null, this.c, ptVar);
        if (resource.getHasError()) {
            throw new IOException("Couldn't retrieve embedded file: " + resource.getErrorString());
        }
    }

    @Override // com.pspdfkit.document.files.EmbeddedFile
    public final Completable writeToStreamAsync(final OutputStream outputStream) {
        lm internalDocument = null;
        uw.a(outputStream, "outputStream", null);
        lm lmVar = this.a;
        if (lmVar != null) {
            internalDocument = lmVar;
        } else {
            FileAnnotation fileAnnotation = this.b;
            if (fileAnnotation != null) {
                internalDocument = fileAnnotation.getInternal().getInternalDocument();
            }
        }
        return internalDocument == null ? Completable.error(new IllegalStateException("Document must not be null")) : Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.wf$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(outputStream);
            }
        }).subscribeOn(internalDocument.b(10));
    }

    public final void a() {
        synchronized (this) {
            if (this.d) {
                return;
            }
            lm internalDocument = this.a;
            if (internalDocument == null) {
                FileAnnotation fileAnnotation = this.b;
                internalDocument = fileAnnotation != null ? fileAnnotation.getInternal().getInternalDocument() : null;
            }
            if (internalDocument == null) {
                return;
            }
            NativeResourceManager nativeResourceManager = internalDocument.getAnnotationProvider().a.q;
            NativeDocument nativeDocument = internalDocument.y;
            FileAnnotation fileAnnotation2 = this.b;
            NativeFileResourceInformation fileInformation = nativeResourceManager.getFileInformation(nativeDocument, fileAnnotation2 != null ? fileAnnotation2.getInternal().getNativeAnnotation() : null, this.c);
            if (fileInformation == null) {
                return;
            }
            long jLongValue = fileInformation.getRawSize() == null ? -1L : fileInformation.getRawSize().longValue();
            if (fileInformation.getFileSize() != null) {
                jLongValue = fileInformation.getFileSize().longValue();
            }
            this.f = jLongValue;
            this.e = fileInformation.getFileName();
            this.g = fileInformation.getFileDescription();
            this.h = fileInformation.getModificationDate();
            this.d = true;
        }
    }

    public wf(lm lmVar, String str) {
        uw.a(str, "resourceId", null);
        this.a = lmVar;
        this.c = str;
        a();
    }
}
