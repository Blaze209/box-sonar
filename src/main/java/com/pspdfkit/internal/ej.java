package com.pspdfkit.internal;

import android.net.Uri;
import com.pspdfkit.annotations.actions.GoToEmbeddedAction;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.sharing.DocumentSharingProviderProcessor;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class ej<T> implements Consumer {
    public final /* synthetic */ gj a;
    public final /* synthetic */ GoToEmbeddedAction b;

    public ej(gj gjVar, GoToEmbeddedAction goToEmbeddedAction) {
        this.a = gjVar;
        this.b = goToEmbeddedAction;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        EmbeddedFile embeddedFile = (EmbeddedFile) obj;
        embeddedFile.getClass();
        gj gjVar = this.a;
        int pageIndex = this.b.getPageIndex();
        Single<Uri> singlePrepareEmbeddedFileForSharing = DocumentSharingProviderProcessor.prepareEmbeddedFileForSharing(gjVar.a.requireContext(), embeddedFile);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        singlePrepareEmbeddedFileForSharing.subscribeOn(schedulerIo).subscribe(new fj(gjVar, pageIndex));
    }
}
