package com.pspdfkit.internal;

import com.pspdfkit.annotations.RichMediaAnnotation;
import com.pspdfkit.annotations.actions.RichMediaExecuteAction;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class qz<T> implements Consumer {
    public final /* synthetic */ sz a;
    public final /* synthetic */ RichMediaExecuteAction b;

    public qz(sz szVar, RichMediaExecuteAction richMediaExecuteAction) {
        this.a = szVar;
        this.b = richMediaExecuteAction;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        kq mediaPlayer;
        RichMediaAnnotation richMediaAnnotation = (RichMediaAnnotation) obj;
        richMediaAnnotation.getClass();
        au auVarB = this.a.a.b(richMediaAnnotation.getPageIndex());
        if (auVarB == null || (mediaPlayer = auVarB.getMediaPlayer()) == null) {
            return;
        }
        RichMediaExecuteAction richMediaExecuteAction = this.b;
        richMediaExecuteAction.getRichMediaAnnotationAsync(mediaPlayer.b).observeOn(AndroidSchedulers.mainThread()).subscribe(new nq(mediaPlayer, richMediaExecuteAction));
    }
}
