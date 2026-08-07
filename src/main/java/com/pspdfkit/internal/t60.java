package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.pspdfkit.signatures.Signature;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

/* JADX INFO: loaded from: classes3.dex */
public final class t60<T, R> implements Function {
    public static final t60<T, R> a = new t60<>();

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        bitmap.getClass();
        return Single.just(Signature.Companion.createStampSignature$default(Signature.INSTANCE, bitmap, new RectF(0.0f, bitmap.getHeight(), bitmap.getWidth(), 0.0f), null, 1.0f, 4, null));
    }
}
