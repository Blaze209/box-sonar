package com.pspdfkit.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.text.TextUtils;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.printing.PrintOptions;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class ax {
    public final PrintOptions a;
    public final PdfProcessorTask b;
    public final Context c;
    public lm d;
    public PrintAttributes e;
    public Size f;
    public boolean g = false;
    public boolean h = false;

    public interface a {
    }

    public ax(Context context, lm lmVar, PrintOptions printOptions, PdfProcessorTask pdfProcessorTask) {
        this.c = context;
        this.d = lmVar;
        this.b = pdfProcessorTask;
        this.a = printOptions;
    }

    public final void a(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, final yw.a aVar, Bundle bundle) {
        if (cancellationSignal.isCanceled()) {
            aVar.a.onLayoutCancelled();
            return;
        }
        boolean z = bundle.getBoolean("EXTRA_PRINT_PREVIEW", false);
        boolean z2 = (printAttributes != null && printAttributes.equals(printAttributes2) && z == this.g) ? false : true;
        this.g = z;
        this.e = printAttributes2;
        if (printAttributes2.getMediaSize() != null) {
            this.f = new Size((int) ((printAttributes2.getMediaSize().getWidthMils() / 1000.0f) * 72.0f), (int) ((printAttributes2.getMediaSize().getHeightMils() / 1000.0f) * 72.0f));
        } else {
            this.f = NewPage.PAGE_SIZE_A4;
        }
        PdfProcessorTask processorTask = null;
        if (!this.h) {
            PdfProcessorTask pdfProcessorTask = this.b;
            if (pdfProcessorTask != null) {
                processorTask = pdfProcessorTask;
            } else {
                PrintOptions printOptions = this.a;
                if (printOptions != null) {
                    try {
                        processorTask = printOptions.getProcessorTask(this.d);
                    } catch (NutrientNotInitializedException e) {
                        PdfLog.w("Nutri.PrintLayoutHandle", e, "Failed to create PdfProcessor instance for printing.", new Object[0]);
                        aVar.a.onLayoutFailed(null);
                    }
                }
            }
        }
        if (processorTask == null) {
            this.h = true;
            int i = this.d.s;
            if (i > 0) {
                aVar.a(a(), i, z2);
                return;
            } else {
                aVar.b();
                return;
            }
        }
        String strA = a();
        File file = new File(this.c.getCacheDir(), Analytics.Event.PRINT);
        file.mkdirs();
        File file2 = new File(file, strA.replaceAll("[:\\\\/*\"?|<>']", ""));
        file2.delete();
        Flowable<PdfProcessor.ProcessorProgress> flowableOnBackpressureDrop = PdfProcessor.processDocumentAsync(processorTask, file2).onBackpressureDrop();
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        final Disposable disposable = (Disposable) flowableOnBackpressureDrop.subscribeOn(schedulerIo).subscribeWith(new zw(this, aVar, file2, z2));
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.pspdfkit.internal.ax$$ExternalSyntheticLambda0
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                ax.a(disposable, aVar);
            }
        });
    }

    public static /* synthetic */ void a(Disposable disposable, a aVar) {
        disposable.dispose();
        ((yw.a) aVar).a();
    }

    public final String a() {
        String strA;
        StringBuilder sb = new StringBuilder();
        PrintOptions printOptions = this.a;
        if (printOptions != null && !TextUtils.isEmpty(printOptions.getDocumentName())) {
            strA = this.a.getDocumentName();
        } else {
            strA = ww.a(this.c, this.d);
        }
        return sb.append(strA).append(this.d.r == null ? ".pdf" : "").toString();
    }
}
