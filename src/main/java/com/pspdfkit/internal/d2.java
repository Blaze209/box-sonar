package com.pspdfkit.internal;

import android.text.TextUtils;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.document.files.EmbeddedFileSource;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeFileResourceInformation;
import com.pspdfkit.utils.PdfLog;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class d2 extends k4 {
    public final FileAnnotation c;
    public EmbeddedFileSource d;
    public wf e;

    public d2(FileAnnotation fileAnnotation, EmbeddedFileSource embeddedFileSource) {
        this.c = fileAnnotation;
        this.d = embeddedFileSource;
        this.a = true;
        this.b = true;
    }

    @Override // com.pspdfkit.internal.k4
    public final boolean d() {
        EmbeddedFileSource embeddedFileSource;
        NativeAnnotation nativeAnnotation;
        lm internalDocument;
        if (!this.c.isAttached() || !this.a || (embeddedFileSource = this.d) == null || (nativeAnnotation = this.c.getInternal().getNativeAnnotation()) == null || (internalDocument = this.c.getInternal().getInternalDocument()) == null) {
            return false;
        }
        String strCreateFileResource = internalDocument.getAnnotationProvider().a.q.createFileResource(nativeAnnotation, new DataProviderShim(embeddedFileSource.getDataProvider()), new NativeFileResourceInformation(embeddedFileSource.getFileName(), embeddedFileSource.getFileSize() != -1 ? Long.valueOf(embeddedFileSource.getFileSize()) : null, null, embeddedFileSource.getFileDescription(), new Date(), null));
        if (TextUtils.isEmpty(strCreateFileResource)) {
            PdfLog.e("Nutri.AnnotationFileRes", "Couldn't attach file to annotation.", new Object[0]);
            return false;
        }
        FileAnnotation fileAnnotation = this.c;
        strCreateFileResource.getClass();
        this.e = new wf(fileAnnotation, strCreateFileResource);
        this.d = null;
        this.a = false;
        return true;
    }

    public d2(FileAnnotation fileAnnotation, String str) {
        this.c = fileAnnotation;
        this.e = new wf(fileAnnotation, str);
    }
}
