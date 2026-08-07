package com.pspdfkit.internal;

import com.pspdfkit.annotations.ScreenAnnotation;
import com.pspdfkit.annotations.actions.RenditionAction;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class cz<T> implements Consumer {
    public final /* synthetic */ ez a;
    public final /* synthetic */ RenditionAction b;

    public cz(ez ezVar, RenditionAction renditionAction) {
        this.a = ezVar;
        this.b = renditionAction;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        kq mediaPlayer;
        ScreenAnnotation screenAnnotation = (ScreenAnnotation) obj;
        screenAnnotation.getClass();
        au auVarB = this.a.a.b(screenAnnotation.getPageIndex());
        if (auVarB == null || (mediaPlayer = auVarB.getMediaPlayer()) == null) {
            return;
        }
        RenditionAction renditionAction = this.b;
        renditionAction.getScreenAnnotationAsync(mediaPlayer.b).observeOn(AndroidSchedulers.mainThread()).subscribe(new mq(mediaPlayer, renditionAction));
    }
}
