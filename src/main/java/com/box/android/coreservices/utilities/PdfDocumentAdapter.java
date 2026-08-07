package com.box.android.coreservices.utilities;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfDocumentAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J7\u0010\u001b\u001a\u00020\u00112\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020 H\u0016¢\u0006\u0002\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/box/android/coreservices/utilities/PdfDocumentAdapter;", "Landroid/print/PrintDocumentAdapter;", "filePath", "Ljava/net/URI;", BoxCommonConstants.EXTRA_FILE_NAME, "", "pageRange", "Landroid/print/PageRange;", "<init>", "(Ljava/net/URI;Ljava/lang/String;Landroid/print/PageRange;)V", "getFilePath", "()Ljava/net/URI;", "getFileName", "()Ljava/lang/String;", "getPageRange", "()Landroid/print/PageRange;", "onLayout", "", "oldAttributes", "Landroid/print/PrintAttributes;", "newAttributes", "cancellationSignal", "Landroid/os/CancellationSignal;", "callback", "Landroid/print/PrintDocumentAdapter$LayoutResultCallback;", "extras", "Landroid/os/Bundle;", "onWrite", SupportedFileExtensions.PAGES_EXTENSION, "", FirebaseAnalytics.Param.DESTINATION, "Landroid/os/ParcelFileDescriptor;", "Landroid/print/PrintDocumentAdapter$WriteResultCallback;", "([Landroid/print/PageRange;Landroid/os/ParcelFileDescriptor;Landroid/os/CancellationSignal;Landroid/print/PrintDocumentAdapter$WriteResultCallback;)V", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfDocumentAdapter extends PrintDocumentAdapter {
    private final String fileName;
    private final URI filePath;
    private final PageRange pageRange;

    public PdfDocumentAdapter(URI filePath, String fileName, PageRange pageRange) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(pageRange, "pageRange");
        this.filePath = filePath;
        this.fileName = fileName;
        this.pageRange = pageRange;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PdfDocumentAdapter(URI uri, String str, PageRange ALL_PAGES, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            ALL_PAGES = PageRange.ALL_PAGES;
            Intrinsics.checkNotNullExpressionValue(ALL_PAGES, "ALL_PAGES");
        }
        this(uri, str, ALL_PAGES);
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final URI getFilePath() {
        return this.filePath;
    }

    public final PageRange getPageRange() {
        return this.pageRange;
    }

    @Override // android.print.PrintDocumentAdapter
    public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback callback, Bundle extras) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (cancellationSignal != null) {
            if (cancellationSignal.isCanceled()) {
                callback.onLayoutCancelled();
                return;
            }
            PrintDocumentInfo.Builder pageCount = new PrintDocumentInfo.Builder(this.fileName).setContentType(0).setPageCount(-1);
            Intrinsics.checkNotNullExpressionValue(pageCount, "setPageCount(...)");
            callback.onLayoutFinished(pageCount.build(), !Intrinsics.areEqual(newAttributes, oldAttributes));
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c9 A[Catch: IOException -> 0x00c5, TRY_LEAVE, TryCatch #0 {IOException -> 0x00c5, blocks: (B:38:0x00c1, B:42:0x00c9), top: B:56:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e7 A[Catch: IOException -> 0x00e3, TRY_LEAVE, TryCatch #2 {IOException -> 0x00e3, blocks: (B:48:0x00df, B:52:0x00e7), top: B:58:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // android.print.PrintDocumentAdapter
    public void onWrite(PageRange[] pages, ParcelFileDescriptor destination, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback callback) throws Throwable {
        OutputStream outputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Exception e;
        String tag;
        String message;
        StringBuilder sb;
        ?? r1 = SupportedFileExtensions.PAGES_EXTENSION;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            try {
                fileInputStream = new FileInputStream(new File(this.filePath));
                try {
                    fileOutputStream = new FileOutputStream(destination.getFileDescriptor());
                    try {
                        byte[] bArr = new byte[16384];
                        for (int i = fileInputStream.read(bArr); i >= 0 && (cancellationSignal == null || !cancellationSignal.isCanceled()); i = fileInputStream.read(bArr)) {
                            fileOutputStream.write(bArr, 0, i);
                        }
                        if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                            callback.onWriteCancelled();
                        } else {
                            callback.onWriteFinished(new PageRange[]{this.pageRange});
                        }
                        try {
                            fileInputStream.close();
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            tag = com.box.android.domain.utils.ExtensionsKt.getTAG(this);
                            message = e2.getMessage();
                            sb = new StringBuilder("Exception while closing streams ");
                            BoxLogUtils.e(tag, sb.append(message).toString());
                        }
                    } catch (Exception e3) {
                        e = e3;
                        callback.onWriteFailed(e.getMessage());
                        BoxLogUtils.e(com.box.android.domain.utils.ExtensionsKt.getTAG(this), "Print Failed " + e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                tag = com.box.android.domain.utils.ExtensionsKt.getTAG(this);
                                message = e4.getMessage();
                                sb = new StringBuilder("Exception while closing streams ");
                                BoxLogUtils.e(tag, sb.append(message).toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream;
                    e = e;
                    callback.onWriteFailed(e.getMessage());
                    BoxLogUtils.e(com.box.android.domain.utils.ExtensionsKt.getTAG(this), "Print Failed " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    r1 = fileInputStream;
                    th = th;
                    if (r1 != 0) {
                        try {
                            r1.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        } catch (IOException e6) {
                            BoxLogUtils.e(com.box.android.domain.utils.ExtensionsKt.getTAG(this), "Exception while closing streams " + e6.getMessage());
                            throw th;
                        }
                    } else if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    r1.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } else if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            r1 = 0;
            outputStream = null;
        }
    }
}
