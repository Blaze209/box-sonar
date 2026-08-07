package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.LowResProvider$renderFromCachedBitmap$2", f = "LowResProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class ro extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wy>, Object> {
    public final /* synthetic */ jm a;
    public final /* synthetic */ x7 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ro(jm jmVar, x7 x7Var, Continuation<? super ro> continuation) {
        super(2, continuation);
        this.a = jmVar;
        this.b = x7Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ro(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wy> continuation) {
        return new ro(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        jm jmVar = this.a;
        zo zoVar = new zo(jmVar.c, jmVar.d);
        Bitmap bitmapA = zoVar.a();
        bitmapA.getClass();
        x7 x7Var = this.b;
        synchronized (bitmapA) {
            new Canvas(bitmapA).drawBitmap(x7Var.a, (Rect) null, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), (Paint) null);
            Unit unit = Unit.INSTANCE;
        }
        return new wy(zoVar, this.a);
    }
}
