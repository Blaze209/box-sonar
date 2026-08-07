package com.pspdfkit.internal;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import com.pspdfkit.internal.jni.NativePrintConfiguration;
import com.pspdfkit.internal.jni.NativePrintProcessor;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.ResourceCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.FileOutputStream;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class bc {
    public final lm a;
    public final Size b;
    public final boolean c;
    public final boolean d;
    public final int e;

    public class a extends ResourceCompletableObserver {
        public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback a;
        public final /* synthetic */ PageRange[] b;

        public a(PrintDocumentAdapter.WriteResultCallback writeResultCallback, PageRange[] pageRangeArr) {
            this.a = writeResultCallback;
            this.b = pageRangeArr;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public final void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.a.onWriteFinished(this.b);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public final void onError(Throwable th) {
            if (isDisposed()) {
                return;
            }
            this.a.onWriteFailed(null);
        }
    }

    public bc(lm lmVar, Size size, PrintAttributes printAttributes, boolean z) {
        int iMin = 150;
        if (printAttributes.getResolution() != null) {
            iMin = Math.min(z ? 72 : 150, Math.max(printAttributes.getResolution().getHorizontalDpi(), printAttributes.getResolution().getVerticalDpi()));
        }
        boolean z2 = printAttributes.getColorMode() == 1;
        this.a = lmVar;
        this.b = size;
        this.e = iMin;
        this.c = z2;
        this.d = z;
    }

    public static void a(NativePrintConfiguration nativePrintConfiguration, ParcelFileDescriptor parcelFileDescriptor, FlowableEmitter flowableEmitter) throws Throwable {
        NativePrintProcessor.asyncGenerateToDataSink(nativePrintConfiguration, new rr(flowableEmitter), new pt(new FileOutputStream(parcelFileDescriptor.getFileDescriptor())));
    }

    public final void a(PageRange[] pageRangeArr, final ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, final PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (PageRange pageRange : pageRangeArr) {
            for (int start = pageRange.getStart(); start <= pageRange.getEnd(); start++) {
                hashSet.add(Integer.valueOf(start));
            }
        }
        final NativePrintConfiguration nativePrintConfigurationCreate = NativePrintConfiguration.create(this.a.y);
        nativePrintConfigurationCreate.setPagesToPrint(hashSet);
        Size size = this.b;
        nativePrintConfigurationCreate.setMediaSize((int) size.width, (int) size.height);
        nativePrintConfigurationCreate.setDensity(this.e);
        nativePrintConfigurationCreate.setMonochrome(this.c);
        nativePrintConfigurationCreate.setPreview(this.d);
        nativePrintConfigurationCreate.setCache(q10.a.a().a);
        Completable completableIgnoreElements = Flowable.create(new FlowableOnSubscribe() { // from class: com.pspdfkit.internal.bc$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) throws Throwable {
                bc.a(nativePrintConfigurationCreate, parcelFileDescriptor, flowableEmitter);
            }
        }, BackpressureStrategy.LATEST).ignoreElements();
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        final Disposable disposable = (Disposable) completableIgnoreElements.subscribeOn(schedulerIo).subscribeWith(new a(writeResultCallback, pageRangeArr));
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.pspdfkit.internal.bc$$ExternalSyntheticLambda1
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                bc.a(disposable, writeResultCallback);
            }
        });
    }

    public static /* synthetic */ void a(Disposable disposable, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        disposable.dispose();
        writeResultCallback.onWriteCancelled();
    }
}
