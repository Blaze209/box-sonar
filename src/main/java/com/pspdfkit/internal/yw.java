package com.pspdfkit.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import com.pspdfkit.document.printing.PrintOptions;
import com.pspdfkit.document.processor.PdfProcessorTask;

/* JADX INFO: loaded from: classes3.dex */
public final class yw extends PrintDocumentAdapter {
    public final ax a;
    public final b b;

    public interface b {
        void a();
    }

    public yw(Context context, lm lmVar, PrintOptions printOptions, PdfProcessorTask pdfProcessorTask, b bVar) {
        this.b = bVar;
        this.a = new ax(context, lmVar, printOptions, pdfProcessorTask);
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onFinish() {
        super.onFinish();
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        this.a.a(printAttributes, printAttributes2, cancellationSignal, new a(layoutResultCallback), bundle);
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        ax axVar = this.a;
        PrintAttributes printAttributes = axVar.e;
        if (printAttributes == null) {
            writeResultCallback.onWriteFailed(null);
        } else {
            new bc(axVar.d, axVar.f, printAttributes, axVar.g).a(pageRangeArr, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    public static class a implements ax.a {
        public final PrintDocumentAdapter.LayoutResultCallback a;

        public a(PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
            this.a = layoutResultCallback;
        }

        public final void a(String str, int i, boolean z) {
            this.a.onLayoutFinished(new PrintDocumentInfo.Builder(str).setContentType(0).setPageCount(i).build(), z);
        }

        public final void b() {
            this.a.onLayoutFailed(null);
        }

        public final void a() {
            this.a.onLayoutCancelled();
        }
    }
}
