package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class qq$$ExternalSyntheticLambda8 implements Consumer {
    public final /* synthetic */ ImageView f$0;

    public /* synthetic */ qq$$ExternalSyntheticLambda8(ImageView imageView) {
        this.f$0 = imageView;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        this.f$0.setImageBitmap((Bitmap) obj);
    }
}
